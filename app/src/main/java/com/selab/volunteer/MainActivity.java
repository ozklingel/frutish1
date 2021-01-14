package com.selab.volunteer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {
    Button a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.hostedEvents);
        b = findViewById(R.id.requestedEvents);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, offer.class);
                startActivity(intent);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, acountsetting.class);
                startActivity(intent);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        MenuItem getItem = menu.findItem(R.id.get_item);
        if (getItem != null) {
            getItem.setTitle("logout");
            AppCompatButton button = (AppCompatButton) getItem.getActionView();
            //Set a ClickListener, the text,
            //the background color or something like that

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("");
                    builder.setTitle("");

                    //Setting message manually and performing action on button click
                    builder.setMessage("Do you want to close this application ?");
                    //This will not allow to close dialogbox until user selects an option
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(MainActivity.this, welcom.class);
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            Toast.makeText(MainActivity.this, "good choose of button", Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                        }
                    });

                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    //alert.setTitle("AlertDialogExample");
                    alert.show();
                }
            });
        }

        return super.onCreateOptionsMenu(menu);
    }

}
