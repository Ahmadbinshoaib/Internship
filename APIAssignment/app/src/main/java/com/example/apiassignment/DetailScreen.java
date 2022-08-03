package com.example.apiassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetailScreen extends AppCompatActivity {
    TextView title, id, flight, eventdate, unix, details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        Intent receiveIntent = this.getIntent();

        title= (TextView) findViewById(R.id.title);
        id= (TextView) findViewById(R.id.id);
        flight= (TextView) findViewById(R.id.flight);
        eventdate= (TextView) findViewById(R.id.utc);
        unix= (TextView) findViewById(R.id.unix);
        details= (TextView) findViewById(R.id.details);



        title.setText(getIntent().getStringExtra("title"));
        id.setText(getIntent().getStringExtra("id"));
        flight.setText(getIntent().getStringExtra("flightno"));
        eventdate.setText(getIntent().getStringExtra("eventdate"));
        unix.setText(getIntent().getStringExtra("eventdateunix"));
        details.setText(getIntent().getStringExtra("details"));



    }
}