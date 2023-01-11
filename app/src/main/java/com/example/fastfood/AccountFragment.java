package com.example.fastfood;

import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class AccountFragment extends Fragment {


    CardView cardView;
    CardView cardView1;
    CardView cardView2;
    CardView cardView3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        cardView = view.findViewById(R.id.cardView3);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),BookmarkActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), "All Bookmark", Toast.LENGTH_SHORT).show();
            }
        });

     cardView1 = view.findViewById(R.id.cardView4);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(),NotificationActivity.class);
                startActivity(intent1);
                Toast.makeText(getContext(), "Your Notification", Toast.LENGTH_SHORT).show();
            }
        });

     cardView2 = view.findViewById(R.id.cardView5);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(),SettingsActivity.class);
                startActivity(intent2);
                Toast.makeText(getContext(), "Settings", Toast.LENGTH_SHORT).show();
            }
        });

     cardView3 = view.findViewById(R.id.cardView6);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(),PaymentActivity.class);
                startActivity(intent3);
                Toast.makeText(getContext(), "Payments", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}