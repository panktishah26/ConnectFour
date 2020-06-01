package com.example.connectfour;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

<<<<<<< Updated upstream
    private static int SPLASH_SCREEN=1000;
=======
    private static int SPLASH_SCREEN=2000;
    Animation topAnimation,bottomAnimation;
    TextView tv_title;
    ImageView iv_icon;
>>>>>>> Stashed changes

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
<<<<<<< Updated upstream
        new Handler().postDelayed(new Runnable() {
=======

        //added 30may
        tv_title=findViewById(R.id.tv_title);
        iv_icon=findViewById(R.id.iv_icon);
        topAnimation= AnimationUtils.loadAnimation(SplashScreen.this,R.anim.top_animation);
        bottomAnimation= AnimationUtils.loadAnimation(SplashScreen.this,R.anim.bottom_animation);
        topAnimation.setDuration(1000);
        bottomAnimation.setDuration(1000);
        iv_icon.setAnimation(topAnimation);
        tv_title.setAnimation(bottomAnimation);

        FirebaseAuth fbauth=FirebaseAuth.getInstance();
        FirebaseUser fbuser=fbauth.getCurrentUser();

         new Handler().postDelayed(new Runnable() {
>>>>>>> Stashed changes
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this, loginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}
