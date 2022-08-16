package com.example.apibasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    List<Structure> postList=null;
    List<Structure> test=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView= findViewById(R.id.rv);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        DatabaseHelper databaseHelper= new DatabaseHelper(this);
        //Structure post= new Structure(123, "Apple", "Apple is a powerful comoany");
        /*
        apiInterface.addPostSecond(123, "Apple", "Ok" ).enqueue(new Callback<Structure>() {
            @Override
            public void onResponse(Call<Structure> call, Response<Structure> response) {

                if(!response.isSuccessful())
                {
                    return;
                }

                Toast.makeText(MainActivity.this, "" + response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Structure> call, Throwable t) {

            }
        });
        */


        apiInterface.getPosts().enqueue(new Callback<List<Structure>>() {
            @Override
            public void onResponse(Call<List<Structure>> call, Response<List<Structure>> response) {
                if(response.body().size()>0)
                {
                    if(postList!=null) {
                        Toast.makeText(MainActivity.this, "No need", Toast.LENGTH_SHORT).show();


                    }
                    else if(postList==null)
                    {
                        postList = response.body();
                        Toast.makeText(MainActivity.this, postList.size()+ "", Toast.LENGTH_SHORT).show();
                        Recycler adapter = new Recycler(MainActivity.this, postList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerView.setAdapter(adapter);

                        Toast.makeText(MainActivity.this, "List is not empty", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(MainActivity.this, postList.get(1).getBody()+"", Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < postList.size(); i++) {
                            databaseHelper.insertPosts(postList.get(i).getId()+"", postList.get(i).getUserId()+"", postList.get(i).getTitle(), postList.get(i).getBody());
                        }
                        test= databaseHelper.fetchContact();
                        for (int i = 0; i < test.size(); i++) {

                            Log.d("Contacts", "Name: " + postList.get(i).getBody());


                        }




                    }




                }
                else
                {
                    Toast.makeText(MainActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Structure>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });


    }
}