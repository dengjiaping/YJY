package com.miguan.yjy.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Copyright (c) 2017/3/28. LiaoPeiKun Inc. All rights reserved.
 */
@Entity
public class Brand implements Parcelable {

    @Id(autoincrement = true)
    @Unique
    private Long id;

    private String name;

    private String letter;

    private boolean isLocal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public Brand() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.letter);
        dest.writeByte(this.isLocal ? (byte) 1 : (byte) 0);
    }

    public boolean getIsLocal() {
        return this.isLocal;
    }

    public void setIsLocal(boolean isLocal) {
        this.isLocal = isLocal;
    }

    protected Brand(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.letter = in.readString();
        this.isLocal = in.readByte() != 0;
    }

    @Generated(hash = 1984431535)
    public Brand(Long id, String name, String letter, boolean isLocal) {
        this.id = id;
        this.name = name;
        this.letter = letter;
        this.isLocal = isLocal;
    }

    public static final Creator<Brand> CREATOR = new Creator<Brand>() {
        @Override
        public Brand createFromParcel(Parcel source) {
            return new Brand(source);
        }

        @Override
        public Brand[] newArray(int size) {
            return new Brand[size];
        }
    };

}