package com.selab.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;


public class welcom extends AppCompatActivity {

        Intent Newpage;
        private int flag=0;
        private FirebaseAuth mAuth;
        DatabaseReference dataBaseb,dataBases;
        DataSnapshot dataSnapshot;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.welcom1);


            final Button signupbuyer =(Button)findViewById(R.id.submitb);
            final Button signupsailer =(Button)findViewById(R.id.submits);
            final Button odot =(Button)findViewById(R.id.submito);

            // set load icon

            signupbuyer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1;

                    intent1=new Intent(com.selab.volunteer.welcom.this,Login.class);
                    startActivity(intent1);
                }
            });
            signupsailer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1;

                    intent1=new Intent(com.selab.volunteer.welcom.this, login_seller.class);
                    startActivity(intent1);
                }
            });
            odot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1;

                    intent1=new Intent(com.selab.volunteer.welcom.this, odot.class);
                    startActivity(intent1);
                }
            });
        }
    }