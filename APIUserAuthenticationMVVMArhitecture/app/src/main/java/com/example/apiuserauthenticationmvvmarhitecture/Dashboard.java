package com.example.apiuserauthenticationmvvmarhitecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.apiuserauthenticationmvvmarhitecture.databinding.ActivityDashboardBinding;
import com.example.apiuserauthenticationmvvmarhitecture.databinding.ActivityMainBinding;
import com.example.apiuserauthenticationmvvmarhitecture.viewModels.DisplayDataViewModel;

public class Dashboard extends AppCompatActivity {
    ActivityDashboardBinding activity;
    DisplayDataViewModel displayDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity= DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        displayDataViewModel= new DisplayDataViewModel(this);
        activity.setViewModel(displayDataViewModel);
        displayDataViewModel.setData();


    }
}