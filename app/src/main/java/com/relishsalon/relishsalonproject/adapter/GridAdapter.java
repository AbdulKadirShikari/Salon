package com.relishsalon.relishsalonproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.relishsalon.relishsalonproject.DetailedMultiplepackageActivity;
import com.relishsalon.relishsalonproject.R;
import com.relishsalon.relishsalonproject.sohel.S;

public class GridAdapter extends BaseAdapter {
    private Context context;

    public Integer[] mThumbIds = {
            R.drawable.haigirlimage, R.drawable.hairmage,  R.drawable.haigirlimage, R.drawable.hairmage,
            R.drawable.fairimage, R.drawable.lipimage,

    };

    public GridAdapter(Context c){
        context=c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_image_packs,parent,false);

        ImageView imageView_hairg_Id=(ImageView)itemView.findViewById(R.id.imageView_hairg_Id);
        imageView_hairg_Id.setImageResource(mThumbIds[position]);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                S.I(context, DetailedMultiplepackageActivity.class,null);
            }
        });
        return itemView;
    }
}















