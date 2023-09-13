package com.example.sabeelproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class donations extends AppCompatActivity {
    EditText item,firstname,lastname,phone,address,details;
    Button submit;
    FirebaseDatabase database;
    DatabaseReference reference;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donations);

        item = findViewById(R.id.item);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        phone = findViewById(R.id.phonenumber);
        address = findViewById(R.id.adderss);
        details = findViewById(R.id.Details);
        submit = findViewById(R.id.submit_button);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Donation List");

                String items = item.getText().toString();
                String firstName = firstname.getText().toString();
                String lastName = lastname.getText().toString();
                String phoneNumber = phone.getText().toString();
                String Address = address.getText().toString();
                String detail = details.getText().toString();




                if (items.isEmpty()) {
                   item.setError("items cannot be empty");
                    item.requestFocus();
                } else if (firstName.isEmpty()) {
                    firstname.setError("first name cannot be empty");
                    firstname.requestFocus();
                } else if (lastName.isEmpty()) {
                    lastname.setError("last name cannot be empty");
                    lastname.requestFocus();
                } else if (phoneNumber.isEmpty()) {
                    phone.setError("Phone Number cannot be empty");
                    phone.requestFocus();
                } else {
                    if (Address.isEmpty()) {
                        address.setError("Address cannot be empty");
                        address.requestFocus();
                    }else {

                        HashMap<String, String> userMap = new HashMap<>();

                        userMap.put("firstname", firstName);
                        userMap.put("item", items);
                        userMap.put("lastname", lastName);
                        userMap.put("phone", phoneNumber);
                        userMap.put("address", Address);
                        userMap.put("details", detail);
                        reference.push().setValue(userMap);


                        Toast.makeText(donations.this, "Submitted Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(donations.this, Selections.class);
                        startActivity(intent);
                    }
                }

            }

        });

    }
    }