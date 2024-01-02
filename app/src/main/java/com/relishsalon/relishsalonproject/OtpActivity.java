package com.relishsalon.relishsalonproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.relishsalon.relishsalonproject.sohel.S;

public class OtpActivity extends BaseActivity {
Button blueBtn;
    @Override
    protected int getContentResId() {
        return R.layout.activity_otp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarWithBackButton("OTP Verification");
        blueBtn=(Button)findViewById(R.id.blueBtn);
        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                S.I(OtpActivity.this,SignUpActivity.class,null);
            }
        });
      //  setContentView();
    }
}
