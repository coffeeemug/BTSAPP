package com.example.bts530;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    TextView loginText;
    EditText email;
    EditText password;
    Button registeruser;
    Button registerbus;
    Button login;
    ProgressBar progressbar;

    UserDBManager dbManagerU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginText = findViewById(R.id.logintxt);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        registeruser = findViewById(R.id.registerbttn);
        registerbus = findViewById(R.id.registerbttn2);
        login = findViewById(R.id.loginbttn);
        progressbar = findViewById(R.id.progressBar);

        dbManagerU = new UserDBManager(this, null, null, 1);


        registeruser.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                //progressbar.setVisibility(View.VISIBLE);

                UserAccounts user = new UserAccounts(email.getText().toString());
                dbManagerU.addUser(user);

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);

            }

        });

        registerbus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                //progressbar.setVisibility(View.VISIBLE);

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                progressbar.setVisibility(View.VISIBLE);

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);

                Toast.makeText(LoginActivity.this,"Successfully logged In", Toast.LENGTH_SHORT).show();
            }
        });
    }
}