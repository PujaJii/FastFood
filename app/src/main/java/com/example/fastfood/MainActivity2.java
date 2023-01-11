package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity2 extends AppCompatActivity {

    ViewPager viewPager;
    CircleIndicator circleIndicator;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        viewPager = findViewById(R.id.myViewPager);
        circleIndicator = findViewById(R.id.circleIndicator);

        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.intro_a);
        list.add(R.drawable.intro_b);
        list.add(R.drawable.intro_cc);

        VpAdapter vpAdapter = new VpAdapter(list, getApplicationContext());
        viewPager.setAdapter(vpAdapter);
        circleIndicator.setViewPager(viewPager);

        button = findViewById(R.id.button12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}