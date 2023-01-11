package com.example.fastfood.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainCateData {
    @Expose
    @SerializedName("updated_at")
    private String updated_at;
    @Expose
    @SerializedName("created_at")
    private String created_at;
    @Expose
    @SerializedName("category_activity_key")
    private String category_activity_key;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("resturant_id")
    private String resturant_id;
    @Expose
    @SerializedName("category_image")
    private String category_image;
    @Expose
    @SerializedName("category_name")
    private String category_name;
    @Expose
    @SerializedName("id")
    private int id;

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

    public String getCategory_activity_key() {
        return category_activity_key;
    }

    public void setCategory_activity_key(String category_activity_key) {
        this.category_activity_key = category_activity_key;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResturant_id() {
        return resturant_id;
    }

    public void setResturant_id(String resturant_id) {
        this.resturant_id = resturant_id;
    }

    public String getCategory_image() {
        return category_image;
    }

    public void setCategory_image(String category_image) {
        this.category_image = category_image;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
