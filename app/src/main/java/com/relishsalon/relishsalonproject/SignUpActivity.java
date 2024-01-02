package com.relishsalon.relishsalonproject;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.relishsalon.relishsalonproject.sohel.S;

public class SignUpActivity extends AppCompatActivity {
    RelativeLayout signuptoprelative,signuppage,signuprelativeemail,signuprelativemobile,signuprelativereferral,signbuttonid;
    TextView Skipid;
    ImageView Signupimageiconid,signupnameimageid,signupemailimageid,signupmobileimageid,signupreferralimageid;
    EditText Nameid,Emailid,Mobilenoid,Referralcodeid;
    Button Signid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Skipid=(TextView)findViewById(R.id.signupskip_id);
        Signupimageiconid=(ImageView)findViewById(R.id.Signupimageicon_id);
        signupnameimageid=(ImageView)findViewById(R.id.signupnameimage_id);
        signupemailimageid=(ImageView)findViewById(R.id.signupemailimage_id);
        signupmobileimageid =(ImageView)findViewById(R.id.signupmobileimage_id);
        signupreferralimageid=(ImageView)findViewById(R.id.signupreferralimage_id);
        Nameid=(EditText)findViewById(R.id.signupname_id);
        Emailid=(EditText)findViewById(R.id.signupemail_id);
        Mobilenoid=(EditText)findViewById(R.id.signupmobile);
        Referralcodeid=(EditText) findViewById(R.id.signupreferral_id);
        Signid=(Button) findViewById(R.id.btnSignUpId);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "font/Raleway-Medium.ttf");
        Skipid.setTypeface(custom_font);
        Nameid.setTypeface(custom_font);
        Emailid.setTypeface(custom_font);
        Mobilenoid.setTypeface(custom_font);
        Referralcodeid.setTypeface(custom_font);

        Signid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                S.I_clear(SignUpActivity.this,DashboardActivity.class,null);

            }
        });


    }
}


