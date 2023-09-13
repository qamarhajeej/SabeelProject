package com.example.sabeelproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;

public class SignupActivity extends AppCompatActivity {
    EditText signupName,signupEmail,signupUsername,signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth=FirebaseAuth.getInstance();

        signupName=findViewById(R.id.signup_name);
        signupEmail=findViewById(R.id.signup_email);
        signupUsername=findViewById(R.id.signup_username);
        signupPassword=findViewById(R.id.signup_password);
        loginRedirectText=findViewById(R.id.loginRedirectText);
        signupButton=findViewById(R.id.signup_button);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database=FirebaseDatabase.getInstance();
                reference=database.getReference("users");

                String name=signupName.getText().toString().trim();
                String email=signupEmail.getText().toString().trim();
                String username=signupUsername.getText().toString().trim();
                String password=signupPassword.getText().toString().trim();
                if (name.isEmpty()){
                    signupName.setError("Name cannot be empty");
                    signupName.requestFocus();
                }else
                if (email.isEmpty()){
                    signupEmail.setError("Email cannot be empty");
                    signupName.requestFocus();
                }else
                if (username.isEmpty()){
                    signupUsername.setError("Username cannot be empty");
                    signupName.requestFocus();
                }else
                if (password.isEmpty()){
                    signupPassword.setError("Password cannot be empty");
                    signupName.requestFocus();
                }else{
                    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                HelperClass helperClass = new HelperClass(name, email, username, password);
                                reference.child(name).setValue(helperClass);

                                Toast.makeText(SignupActivity.this, "you have signed up successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignupActivity.this, "signing up failed!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });



    }
}