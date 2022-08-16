package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;
    DatabaseHelper databaseHelper= new DatabaseHelper(this);
    ArrayList<Doctors> arrDoctor= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrDoctor= databaseHelper.fetchContact();
        recyclerView= findViewById(R.id.recyclerView);
        imageView = findViewById(R.id.imageView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Recycler adapter = new Recycler(this, arrDoctor);
        recyclerView.setAdapter(adapter);
        /*


        for (int i = 0; i < arrDoctor.size(); i++) {

            Log.d("Contacts", "Name: " + arrDoctor.get(i).getName());

        }*/


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AddDoctor.class);
                startActivity(intent);


            }
        });
    }


}