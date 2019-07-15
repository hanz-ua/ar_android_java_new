package com.bvblogic.examplearbvb.db.domain;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;


import io.reactivex.annotations.NonNull;

/**
 * Created by hanz on 08.05.2018.
 */

@Entity(tableName = "user")
public class User {


    @PrimaryKey()
    @ColumnInfo(name = "user_id")
    @NonNull
    private int uid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "mobile")
    private String mobile;

    @ColumnInfo(name = "dolznost")
    private String post;

    @ColumnInfo(name = "company")
    private String company;

    @ColumnInfo(name = "home")
    private String home;

    @ColumnInfo(name = "logo")
    private String logo;

    @ColumnInfo(name = "department")
    private String department;


    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "token")
    private String token;


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return name;
    }
}
