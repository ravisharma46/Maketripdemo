package com.example.apple.maketripdemo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class get_date extends AppCompatActivity {


    private CalendarView calendarView;
    private Button b1;
    public String formattedDate="";
    public String str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_date);
        calendarView= (CalendarView) findViewById(R.id.calendarView);
        b1=(Button) findViewById(R.id.fab);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Select Date</font>"));

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.fadedWhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent=new Intent();
                intent.putExtra("MESSAGE",formattedDate);
                setResult(2,intent);
                finish();//finishing activity
            }
        });




        calendarView.setMinDate(System.currentTimeMillis() - 1000);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                 str =Integer.toString(day)+"/"+Integer.toString(month+1)+"/"+Integer.toString(year);

                Log.e("TAG",str);

                setDate(str);

            }
        });




    }

    public  String setDate(String str){
        Date date = null;
        try {

            date = new SimpleDateFormat("dd/MM/yyyy").parse(str);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        formattedDate = new SimpleDateFormat("EEE dd MMM yyyy").format(date);

        return formattedDate;
    }


    public String getFormattedDate() {
        return formattedDate;
    }



}
