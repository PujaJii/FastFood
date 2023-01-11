package com.example.fastfood.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

    @Expose
    @SerializedName("response_message")
    private String response_message;
    @Expose
    @SerializedName("data")
    private DataLogin data;
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

    public DataLogin getData() {
        return data;
    }

    public void setData(DataLogin data) {
        this.data = data;
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