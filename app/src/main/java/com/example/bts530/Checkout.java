package com.example.bts530;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Checkout extends AppCompatActivity {

    private static final String TAG = "Checkout";

    ImageView home;
    ImageView search;
    ImageView profile;
    ImageView paybttn;

    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        home = findViewById(R.id.homebttn);
        search = findViewById(R.id.searchbttn);
        profile = findViewById(R.id.profbttn);
        paybttn = findViewById(R.id.googleplaybttns);

        search.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Checkout.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Checkout.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        profile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Checkout.this, customer_profile.class);
                startActivity(intent);
            }

        });

        paybttn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Log.d(TAG,"sendmail: ");

                String[] TO_EMAILS= {"example@gmail.com"};
                String[] CC = {"example@gmail.com"};
                String[] BCC = {"example@gmail.com"};

                Intent intent = new Intent (Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, TO_EMAILS);
                intent.putExtra(Intent.EXTRA_CC, CC);
                intent.putExtra(Intent.EXTRA_BCC, BCC);

                intent.putExtra(Intent.EXTRA_SUBJECT, "Service Request");
                intent.putExtra(Intent.EXTRA_TEXT, "================================="+
                        "\nCustomer's Name: Chike" +
                        "\n\nPhone: 123-456-7890" +
                        "\n\nRequested Service: Wash" +
                        "\n\nDate: 28/1/2021" +
                        "\n\nCar Make: Toyota" +
                        "\n\nCar Model: Supra" +
                        "\n\nCar Color: White" +
                        "\n\nDescription: Car would be parked around back" +
                        "\n=================================");

                startActivity(Intent.createChooser(intent, "Choose Your preferred email app"));

                Toast.makeText(Checkout.this,"Payment Complete", Toast.LENGTH_SHORT).show();
            }

        });
    }
}