package com.example.apibasic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("posts")
    Call<List<Structure>> getPosts();

    @POST("posts")
    Call<Structure> addPost ( @Body Structure post);

    @FormUrlEncoded
    @POST("posts")
    Call<Structure> addPostSecond (
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String body


    );



}
