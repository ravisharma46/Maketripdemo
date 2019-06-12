package com.example.apple.maketripdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HolidayInActivity extends AppCompatActivity {

    public Button bt,start;
    private LinearLayout mLinear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_in);

        bt= (Button) findViewById(R.id.fab_call);
        start= (Button) findViewById(R.id.start_1);
        mLinear = (LinearLayout) findViewById(R.id.child_linear);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Holiday in Bhutan</font>"));

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HolidayInActivity.this,Holiday_select.class);
                startActivity(i);
            }
        });









        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bt.setVisibility(View.INVISIBLE);

                BottomSheetDialog dialog = new BottomSheetDialog(HolidayInActivity.this);
                View sheetView = HolidayInActivity.this.getLayoutInflater().inflate(R.layout.call_user, null);
                dialog.setContentView(sheetView);
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();

                final TextView query_1 = (TextView) sheetView.findViewById(R.id.send_query);
                TextView call = (TextView) sheetView.findViewById(R.id.call);

                // Set  query button click listener
                query_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Dismiss the alert dialog

                       Intent i= new Intent(HolidayInActivity.this,query.class);
                       startActivity(i);

                    }
                });

               // Set  call button click listener
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:123456789"));
                        startActivity(callIntent);
                    }
                });

                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        bt.setVisibility(View.VISIBLE);
                    }
                });





            }
        });





    }
}
