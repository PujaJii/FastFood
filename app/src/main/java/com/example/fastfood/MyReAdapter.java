package com.example.fastfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastfood.models.MainCateData;
import com.squareup.picasso.Picasso;


import java.util.List;

public class MyReAdapter extends RecyclerView.Adapter<MyReAdapter.ViewHolder>{
//
//    ArrayList textList;
//    ArrayList textList1;
//    ArrayList imgList;
    List<MainCateData> mainCateDataList;
    Context context;

    public MyReAdapter(List<MainCateData> mainCateDataList, Context context) {
        this.mainCateDataList = mainCateDataList;
        this.context = context;
    }
    
    //
//    public MyReAdapter(ArrayList textList, ArrayList textList1, ArrayList imgList, Context context) {
//        this.textList = textList;
//        this.textList1 = textList1;
//        this.imgList = imgList;
//        this.context = context;
//    }

    @NonNull
    @Override
    public MyReAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.re_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyReAdapter.ViewHolder holder, int position) {
        holder.textView.setText(mainCateDataList.get(position).getCategory_name());
//        holder.textView1.setText(mainCateDataList.get(position).toString());
//        holder.imageView.setImageResource((Integer) imgList.get(position));
        Picasso.get().load(mainCateDataList.get(position).getCategory_image()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView13);
            imageView = itemView.findViewById(R.id.imageView6);

        }
    }
}
