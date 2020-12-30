
package com.selab.volunteer;

        import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class acountsetting extends AppCompatActivity {
    Button a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        a = findViewById(R.id.hostedEvents);
        b = findViewById(R.id.requestedEvents);
        c= findViewById(R.id.changeoldpassword);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(acountsetting.this, changeusername.class);
                //startActivity(intent);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(acountsetting.this, changeemail.class);
                //startActivity(intent);
            }
        });
    }


}
