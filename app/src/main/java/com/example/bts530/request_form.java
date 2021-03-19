package com.example.bts530;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class request_form extends AppCompatActivity {

    ImageView home;
    ImageView search;
    ImageView profile;

    private EditText customer_Name, customerPhone,customerService, requestDate, car_Make, car_Model, car_Color, car_Desc;
    String name, phone,service, date, make, model, color, description;
    Button send_req_Bttn, cancel_Bttn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);

        home = findViewById(R.id.homebttn);
        search = findViewById(R.id.searchbttn);
        profile = findViewById(R.id.profbttn);

        customer_Name = (EditText) findViewById(R.id.customerName);
        customerPhone = (EditText) findViewById(R.id.cusPhone);
        customerService = (EditText) findViewById(R.id.cusService);
        requestDate = (EditText) findViewById(R.id.reqDate);
        car_Make = (EditText) findViewById(R.id.carMake);
        car_Model = (EditText) findViewById(R.id.carModel);
        car_Color = (EditText) findViewById(R.id.carColor);
        car_Desc = (EditText) findViewById(R.id.carDesc);

        cancel_Bttn = findViewById(R.id.cancelBttn);
        cancel_Bttn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(request_form.this, BusinessProfile.class);
                startActivity(intent);

                Toast.makeText(request_form.this,"Request Cancelled", Toast.LENGTH_SHORT).show();
            }

        });

        send_req_Bttn = findViewById(R.id.sendreqBttn);
        send_req_Bttn.setOnClickListener(new View.OnClickListener(){

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick (View view){
                sendForm();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(request_form.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(request_form.this, HomeActivity.class);
                startActivity(intent);
            }

        });

        profile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(request_form.this, customer_profile.class);
                startActivity(intent);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sendForm(){

        initialize();
        if(!validate()){

            Toast.makeText(request_form.this,"Please ensure all Fields are correctly filled", Toast.LENGTH_LONG).show();
        }
        else{

            successful();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean validate(){

       boolean valid = true;

        if(name.equals("")){

            customer_Name.setError("Please enter a valid name");
            valid = false;
        }

        if(phone.equals("")){

            customerPhone.setError("Please enter a valid phone number");
            valid = false;
        }

        if(service.equals("")){

            customerPhone.setError("Please enter a valid phone number");
            valid = false;
        }

        if(date.equals("")){

            customerPhone.setError("Please enter a date");
            valid = false;
        }
        else{

            checkDateFormat(date);
        }

        if(make.equals("")){

            customerPhone.setError("Please enter a make");
            valid = false;
        }

        if(model.equals("")){

            customerPhone.setError("Please enter a model");
            valid = false;
        }

        if(color.equals("")){

            customerPhone.setError("Please enter a color");
            valid = false;
        }

        return valid;
    };

    public Boolean checkDateFormat(String date){
        if (date == null || !date.matches("^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}$"))
            return false;
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        try {
            format.parse(date);
            return true;
        }catch (ParseException e){
            return false;
        }
    }

    public void successful(){

        Intent intent = new Intent(request_form.this, AcccptanceActivity.class);
        startActivity(intent);

        Toast.makeText(request_form.this,"Your Request has been Sent", Toast.LENGTH_SHORT).show();
    }

    public void initialize(){

        name = customer_Name.getText().toString().trim();
        phone = customerPhone.getText().toString().trim();
        service = customerService.getText().toString().trim();
        date = requestDate.getText().toString().trim();
        make = car_Make.getText().toString().trim();
        model = car_Model.getText().toString().trim();
        color = car_Color.getText().toString().trim();
        description = car_Desc.getText().toString().trim();
    }
}


