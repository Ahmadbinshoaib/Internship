package com.example.apiassignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("history")
    Call<List<Structure>> getHistory();
}
