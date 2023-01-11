package com.example.fastfood.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataLogin {
    @Expose
    @SerializedName("closing_time")
    private String closing_time;
    @Expose
    @SerializedName("opening_time")
    private String opening_time;
    @Expose
    @SerializedName("full_address")
    private String full_address;
    @Expose
    @SerializedName("resturent_ratings")
    private String resturent_ratings;
    @Expose
    @SerializedName("resturent_reviews")
    private String resturent_reviews;
    @Expose
    @SerializedName("image")
    private String image;
    @Expose
    @SerializedName("latitute")
    private String latitute;
    @Expose
    @SerializedName("longitute")
    private String longitute;
    @Expose
    @SerializedName("updated_at")
    private String updated_at;
    @Expose
    @SerializedName("created_at")
    private String created_at;
    @Expose
    @SerializedName("remember_token")
    private String remember_token;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("res_access_token")
    private String res_access_token;
    @Expose
    @SerializedName("res_id")
    private String res_id;
    @Expose
    @SerializedName("id")
    private int id;

    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
    }

    public String getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(String opening_time) {
        this.opening_time = opening_time;
    }

    public String getFull_address() {
        return full_address;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }

    public String getResturent_ratings() {
        return resturent_ratings;
    }

    public void setResturent_ratings(String resturent_ratings) {
        this.resturent_ratings = resturent_ratings;
    }

    public String getResturent_reviews() {
        return resturent_reviews;
    }

    public void setResturent_reviews(String resturent_reviews) {
        this.resturent_reviews = resturent_reviews;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLatitute() {
        return latitute;
    }

    public void setLatitute(String latitute) {
        this.latitute = latitute;
    }

    public String getLongitute() {
        return longitute;
    }

    public void setLongitute(String longitute) {
        this.longitute = longitute;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRes_access_token() {
        return res_access_token;
    }

    public void setRes_access_token(String res_access_token) {
        this.res_access_token = res_access_token;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
