package com.example.sabeelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Selections extends AppCompatActivity {
    Button donate;
    TextView getHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selections);
        donate=findViewById(R.id.Donate);
        getHelp=findViewById(R.id.get_help);

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Selections.this,donations.class);
                startActivity(intent);
            }
        });

        getHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Selections.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}