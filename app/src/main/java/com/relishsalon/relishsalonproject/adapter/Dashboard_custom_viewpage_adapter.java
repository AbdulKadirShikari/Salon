package com.relishsalon.relishsalonproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.relishsalon.relishsalonproject.R;

import java.util.ArrayList;

public class Dashboard_custom_viewpage_adapter extends PagerAdapter {
    Context context;
    int images[];
    LayoutInflater layoutInflater;


    public Dashboard_custom_viewpage_adapter(Context context, int images[]) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    public static class CustomSpinnerAdapter extends ArrayAdapter<String> {

        LayoutInflater flater;
        ArrayList<String> strings;
        Activity context;

        public CustomSpinnerAdapter(Activity context,int resouceId, int textviewId, ArrayList<String> strings){
            super(context,resouceId,textviewId,strings);
            this. strings=strings;
            this.context=context;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            String rowItem = strings.get(position);

            View rowview = context.getLayoutInflater().inflate(R.layout.spinner_radio_button,null,true);

    ////        RadioButton txtTitle = (RadioButton) rowview.findViewById(R.id.rbRadiousId);
    //        txtTitle.setText(rowItem);



            return rowview;
        }
    }
}


