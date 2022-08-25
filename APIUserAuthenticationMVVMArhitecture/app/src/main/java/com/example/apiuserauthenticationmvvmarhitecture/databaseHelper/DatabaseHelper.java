package com.example.apiuserauthenticationmvvmarhitecture.databaseHelper;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.apiuserauthenticationmvvmarhitecture.classModels.LogInEntity;
import com.example.apiuserauthenticationmvvmarhitecture.classModels.TasksEntity;
import com.example.apiuserauthenticationmvvmarhitecture.dao.LogInDao;
import com.example.apiuserauthenticationmvvmarhitecture.dao.TasksDao;

@Database(entities = {LogInEntity.class, TasksEntity.class} , exportSchema = false, version = 2)
public abstract class DatabaseHelper extends RoomDatabase {
    private static final String DB_NAME= "TODO";
    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getDB(Context context){
        if(instance== null)
        {
            instance= Room.databaseBuilder(context, DatabaseHelper.class, DB_NAME).
                    fallbackToDestructiveMigration().
                    allowMainThreadQueries().
                    build();
        }
        return instance;
    }

    public abstract LogInDao logInDao();
    public abstract TasksDao tasksDao();
}
