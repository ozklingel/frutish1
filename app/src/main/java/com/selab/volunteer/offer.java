package com.selab.volunteer;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        offer.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.logintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("פרסם");



        layout=(LinearLayout)findViewById(R.id.loginlayout);
        layout.setVisibility(View.VISIBLE);

        location=findViewById(R.id.location);
        type=findViewById(R.id.type);
        price=findViewById(R.id.price);


       // eventph = phone.getText().toString().trim();
        eventph="s";
        final Button submit=(Button)findViewById(R.id.submit) ;


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventl = location.getText().toString();
                eventt = type.getText().toString();
                eventp = Integer.parseInt(price.getText().toString());
                        final EventOneSchema eventOneSchema = new EventOneSchema(eventl, eventt, eventp, eventph);



                        databaseEvents = FirebaseDatabase.getInstance().getReference().child("Events/" );
                        String eventId = databaseEvents.push().getKey();

                        databaseEvents.child(eventId).setValue(eventOneSchema);
                Toast.makeText(getApplicationContext(), "successful"+eventId, Toast.LENGTH_LONG).show();

                intent=new Intent(com.selab.volunteer.offer.this,HostFinal.class);
                startActivity(intent);
            }
        });



    }}