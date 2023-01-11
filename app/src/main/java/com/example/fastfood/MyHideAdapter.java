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

public class MyHideAdapter extends RecyclerView.Adapter<MyHideAdapter.ViewHolder>{

    List<MainCateData> mainCateDataList1;
    Context context;

    public MyHideAdapter(List<MainCateData> mainCateDataList1, Context context) {
        this.mainCateDataList1 = mainCateDataList1;
        this.context = context;
    }


    @NonNull
    @Override
    public MyHideAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hide_category_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHideAdapter.ViewHolder holder, int position) {
        holder.textView1.setText(mainCateDataList1.get(position).getCategory_name());

        Picasso.get().load(mainCateDataList1.get(position).getCategory_image()).into(holder.imageView1);
    }

    @Override
    public int getItemCount() {
        return mainCateDataList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       TextView textView1;
       ImageView imageView1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.hide_textView13);
            imageView1 = itemView.findViewById(R.id.hide_imageView6);
        }
    }
}

