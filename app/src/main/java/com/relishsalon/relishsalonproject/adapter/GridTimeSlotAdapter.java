package com.relishsalon.relishsalonproject.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.relishsalon.relishsalonproject.DetailedMultiplepackageActivity;
import com.relishsalon.relishsalonproject.R;
import com.relishsalon.relishsalonproject.sohel.S;

import java.util.ArrayList;

public class GridTimeSlotAdapter extends BaseAdapter {
    private Context context;
    ArrayList<String>timeSlots;


    public GridTimeSlotAdapter(Context c, ArrayList<String>stringsTimeSlots){
        context=c;
        timeSlots=stringsTimeSlots;
    }

    @Override
    public int getCount() {
        return timeSlots.size();
    }

    @Override
    public Object getItem(int position) {
        return timeSlots.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_time_slot,parent,false);
       String timeslotsStr= timeSlots.get(position);
        Button button_TimePinkFirst_Id=(Button) itemView.findViewById(R.id.button_TimePinkFirst_Id);
        if(position==0) {
            button_TimePinkFirst_Id.setBackgroundResource(R.drawable.button);
        }else{
            button_TimePinkFirst_Id.setBackgroundColor(Color.WHITE);
            button_TimePinkFirst_Id.setTextColor(context.getResources().getColor(R.color.colorPrimary));
            button_TimePinkFirst_Id.setText(timeslotsStr);
        }


        return itemView;
    }
}















