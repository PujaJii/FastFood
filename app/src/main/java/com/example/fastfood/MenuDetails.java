package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastfood.models.AddCart;
import com.example.fastfood.models.CateDataList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuDetails extends AppCompatActivity {


    private static final String TAG = "MenuDetails";

    Intent intent;
    TextView textView;
    TextView description_text;
    TextView price_text;
    TextView discount_text;
    TextView final_price_text;
    TextView cart_text_price;
    ImageView imageView;
    FloatingActionButton fab;
    String str = "KIOS";
    String myRandomNumber;
    ApiInterface apiInterface;
     TextView quantityText;
    int quantity = 0;
    String android_id,menuactivitykey_str;
    String item_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);
        xmlinit();
        xmlonclik();
        generateRandomNumber();
        //DeviceId
         android_id = Settings.Secure.getString(this.getContentResolver(),Settings.Secure.ANDROID_ID);
       /* SharedPreferences sharedPreferences = getSharedPreferences("MyAndroidIdPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("androidId",android_id);
        myEdit.apply();
        Log.d("Android","Android ID : "+android_id);*/

    }

    private void xmlonclik() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getAddCart();

            }
        });
    }
    private void xmlinit() {
        textView = findViewById(R.id.textView21);
        description_text = findViewById(R.id.textView22);
        price_text = findViewById(R.id.price_textView24);
        discount_text = findViewById(R.id.discount_textView26);
        final_price_text = findViewById(R.id.final_price_textView28);
        quantityText = findViewById(R.id.quantityText);
        cart_text_price = findViewById(R.id.textView24);
        fab = findViewById(R.id.floatingActionButton3);
        intent = getIntent();
         item_name = intent.getStringExtra("item_name");
        textView.setText(item_name);
        menuactivitykey_str=intent.getStringExtra("menu_activity_key");


        String description = intent.getStringExtra("description");
        description_text.setText(description);
        String price = intent.getStringExtra("price");
        price_text.setText(price);
        String discount = intent.getStringExtra("discount");
        discount_text.setText(discount);
        String final_price = intent.getStringExtra("final_price");
        final_price_text.setText(final_price);
        //cart_text_price.setText(final_price);

//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            int image = extras.getInt("item_image");
//            imageView = findViewById(R.id.imageView_menu_image);
//            imageView.setImageResource(R.drawable.menu_image);
//        } else {
//            Toast.makeText(this, "Image value is null", Toast.LENGTH_SHORT).show();
//        }

    }

    private void getAddCart() {

        MyPreferences myPreferences = new MyPreferences(this);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<AddCart> callAddCart = apiInterface.getAddCart(myPreferences.readId(),myRandomNumber,android_id,menuactivitykey_str,String.valueOf(quantity),"0","0",item_name,"1");
        callAddCart.enqueue(new Callback<AddCart>() {
            @Override
            public void onResponse(Call<AddCart> call, Response<AddCart> response) {
                if(response.body().getResponse().equals("true")){
                    Toast.makeText(MenuDetails.this, ""+response.body().getResponse_message(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MenuDetails.this, "Please add product!!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<AddCart> call, Throwable t) {
                Toast.makeText(MenuDetails.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateRandomNumber() {

//        int aNumber = (int) (100 * Math.random()) + 1;
//        String strI = String.valueOf(aNumber);
//        myRandomNumber = str+strI;

        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        myRandomNumber = str + String.format("%06d", number);

        SharedPreferences sharedPreferences = getSharedPreferences("MyUserPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("userId",myRandomNumber);
        myEdit.apply();

        Toast.makeText(this, ""+myRandomNumber, Toast.LENGTH_SHORT).show();

        Log.e(TAG, "generateRandomNumber: "+myRandomNumber );
    }

    // On click on "-" text
    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
            display(quantity);
            quantity = Integer.parseInt(quantityText.getText().toString());
            String final_price = intent.getStringExtra("final_price");
            int price = quantity*(Integer.parseInt(final_price));
            displayPrice(price);
        }
    }

    // On click on "+" text
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
        quantity = Integer.parseInt(quantityText.getText().toString());
        String final_price = intent.getStringExtra("final_price");
        int price = quantity*(Integer.parseInt(final_price));
        displayPrice(price);
    }

    private void display(int number) {
        quantityText.setText("" + number);
    }

    private void displayPrice(int number) {
        cart_text_price.setText("" + number);
    }
 }