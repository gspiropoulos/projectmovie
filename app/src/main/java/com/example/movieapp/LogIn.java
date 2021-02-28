package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Button signUp = findViewById(R.id.sign_btn);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LogIn.this, Register.class);
                startActivity(intent);

            }
        });

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button logBtn = findViewById(R.id.log_btn);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(username.getText().toString().isEmpty()){
                    username.setError("Email is missing");
                    return;
                }



           firebaseAuth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString())
                   .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                       @Override
                       public void onSuccess(AuthResult authResult) {
                           Intent intent = new Intent(getApplicationContext(), ResponseActivity.class);
                           startActivity(intent);
                       }
                   }).addOnFailureListener(new OnFailureListener() {
               @Override
               public void onFailure(@NonNull Exception e) {

                   Toast.makeText(LogIn.this, "Error with log in", Toast.LENGTH_SHORT).show();

               }
           });


            }

        });
    }
}