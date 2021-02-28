//package com.example.movieapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.movieapp.LogReg.LogIn;
//
//public class LaunchScreen extends AppCompatActivity {
//    private static int SPLASH_TIME_OUT = 5000;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_launch_screen);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent launchIntent = new Intent(LaunchScreen.this, LogIn.class);
//                startActivity(launchIntent);
//                finish();
//            }
//        },SPLASH_TIME_OUT);
//    }
//}