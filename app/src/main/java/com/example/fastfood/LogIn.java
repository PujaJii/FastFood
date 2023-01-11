package com.example.fastfood;

import android.content.Intent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastfood.models.Login;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogIn extends Fragment {

    TextView textView;
    Button button;
    Button button1;
    Button button2;
    EditText editText;
    EditText editTextPW;

    ApiInterface apiInterface;
    MyPreferences myPreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        textView = view.findViewById(R.id.textView2);
        editText = view.findViewById(R.id.editTextTextEmailAddress);
        editTextPW = view.findViewById(R.id.editTextTextPassword);


        button = view.findViewById(R.id.button);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),MainActivity4.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(editText.getText().toString()) || TextUtils.isEmpty(editTextPW.getText().toString())){
                    Toast.makeText(getContext(), "Fields empty", Toast.LENGTH_SHORT).show();
                }else if (editText.getText().toString().equals("admin@gmail.com") && editTextPW.getText().toString().equals("123456")){
                  getPass();
                }
                else{
                    Toast.makeText(getContext(), "Wrong password", Toast.LENGTH_SHORT).show();

                }

            }
        });
        button1 = view.findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Please Click Log in!", Toast.LENGTH_SHORT).show();
            }
        });
        button2 = view.findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Please Click Log in!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void getPass() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Login> callLogin = apiInterface.getPass("admin@gmail.com","123456");
        callLogin.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.body().getResponse().equals("true")){

//                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPref",MODE_PRIVATE);
//                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
//                    myEdit.putString("name", response.body().getData().getRemember_token());
//                    myEdit.apply();

                    myPreferences = new MyPreferences(getContext());
                    myPreferences.writeId(response.body().getData().getRemember_token());

                    Toast.makeText(getContext(), "success : " +response.body().getData().getRemember_token(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(),MainActivity5.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(getContext(), "Invalid credential", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getContext(), "Failure" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}