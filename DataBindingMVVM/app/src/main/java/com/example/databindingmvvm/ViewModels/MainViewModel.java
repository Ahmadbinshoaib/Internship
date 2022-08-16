package com.example.databindingmvvm.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.databindingmvvm.models.Customer;

public class MainViewModel extends AndroidViewModel {
    Customer customer;
    public MainViewModel(@NonNull Application application) {
        super(application);
        customer= new Customer();
        customer.setCustName("Ahmad Shoaib MVVM");
    }

    public Customer getCustomer() {
        return customer;
    }
}
