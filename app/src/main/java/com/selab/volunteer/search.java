package com.selab.volunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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





        location=findViewById(R.id.location);
        type=findViewById(R.id.type);
        price=findViewById(R.id.maximumprice);


        final Button submit=(Button)findViewById(R.id.submit) ;





        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventl = location.getText().toString().trim();
                eventt = type.getText().toString().trim();
                eventp = Integer.parseInt(price.getText().toString().trim());

//curently by type only
                tempdata2 = FirebaseDatabase.getInstance().getReference().child("trees");
                tempdata2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for( DataSnapshot tree : dataSnapshot.getChildren())
                        {
                            String name = tree.child("type").getValue(String.class);
                          if(name.equalsIgnoreCase(eventt))
                            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }});


    }




}