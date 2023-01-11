package com.example.fastfood;

import android.annotation.SuppressLint;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class VpAdapter extends PagerAdapter {
    List<Integer> list;
    Context context;

    public VpAdapter(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.viewpager_layout,container,false);
        ImageView image = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        if (position == 0){
            textView.setText("Hemat Makanan dengan yang baru kami Fitur!");
        }else if (position == 1){
            textView.setText("Tetapkan preferensi untuk banyak pengguna dari berbagai restoran!");
        }else {
            textView.setText("Cepat, diselamatkan makanan di tempatmu melayani.");
        }
        image.setImageResource(list.get(position));
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
