package com.example.bts530;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class customer_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        String [] cars = {"Car1", "Car2", "Car3","Car4", "Car5"};

        ListAdapter profileAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, cars);
        ListView cars_listview = (ListView) findViewById(R.id.cars_list);
        cars_listview.setAdapter(profileAdapter);

        cars_listview.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(customer_profile.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}