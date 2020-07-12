package com.newmall.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Users {
    /**
     * 主键id 用户id
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 用户名
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 昵称
     */
    @Column(name = "NICKNAME")
    private String nickname;

    /**
     * 真实姓名
     */
    @Column(name = "REALNAME")
    private String realname;

    /**
     * 头像
     */
    @Column(name = "FACE")
    private String face;

    /**
     * 手机号
     */
    @Column(name = "MOBILE")
    private String mobile;

    /**
     * 邮箱地址
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 性别 1:男  0:女  2:保密
     */
    @Column(name = "SEX")
    private Integer sex;

    /**
     * 生日
     */
    @Column(name = "BIRTHDAY")
    private Date birthday;

    /**
     * 创建时
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    /**
     * 获取主键id 用户id
     *
     * @return ID - 主键id 用户id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id 用户id
     *
     * @param id 主键id 用户id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return USERNAME - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return PASSWORD - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称
     *
     * @return NICKNAME - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取真实姓名
     *
     * @return REALNAME - 真实姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置真实姓名
     *
     * @param realname 真实姓名
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取头像
     *
     * @return FACE - 头像
     */
    public String getFace() {
        return face;
    }

    /**
     * 设置头像
     *
     * @param face 头像
     */
    public void setFace(String face) {
        this.face = face;
    }

    /**
     * 获取手机号
     *
     * @return MOBILE - 手机号
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
     * 获取邮箱地址
     *
     * @return EMAIL - 邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址
     *
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取性别 1:男  0:女  2:保密
     *
     * @return SEX - 性别 1:男  0:女  2:保密
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别 1:男  0:女  2:保密
     *
     * @param sex 性别 1:男  0:女  2:保密
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取生日
     *
     * @return BIRTHDAY - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取创建时
     *
     * @return CREATED_TIME - 创建时
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时
     *
     * @param createdTime 创建时
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATED_TIME - 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}