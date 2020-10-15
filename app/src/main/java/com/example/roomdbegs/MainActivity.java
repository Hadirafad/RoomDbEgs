package com.example.roomdbegs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name,email,country,phone,view;
    Button btnSave,btnView;
    RecyclerView recyclerView;

    RoomDB database;
    List<MainData> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        country = findViewById(R.id.country);
        phone = findViewById(R.id.phone);
        btnSave = findViewById(R.id.btnSave);
        //btnView = findViewById(R.id.btnView);
        recyclerView = findViewById(R.id.recycler_view);

        database =RoomDB.getInstance(this);
        dataList=database.mainDao().getAll();


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sName=name.getText().toString().trim();
                String sPhone=phone.getText().toString().trim();
                String sCountry=country.getText().toString().trim();
                String sEmail=email.getText().toString().trim();

                MainData data=new MainData();
                data.setEmail(sEmail);
                data.setName(sName);
                data.setCountry(sCountry);
                data.setPhone(sPhone);
                database.mainDao().insert(data);
                name.setText("");
                email.setText("");
                country.setText("");
                phone.setText("");

                dataList.clear();

                //MainData d=dataList.get(0);
                String iEmail=data.getEmail();
                String iName=data.getName();
                String iCountry=data.getCountry();
                String iPhno=data.getPhone();

                Intent myIntent = new Intent(MainActivity.this, viewData.class);
                myIntent.putExtra("name", iName);
                myIntent.putExtra("email", iEmail);
                myIntent.putExtra("country", iCountry);
                myIntent.putExtra("phone", iPhno);
                startActivity(myIntent);

            }
        });

      /* btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainData d=dataList.get(0);
                String iEmail=d.getEmail();
                String iName=d.getName();
                String iCountry=d.getCountry();
                String iPhno=d.getPhone();

                Intent myIntent = new Intent(getApplicationContext(), viewData.class);
                myIntent.putExtra("name", iName);
                myIntent.putExtra("email", iEmail);
                myIntent.putExtra("country", iCountry);
                myIntent.putExtra("phone", iPhno);
                startActivity(myIntent);
            }
        });
*/
    }
}
