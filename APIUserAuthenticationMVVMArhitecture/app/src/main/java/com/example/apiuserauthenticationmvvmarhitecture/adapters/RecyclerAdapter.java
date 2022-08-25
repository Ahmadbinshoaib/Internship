package com.example.apiuserauthenticationmvvmarhitecture.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiuserauthenticationmvvmarhitecture.R;
import com.example.apiuserauthenticationmvvmarhitecture.databinding.ViewItemBinding;
import com.example.apiuserauthenticationmvvmarhitecture.responses.Data;
import com.example.apiuserauthenticationmvvmarhitecture.viewModels.ModelItemClass;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Data> data;
    private LayoutInflater layoutInflater;

    public RecyclerAdapter()
    {
        this.data= new ArrayList<>();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater==null)
        {
            layoutInflater= LayoutInflater.from(parent.getContext());
        }
        ViewItemBinding binding= DataBindingUtil.inflate(layoutInflater, R.layout.view_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data model= data.get(position);
        holder.bind.setModel(new ModelItemClass(model));

    }

//    @Override
//    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
//        super.onViewAttachedToWindow(holder);
//        holder.bindData();
//    }
//
//    @Override
//    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
//        super.onViewDetachedFromWindow(holder);
//        holder.unbindData();
//    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void update(List<Data> data) {
        if(data==null || data.isEmpty()){
            this.data.clear();
        }
        else{
            this.data.addAll(data);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ViewItemBinding bind;
        public ViewHolder(ViewItemBinding binding) {
            super(binding.getRoot());
            this.bind= binding;
        }


    }
}
