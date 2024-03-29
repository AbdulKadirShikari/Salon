package com.relishsalon.relishsalonproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public abstract class BaseActivity extends AppCompatActivity {
    //    private Context context;
    public static Activity activity;
    protected Toolbar toolbar;
    private boolean connected=false;
    static BaseActivity mInstance;
    private Handler mHandler;
    ImageView retryBtn;
    protected abstract int getContentResId();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResId());

    }



    protected void setToolbarWithBackButton(String title) {
        initToolbar();
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);

    }

    protected void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    protected void initTitleToolbar(String title) {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle(title);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                navigateToParent();
                break;
        }
        return true;
    }

    private void navigateToParent() {
        Intent intent = NavUtils.getParentActivityIntent(this);
        if (intent == null) {
            this.finish();
        } else {
            NavUtils.navigateUpFromSameTask(this);
        }
    }

    public static BaseActivity getInstance(Context ctx) {
        //  context = ctx.getApplicationContext();
        return mInstance;
    }

    /*
        public void checkNetworkAvailability(final Context cxs){
            if (AppController.getInstance(this).isOnline()){
                setContentView(getContentResId());
            }
            else {
                setContentView(R.layout.no_internet_connection);
                retryBtn=findViewById(R.id.retryBtn);
                retryBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (AppController.getInstance(getApplicationContext()).isOnline()) {
                            S.I_clear(getApplicationContext(),BaseActivity.this.getClass(), null);
                            S.E("retry k if me aa rha h");
                        }
                        else {
                            S.T(getApplicationContext(),"Please turn on your data.");
                           // setContentView(R.layout.no_internet_connection);
                            S.E("retry k else me aa rha h");
                        }
                      //  setContentView(getContentResId());
                    }
                });
            }
        }
    */
    private final Runnable m_Runnable = new Runnable()
    {
        public void run()

        {
//            Toast.makeText(context,"in runnable",Toast.LENGTH_SHORT).show();
//            checkNetworkAvailability();
            mHandler.postDelayed(m_Runnable, 5000);
        }

    };//runnable
}


