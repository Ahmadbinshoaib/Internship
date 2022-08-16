package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class AddDoctor extends AppCompatActivity {
    TextInputLayout name, cnic, phone, qual, speciali;
    Button add, clear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DatabaseHelper databaseHelper= new DatabaseHelper(this);
        ArrayList<Doctors> contactModels= new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        name= findViewById(R.id.dname);

        cnic= findViewById(R.id.dcnic);
        phone= findViewById(R.id.dphone);
        qual= findViewById(R.id.dqualification);
        speciali= findViewById(R.id.dspecialization);


        add= findViewById(R.id.adddoctor);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ArrayList<Doctors> contactModels= new ArrayList<>();

                databaseHelper.insertDoctors(name.getEditText().getText().toString(), phone.getEditText().getText().toString(), cnic.getEditText().getText().toString(), qual.getEditText().getText().toString(), speciali.getEditText().getText().toString());

                Toast.makeText(AddDoctor.this, "Added Successfully", Toast.LENGTH_SHORT).show();


            }
        });

        clear= findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });














    }
    public void clear()
    {
      name.setHint("Name");
    }
}