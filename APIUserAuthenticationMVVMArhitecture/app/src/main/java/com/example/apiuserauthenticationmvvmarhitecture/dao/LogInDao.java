package com.example.apiuserauthenticationmvvmarhitecture.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.apiuserauthenticationmvvmarhitecture.classModels.LogInEntity;
import com.example.apiuserauthenticationmvvmarhitecture.classModels.TasksEntity;

import java.util.List;

@Dao
public interface LogInDao {
    String table_name= "users";
    String table_name2="tasks";

    @Insert
    void insertLoginResponse(LogInEntity logInEntity);

    @Query(value = "Select * from " + table_name)
    List<LogInEntity> getAllUsers();





}
