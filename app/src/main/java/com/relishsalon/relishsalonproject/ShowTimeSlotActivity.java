package com.relishsalon.relishsalonproject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.GridView;

import com.relishsalon.relishsalonproject.adapter.GridTimeSlotAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarListener;

public class ShowTimeSlotActivity extends Activity {

    private String mydate;
    private HorizontalCalendar horizontalCalendar;
    ArrayList<String>stringTimeSlot=new ArrayList<>();
    GridView gridTimeSlotsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeslot);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        gridTimeSlotsId=(GridView)findViewById(R.id.gridTimeSlotsId) ;
        stringTimeSlot.add("10:00 AM - 10:30 AM");
        stringTimeSlot.add("11:00 AM - 11:30 AM");
        stringTimeSlot.add("12:00 AM - 12:30 AM");
        stringTimeSlot.add("01:00 AM - 01:30 AM");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        mydate = df.format(new Date());

        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DAY_OF_WEEK, 7);

        /** start before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DAY_OF_WEEK, -0);

        final Calendar defaultDate = Calendar.getInstance();
        defaultDate.add(Calendar.DAY_OF_WEEK, 1);

        horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .startDate(startDate.getTime())
                .endDate(endDate.getTime())
                .datesNumberOnScreen(5)
                .dayNameFormat("EEE")
                .dayNumberFormat("dd")
                .monthFormat("MMM")
                .showDayName(true)
                .showMonthName(true)
                .defaultSelectedDate(defaultDate.getTime())
                .textColor(Color.LTGRAY, Color.WHITE)
                .selectedDateBackground(Color.TRANSPARENT)
                .build();
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Date date, int position) {
//
                GridTimeSlotAdapter gridTimeSlotAdapter=new GridTimeSlotAdapter(ShowTimeSlotActivity.this,stringTimeSlot);
                gridTimeSlotsId.setAdapter(gridTimeSlotAdapter);
            }
        });
        GridTimeSlotAdapter gridTimeSlotAdapter=new GridTimeSlotAdapter(ShowTimeSlotActivity.this,stringTimeSlot);
        gridTimeSlotsId.setAdapter(gridTimeSlotAdapter);
    }
}
