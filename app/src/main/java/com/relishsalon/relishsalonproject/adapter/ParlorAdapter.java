package com.relishsalon.relishsalonproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.relishsalon.relishsalonproject.R;
import com.relishsalon.relishsalonproject.model.ModelClass;

import java.util.List;

public class ParlorAdapter extends RecyclerView.Adapter<ParlorAdapter.MyViewHolder> {
    private List<ModelClass> list;

    public ParlorAdapter(List<ModelClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date,time,parlorname,status,price,list1,list2,list3;
        public ImageView icon, image;

        public MyViewHolder( View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.textDateChange_Id);
            time = (TextView) itemView.findViewById(R.id.textDateTimeId);
            price = (TextView) itemView.findViewById(R.id.price_Id);
            parlorname =(TextView) itemView.findViewById(R.id.parlorNameId);
            status =(TextView) itemView.findViewById(R.id.statusId);
            list1 =(TextView) itemView.findViewById(R.id.textContentf_Id);
            list2 =(TextView) itemView.findViewById(R.id.contentsId);
            list3 =(TextView) itemView.findViewById(R.id.contenttId);


        }
    }
    public ParlorAdapter(List<ModelClass> list){
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_appointment_history,viewGroup,false);
        return  new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ModelClass modelClass = list.get(position);
        holder.date.setText(modelClass.date);
        holder.time.setText(modelClass.time);
        holder.price.setText(modelClass.price);
        holder.status.setText(modelClass.status);
        holder.list1.setText(modelClass.list1);
        holder.list2.setText(modelClass.list2);
        holder.list3.setText(modelClass.list3);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}




