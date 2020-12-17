package com.selab.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class welcom extends AppCompatActivity {
    Button gotob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcom1);
        gotob = findViewById(R.id.requestedEvents);

        gotob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcom.this, Login.class);
                startActivity(intent);


            }
        });
    }
}