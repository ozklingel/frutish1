package com.selab.volunteer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EventList1 extends Activity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showserch);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        final Button submit=(Button)findViewById(R.id.submit) ;
        // Defined Array values to show in ListView
        String[] values = (String[]) getIntent().getStringArrayExtra("key");;

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                final String  itemValue    = (String) listView.getItemAtPosition(position);
                final FirebaseAuth mAuth = FirebaseAuth.getInstance();
                FirebaseUser currentUser = mAuth.getCurrentUser();

                // Show Alert
                final AlertDialog.Builder builder = new AlertDialog.Builder(EventList1.this);
                builder.setMessage("");
                builder.setTitle("");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to send a mail to this tree owner ?"+ "email:"+itemValue.split(":")[4]);
                //This will not allow to close dialogbox until user selects an option
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(EventList1.this, "secssesfull", Toast.LENGTH_SHORT).show();
                        mAuth.sendPasswordResetEmail(itemValue.split(":")[4]);
                        Intent intent = new Intent(EventList1.this, MainActivitybuyer.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        Toast.makeText(EventList1.this, "good choose of button", Toast.LENGTH_SHORT).show();
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
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EventList1.this, MainActivitybuyer.class);
                startActivity(i);

            }
        });

    }

}