package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.fastfood.models.MainCateData;
import com.example.fastfood.models.MainCategoryList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryView extends AppCompatActivity {

    MyPreferences myPreferences;
    RecyclerView myNewRecyclerView;
    ApiInterface apiInterface;
    List<MainCateData> mainCateList1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);
        myPreferences = new MyPreferences(getApplicationContext());
        myNewRecyclerView = findViewById(R.id.recyclerView_hidePage);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getApplicationContext(),1);
        myNewRecyclerView.setLayoutManager(gridLayoutManager1);
        getHideCategories();
    }

    private void getHideCategories() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MainCategoryList> catecall1 = apiInterface.getHideCategories(myPreferences.readId());
        catecall1.enqueue(new Callback<MainCategoryList>() {
            @Override
            public void onResponse(Call<MainCategoryList> call, Response<MainCategoryList> response) {
                if(response.body().getResponse().equals("true")){
                    mainCateList1 = response.body().getData();
                    MyHideAdapter myHideAdapter= new MyHideAdapter(mainCateList1,getApplicationContext());
                    myNewRecyclerView.setAdapter(myHideAdapter);
                }
                else {
                    Toast.makeText(CategoryView.this, "Else part", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainCategoryList> call, Throwable t) {

            }
        });
    }


}
