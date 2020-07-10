package com.newmall.pojo;

import javax.persistence.*;

@Table(name = "user_address")
public class UserAddress {
    @Id
    private Integer id;

    /**
     * 收获人姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String country;

    /**
     * 详细地址
     */
    private String detail;

    @Column(name = "delete_time")
    private Integer deleteTime;

    /**
     * 外键
     */
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "update_time")
    private Integer updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取收获人姓名
     *
     * @return name - 收获人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置收获人姓名
     *
     * @param name 收获人姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区
     *
     * @return country - 区
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置区
     *
     * @param country 区
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取详细地址
     *
     * @return detail - 详细地址
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置详细地址
     *
     * @param detail 详细地址
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return delete_time
     */
    public Integer getDeleteTime() {
        return deleteTime;
    }

    /**
     * @param deleteTime
     */
    public void setDeleteTime(Integer deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * 获取外键
     *
     * @return user_id - 外键
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置外键
     *
     * @param userId 外键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return update_time
     */
    public Integer getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }
}