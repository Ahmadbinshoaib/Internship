package com.example.apiuserauthenticationmvvmarhitecture.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.apiuserauthenticationmvvmarhitecture.classModels.LogInEntity;
import com.example.apiuserauthenticationmvvmarhitecture.classModels.TasksEntity;

import java.util.List;

@Dao
public interface TasksDao {
    String table_name= "tasks";

    @Insert
    void insertTasksResponse(TasksEntity tasksEntity);

    @Query(value = "Select * from " + table_name)
    List<TasksEntity> getAllTasks();


}
