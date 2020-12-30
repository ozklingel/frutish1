package com.selab.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivitybuyer extends AppCompatActivity {
    Button a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainbuyer);
        a = findViewById(R.id.hostedEvents);
        b = findViewById(R.id.requestedEvents);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivitybuyer.this, search.class);
                startActivity(intent);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivitybuyer.this, acountsetting.class);
                startActivity(intent);
            }
        });
    }


}
