package com.example.fastfood;


import com.example.fastfood.models.AddCart;
import com.example.fastfood.models.CategoryModel;
import com.example.fastfood.models.Login;
import com.example.fastfood.models.MainCategoryList;


import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("api/pos_login_restaurants")
    @FormUrlEncoded
    Call<Login> getPass(
            @Field("emailId") String email_Id,
            @Field("password") String password
    );

    @POST("api/menu_list")
    @FormUrlEncoded
    Call<CategoryModel> getPosts(
            @Field("access_token") String access_token
    );
    @POST("api/category_list")
    @FormUrlEncoded
    Call<MainCategoryList> getCategories(
            @Field("access_token") String access_token
    );
    @POST("api/category_list")
    @FormUrlEncoded
    Call<MainCategoryList> getHideCategories(
            @Field("access_token") String access_token
    );

    @POST("api/category_list")
    @FormUrlEncoded
    Call<MainCategoryList> getCategoriesImage(
            @Field("access_token") String access_token
    );

    @POST("api/add_to_cart")
    @FormUrlEncoded
    Call<AddCart> getAddCart(
            @Field("access_token") String access_token,
            @Field("userId") String userId,
            @Field("deviceId") String deviceId,
            @Field("menu_activity_key") String menu_activity_key,
            @Field("quantity") String quantity,
            @Field("has_addons") String has_addons,
            @Field("addons_item") String addons_item,
            @Field("attributes_key") String attributes_key,
            @Field("attributes_value") String attributes_value
    );
}
