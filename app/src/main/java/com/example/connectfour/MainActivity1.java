package com.example.connectfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.example.connectfour.wifi.UserListActivity;


public class MainActivity extends AppCompatActivity {
    Button computer, friend, profile, btn_signout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        computer =(Button)findViewById(R.id.button);
        friend =(Button)findViewById(R.id.button2);
        profile =(Button)findViewById(R.id.button3);
        btn_signout=findViewById(R.id.btn_signout);
        btn_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finishAffinity();
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });

        computer.setOnClickListener(new MainActivity.PlayWithComputer());
        friend.setOnClickListener(new MainActivity.PlayWithFriend());
        profile.setOnClickListener(new MainActivity.ViewProfile());
    }



    private class PlayWithComputer implements View.OnClickListener {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, GameActivity.class).putExtra("type", "single"));
        }
    }

    private class PlayWithFriend implements View.OnClickListener {
        public void onClick(View v) {
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
            if(currentUser == null) {
                startActivity(new Intent(MainActivity.this, loginActivity.class));
            } else {
                startActivity(new Intent(MainActivity.this, UserListActivity.class));
            }
        }
    }

    private class ViewProfile implements View.OnClickListener {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, userHomeActivity.class));
        }
    }
}
