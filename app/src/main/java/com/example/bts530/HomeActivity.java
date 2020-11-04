package com.example.bts530;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String [] businesses = {"Business1", "Business2", "Business3","Business4", "Business5", "Business6","Business7", "Business8", "Business9","Business10", "Business11", "Business12", };

        ListAdapter homepageAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, businesses);
        ListView homepage_listview = (ListView) findViewById(R.id.homepage_listview);
        homepage_listview.setAdapter(homepageAdapter);

        homepage_listview.setOnItemClickListener(

                new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(HomeActivity.this, customer_profile.class);
                        startActivity(intent);
                    }
                }
        );
    }
}