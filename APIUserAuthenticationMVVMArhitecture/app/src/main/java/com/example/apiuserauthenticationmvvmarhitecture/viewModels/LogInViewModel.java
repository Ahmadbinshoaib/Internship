package com.example.apiuserauthenticationmvvmarhitecture.viewModels;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.example.apiuserauthenticationmvvmarhitecture.Dashboard;;
import com.example.apiuserauthenticationmvvmarhitecture.remote.APIService;
import com.example.apiuserauthenticationmvvmarhitecture.remote.RetrofitInstance;
import com.example.apiuserauthenticationmvvmarhitecture.request.LogInRequest;
import com.example.apiuserauthenticationmvvmarhitecture.responses.LogInResponse;
import com.example.apiuserauthenticationmvvmarhitecture.responses.User;


import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInViewModel  extends Observable {

    private Context context;
    public final ObservableField<String> email= new ObservableField<>("");
    public final ObservableField<String> password= new ObservableField<>("");


    public LogInViewModel(Context context) {
        this.context = context;

    }
    public void setLoginRequest(String email, String password){

        showToast("Inside Login View Model");
        LogInRequest logInRequest= new LogInRequest(email, password);
        APIService apiService = RetrofitInstance.getRetrofit().create(APIService.class);
        apiService.userLoginCall("application/json",logInRequest ).enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {

                if(response.isSuccessful())
                {
                    showToast("No empty");
                   LogInResponse logInResponse= new LogInResponse();
                   logInResponse= response.body();
                   //showToast( "" + logInResponse.getClass());
                    showToast(""+ logInResponse.getToken());
                    User user= logInResponse.getUser();
                    showToast(""+ user.getName());

                    Intent intent= new Intent(context, Dashboard.class);
                    context.startActivity(intent);

                }
//                else if(response.toString()=="400")
//                {
//                    showToast("Error 404" + response.toString());
//                }
                else
                {

                    showToast("Error occured. Please try again later.");

                }


            }
            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {
                showToast(""+ t.getLocalizedMessage());

            }
        });


        /*
        ApiInterface1 apiInterface1 = RetrofitInstance1.getRetrofit().create(ApiInterface1.class);
        apiInterface1.getHistory().enqueue(new Callback<List<Structure>>() {
            @Override
            public void onResponse(Call<List<Structure>> call, Response<List<Structure>> response) {
                if(response.body().size()>0)
                {

                    showToast("No empty");
                    List<Structure> postList = response.body();
                    showToast(""+ postList.get(0).getDetails());


                }
                else
                {
                    showToast("Error");
                }

            }

            @Override
            public void onFailure(Call<List<Structure>> call, Throwable t) {
                showToast(""+ t.getLocalizedMessage());

            }
        });

         */


    }

    public void showToast(String msg)
    {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
