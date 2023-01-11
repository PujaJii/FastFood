package com.example.fastfood.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddCart {

    @Expose
    @SerializedName("response_message")
    private String response_message;
    @Expose
    @SerializedName("data")
    private List<AddCartData> data;
    @Expose
    @SerializedName("addon_list")
    private int addon_list;
    @Expose
    @SerializedName("status_code")
    private int status_code;
    @Expose
    @SerializedName("response")
    private String response;

    public String getResponse_message() {
        return response_message;
    }

    public void setResponse_message(String response_message) {
        this.response_message = response_message;
    }

    public List<AddCartData> getData() {
        return data;
    }

    public void setData(List<AddCartData> data) {
        this.data = data;
    }

    public int getAddon_list() {
        return addon_list;
    }

    public void setAddon_list(int addon_list) {
        this.addon_list = addon_list;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
