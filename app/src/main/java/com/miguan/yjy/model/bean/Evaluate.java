package com.miguan.yjy.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Copyright (c) 2017/3/24. LiaoPeiKun Inc. All rights reserved.
 */

public class Evaluate implements Parcelable {

    private int id;

    private int user_id;

    private String comment;

    private int like_num;

    private String username;

    private String img;

    private String birth_year;

    private int pageTotal;

    private int pageSize;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.user_id);
        dest.writeString(this.comment);
        dest.writeInt(this.like_num);
        dest.writeString(this.username);
        dest.writeString(this.img);
        dest.writeString(this.birth_year);
        dest.writeInt(this.pageTotal);
        dest.writeInt(this.pageSize);
    }

    public Evaluate() {
    }

    protected Evaluate(Parcel in) {
        this.id = in.readInt();
        this.user_id = in.readInt();
        this.comment = in.readString();
        this.like_num = in.readInt();
        this.username = in.readString();
        this.img = in.readString();
        this.birth_year = in.readString();
        this.pageTotal = in.readInt();
        this.pageSize = in.readInt();
    }

    public static final Creator<Evaluate> CREATOR = new Creator<Evaluate>() {
        @Override
        public Evaluate createFromParcel(Parcel source) {
            return new Evaluate(source);
        }

        @Override
        public Evaluate[] newArray(int size) {
            return new Evaluate[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}