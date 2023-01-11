package com.example.fastfood.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddCartData {
    @Expose
    @SerializedName("is_addon_added")
    private String is_addon_added;
    @Expose
    @SerializedName("menu_image")
    private String menu_image;
    @Expose
    @SerializedName("final_price")
    private String final_price;
    @Expose
    @SerializedName("menu_name")
    private String menu_name;
    @Expose
    @SerializedName("cart_price")
    private String cart_price;
    @Expose
    @SerializedName("cart_menu_quantity")
    private String cart_menu_quantity;
    @Expose
    @SerializedName("cart_id")
    private String cart_id;

    public String getIs_addon_added() {
        return is_addon_added;
    }

    public void setIs_addon_added(String is_addon_added) {
        this.is_addon_added = is_addon_added;
    }

    public String getMenu_image() {
        return menu_image;
    }

    public void setMenu_image(String menu_image) {
        this.menu_image = menu_image;
    }

    public String getFinal_price() {
        return final_price;
    }

    public void setFinal_price(String final_price) {
        this.final_price = final_price;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getCart_price() {
        return cart_price;
    }

    public void setCart_price(String cart_price) {
        this.cart_price = cart_price;
    }

    public String getCart_menu_quantity() {
        return cart_menu_quantity;
    }

    public void setCart_menu_quantity(String cart_menu_quantity) {
        this.cart_menu_quantity = cart_menu_quantity;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }
}
