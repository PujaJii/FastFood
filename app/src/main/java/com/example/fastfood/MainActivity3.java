package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity3 extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPagerTab);
        tabLayout.setupWithViewPager(viewPager);

        TabVpAdapter tabVpAdapter = new TabVpAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabVpAdapter.addFragment(new LogIn(),"LogIn");
        tabVpAdapter.addFragment(new SignIn(),"Sign-Up");
        viewPager.setAdapter(tabVpAdapter);
    }
}