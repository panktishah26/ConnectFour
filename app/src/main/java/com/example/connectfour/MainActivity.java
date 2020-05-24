package com.example.connectfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button computer, friend, profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        computer =(Button)findViewById(R.id.button);
        friend =(Button)findViewById(R.id.button2);
        profile =(Button)findViewById(R.id.button3);

        computer.setOnClickListener(new MainActivity.PlayWithComputer());
        friend.setOnClickListener(new MainActivity.PlayWithFriend());
        profile.setOnClickListener(new MainActivity.ViewProfile());
    }


    private class PlayWithComputer implements View.OnClickListener {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, GameActivity.class));
        }
    }

    private class PlayWithFriend implements View.OnClickListener {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, GameActivity.class));
        }
    }

    private class ViewProfile implements View.OnClickListener {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, GameActivity.class));
        }
    }
}
