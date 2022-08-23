package com.example.apiuserauthenticationmvvmarhitecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.example.apiuserauthenticationmvvmarhitecture.databinding.ActivityMainBinding;
import com.example.apiuserauthenticationmvvmarhitecture.presenter.Presenter;
import com.example.apiuserauthenticationmvvmarhitecture.viewModels.LogInViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private LogInViewModel logInViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main );
        logInViewModel= new LogInViewModel(this);
        activityMainBinding.setLoginview(logInViewModel);

        activityMainBinding.setPresenter(new Presenter() {
            @Override
            public void loginData() {
                showToast("Login Activity Presenter");
                final String email= activityMainBinding.email.getText().toString();
                final String password= activityMainBinding.password.getText().toString();
                logInViewModel.setLoginRequest(email, password);
            }
        });

    }

    void showToast(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}