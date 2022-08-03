package com.example.apiassignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        View v= LayoutInflater.from(context).inflate(R.layout.history_row, parent, false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Structure temp= arrContacts.get(position);

        holder.txttitle.setText(arrContacts.get(position).getTitle());
        holder.txteventdate.setText(arrContacts.get(position).getEvent_date_utc());
        holder.txteventunix.setText(arrContacts.get(position).getEvent_date_unix() + "");
        holder.txtflightno.setText((int) arrContacts.get(position).getFlight_number() + "");

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailScreen.class );
                intent.putExtra("title", temp.getTitle());
                String id =  temp.getId() + "";
                intent.putExtra("id" ,id);
                intent.putExtra("eventdate" , temp.getEvent_date_utc());
                String unix =  temp.getEvent_date_unix() + "";
                intent.putExtra("eventdateunix" ,unix );
                String flight =  temp.getFlight_number() + "";
                intent.putExtra("flightno", flight);
                intent.putExtra("details" , temp.getDetails());
                //intent.putExtra("reddit" , temp.LinksObject.getReddit());
                //intent.putExtra("wiki" , temp.LinksObject.getWikipedia());
                //intent.putExtra("article" , temp.LinksObject.getArticle());
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttitle, txteventdate, txteventunix , txtflightno;
        Button v;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txttitle = itemView.findViewById(R.id.title);
            txteventdate= itemView.findViewById(R.id.eventdate);
            txtflightno = itemView.findViewById(R.id.flightno);
            txteventunix= itemView.findViewById(R.id.eventdateunix);
            v= itemView.findViewById(R.id.view);
        }
    }
}
