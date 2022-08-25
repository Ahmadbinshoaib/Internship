package com.example.apiuserauthenticationmvvmarhitecture.viewModels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.apiuserauthenticationmvvmarhitecture.responses.Data;

public class ModelItemClass extends BaseObservable {
    private Data data;

    public ModelItemClass(Data data) {
        this.data = data;
    }

    @Bindable
    public String getDescription()
    {
        return data.getDescription();
    }
    @Bindable
    public String getCreatedAt()
    {
        return data.getCreatedAt();
    }
    @Bindable
    public String getUpdatedAt()
    {
        return data.getUpdatedAt();
    }
}
