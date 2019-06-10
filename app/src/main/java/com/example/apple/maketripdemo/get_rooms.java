package com.example.apple.maketripdemo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class get_rooms extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<listitem> listitems;
    private TextView add_room;
    private Button done;
    private  int x;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_rooms);


        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>TRAVELLERS-ROOM WISE</font>"));

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.fadedWhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        add_room= (TextView) findViewById(R.id.add_room);
        done=(Button)findViewById(R.id.btDone);

        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        listitems=new ArrayList<>();



        loadRecyclerViewData();
        add_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x=listitems.size();


                  if(x<6){
                      loadRecyclerViewData();

                  }
                  else{
                      Toast.makeText(getApplicationContext(),"Only 6 Room Allowed",Toast.LENGTH_SHORT).show();
                  }

            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // this is the data you want to pass
                Gson gson = new Gson();
                Type type = new TypeToken<List<listitem>>() {}.getType();
                String json = gson.toJson(listitems, type);
                Intent intent = new Intent(getBaseContext(), SelectBookingDetails.class);
                intent.putExtra("LIST", json);
                setResult(3,intent);
                finish();//finishing activity


            }
        });





    }
    private void loadRecyclerViewData(){




        listitem item =new listitem("ROOM "+(x+1),"Adults","Age 12y and above","Children","Age 11y and below","01","00");
        listitems.add(item);

        x=listitems.size();

        adapter= new MyAdapter(listitems,getApplicationContext());
        recyclerView.setAdapter(adapter);










    }


}
