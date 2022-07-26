package com.example.performa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //Spinners
    String[] items =  {"Lahore","Islamabad","Peshawar","Dera Ghazi Khan","Gujranwala"};
    String[] districts =  {"Lahore","Islamabad","Peshawar","Dera Ghazi Khan","Gujranwala"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    AutoCompleteTextView autoCompleteTxt1;
    ArrayAdapter<String> adapterItems1;

    //DatePicker
    EditText mDateFormat;
    DatePickerDialog.OnDateSetListener onDateSetListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar calendar= Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_items,items);
        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });


        autoCompleteTxt1 = findViewById(R.id.auto_complete_txt1);

        adapterItems1 = new ArrayAdapter<String>(this,R.layout.list_items,districts);
        autoCompleteTxt1.setAdapter(adapterItems1);

        autoCompleteTxt1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });

        //Date Picker

        mDateFormat=  findViewById(R.id.dateFormat);
        mDateFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog= new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, onDateSetListener,year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

   onDateSetListener = new DatePickerDialog.OnDateSetListener() {
       @Override
       public void onDateSet(DatePicker datePicker, int year, int month, int day) {
           month= month+1;
           String date= day + " / " + month + " / " + year;
           mDateFormat.setText(date);



       }
   };
    }
}