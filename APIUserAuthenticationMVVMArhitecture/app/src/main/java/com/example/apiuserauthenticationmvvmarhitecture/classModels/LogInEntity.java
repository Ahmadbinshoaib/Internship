package com.example.apiuserauthenticationmvvmarhitecture.classModels;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class LogInEntity {
    @ColumnInfo(name = "age")
    private Integer age;
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "createdAt")
    private String createdAt;
    @ColumnInfo(name = "updatedAt")
    private String updatedAt;
    @ColumnInfo(name = "v")
    private Integer v;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public LogInEntity(Integer age, String id, String name, String email, String createdAt, String updatedAt, Integer v) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.v = v;
    }
}
