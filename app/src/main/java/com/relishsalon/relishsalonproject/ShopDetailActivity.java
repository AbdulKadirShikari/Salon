package com.relishsalon.relishsalonproject;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.relishsalon.relishsalonproject.adapter.Dashboard_custom_viewpage_adapter;
import com.relishsalon.relishsalonproject.adapter.GridAdapter;

public class ShopDetailActivity extends AppCompatActivity {


    int[] images = {R.drawable.banner, R.drawable.banner,R.drawable.banner};
    GridView gridViewList;
    GridAdapter gridAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        ViewPager viewPager = (ViewPager) findViewById(R.id.dashboard_viewpager_id);
        gridViewList = (GridView) findViewById(R.id.gridPackesId);
        viewPager.setAdapter(new Dashboard_custom_viewpage_adapter(this, images));
        gridAdapter=new GridAdapter(ShopDetailActivity.this);
        gridViewList.setAdapter(gridAdapter);
        gridViewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}


