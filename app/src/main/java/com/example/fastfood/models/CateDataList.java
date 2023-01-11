package com.example.fastfood.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CateDataList {
    @Expose
    @SerializedName("category_id")
    private String category_id;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("final_price")
    private String final_price;
    @Expose
    @SerializedName("discount_type")
    private String discount_type;
    @Expose
    @SerializedName("discount")
    private String discount;
    @Expose
    @SerializedName("menu_price")
    private String menu_price;
    @Expose
    @SerializedName("category_name")
    private String category_name;
    @Expose
    @SerializedName("menu_image")
    private String menu_image;
    @Expose
    @SerializedName("menu_name")
    private String menu_name;
    @Expose
    @SerializedName("menu_activity_key")
    private String menu_activity_key;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFinal_price() {
        return final_price;
    }

    public void setFinal_price(String final_price) {
        this.final_price = final_price;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMenu_price() {
        return menu_price;
    }

    public void setMenu_price(String menu_price) {
        this.menu_price = menu_price;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getMenu_image() {
        return menu_image;
    }

    public void setMenu_image(String menu_image) {
        this.menu_image = menu_image;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_activity_key() {
        return menu_activity_key;
    }

    public void setMenu_activity_key(String menu_activity_key) {
        this.menu_activity_key = menu_activity_key;
    }
}
