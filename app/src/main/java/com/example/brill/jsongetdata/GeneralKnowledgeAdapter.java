package com.example.brill.jsongetdata;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by brill on 9/14/2017.
 */

public class GeneralKnowledgeAdapter extends RecyclerView.Adapter<GeneralKnowledgeAdapter.ViewHolder> {

    Context context;

    List<GattersatterGenralKnowledge> getDataAdapter;

    public GeneralKnowledgeAdapter(List<GattersatterGenralKnowledge> getDataAdapter, Context context){

        super();

        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       final GattersatterGenralKnowledge getDataAdapter1 =  getDataAdapter.get(position);
        String name,email,phone;

        name=getDataAdapter1.getStrname();
        email=getDataAdapter1.getStremail();
        phone=getDataAdapter1.getStrphone();


        holder.txtname.setText(name);
        holder.txtemail.setText(email);
        holder.txtphone.setText(phone);



    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        public TextView txtname;
        public TextView txtemail;
        public TextView txtphone;


        public ViewHolder(View itemView) {

            super(itemView);

         //   IdTextView = (TextView) itemView.findViewById(R.id.txtview) ;
            txtname = (TextView) itemView.findViewById(R.id.txtname) ;
            txtemail = (TextView) itemView.findViewById(R.id.txtemail) ;
            txtphone = (TextView) itemView.findViewById(R.id.txtphone) ;


        }

    }
}