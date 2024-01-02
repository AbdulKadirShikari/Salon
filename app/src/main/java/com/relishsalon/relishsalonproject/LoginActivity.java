package com.relishsalon.relishsalonproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.tasks.Task;
import com.relishsalon.relishsalonproject.sohel.Const;
import com.relishsalon.relishsalonproject.sohel.S;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.OnActivityResult;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;

public class LoginActivity extends AppCompatActivity implements
        View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {


    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int RC_SIGN_IN = 007;
    private GoogleApiClient mGoogleApiClient;
    private ProgressDialog mProgressDialog;
    private static String APP_ID = "2006329509670070";
    CallbackManager callbackManager;
    private static final String EMAIL = "email";


    TextView Skip, permission_below_btn, or_Tv, connect_tv, facebook_txt, google_txt, text_below_fb_btn;
    EditText mobileno, Nameid, Emailid;
    Button loginbtn;
    LoginButton loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Skip = findViewById(R.id.Skip);
        permission_below_btn = findViewById(R.id.permission_below_btn);
        or_Tv = findViewById(R.id.or_Tv);
        connect_tv = findViewById(R.id.connect_tv);
        facebook_txt = findViewById(R.id.facebook_txt);
        google_txt = findViewById(R.id.google_txt);
        text_below_fb_btn = findViewById(R.id.text_below_fb_btn);
        mobileno = findViewById(R.id.mobileno);
        loginbtn = findViewById(R.id.loginbtn);
        Nameid = (EditText) findViewById(R.id.signupname_id);
        Emailid = (EditText) findViewById(R.id.signupemail_id);
        loginButton = (LoginButton) findViewById(R.id.login_button);


        google_txt.setOnClickListener(this);
        AppEventsLogger logger = null;

        callbackManager = CallbackManager.Factory.create();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        boolean loggedOut = AccessToken.getCurrentAccessToken() == null;

        if (!loggedOut) {

        }
        callbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        loginButton .registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                boolean loggedIn = AccessToken.getCurrentAccessToken() == null;
                Log.d("API123", loggedIn + " ??");

            }
            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                S.I(LoginActivity.this, OtpActivity.class, null);
            }
        });
        font();
    }
    private void font() {
        Typeface Medium = Typeface.createFromAsset(getAssets(), "font/Raleway-Medium.ttf");
        Typeface SemiBold = Typeface.createFromAsset(getAssets(), "font/Raleway-SemiBold.ttf");
        Typeface Light = Typeface.createFromAsset(getAssets(), "font/Raleway-Light.ttf");
        Skip.setTypeface(Medium);
        mobileno.setTypeface(Medium);
        connect_tv.setTypeface(Medium);
        or_Tv.setTypeface(Medium);
        facebook_txt.setTypeface(SemiBold);
        google_txt.setTypeface(SemiBold);
        loginbtn.setTypeface(SemiBold);
        permission_below_btn.setTypeface(Light);
    }
    private void signInButton() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(intent, RC_SIGN_IN);
    }
    private void handleResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            String name = account.getDisplayName();
            String email = account.getEmail();
            updateUI(true);
            Log.e("check", "Name: " + name + ", Email: " + email);
        } else {

            updateUI(false);
        }
    }
    private void updateUI(boolean isLogin) {
        if (isLogin) {
            google_txt.setVisibility(View.GONE);
        } else {

            google_txt.setVisibility(View.VISIBLE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("connectionResult", "onConnectionFailed:" + connectionResult);

    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.google_txt:
                signInButton();
                break;
        }
    }

    private void getUserProfile(AccessToken currentAccessToken) {
        GraphRequest request = GraphRequest.newMeRequest(
                currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.d("TAG", object.toString());
                        try {
                            String name = object.getString("name");
                            String email = object.getString("email");

                            Nameid.setText(name);
                            Emailid.setText(email);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();

    }
}


