package com.example.apple.maketripdemo;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SelectBookingDetails extends AppCompatActivity {

    private TextView date,room_set,room, date_set;
    private Button bt_done;

    public String s="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_booking_details);


        date = (TextView) findViewById(R.id.datePick);
        date_set = (TextView) findViewById(R.id.date_set);
        room_set = (TextView) findViewById(R.id.room_set);
        room = (TextView) findViewById(R.id.room);
        bt_done = (Button) findViewById(R.id.bt_done);





        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Select Booking Details</font>"));

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.fadedWhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SelectBookingDetails.this, get_date.class);
                startActivityForResult(intent, 2);
            }
        });



        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectBookingDetails.this, get_rooms.class);
                startActivityForResult(intent, 3);
            }
        });


        final Calendar c =  Calendar.getInstance();
        int mYear=c.get(Calendar.YEAR);
        int mMonth=c.get(Calendar.MONTH);
        int mDay =c.get(Calendar.DAY_OF_MONTH);

        String str1 =Integer.toString(mDay)+"/"+Integer.toString(mMonth+1)+"/"+Integer.toString(mYear);
        get_date g= new get_date();
        g.setDate(str1);

        s= g.getFormattedDate();
        date_set.setText(s);

        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            String message=data.getStringExtra("MESSAGE");


            if(message.isEmpty()){
                date_set.setText(s);
            }
            else{

            date_set.setText(message);
        }



        }
        if(requestCode==3)
        {

            Gson gson = new Gson();
            String stringLocation = data.getStringExtra("LIST");

            Log.i("data",stringLocation);

            if(stringLocation != null) {

                Type type = new TypeToken<List<listitem>>() {}.getType();
               List<listitem> objectLocations = gson.fromJson(stringLocation, type);


               int ansA=0,ansC=0,Total_room=0;
               for(int i=0;i<objectLocations.size();i++){
                   String strA= objectLocations.get(i).getShow_A();
                   String strC=objectLocations.get(i).getShow_ch();
                   int sumA=Integer.parseInt(strA);
                   int sumC=Integer.parseInt(strC);
                    Total_room=objectLocations.size();
                    ansA=ansA+sumA;
                    ansC=ansC+sumC;


               }

               if(ansC==0){
                   room_set.setText(ansA+" Adults in "+Total_room+" Room");

               }
               else if(ansC>0){
                   room_set.setText(ansA+" Adults, "+ ansC+" Child in "+Total_room+" Room");
               }



            }
            else{
                Log.i("data","failed");
            }



        }


    }



}
