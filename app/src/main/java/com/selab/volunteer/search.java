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
               // array1[0]=eventl;
                //array1[1]=eventt;
                //array1[2]=eventp;


                DatabaseReference tempdata2 = FirebaseDatabase.getInstance().getReference().child("trees");
                tempdata2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        List<String> array1 = new ArrayList<String>();


                        for( DataSnapshot tree : dataSnapshot.getChildren())
                        {

                            if (tree.child("type").getValue(String.class).equalsIgnoreCase(eventt)&&tree.child("location").getValue(String.class).equalsIgnoreCase(eventl)) {
                                //array1[0] = tree.child("type").getValue(String.class);
                                //array1[1] = tree.child("location").getValue(String.class);
                                //array1[2] = tree.child("location").getValue(String.class);
                                //array1[0]= array1[0]+ array1[1]+ array1[2];
                                array1.add("type:"+tree.child("type").getValue(String.class)+"/nlocation:"+tree.child("location").getValue(String.class)+"");

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

//curently by type only

            }});


    }




}