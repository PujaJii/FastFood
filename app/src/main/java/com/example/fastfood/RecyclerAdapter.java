package com.example.fastfood;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastfood.models.CateDataList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
//    ArrayList namelist;
//    ArrayList imagelist;

    List<CateDataList> list;
    Context context;

    public RecyclerAdapter(List<CateDataList> list, Context context) {

        this.list = list;
        this.context = context;

    }

    //    public RecyclerAdapter(ArrayList namelist, ArrayList imagelist, Context context) {
//        this.namelist = namelist;
//        this.imagelist = imagelist;
//        this.context = context;
//    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // for Local data
//        holder.textView.setText(namelist.get(position).toString());
//        holder.imageView.setImageResource((Integer) imagelist.get(position));

        //From API
        String id= String.valueOf(list.get(position).getCategory_name());
        holder.textView.setText(id);

        Picasso.get().load(list.get(position).getMenu_image()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MenuDetails.class);
                intent.putExtra("item_name",list.get(position).getMenu_name());
                intent.putExtra("description",list.get(position).getDescription());
                intent.putExtra("price",list.get(position).getMenu_price());
                intent.putExtra("discount",list.get(position).getDiscount());
                intent.putExtra("final_price",list.get(position).getFinal_price());
                intent.putExtra("item_image",list.get(position).getMenu_image());
                intent.putExtra("menu_activity_key",list.get(position).getMenu_activity_key());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ViewHolder( View View) {
            super(View);
             textView = View.findViewById(R.id.textView10);
             imageView = View.findViewById(R.id.imageView4);
        }
    }
}
