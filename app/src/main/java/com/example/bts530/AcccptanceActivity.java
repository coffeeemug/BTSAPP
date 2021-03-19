package com.example.bts530;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AcccptanceActivity extends AppCompatActivity {

    ImageView home;
    ImageView search;
    ImageView profile;

    Button accept;
    Button decline;

    //GridView gridView;

    //String[] fields = {"Name", "Phone", "Service", "Date", "time", "Make", "Model", "Desc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acccptance);

        home = findViewById(R.id.homebttn);
        search = findViewById(R.id.searchbttn);
        profile = findViewById(R.id.profbttn);

        accept = findViewById(R.id.acceptBttn);
        decline = findViewById(R.id.declineBttn);


        search.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AcccptanceActivity.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AcccptanceActivity.this, HomeActivity.class);
                startActivity(intent);

            }

        });

        profile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AcccptanceActivity.this, customer_profile.class);
                startActivity(intent);
            }

        });

        accept.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Toast.makeText(AcccptanceActivity.this,"You have accepted", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(AcccptanceActivity.this, customer_profile.class);
                startActivity(intent);

                // add nottification
            }

        });

        decline.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Toast.makeText(AcccptanceActivity.this,"You have declined", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(AcccptanceActivity.this, customer_profile.class);
                startActivity(intent);

            }

        });

        //gridView = findViewById(R.id.form_grid);
    }
}