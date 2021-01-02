package com.selab.volunteer;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class offer extends AppCompatActivity {


    private Intent intent, intent1;
    private FirebaseAuth mAuth;
    DatabaseReference databaseEvents;
    private LoginButton facebookbutton;
    private SignInButton googlebutton;
    EditText location;
    EditText type;
    EditText price;
    EditText phone;
    int eventp;
    String eventl ;
    String eventt ;
    String eventph ;

    LinearLayout layout;
    boolean connected = false;
    ProgressDialog mprogress,googlebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of__events);

        //offer.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        location=findViewById(R.id.location);
        type=findViewById(R.id.type);
        price=findViewById(R.id.price);


       // eventph = phone.getText().toString().trim();
        eventph="s";
        final Button submit=(Button)findViewById(R.id.submit) ;


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventl = location.getText().toString().trim();
                eventt = type.getText().toString().trim();
                eventp = Integer.parseInt(price.getText().toString());
                        final EventOneSchema eventOneSchema = new EventOneSchema(eventl, eventt, eventp, eventph);


                databaseEvents = FirebaseDatabase.getInstance().getReference().child("trees");
                String eventId = databaseEvents.push().getKey();

                databaseEvents.child(eventId).setValue(eventOneSchema);
                Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_LONG).show();

                intent=new Intent(com.selab.volunteer.offer.this,HostFinal.class);
                startActivity(intent);
            }
        });



    }}