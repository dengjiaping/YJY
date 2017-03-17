package com.miguan.yjy.model.services;


import com.miguan.yjy.model.bean.Article;
import com.miguan.yjy.model.bean.Feedback;
import com.miguan.yjy.model.bean.Message;
import com.miguan.yjy.model.bean.User;
import com.miguan.yjy.model.bean.Version;

import java.util.List;
import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Copyright (c) 2015. LiaoPeiKun Inc. All rights reserved.
 */

public interface Services {

    String BASE_URL = "http://api.beta.otkpk.com/v1/";

    //////////////////用户相关/////////////////////
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 是否成功
     */
    @FormUrlEncoded
    @POST("user/user/login")
    Observable<User> login(
            @Field("username") CharSequence username,
            @Field("password") CharSequence password
    );

    /**
     * 用户注册
     *
     * @param username 用户名
     * @param password 密码
     * @param mobile 手机
     * @param captcha 验证码
     * @return 结果
     */
    @FormUrlEncoded
    @POST("user/user/sign-up")
    Observable<User> register(
            @Field("username") CharSequence username,
            @Field("mobile") CharSequence mobile,
            @Field("captcha") CharSequence captcha,
            @Field("password") CharSequence password
    );

    /**
     * 发送注册验证码
     * @param mobile 手机号
     * @return 是否成功
     */
    @FormUrlEncoded
    @POST("user/user/captcha-register")
    Observable<Boolean> sendCaptchaRegister(
            @Field("mobile") CharSequence mobile
    );

    /**
     * 发送重置密码验证码
     * @param mobile 手机号
     * @return 是否成功
     */
    @FormUrlEncoded
    @POST("user/user/captcha-reset")
    Observable<Boolean> sendCaptchaReset(
            @Field("mobile") CharSequence mobile
    );

    /**
     * 其他验证码
     * @param mobile 手机号
     * @return 是否成功
     */
    @FormUrlEncoded
    @POST("user/user/captcha-update")
    Observable<Boolean> sendCaptchaUpdate(
            @Field("mobile") CharSequence mobile,
            @Field("token") CharSequence token
    );

    /**
     * 忘记密码
     *
     * @param newPwd 新密码
     * @param mobile 手机
     * @param captcha 验证码
     * @return
     */
    @FormUrlEncoded
    @POST("user/user/reset-password")
    Observable<Boolean> modifyPwd(
            @Field("mobile") CharSequence mobile,
            @Field("captcha") CharSequence captcha,
            @Field("password") CharSequence newPwd
    );

    /**
     * 个人中心
     *
     * @param token 登录令牌
     * @return
     */
    @FormUrlEncoded
    @POST("user/center/index")
    Observable<User> userInfo(
            @Field("token") CharSequence token
    );

    /**
     * 个人资料
     *
     * @param token 登录令牌
     * @return
     */
    @FormUrlEncoded
    @POST("user/message/index")
    Observable<User> userProfile(
            @Field("token") CharSequence token
    );

    /**
     * 个人资料修改
     * token
     * photo
     * qq
     * email
     * actuality
     * birthday
     * province
     * city
     * sign
     * @return
     */
    @FormUrlEncoded
    @POST("user/message/edit")
    Observable<Boolean> modifyProfile(
            @FieldMap Map<String, String> request
    );

    /**
     * 消息列表
     */
    @FormUrlEncoded
    @POST("user/systemmessage/system-message")
    Observable<List<Message>> getMessageList(
            @Field("token") String token,
            @Field("type") Integer type,
            @Field("page") Integer page
    );

    /**
     * 吐槽一下
     * @param token 登录令牌
     * @param type  类型（0:产品建议、1:发现BUG、2:举报作弊、3:其他）
     * @param contact 联系方式
     * @param content 吐槽内容
     * @param img 上传照片
     * @param source 信息来源（来源 0:安卓 1：IOS）
     * @return
     */
    @FormUrlEncoded
    @POST("user/feedback/feedback")
    Observable<Feedback> feedback(
            @Field("token") String token,
            @Field("type") Integer type,
            @Field("contact") String contact,
            @Field("content") String content,
            @Field("img") String img,
            @Field("source") int source
    );

    ////////////////////其他//////////////////////
    /**
     * 资讯列表
     *
     * @param type 文章类型 '1'=>'新闻','2'=>'行业','3'=>'攻略','4'=>'评测','5'=>'活动',
     * @param page 当前页数
     * @return
     */
    @GET("article/article/article-list")
    Observable<List<Article>> articleList(
            @Query("type") int type,
            @Query("page") int page
    );

    /**
     * 检测更新
     *
     * @param version 当前版本号
     * @return
     */
    @GET("system/system/version-upgrade")
    Observable<Version> checkUpdate(
            @Query("version") String version
    );

}