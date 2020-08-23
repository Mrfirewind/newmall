package com.newmall.controller;

import com.google.common.collect.Lists;
import com.newmall.enums.YesOrNo;
import com.newmall.pojo.Carousel;
import com.newmall.pojo.Category;
import com.newmall.pojo.vo.CategoryVO;
import com.newmall.pojo.vo.NewItemsVO;
import com.newmall.service.CarouselService;
import com.newmall.service.CategoryService;
import com.newmall.utils.JsonResult;
import com.newmall.utils.JsonUtils;
import com.newmall.utils.RedisOperator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Api(value = "首页", tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RedisOperator redisOperator;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public JsonResult carousel() {
        String carouselStr = redisOperator.get("carousel");
        if (StringUtils.isNoneBlank(carouselStr)) {
            return JsonResult.ok(JsonUtils.jsonToList(carouselStr, Carousel.class));
        }

        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        redisOperator.set("carousel", JsonUtils.objectToJson(list));
        return JsonResult.ok(list);
    }

    /**
     * 1. 后台运营系统，一旦广告（轮播图）发生更改，就可以删除缓存，然后重置
     * 2. 定时重置，比如每天凌晨三点重置
     * 3. 每个轮播图都有可能是一个广告，每个广告都会有一个过期时间，过期了，再重置
     */


    /**
     * 首页分类展示需求：
     * 1. 第一次刷新主页查询大分类，渲染展示到首页
     * 2. 如果鼠标上移到大分类，则加载其子分类的内容，如果已经存在子分类，则不需要加载（懒加载）
     */
    @ApiOperation(value = "获取商品分类(一级分类)", notes = "获取商品分类(一级分类)", httpMethod = "GET")
    @GetMapping("/cats")

    public JsonResult cats() {
        List<Category> list;
        String catsStr = redisOperator.get("cats");
        if (StringUtils.isBlank(catsStr)) {
            list = categoryService.queryAllRootLevelCat();
            redisOperator.set("cats", JsonUtils.objectToJson(list));
        } else {
            list = JsonUtils.jsonToList(catsStr, Category.class);
        }

        return JsonResult.ok(list);
    }

    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public JsonResult subCat(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {
        if (Objects.isNull(rootCatId)) {
            return JsonResult.errorMsg("分类不存在");
        }

        List<CategoryVO> list ;
        String catsStr = redisOperator.get("subCat:" + rootCatId);
        if (StringUtils.isBlank(catsStr)) {
            list = categoryService.getSubCatList(rootCatId);

            /**
             * 查询的key在redis中不存在，
             * 对应的id在数据库也不存在，
             * 此时被非法用户进行攻击，大量的请求会直接打在db上，
             * 造成宕机，从而影响整个系统，
             * 这种现象称之为缓存穿透。
             * 解决方案：把空的数据也缓存起来，比如空字符串，空对象，空数组或list
             */
            if (CollectionUtils.isNotEmpty(list)) {
                redisOperator.set("subCat:" + rootCatId, JsonUtils.objectToJson(list));
            } else {
                redisOperator.set("subCat:" + rootCatId, JsonUtils.objectToJson(list), 5*60);
            }
        } else {
            list = JsonUtils.jsonToList(catsStr, CategoryVO.class);
        }

        return JsonResult.ok(list);
    }

    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据", notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public JsonResult sixNewItems(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {

        if (rootCatId == null) {
            return JsonResult.errorMsg("分类不存在");
        }

        List<NewItemsVO> list = categoryService.getSixNewItemsLazy(rootCatId);
        return JsonResult.ok(list);
    }

}
