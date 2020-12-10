package com.selab.volunteer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.google.firebase.database.ValueEventListener;
public class search extends AppCompatActivity {



    private Intent intent, intent1;
    DatabaseReference databaseReference, tempdata,tempdata2;
    private LoginButton facebookbutton;
    private SignInButton googlebutton;
    EditText location;
    EditText type;
    EditText price;
    int eventp;
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

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.logintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("חפש");

        layout=(LinearLayout)findViewById(R.id.loginlayout);
        layout.setVisibility(View.VISIBLE);

        location=findViewById(R.id.location);
        type=findViewById(R.id.type);
        price=findViewById(R.id.maximumprice);


        final Button submit=(Button)findViewById(R.id.submit) ;





        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventl = location.getText().toString();
                eventt = type.getText().toString();
                eventp = Integer.parseInt(price.getText().toString());

//curently by type only
                tempdata2 = FirebaseDatabase.getInstance().getReference().child("Events/");
                tempdata2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        boolean bool = false;
                        for (DataSnapshot childsnap : dataSnapshot.getChildren()) {
                            if ((childsnap.child("type").getValue() + "").equals((type.getText() + "").trim())) {
                                bool = true;
                                text = childsnap.getKey();
                                Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_LONG).show();
                                TextView pname = (TextView)findViewById(R.id.tree);
                                pname.setText(childsnap.child("type").getValue() + ","+childsnap.child("location").getValue());

                                break;
                            }
                        }
                        if(bool==false){
                            Toast.makeText(getApplicationContext(), "unsuccessful", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }




                });
            }});


    }




}