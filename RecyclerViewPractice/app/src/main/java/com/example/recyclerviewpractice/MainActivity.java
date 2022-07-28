package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<EventModel> events= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hook
        RecyclerView recyclerView= findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        events.add(new EventModel("25", "Nov", "Apple Event ", "Speaker Tim Cook.", "25-11-2017 : 04:00 PM"));
        events.add(new EventModel("01", "Nov", "Twitter Event ", "Speaker Jack Dorsey.", "01-11-2017 : 07:00 PM"));
        events.add(new EventModel("18", "Oct", "Google Event ", "Speaker Lary Page.", "18-10-2017 : 03:00 PM"));
        events.add(new EventModel("16", "Oct", "Facebook Event ", "Speaker Mark Zukerberg.", "16-10-2017 : 01:00 PM"));

        Recycler adapter = new Recycler(this, events);
        recyclerView.setAdapter(adapter);
    }
}