package com.selab.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class search extends AppCompatActivity {



    private Intent intent, intent1;
    DatabaseReference databaseReference, tempdata,tempdata2;
    private LoginButton facebookbutton;
    private SignInButton googlebutton;
    EditText location;
    EditText type;
    EditText price;
    String eventp;
    String eventl ;
    String eventt ;
    String text;
    LinearLayout layout;
    boolean connected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waitlisted);

        //FacebookSdk.sdkInitialize(this.getApplicationContext());
        search.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);


        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("search");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        location=findViewById(R.id.location);
        type=findViewById(R.id.type);
        price=findViewById(R.id.maximumprice);


        final Button submit=(Button)findViewById(R.id.submit) ;





        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventl = location.getText().toString().trim();
                eventt = type.getText().toString().trim();
                eventp = price.getText().toString().trim();
                String[] array1 = new  String[3];


                /////////////////////////////////
                if(eventt.isEmpty()&&eventp.isEmpty()&&eventl.isEmpty()) {

                    DatabaseReference tempdata2 = FirebaseDatabase.getInstance().getReference().child("trees");
                    tempdata2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            List<String> array1 = new ArrayList<String>();


                            for (DataSnapshot tree : dataSnapshot.getChildren()) {
                                int p = tree.child("price").getValue(Integer.class);
                                String pvalue = String.valueOf(p);

                                    //array1[0] = tree.child("type").getValue(String.class);
                                    //array1[1] = tree.child("location").getValue(String.class);
                                    //array1[2] = tree.child("location").getValue(String.class);
                                    //array1[0]= array1[0]+ array1[1]+ array1[2];

                                    array1.add("Type:  " + tree.child("type").getValue(String.class) + "           Location:  " + tree.child("location").getValue(String.class) + "           price:  " + pvalue);


                            }
                            String[] stockArr = new String[array1.size()];
                            Intent i = new Intent(search.this, EventList1.class);
                            i.putExtra("key", array1.toArray(stockArr));
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }


                    });
                }
                /////////////////////////////////////////////////

                if(eventt.isEmpty()&&eventp.isEmpty()) {

                    DatabaseReference tempdata2 = FirebaseDatabase.getInstance().getReference().child("trees");
                    tempdata2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            List<String> array1 = new ArrayList<String>();


                            for (DataSnapshot tree : dataSnapshot.getChildren()) {
                                int p = tree.child("price").getValue(Integer.class);
                                String pvalue = String.valueOf(p);

                                if (tree.child("location").getValue(String.class).equalsIgnoreCase(eventl) ) {
                                    //array1[0] = tree.child("type").getValue(String.class);
                                    //array1[1] = tree.child("location").getValue(String.class);
                                    //array1[2] = tree.child("location").getValue(String.class);
                                    //array1[0]= array1[0]+ array1[1]+ array1[2];

                                    array1.add("Type:  " + tree.child("type").getValue(String.class) + "           Location:  " + tree.child("location").getValue(String.class) + "           price:  " + pvalue);

                                }
                            }
                            String[] stockArr = new String[array1.size()];
                            Intent i = new Intent(search.this, EventList1.class);
                            i.putExtra("key", array1.toArray(stockArr));
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }


                    });
                }
                ///////////////////////////////////////////
                if(eventl.isEmpty()&&eventp.isEmpty()) {

                    DatabaseReference tempdata2 = FirebaseDatabase.getInstance().getReference().child("trees");
                    tempdata2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            List<String> array1 = new ArrayList<String>();


                            for (DataSnapshot tree : dataSnapshot.getChildren()) {
                                int p = tree.child("price").getValue(Integer.class);
                                String pvalue = String.valueOf(p);

                                if (tree.child("type").getValue(String.class).equalsIgnoreCase(eventt) ) {
                                    //array1[0] = tree.child("type").getValue(String.class);
                                    //array1[1] = tree.child("location").getValue(String.class);
                                    //array1[2] = tree.child("location").getValue(String.class);
                                    //array1[0]= array1[0]+ array1[1]+ array1[2];

                                    array1.add("Type:  " + tree.child("type").getValue(String.class) + "           Location:  " + tree.child("location").getValue(String.class) + "           price:  " + pvalue);

                                }
                            }
                            String[] stockArr = new String[array1.size()];
                            Intent i = new Intent(search.this, EventList1.class);
                            i.putExtra("key", array1.toArray(stockArr));
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }


                    });
                }
                ////////////////////////////////////////////////
                ///////////////////////////////////////////
                if(eventl.isEmpty()&&eventt.isEmpty()) {

                    DatabaseReference tempdata2 = FirebaseDatabase.getInstance().getReference().child("trees");
                    tempdata2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            List<String> array1 = new ArrayList<String>();


                            for (DataSnapshot tree : dataSnapshot.getChildren()) {
                                int p = tree.child("price").getValue(Integer.class);
                                String pvalue = String.valueOf(p);

                                if (p <= Integer.parseInt(eventp) ) {
                                    //array1[0] = tree.child("type").getValue(String.class);
                                    //array1[1] = tree.child("location").getValue(String.class);
                                    //array1[2] = tree.child("location").getValue(String.class);
                                    //array1[0]= array1[0]+ array1[1]+ array1[2];

                                    array1.add("Type:  " + tree.child("type").getValue(String.class) + "           Location:  " + tree.child("location").getValue(String.class) + "           price:  " + pvalue);

                                }
                            }
                            String[] stockArr = new String[array1.size()];
                            Intent i = new Intent(search.this, EventList1.class);
                            i.putExtra("key", array1.toArray(stockArr));
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }


                    });
                }
    ////////////////////////////////////////////////////
if(eventl.isEmpty()) {

    DatabaseReference tempdata2 = FirebaseDatabase.getInstance().getReference().child("trees");
    tempdata2.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            List<String> array1 = new ArrayList<String>();


            for (DataSnapshot tree : dataSnapshot.getChildren()) {
                int p = tree.child("price").getValue(Integer.class);
                String pvalue = String.valueOf(p);

                if (tree.child("type").getValue(String.class).equalsIgnoreCase(eventt)  && p <= Integer.parseInt(eventp)) {
                    //array1[0] = tree.child("type").getValue(String.class);
                    //array1[1] = tree.child("location").getValue(String.class);
                    //array1[2] = tree.child("location").getValue(String.class);
                    //array1[0]= array1[0]+ array1[1]+ array1[2];

                    array1.add("Type:  " + tree.child("type").getValue(String.class) + "           Location:  " + tree.child("location").getValue(String.class) + "           price:  " + pvalue);

                }
            }
            String[] stockArr = new String[array1.size()];
            Intent i = new Intent(search.this, EventList1.class);
            i.putExtra("key", array1.toArray(stockArr));
            startActivity(i);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }


    });
}
/////////////////////////////////////////////////
                if(eventt.isEmpty()) {

                    DatabaseReference tempdata2 = FirebaseDatabase.getInstance().getReference().child("trees");
                    tempdata2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            List<String> array1 = new ArrayList<String>();


                            for (DataSnapshot tree : dataSnapshot.getChildren()) {
                                int p = tree.child("price").getValue(Integer.class);
                                String pvalue = String.valueOf(p);

                                if ( tree.child("location").getValue(String.class).equalsIgnoreCase(eventl) && p <= Integer.parseInt(eventp)) {
                                    //array1[0] = tree.child("type").getValue(String.class);
                                    //array1[1] = tree.child("location").getValue(String.class);
                                    //array1[2] = tree.child("location").getValue(String.class);
                                    //array1[0]= array1[0]+ array1[1]+ array1[2];

                                    array1.add("Type:  " + tree.child("type").getValue(String.class) + "           Location:  " + tree.child("location").getValue(String.class) + "           price:  " + pvalue);

                                }
                            }
                            String[] stockArr = new String[array1.size()];
                            Intent i = new Intent(search.this, EventList1.class);
                            i.putExtra("key", array1.toArray(stockArr));
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }


                    });
                }
//////////////////////////////////////////////
                if(eventp.isEmpty()) {

                    DatabaseReference tempdata2 = FirebaseDatabase.getInstance().getReference().child("trees");
                    tempdata2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            List<String> array1 = new ArrayList<String>();


                            for (DataSnapshot tree : dataSnapshot.getChildren()) {
                                int p = tree.child("price").getValue(Integer.class);
                                String pvalue = String.valueOf(p);

                                if (tree.child("type").getValue(String.class).equalsIgnoreCase(eventt) && tree.child("location").getValue(String.class).equalsIgnoreCase(eventl) ) {
                                    //array1[0] = tree.child("type").getValue(String.class);
                                    //array1[1] = tree.child("location").getValue(String.class);
                                    //array1[2] = tree.child("location").getValue(String.class);
                                    //array1[0]= array1[0]+ array1[1]+ array1[2];

                                    array1.add("Type:  " + tree.child("type").getValue(String.class) + "           Location:  " + tree.child("location").getValue(String.class) + "           price:  " + pvalue);

                                }
                            }
                            String[] stockArr = new String[array1.size()];
                            Intent i = new Intent(search.this, EventList1.class);
                            i.putExtra("key", array1.toArray(stockArr));
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }


                    });
                }

                DatabaseReference tempdata2 = FirebaseDatabase.getInstance().getReference().child("trees");
                tempdata2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        List<String> array1 = new ArrayList<String>();


                        for (DataSnapshot tree : dataSnapshot.getChildren()) {
                            int p = tree.child("price").getValue(Integer.class);
                            String pvalue = String.valueOf(p);

                            if (tree.child("type").getValue(String.class).equalsIgnoreCase(eventt) && tree.child("location").getValue(String.class).equalsIgnoreCase(eventl)&& p <= Integer.parseInt(eventp) ) {
                                //array1[0] = tree.child("type").getValue(String.class);
                                //array1[1] = tree.child("location").getValue(String.class);
                                //array1[2] = tree.child("location").getValue(String.class);
                                //array1[0]= array1[0]+ array1[1]+ array1[2];

                                array1.add("Type:  " + tree.child("type").getValue(String.class) + "           Location:  " + tree.child("location").getValue(String.class) + "           price:  " + pvalue + "   email:"+tree.child("eventemail").getValue(String.class));

                            }
                        }
                        String[] stockArr = new String[array1.size()];
                        Intent i = new Intent(search.this, EventList1.class);
                        i.putExtra("key", array1.toArray(stockArr));
                        startActivity(i);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }


                });

            }});


    }




}