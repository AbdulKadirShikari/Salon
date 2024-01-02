package com.relishsalon.relishsalonproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.relishsalon.relishsalonproject.sohel.S;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity
      /*  implements NavigationView.OnNavigationItemSelectedListener,*/ implements OnMapReadyCallback {
    Button btForLocationId;
    private GoogleMap mMap;
    ArrayList<LatLng> latLngsmarkerLocation = new ArrayList<>();
    private Button btnBottomLocationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setSupportActionBar(toolbar);
        LatLng latLng = new LatLng(22.741793818067187, 75.95176635959467);
        LatLng latLng1 = new LatLng(22.66847396789463, 75.79229294040522);
        LatLng latLng2 = new LatLng(22.705138800219427, 75.87202964999994);
        latLngsmarkerLocation.add(latLng);
        latLngsmarkerLocation.add(latLng1);
        latLngsmarkerLocation.add(latLng2);


        final Button fab = (Button) findViewById(R.id.fab);
        btnBottomLocationId = (Button) findViewById(R.id.btnBottomLocationId);
        final Button btForLocationId = (Button) findViewById(R.id.btForLocationId);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Point point = new Point();
                point.x = (int) btForLocationId.getX();
                point.y = (int) btForLocationId.getY();
                showSortPopup(DashboardActivity.this, point);
            }
        });

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);


        toggle.syncState();


        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/


    }

    public Bitmap getMarkerDesign() {

        Bitmap.Config conf = Bitmap.Config.ARGB_8888;
        Bitmap bmp = Bitmap.createBitmap(80, 80, conf);
        Canvas canvas1 = new Canvas(bmp);
        Paint pBackground = new Paint();
// paint defines the text color, stroke width and size
      /*  Paint pBackground = new Paint();
        pBackground.setColor(Color.BLACK);
        canvas1.drawRect(0, 0, 512, 512, pBackground);*/


        canvas1.drawBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.circle_count), 0, 0, pBackground);
        int xPos = (canvas1.getWidth() / 2);
        Paint textPaint = new Paint();
        int yPos = (int) ((canvas1.getHeight() / 2));
        //((textPaint.descent() + textPaint.ascent()) / 2) is the distance from the baseline to the center.

        canvas1.drawText("1", 40, 40, textPaint);

        textPaint.setTextSize(14);

//        canvas1.drawText("1",40,40,pBackground);
// modify canvas
      /*  canvas1.drawBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.avtor_topper), 0,0, color);*/

        return bmp;

    }

    public void createMarker(double latitude, double longitude, String title, String snippet, int iconResID) {

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .anchor(0.5f, 0.5f)
                .title(title)
                .snippet(snippet)
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerDesign())));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Shop 1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                Point point = new Point();
                point.x = (int) btnBottomLocationId.getX();
                point.y = (int) btnBottomLocationId.getY();
                showPopupBottom(DashboardActivity.this, point);
                return false;
            }
        });
      /*  LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for(int i=0;i<latLngsmarkerLocation.size();i++){
          *//*  builder.include(latLngsmarkerLocation.get(i));*//*
            createMarker(latLngsmarkerLocation.get(i).latitude,latLngsmarkerLocation.get(i).longitude,""+i,"",R.drawable.circle_count);
        }*/
        /*    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngsmarkerLocation.get(latLngsmarkerLocation.size()-1)));*/



      /*  LatLngBounds bounds = builder.build();
        int padding = 12; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        mMap.moveCamera(cu);
        mMap.animateCamera(cu);*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")

  /*  @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.item_profile) {
            // Handle the camera action
        } else if (id == R.id.item_app_history) {
            S.I(DashboardActivity.this, AppointmentHistoryActivity.class, null);

        } else if (id == R.id.item_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

    private void showSortPopup(final Activity context, Point p) {
        // Inflate the popup_layout.xml
        /*  LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popuplayout);*/
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.spinner_radio_button, null);

        // Creating the PopupWindow
        PopupWindow changeSortPopUp = new PopupWindow(context);
        changeSortPopUp.setContentView(layout);
        changeSortPopUp.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        changeSortPopUp.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        changeSortPopUp.setFocusable(true);

        // Some offset to align the popup a bit to the left, and a bit down, relative to button's position.
        int OFFSET_X = -20;
        int OFFSET_Y = 95;

        // Clear the default translucent background
        changeSortPopUp.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        changeSortPopUp.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y);


        // Getting a reference to Close button, and close the popup when clicked.
        RadioGroup radioGroupButton = (RadioGroup) layout.findViewById(R.id.rgDistanceId);
        radioGroupButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.rbThreeKmId:
                        Point point = new Point();
                        point.x = (int) btnBottomLocationId.getX();
                        point.y = (int) btnBottomLocationId.getY();
                        showPopupBottom(DashboardActivity.this, point);

                        break;

                    case R.id.rbFiveKmId:

                        break;

                    case R.id.rbTenKmId:

                        break;

                }

            }
        });
      /*  Button close = (Button) layout.findViewById(R.id.close);
        close.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                changeSortPopUp.dismiss();
            }
        });*/

    }

    private void showPopupBottom(final Activity context, Point p) {
        // Inflate the popup_layout.xml
        /*  LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popuplayout);*/
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.shop_small_popup, null);

        // Creating the PopupWindow
        PopupWindow changeSortPopUp = new PopupWindow(context);
        changeSortPopUp.setContentView(layout);
        changeSortPopUp.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        changeSortPopUp.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        changeSortPopUp.setFocusable(true);

        // Some offset to align the popup a bit to the left, and a bit down, relative to button's position.
        int OFFSET_X = -20;
        int OFFSET_Y = 95;

        // Clear the default translucent background
        changeSortPopUp.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        changeSortPopUp.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y);


        // Getting a reference to Close button, and close the popup when clicked.

        Button close = (Button) layout.findViewById(R.id.btnViewId);
        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                S.I_clear(DashboardActivity.this, ShopDetailActivity.class, null);
            }
        });

    }
}
