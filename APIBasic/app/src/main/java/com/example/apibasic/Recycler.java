package com.example.apibasic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {

    Context context;
    List<Structure> arrContacts;
    Recycler (Context context, List<Structure> arrContacts)
    {
        this.context= context;
        this.arrContacts= arrContacts;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txttitle.setText(arrContacts.get(position).getTitle());
        holder.txtbody.setText(arrContacts.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttitle, txtbody;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txttitle = itemView.findViewById(R.id.title);
            txtbody= itemView.findViewById(R.id.body);
        }
    }
}
