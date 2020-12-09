package com.example.bts530;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {

    ImageView home;
    ImageView search;
    ImageView profile;

    SearchView thesearch;
    ArrayList<String> arraylist = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home = findViewById(R.id.homebttn);
        search = findViewById(R.id.searchbttn);
        profile = findViewById(R.id.profbttn);


        ListView listView = (ListView) findViewById(R.id.homepage_listview);
        thesearch = findViewById(R.id.search_bar);


        String business_array = "{\"Businesses\":[\n" +
                "    {\"id\":\"1\",\"business_name\":\"Gabcube\",\"email\":\"pambrogini0@google.co.jp\",\"phone_number\":\"418-830-3791\",\"business_address\":\"3604 Drewry Court\",\"detail_service_price\":50,\"detail_service_availability\":false,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"2\",\"business_name\":\"Rhyzio\",\"email\":\"fpateman1@51.la\",\"phone_number\":\"366-208-0606\",\"business_address\":\"54 Monterey Plaza\",\"detail_service_price\":50,\"detail_service_availability\":false,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"3\",\"business_name\":\"Edgeclub\",\"email\":\"jdaville2@businessinsider.com\",\"phone_number\":\"504-529-9237\",\"business_address\":\"050 Fair Oaks Street\",\"detail_service_price\":50,\"detail_service_availability\":true,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"4\",\"business_name\":\"Quimba\",\"email\":\"nwillimont3@mapquest.com\",\"phone_number\":\"597-148-0158\",\"business_address\":\"63 Merrick Crossing\",\"detail_service_price\":50,\"detail_service_availability\":true,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"5\",\"business_name\":\"Zava\",\"email\":\"hduncombe4@domainmarket.com\",\"phone_number\":\"786-100-7747\",\"business_address\":\"01238 Jackson Drive\",\"detail_service_price\":50,\"detail_service_availability\":true,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"6\",\"business_name\":\"Layo\",\"email\":\"hskyrme5@artisteer.com\",\"phone_number\":\"437-891-2084\",\"business_address\":\"62 Johnson Place\",\"detail_service_price\":50,\"detail_service_availability\":false,\"wash_price\":50,\"wash_availability\":false},\n" +
                "    {\"id\":\"7\",\"business_name\":\"Devcast\",\"email\":\"bshirlaw6@kickstarter.com\",\"phone_number\":\"772-463-8622\",\"business_address\":\"8 Bay Crossing\",\"detail_service_price\":50,\"detail_service_availability\":false,\"wash_price\":50,\"wash_availability\":false},\n" +
                "    {\"id\":\"8\",\"business_name\":\"Photobug\",\"email\":\"ceade7@telegraph.co.uk\",\"phone_number\":\"704-888-0280\",\"business_address\":\"432 Mifflin Center\",\"detail_service_price\":50,\"detail_service_availability\":true,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"9\",\"business_name\":\"Divape\",\"email\":\"mloudian8@washington.edu\",\"phone_number\":\"179-723-2606\",\"business_address\":\"815 Grim Park\",\"detail_service_price\":50,\"detail_service_availability\":false,\"wash_price\":50,\"wash_availability\":false},\n" +
                "    {\"id\":\"10\",\"business_name\":\"Vidoo\",\"email\":\"gsimison9@sun.com\",\"phone_number\":\"744-281-8783\",\"business_address\":\"6848 Mandrake Avenue\",\"detail_service_price\":50,\"detail_service_availability\":true,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"11\",\"business_name\":\"Twinder\",\"email\":\"vgommesa@umich.edu\",\"phone_number\":\"781-850-0096\",\"business_address\":\"9 Mayfield Drive\",\"detail_service_price\":50,\"detail_service_availability\":true,\"wash_price\":50,\"wash_availability\":false},\n" +
                "    {\"id\":\"12\",\"business_name\":\"Topiczoom\",\"email\":\"ldeethb@redcross.org\",\"phone_number\":\"586-488-5024\",\"business_address\":\"1 Riverside Drive\",\"detail_service_price\":50,\"detail_service_availability\":true,\"wash_price\":50,\"wash_availability\":false},\n" +
                "    {\"id\":\"13\",\"business_name\":\"Zoomdog\",\"email\":\"ehabishawc@yahoo.com\",\"phone_number\":\"685-817-5477\",\"business_address\":\"02 Monterey Plaza\",\"detail_service_price\":50,\"detail_service_availability\":true,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"14\",\"business_name\":\"Fivebridge\",\"email\":\"rgonnellyd@diigo.com\",\"phone_number\":\"878-930-2857\",\"business_address\":\"2280 Corscot Way\",\"detail_service_price\":50,\"detail_service_availability\":false,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"15\",\"business_name\":\"Quire\",\"email\":\"ejoynere@360.cn\",\"phone_number\":\"306-911-5466\",\"business_address\":\"5189 Dahle Terrace\",\"detail_service_price\":50,\"detail_service_availability\":true,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"16\",\"business_name\":\"Photojam\",\"email\":\"agiraudotf@drupal.org\",\"phone_number\":\"741-113-3623\",\"business_address\":\"28494 Vidon Hill\",\"detail_service_price\":50,\"detail_service_availability\":false,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"17\",\"business_name\":\"Mynte\",\"email\":\"lclemog@is.gd\",\"phone_number\":\"766-846-8240\",\"business_address\":\"8730 Rockefeller Trail\",\"detail_service_price\":50,\"detail_service_availability\":false,\"wash_price\":50,\"wash_availability\":false},\n" +
                "    {\"id\":\"18\",\"business_name\":\"Riffpath\",\"email\":\"arahillh@homestead.com\",\"phone_number\":\"721-452-5405\",\"business_address\":\"3 Gulseth Park\",\"detail_service_price\":50,\"detail_service_availability\":false,\"wash_price\":50,\"wash_availability\":true},\n" +
                "    {\"id\":\"19\",\"business_name\":\"Realblab\",\"email\":\"jcounteri@homestead.com\",\"phone_number\":\"293-505-9334\",\"business_address\":\"277 Nova Way\",\"detail_service_price\":50,\"detail_service_availability\":false,\"wash_price\":50,\"wash_availability\":false},\n" +
                "    {\"id\":\"20\",\"business_name\":\"Yombu\",\"email\":\"msparrowhawkj@homestead.com\",\"phone_number\":\"408-255-8896\",\"business_address\":\"50 Monument Center\",\"detail_service_price\":50,\"detail_service_availability\":false,\"wash_price\":50,\"wash_availability\":true}]\n" +
                "}";
        try{

            JSONObject jsonObject = new JSONObject(business_array);
            JSONArray jsonArray = jsonObject.getJSONArray("Businesses");

            for(int i=0; i<jsonArray.length(); i++){

                JSONObject object = jsonArray.getJSONObject(i);
                String businessName = object.getString("business_name");
                String businessEmail = object.getString("email");
                String businessPhone = object.getString("phone_number");

                arraylist.add((businessName + "\n" + "Email: " +businessEmail + "\n" + "Phone: " + businessPhone));
            }

        }catch (JSONException e){
            e.printStackTrace();
        }

        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, arraylist);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(HomeActivity.this, BusinessProfile.class);
                        startActivity(intent);
                    }
                }
        );

        thesearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                HomeActivity.this.arrayAdapter.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                HomeActivity.this.arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        search.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        profile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, customer_profile.class);
                startActivity(intent);
            }

        });
    }
}