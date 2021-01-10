package com.selab.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class odot extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odot);


        final Button signupbuyer = (Button) findViewById(R.id.submitb);
        signupbuyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1;

                intent1=new Intent(com.selab.volunteer.odot.this,welcom.class);
                startActivity(intent1);
            }
        });
    }
}