package com.relishsalon.relishsalonproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.relishsalon.relishsalonproject.sohel.S;

public class DetailedMultiplepackageActivity extends AppCompatActivity {
LinearLayout llAddCartId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_package);
        llAddCartId=(LinearLayout)findViewById(R.id.llAddCartId);
        llAddCartId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                S.I(DetailedMultiplepackageActivity.this,ShowTimeSlotActivity.class,null);
            }
        });
    }
}


