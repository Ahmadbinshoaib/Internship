package com.example.databaseconfigurationdatabasehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<ContactModel> contactModels= new ArrayList<>();
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(this);
        databaseHelper.insertContacts("Ahmad", "03098021640");
        databaseHelper.insertContacts("Ahmad1", "03098021640");
        databaseHelper.insertContacts("Ahmad2", "03098021640");
        databaseHelper.insertContacts("Talha", "03098021640");


        contactModels= databaseHelper.fetchContact();

        for (int i = 0; i < contactModels.size(); i++) {

            Log.d("Contacts", "Name: " + contactModels.get(i).getName());


        }
    }
}