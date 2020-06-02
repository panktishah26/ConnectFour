package com.example.connectfour;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN=1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        FirebaseAuth fbauth=FirebaseAuth.getInstance();
        FirebaseUser fbuser=fbauth.getCurrentUser();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (fbuser!=null)
                {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Intent intent=new Intent(SplashScreen.this, loginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },SPLASH_SCREEN);
    }
}
