package com.example.apiuserauthenticationmvvmarhitecture.viewModels;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiuserauthenticationmvvmarhitecture.adapters.RecyclerAdapter;
import com.example.apiuserauthenticationmvvmarhitecture.classModels.TasksEntity;
import com.example.apiuserauthenticationmvvmarhitecture.databaseHelper.DatabaseHelper;
import com.example.apiuserauthenticationmvvmarhitecture.responses.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class DisplayDataViewModel extends BaseObservable {


    private Context context;
    private List<Data> data;
    private RecyclerAdapter recyclerAdapter;

    public DisplayDataViewModel(Context context) {
        data= new ArrayList<>();
        recyclerAdapter= new RecyclerAdapter();
        this.context=context;
    }

    @BindingAdapter({"app:adapter", "app:data"})
    public static void bind(RecyclerView recyclerView, RecyclerAdapter adapter, List<Data> data)
    {
        recyclerView.setAdapter(adapter);
        adapter.update(data);
    }

   // private Context context;

    public void setData() {
        setArrayData();
    }

    @Bindable
    public List<Data> getData() {
        return data;
    }

    @Bindable
    public RecyclerAdapter getRecyclerAdapter() {
        return recyclerAdapter;
    }

    private void setArrayData() {
//        for (int i = 0; i < 10; i++) {
//            Data ok= new Data();
//            ok.setDescription("reading");
//            data.add(ok);
//
//        }

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(context);
        List<TasksEntity> arr1= databaseHelper.tasksDao().getAllTasks();
        Toast.makeText(context, ""+ arr1.size(), Toast.LENGTH_SHORT).show();

        for (int i = 0; i < arr1.size() ; i++) {
            Data ok= new Data();
           ok.setDescription(arr1.get(i).getDescription());
           ok.setCreatedAt(arr1.get(i).getCreatedAt());
           ok.setUpdatedAt(arr1.get(i).getUpdatedAt());
           data.add(ok);

        }





    }
}
