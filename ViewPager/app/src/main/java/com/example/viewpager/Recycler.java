package com.example.viewpager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {
    Context context;
    ArrayList<LeaveModel> arrEvents;
    Recycler (Context context, ArrayList<LeaveModel> arrEvents)
    {
        this.context= context;
        this.arrEvents= arrEvents;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.leaves_row, parent, false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtleave.setText(arrEvents.get(position).l_leave);
        holder.txtdatefrom.setText(arrEvents.get(position).l_datefrom);
        holder.txtdateto.setText(arrEvents.get(position).l_dateto);
        holder.txtnod.setText(arrEvents.get(position).l_noofdays);
        holder.txtstatus.setText(arrEvents.get(position).l_status);
        holder.txtstatus.setBackground(getDrawable(arrEvents.get(position).l_status));






    }

    Drawable getDrawable(String status){
        if(status.equals("")){

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return arrEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtleave, txtstatus, txtdatefrom, txtdateto, txtnod;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtleave = itemView.findViewById(R.id.leave);
            txtstatus = itemView.findViewById(R.id.status);
            txtdatefrom = itemView.findViewById(R.id.datefrom);
            txtdateto = itemView.findViewById(R.id.dateto);
            txtnod = itemView.findViewById(R.id.noofdays);

        }
    }
}
