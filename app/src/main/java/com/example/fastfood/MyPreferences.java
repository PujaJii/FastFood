package com.example.fastfood;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;


public class MyPreferences {

    Context context;

    public MyPreferences(Context context) {
        this.context = context;
    }

    public void writeId(String id){

        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("name",id);
        myEdit.apply();

    }

    public String readId(){
        SharedPreferences sh = context.getSharedPreferences("MyPref",MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        return s1;
    }
}