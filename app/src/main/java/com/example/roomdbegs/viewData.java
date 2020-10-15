package com.example.roomdbegs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class viewData extends AppCompatActivity {

    TextView tvName,tvEmail,tvPhno,tvCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        tvCountry=findViewById(R.id.tvCountry);
        tvEmail=findViewById(R.id.tvMail);
        tvName=findViewById(R.id.tvName);
        tvPhno=findViewById(R.id.tvPhno);


        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String country = intent.getStringExtra("country");
        String phone = intent.getStringExtra("phone");

        tvName.setText(name);
        tvPhno.setText(phone);
        tvEmail.setText(email);
        tvCountry.setText(country);

    }
}
