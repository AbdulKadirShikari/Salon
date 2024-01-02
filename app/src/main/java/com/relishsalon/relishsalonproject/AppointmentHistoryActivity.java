package com.relishsalon.relishsalonproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.relishsalon.relishsalonproject.adapter.ParlorAdapter;
import com.relishsalon.relishsalonproject.model.ModelClass;

import java.util.ArrayList;
import java.util.List;

public class AppointmentHistoryActivity extends AppCompatActivity {
    private List<ModelClass> list =new ArrayList<>();
    private RecyclerView recyclerView;
    private ParlorAdapter parloradapter;
    Context getAssets;
    LinearLayout linearLayout;
    TextView textViewHomeId;
    TextView textViewPrice;
    TextView textViewStatus;
    TextView textViewDate;
    TextView textViewTime;
    TextView textViewparlorname;
    TextView textViewSara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_history);
        textViewHomeId=(TextView) findViewById(R.id.homeImage_Id);
        textViewPrice =(TextView)findViewById(R.id.price_Id);
        textViewStatus =(TextView) findViewById(R.id.donecancleId);
        textViewDate =(TextView) findViewById(R.id.textDATE_id);

        textViewTime =(TextView) findViewById(R.id.textDateTimeId);
        textViewparlorname =(TextView) findViewById(R.id.parlorNameId);
        textViewSara =(TextView) findViewById(R.id.textContentf_Id);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        parloradapter = new ParlorAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(parloradapter);




/*
        AssetManager am = context.getApplicationContext().getAssets();
                 Typeface typeface = Typeface.createFromAsset(am,
                   String.format(Locale.US, "fonts/%s", "Raleway-Medium.ttf"));
                textViewDate.setTypeface(typeface);
                textViewSara.setTypeface(typeface);
                textViewTime.setTypeface(typeface);

                Typeface typeface1 =Typeface.createFromAsset(am,String.format(Locale.CANADA,"fonts/%s","Raleway-SemiBold.ttf"));
                textViewPrice.setTypeface(typeface1);
                textViewHomeId.setTypeface(typeface1);
                textViewparlorname.setTypeface(typeface1);
                textViewStatus.setTypeface(typeface1);*/


          /* Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/Raleway-Medium.ttf");
           textViewDate.setTypeface(custom_font);
           textViewTime.setTypeface(custom_font);
           textViewSara.setTypeface(custom_font);

           Typeface custom_font1 =Typeface.createFromAsset(getAssets(),"fonts/Raleway-SemiBold.ttf");
           textViewHomeId.setTypeface(custom_font1);
           textViewPrice.setTypeface(custom_font1);
           textViewparlorname.setTypeface(custom_font1);
           textViewStatus.setTypeface(custom_font1);*/
        prepareModelClassData();
    }

    private void prepareModelClassData() {

        ModelClass modelClass1 = new ModelClass();
        modelClass1.price="999/-";
        modelClass1.time="2.15PM";
        modelClass1.date="19 jan 2019";
        modelClass1.status="STATUS-DONE";
        modelClass1.list1="Sara-Gold Facial(improved gold radiance with mould mask)";
        modelClass1.list2="Basic-Manicure";
        modelClass1.list3="Basic-Pedicure";
        list.add(modelClass1);

        ModelClass modelClass2 = new ModelClass();
        modelClass2.price="1999/-";
        modelClass2.time="12.19PM";
        modelClass2.date="19 jan 2019";
        modelClass2.status="STATUS-DONE";
        modelClass2.list1="Sara-Gold Facial(improved gold radiance with mould mask)";
        modelClass2.list2="Basic-Manicure";
        modelClass2.list3="Basic-Pedicure";
        list.add(modelClass2);

        ModelClass modelClass3 = new ModelClass();
        modelClass3.price="2999/-";
        modelClass3.time="07.15AM";
        modelClass3.date="9 Fab 2019";
        modelClass3.status="STATUS-CANCLE";
        modelClass3.list1="Sara-Gold Facial(improved gold radiance with mould mask)";
        modelClass3.list2="Basic-Manicure";
        modelClass3.list3="Basic-Pedicure";
        list.add(modelClass3);

        ModelClass modelClass4 = new ModelClass();
        modelClass4.price="2999/-";
        modelClass4.time="07.15AM";
        modelClass4.date="9 Fab 2019";
        modelClass4.status="STATUS-CANCLE";
        modelClass4.list1="Sara-Gold Facial(improved gold radiance with mould mask)";
        modelClass4.list2="Basic-Manicure";
        modelClass4.list3="Basic-Pedicure";
        list.add(modelClass4);

        ModelClass modelClass5 = new ModelClass();
        modelClass5.price="2999/-";
        modelClass5.time="07.15AM";
        modelClass5.date="9 Fab 2019";
        modelClass5.status="STATUS-CANCLE";
        modelClass5.list1="Sara-Gold Facial(improved gold radiance with mould mask)";
        modelClass5.list2="Basic-Manicure";
        modelClass5.list3="Basic-Pedicure";
        list.add(modelClass5);

        ModelClass modelClass6 = new ModelClass();
        modelClass6.price="2999/-";
        modelClass6.time="07.15AM";
        modelClass6.date="9 Fab 2019";
        modelClass6.status="STATUS-CANCLE";
        modelClass6.list1="Sara-Gold Facial(improved gold radiance with mould mask)";
        modelClass6.list2="Basic-Manicure";
        modelClass6.list3="Basic-Pedicure";
        list.add(modelClass6);

        ModelClass modelClass7 = new ModelClass();
        modelClass7.price="2999/-";
        modelClass7.time="07.15AM";
        modelClass7.date="9 Fab 2019";
        modelClass7.status="STATUS-CANCLE";
        modelClass7.list1="Sara-Gold Facial(improved gold radiance with mould mask)";
        modelClass7.list2="Basic-Manicure";
        modelClass7.list3="Basic-Pedicure";
        list.add(modelClass7);

        ModelClass modelClass8 = new ModelClass();
        modelClass8.price="2999/-";
        modelClass8.time="07.15AM";
        modelClass8.date="20 Jan 2019";
        modelClass8.status="STATUS-CANCLE";
        modelClass8.list1="Sara-Gold Facial(improved gold radiance with mould mask)";
        modelClass8.list2="Basic-Manicure";
        modelClass8.list3="Basic-Pedicure";
        list.add(modelClass8);

        parloradapter.notifyDataSetChanged();
    }
}






