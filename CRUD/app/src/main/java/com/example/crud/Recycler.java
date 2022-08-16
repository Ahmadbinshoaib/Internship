package com.example.crud;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {
    Context context;
    ArrayList<Doctors> arrEvents;

    Recycler (Context context, ArrayList<Doctors> arrEvents)
    {
        this.context= context;
        this.arrEvents= arrEvents;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.doctors_row, parent, false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.txtid.setText(arrEvents.get(position).getId() + "");
        holder.txtname.setText(arrEvents.get(position).getName());
        holder.txtphone.setText(arrEvents.get(position).getPhoneNumber());
        holder.txtspecialization.setText(arrEvents.get(position).getSpecialization());
        holder.txtqualification.setText(arrEvents.get(position).getQualification());
        holder.txtdcnic.setText(arrEvents.get(position).getCnic());

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, UpdateDoctor.class);
                intent.putExtra("id",String.valueOf(arrEvents.get(position).getId() + ""));
                intent.putExtra("name",String.valueOf(arrEvents.get(position).getName()));
                intent.putExtra("cnic",String.valueOf(arrEvents.get(position).getCnic()));
                intent.putExtra("phone",String.valueOf(arrEvents.get(position).getPhoneNumber()));
                intent.putExtra("quali",String.valueOf(arrEvents.get(position).getQualification()));
                intent.putExtra("speci",String.valueOf(arrEvents.get(position).getSpecialization()));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname, txtphone, txtdcnic, txtqualification, txtspecialization, txtid;
        LinearLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtname= itemView.findViewById(R.id.name);
            txtphone= itemView.findViewById(R.id.phone);
            txtdcnic= itemView.findViewById(R.id.cnic);
            txtqualification= itemView.findViewById(R.id.qualifiaction);
            txtspecialization= itemView.findViewById(R.id.specializaton);
            txtid= itemView.findViewById(R.id.id1);
            mainLayout = itemView.findViewById(R.id.mainLayout);



        }
    }


}
