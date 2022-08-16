package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class UpdateDoctor extends AppCompatActivity {

    TextInputLayout uname, ucnic, uphone, uqual, uspeciali;
    Button up, delete;
    String sid, sname, sphone, scnic, squalif, sspecia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_doctor);

        uname= findViewById(R.id.uname);
        ucnic= findViewById(R.id.ucnic);
        uphone= findViewById(R.id.uphone);
        uqual= findViewById(R.id.uqualification);
        uspeciali= findViewById(R.id.uspecialization);

        up= findViewById(R.id.updoctor);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHelper myDB = new DatabaseHelper(UpdateDoctor.this);
                myDB.updateData(sid, uname.getEditText().getText().toString(), uphone.getEditText().getText().toString(), ucnic.getEditText().getText().toString(), uspeciali.getEditText().getText().toString(), uqual.getEditText().getText().toString());

            }
        });
        getAndSetIntentData();

        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            confirmDialog();

            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("cnic") && getIntent().hasExtra("quali")
                && getIntent().hasExtra("phone")
         && getIntent().hasExtra("speci")){
            //Getting Data from Intent
            sid = getIntent().getStringExtra("id");
            sname = getIntent().getStringExtra("name");
            scnic = getIntent().getStringExtra("cnic");
            sphone = getIntent().getStringExtra("phone");
            squalif = getIntent().getStringExtra("quali");
            sspecia = getIntent().getStringExtra("speci");
            //Setting Intent Data
            uname.getEditText().setText(sname);
            ucnic.getEditText().setText(scnic);
            uphone.getEditText().setText(sphone);
            uqual.getEditText().setText(squalif);
            uspeciali.getEditText().setText(squalif);

        }else{


        }
    }


    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + sname + " ?");
        builder.setMessage("Are you sure you want to delete " + sname + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper myDB = new DatabaseHelper(UpdateDoctor.this);
                myDB.deleteOneRow(sid);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}