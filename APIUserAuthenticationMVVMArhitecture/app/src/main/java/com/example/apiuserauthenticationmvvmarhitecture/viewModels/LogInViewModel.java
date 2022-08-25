package com.example.apiuserauthenticationmvvmarhitecture.viewModels;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.ObservableField;

import com.example.apiuserauthenticationmvvmarhitecture.Dashboard;;
import com.example.apiuserauthenticationmvvmarhitecture.classModels.LogInEntity;
import com.example.apiuserauthenticationmvvmarhitecture.classModels.TasksEntity;
import com.example.apiuserauthenticationmvvmarhitecture.databaseHelper.DatabaseHelper;
import com.example.apiuserauthenticationmvvmarhitecture.remote.APIService;
import com.example.apiuserauthenticationmvvmarhitecture.remote.RetrofitInstance;
import com.example.apiuserauthenticationmvvmarhitecture.request.LogInRequest;
import com.example.apiuserauthenticationmvvmarhitecture.responses.Data;
import com.example.apiuserauthenticationmvvmarhitecture.responses.GetAllTasks;
import com.example.apiuserauthenticationmvvmarhitecture.responses.LogInResponse;
import com.example.apiuserauthenticationmvvmarhitecture.responses.User;


import java.util.ArrayList;
import java.util.List;
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
                    DatabaseHelper databaseHelper = DatabaseHelper.getDB(context);
                    try {

                        databaseHelper.logInDao().insertLoginResponse(
                                new LogInEntity(user.getAge(), user.getId(), user.getName(), user.getEmail(), user.getCreatedAt(), user.getUpdatedAt(), user.getV())
                        );

                    }
                    catch (Exception e)
                    {

                    }

                    List<LogInEntity> arr= databaseHelper.logInDao().getAllUsers();
                    for (int i = 0; i < arr.size() ; i++) {
                        Log.d("Data", "Database Name" + arr.get(i).getName());
                        showToast("Database Say "+ arr.get(i).getName() + arr.get(i).getEmail());
                        
                    }

                   apiService.getTasks("application/json", logInResponse.getToken() + "" ).enqueue(new Callback<GetAllTasks>() {
                       @Override
                       public void onResponse(Call<GetAllTasks> call, Response<GetAllTasks> response) {
                           if(response.isSuccessful())
                           {
                               showToast("Tasksssss");
                               GetAllTasks getAllTasks= new GetAllTasks();
                               getAllTasks= response.body();
                               List<Data> list= new ArrayList<>();
                               list= getAllTasks.getData();
                               showToast(list.get(0).getDescription()+"Tasks Cumminh");

                               DatabaseHelper databaseHelper = DatabaseHelper.getDB(context);
                               try {

                                   for (int i = 0; i < list.size(); i++) {

                                       databaseHelper.tasksDao().insertTasksResponse(new TasksEntity(list.get(i).getCompleted(), list.get(i).getId(),
                                               list.get(i).getDescription(),list.get(i).getOwner(), list.get(i).getCreatedAt(), list.get(i).getUpdatedAt(), list.get(i).getV()));
                                   }


                               }
                               catch (Exception e)
                               {

                               }

                               List<TasksEntity> arr1= databaseHelper.tasksDao().getAllTasks();
                               for (int i = 0; i < arr1.size() ; i++) {
                                   Log.d("Data", "Database Description" + arr1.get(i).getDescription());

                               }



                           }
                           else
                           {

                           }

                       }

                       @Override
                       public void onFailure(Call<GetAllTasks> call, Throwable t) {

                       }
                   });





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
