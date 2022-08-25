package com.example.apiuserauthenticationmvvmarhitecture.classModels;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tasks")
public class TasksEntity {

    @ColumnInfo(name = "status")
    private Boolean completed;
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String id;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "owner")
    private String owner;
    @ColumnInfo(name = "createdAt")
    private String createdAt;
    @ColumnInfo(name = "updatedAt")
    private String updatedAt;
    @ColumnInfo(name = "v")
    private Integer v;

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public TasksEntity(Boolean completed, @NonNull String id, String description, String owner, String createdAt, String updatedAt, Integer v) {
        this.completed = completed;
        this.id = id;
        this.description = description;
        this.owner = owner;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.v = v;
    }
}
