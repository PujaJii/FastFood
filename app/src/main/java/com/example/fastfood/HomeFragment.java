package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastfood.models.CateDataList;
import com.example.fastfood.models.CategoryModel;
import com.example.fastfood.models.MainCateData;
import com.example.fastfood.models.MainCategoryList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

//    ArrayList itemNames = new ArrayList<>(Arrays.asList("Hot Deals ", "New on FastFood",
//                                          "Save Food,\nSave Hunger", "Set Your Preferences Now!"));
//    ArrayList<Integer> itemImages = new ArrayList<>(Arrays.asList(R.drawable.hot_deal,R.drawable.new_on_shohoz,
//                                              R.drawable.badget_meal, R.drawable.favourite_food ));
//
//    ArrayList text = new ArrayList<>(Arrays.asList("Cappuccino", "Egg and cheese \nsandwich","Cappuccino"));
//    ArrayList text1 = new ArrayList<>(Arrays.asList("Suhani Restaurant", "Mehfil’s Place","Suhani Restaurant"));
//    ArrayList<Integer> img = new ArrayList<>(Arrays.asList(R.drawable.cup,R.drawable.breakfast,R.drawable.cup));

    ArrayList itemNames1 = new ArrayList<>(Arrays.asList("Daily Meals", "Middle- Eastern",
                                                           "Chinese", "Desi"));
    ArrayList<Integer> itemImages1 = new ArrayList<>(Arrays.asList(R.drawable.daily,R.drawable.eastern,
                                                                   R.drawable.chinese,R.drawable.desi));


    ViewPager viewPager;
    CircleIndicator circleIndicator;
    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    ImageView imageView;
    TextView textView;

    ApiInterface apiInterface;
    List<CateDataList> myList;
    List<MainCateData> mainCateList;
    MyPreferences myPreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        textView = view.findViewById(R.id.textView_viewAll);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CategoryView.class);
                startActivity(intent);
            }
        });

        myPreferences = new MyPreferences(getContext());

        imageView = view.findViewById(R.id.button_heart);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Heart", Toast.LENGTH_SHORT).show();
            }
        });

        viewPager = view.findViewById(R.id.myViewPagerHome);
        circleIndicator = view.findViewById(R.id.circleIndicator);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.banner);
        imageList.add(R.drawable.banner);
        imageList.add(R.drawable.banner);
        imageList.add(R.drawable.banner);

        MyVpAdapter myVpAdapter = new MyVpAdapter(imageList);
        viewPager.setAdapter(myVpAdapter);
        circleIndicator.setViewPager(viewPager);

        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
        recyclerView.setLayoutManager(gridLayoutManager);
        getPosts();
      //  getImages();


        recyclerView1 = view.findViewById(R.id.recyclerView2);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(),3);
        recyclerView1.setLayoutManager(gridLayoutManager1);
        getCategories();
//        getCategoriesImage();

//        recyclerView2 = view.findViewById(R.id.recyclerView3);
//        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(),4);
//        RecyclerAdapter recyclerAdapter1 = new RecyclerAdapter(itemNames1,itemImages1,getContext());
//        recyclerView2.setAdapter(recyclerAdapter1);
//        recyclerView2.setLayoutManager(gridLayoutManager2);

        return view;
    }


    private void getCategories() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MainCategoryList> cateCall = apiInterface.getCategories(myPreferences.readId());
        cateCall.enqueue(new Callback<MainCategoryList>() {
            @Override
            public void onResponse(Call<MainCategoryList> call, Response<MainCategoryList> response) {
                if(response.body().getResponse().equals("true")){
                    mainCateList = response.body().getData();
                    MyReAdapter myReAdapter = new MyReAdapter(mainCateList,getContext());
                    recyclerView1.setAdapter(myReAdapter);
                }else {
                    Toast.makeText(getContext(), "Else part", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainCategoryList> call, Throwable t) {
                Toast.makeText(getContext(), "Failure"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPosts() {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<CategoryModel> call = apiInterface.getPosts(myPreferences.readId());
        call.enqueue(new Callback<CategoryModel>() {

            @Override
            public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                if(response.body().getResponse().equals("true")) {
                    myList = response.body().getData();
                    RecyclerAdapter recyclerAdapter = new RecyclerAdapter(myList,getContext());
                    recyclerView.setAdapter(recyclerAdapter);
                }
                else {
                    Toast.makeText(getContext(), "Else part", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<CategoryModel> call, Throwable t) {
                Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}