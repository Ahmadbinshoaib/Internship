package com.example.apiuserauthenticationmvvmarhitecture.remote;

import com.example.apiuserauthenticationmvvmarhitecture.request.LogInRequest;
import com.example.apiuserauthenticationmvvmarhitecture.responses.GetAllTasks;
import com.example.apiuserauthenticationmvvmarhitecture.responses.LogInResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIService {

    @POST("/user/login")
    Call<LogInResponse> userLoginCall(
            @Header("Content-Type") String content_type,
            @Body LogInRequest logInRequest);

    @GET("/task")
    Call<GetAllTasks> getTasks(
            @Header("Content-Type") String content_type,
            @Header("Authorization")String token
    );
}
