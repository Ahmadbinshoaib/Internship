package com.example.recyclerviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder>{
    Context context;
    ArrayList<EventModel> arrEvents;
    Recycler (Context context, ArrayList<EventModel> arrEvents)
    {
        this.context= context;
        this.arrEvents= arrEvents;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.events_row, parent, false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtdate.setText(arrEvents.get(position).e_date);
        holder.txtmonth.setText(arrEvents.get(position).e_month);
        holder.txtdescription.setText(arrEvents.get(position).e_description);
        holder.txttitle.setText(arrEvents.get(position).e_title);
        holder.txtdate1.setText(arrEvents.get(position).e_date1);



    }

    @Override
    public int getItemCount() {

        return arrEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtdate, txtmonth, txttitle, txtdescription, txtdate1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtdate = itemView.findViewById(R.id.date);
            txtmonth = itemView.findViewById(R.id.month);
            txttitle = itemView.findViewById(R.id.title);
            txtdescription = itemView.findViewById(R.id.description);
            txtdate1 = itemView.findViewById(R.id.date1);



        }
    }
}
