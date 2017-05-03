package com.miguan.yjy.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2015. LiaoPeiKun Inc. All rights reserved.
 */

public class User implements Parcelable {

    @SerializedName(value = "user_id", alternate = {"userId", "id"})
    private int user_id;

    @SerializedName(value = "img", alternate = {"user_img"})
    private String img;

    @SerializedName(value = "username", alternate = {"user_name"})
    private String username;

    private int sex;

    private String status;

    private String birth_year;

    private String birth_day;

    private String birth_month;

    private String city;

    private int img_state;

    private String email;

    private String skin_name;

    private String province;

    private String rank_points;

    private String mobile;

    private String dry;
    private String tolerance;
    private String pigment;
    private String compact;

    /**
     * 过期产品数
     */
    private int overdueNum;

    /**
     * 未读消息数
     */
    private int unReadNum;

    public String getDry() {
        return dry;
    }

    public void setDry(String dry) {
        this.dry = dry;
    }

    public String getTolerance() {
        return tolerance;
    }

    public void setTolerance(String tolerance) {
        this.tolerance = tolerance;
    }

    public String getPigment() {
        return pigment;
    }

    public void setPigment(String pigment) {
        this.pigment = pigment;
    }

    public String getCompact() {
        return compact;
    }

    public void setCompact(String compact) {
        this.compact = compact;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(String birth_day) {
        this.birth_day = birth_day;
    }

    public String getBirth_month() {
        return birth_month;
    }

    public void setBirth_month(String birth_month) {
        this.birth_month = birth_month;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getImg_state() {
        return img_state;
    }

    public void setImg_state(int img_state) {
        this.img_state = img_state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkin_name() {
        return skin_name;
    }

    public void setSkin_name(String skin_name) {
        this.skin_name = skin_name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRank_points() {
        return rank_points;
    }

    public void setRank_points(String rank_points) {
        this.rank_points = rank_points;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getOverdueNum() {
        return overdueNum;
    }

    public void setOverdueNum(int overdueNum) {
        this.overdueNum = overdueNum;
    }

    public int getUnReadNUM() {
        return unReadNum;
    }

    public void setUnReadNUM(int unReadNUM) {
        this.unReadNum = unReadNUM;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.user_id);
        dest.writeString(this.img);
        dest.writeString(this.username);
        dest.writeInt(this.sex);
        dest.writeString(this.status);
        dest.writeString(this.birth_year);
        dest.writeString(this.birth_day);
        dest.writeString(this.birth_month);
        dest.writeString(this.city);
        dest.writeInt(this.img_state);
        dest.writeString(this.email);
        dest.writeString(this.skin_name);
        dest.writeString(this.province);
        dest.writeString(this.rank_points);
        dest.writeString(this.mobile);
        dest.writeString(this.dry);
        dest.writeString(this.tolerance);
        dest.writeString(this.pigment);
        dest.writeString(this.compact);
        dest.writeInt(this.overdueNum);
        dest.writeInt(this.unReadNum);
    }

    protected User(Parcel in) {
        this.user_id = in.readInt();
        this.img = in.readString();
        this.username = in.readString();
        this.sex = in.readInt();
        this.status = in.readString();
        this.birth_year = in.readString();
        this.birth_day = in.readString();
        this.birth_month = in.readString();
        this.city = in.readString();
        this.img_state = in.readInt();
        this.email = in.readString();
        this.skin_name = in.readString();
        this.province = in.readString();
        this.rank_points = in.readString();
        this.mobile = in.readString();
        this.dry = in.readString();
        this.tolerance = in.readString();
        this.pigment = in.readString();
        this.compact = in.readString();
        this.overdueNum = in.readInt();
        this.unReadNum = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
