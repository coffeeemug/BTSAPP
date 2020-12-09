package com.example.bts530;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class BusinessProfile extends AppCompatActivity {

    ImageView home;
    ImageView search;
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_profile);

        home = findViewById(R.id.homebttn);
        search = findViewById(R.id.searchbttn);
        profile = findViewById(R.id.profbttn);

        String [] Services = {"Wash Only", "Wash and Detail", "Detail Only"};

        ListAdapter profileAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Services);
        ListView service_listview = (ListView) findViewById(R.id.service_list);
        service_listview.setAdapter(profileAdapter);

        service_listview.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(BusinessProfile.this, Checkout.class);
                        startActivity(intent);
                    }
                }
        );


        search.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BusinessProfile.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BusinessProfile.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        profile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BusinessProfile.this, customer_profile.class);
                startActivity(intent);
            }

        });
    }
}