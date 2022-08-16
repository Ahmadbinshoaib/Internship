package com.example.databindingmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.databindingmvvm.ViewModels.MainViewModel;
import com.example.databindingmvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding mainxml= DataBindingUtil.setContentView(this, R.layout.activity_main);

        //View Binding
        mainxml.vb.setText("View Binding" + "");

        //Data Binding
        mainxml.setDatabinding("Data Binding");


        //Structural Class
        Product product= new Product();
        product.setProName("VIVO ");
        product.setProID("12345P");
        mainxml.setProduct(product);


        //MVVM
        mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        mainxml.setCustomer(mainViewModel.getCustomer());



    }
}