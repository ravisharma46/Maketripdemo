package com.example.apple.maketripdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<listitem> listitems;
    private Context context;
    public int count , count2 ;



    public MyAdapter(List<listitem> listitems,Context context ){
        this.listitems = listitems;
        this.context = context;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);


        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        int x = viewHolder.getLayoutPosition();

        Log.i("POSi",Integer.toString(x));

        final listitem listitem = listitems.get(i);

        if(i==0){
            viewHolder.remove.setVisibility(View.INVISIBLE);
        }

        int z=listitems.size();


        Log.i("POSiz",Integer.toString(z));
        viewHolder.room_1.setText(listitem.getRoom());
        viewHolder.adult_1.setText(listitem.getAdult());


      //  if(listitems.get(x).getShow_A().equals("01") && listitems.get(x).getShow_ch().equals("00") ) {
if((z-1)==i){
            viewHolder.adultA_1.setText(listitem.getAdultA());
            viewHolder.child_1.setText(listitem.getChild());
            viewHolder.childA_1.setText(listitem.getChidA());
            viewHolder.show_int.setText(listitem.getShow_A());
            viewHolder.show_int2.setText(listitem.getShow_ch());

            count=1;
            count2=0;


    if (count == 1){
        viewHolder.dcr_bt.setEnabled(false);
    }

            // button for adult listener
            viewHolder.incr_bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    count++;
                    viewHolder.dcr_bt.setEnabled(true);
                    if (count > 4) {
                        viewHolder.incr_bt.setEnabled(false);
                        return;
                    }
                    viewHolder.show_int.setText("0" + Integer.toString(count));

                }
            });


            viewHolder.dcr_bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count--;
                    viewHolder.incr_bt.setEnabled(true);
                    if (count == 0) {
                        viewHolder.dcr_bt.setEnabled(false);
                        return;
                    }
                    viewHolder.show_int.setText("0" + Integer.toString(count));
                }
            });


            //button for child listner
            viewHolder.incr_bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count2++;
                    viewHolder.dcr_bt2.setEnabled(true);
                    if (count2 > 4) {
                        viewHolder.incr_bt2.setEnabled(false);
                        return;
                    }
                    viewHolder.show_int2.setText("0" + Integer.toString(count2));

                }
            });


    if (count2 == 0){
        viewHolder.dcr_bt2.setEnabled(false);
    }

            viewHolder.dcr_bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    viewHolder.incr_bt2.setEnabled(true);
                    count2--;
                    if (count2 == 0) {

                        viewHolder.dcr_bt2.setEnabled(false);
                        viewHolder.show_int2.setText("0" + Integer.toString(count2));
                        return;


                    }

                    viewHolder.show_int2.setText("0" + Integer.toString(count2));
                }
            });




        }
        else{
            viewHolder.show_int.setText(listitems.get(x).getShow_A());
            viewHolder.show_int2.setText(listitems.get(x).getShow_ch());

            viewHolder.dcr_bt.setVisibility(View.INVISIBLE);
            viewHolder.incr_bt.setVisibility(View.INVISIBLE);

            viewHolder.dcr_bt2.setVisibility(View.INVISIBLE);
            viewHolder.incr_bt2.setVisibility(View.INVISIBLE);
        }



    }







    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public Button incr_bt, dcr_bt, incr_bt2, dcr_bt2, remove;
        public TextView room_1, adult_1, adultA_1, child_1, childA_1, show_int, show_int2;

        public LinearLayout linearLayout;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            room_1 = (TextView) itemView.findViewById(R.id.room_1);
            adult_1 = (TextView) itemView.findViewById(R.id.adult_1);
            adultA_1 = (TextView) itemView.findViewById(R.id.adultA_1);
            child_1 = (TextView) itemView.findViewById(R.id.child_1);
            childA_1 = (TextView) itemView.findViewById(R.id.childA_1);

            //for adult
            incr_bt = (Button) itemView.findViewById(R.id.increase);
            dcr_bt = (Button) itemView.findViewById(R.id.decrease);
            show_int = (TextView) itemView.findViewById(R.id.integer_number);


            //for childrens
            incr_bt2 = (Button) itemView.findViewById(R.id.increase_2);
            dcr_bt2 = (Button) itemView.findViewById(R.id.decrease_2);
            show_int2 = (TextView) itemView.findViewById(R.id.integer_number2);

            //remove button
            remove=(Button) itemView.findViewById(R.id.remove);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);




           //saving previous data

           show_int.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence s, int i, int i1, int i2) {

                   Log.e("POSi",Integer.toString(getAdapterPosition()));

               listitems.get(getAdapterPosition()).setShow_A(s.toString());





               }
               @Override
               public void afterTextChanged(Editable editable) {

               }
           });



       //saving previous data
           show_int2.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence s, int i, int i1, int i2) {

                   listitems.get(getAdapterPosition()).setShow_ch(s.toString());
               }

               @Override
               public void afterTextChanged(Editable editable) {

               }
           });


           //remove button set onClick
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position =getAdapterPosition();
                    listitems.remove(position);
                    //ViewHolder.this.getAdapterPosition();
                   // MyAdapter.this.notifyAll();
                    notifyItemRemoved(position);

                }
            });





        }
    }


}
