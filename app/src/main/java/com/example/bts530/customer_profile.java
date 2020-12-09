package com.example.bts530;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class customer_profile extends AppCompatActivity {

    ImageView home;
    ImageView search;
    ImageView profile;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        home = findViewById(R.id.homebttn);
        search = findViewById(R.id.searchbttn);
        profile = findViewById(R.id.profbttn);

        listView = findViewById(R.id.car_list);

        ArrayList<Cars> arraylist = new ArrayList<>();

        arraylist.add(new Cars(R.drawable.car1, "Mazda Rx7", "Green Mazda Rx7"));
        arraylist.add(new Cars(R.drawable.car2, "370z", "Blue 370z"));
        arraylist.add(new Cars(R.drawable.car3, "Subaru Impreza", "Camo Subaru Impreza"));
        arraylist.add(new Cars(R.drawable.car4, "Nissan GTR", "Black Nissan GTR"));
        arraylist.add(new Cars(R.drawable.car5, "Toyota Supra", "Purple Toyota Supra"));

        CarsAdapter carsAdapter = new CarsAdapter(this, R.layout.list_row,arraylist);
        listView.setAdapter(carsAdapter);


        search.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(customer_profile.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(customer_profile.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        profile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(customer_profile.this, customer_profile.class);
                startActivity(intent);
            }

        });

    }
}