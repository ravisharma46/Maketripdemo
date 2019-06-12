package com.example.apple.maketripdemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class query extends AppCompatActivity {

    public TextView date;
    public Button submit;
    public String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        date=(TextView) findViewById(R.id.date_set);
        submit=(Button) findViewById(R.id.submit_query);




        //date set
        final Calendar c =  Calendar.getInstance();
        int mYear=c.get(Calendar.YEAR);
        int mMonth=c.get(Calendar.MONTH);
        int mDay =c.get(Calendar.DAY_OF_MONTH);

        String str1 =Integer.toString(mDay)+"/"+Integer.toString(mMonth+1)+"/"+Integer.toString(mYear);
        get_date g= new get_date();
        g.setDate(str1);

        s= g.getFormattedDate();
        date.setText(s);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(query.this, get_date.class);
                startActivityForResult(intent, 2);
            }
        });

        //----submit button action-----

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            String message = data.getStringExtra("MESSAGE");


            if (message.isEmpty()) {
                date.setText(s);
            } else {

                date.setText(message);
            }

        }
    }
}
