package com.example.connectfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class GameLevelActivity extends AppCompatActivity {
    Button btn_easy,btn_medium,btn_hard;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        finish();
        Intent intent = new Intent(GameLevelActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_level);
        btn_easy=findViewById(R.id.btn_easy);
        btn_medium=findViewById(R.id.btn_medium);
        btn_hard=findViewById(R.id.btn_hard);

        btn_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GameLevelActivity.this,GameActivity.class);
                intent.putExtra("level",Constants.MODE_EASY);
                intent.putExtra("type", "single");
                startActivity(intent);
            }
        });

        btn_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GameLevelActivity.this,GameActivity.class);
                intent.putExtra("level",Constants.MODE_MEDIUM);
                intent.putExtra("type", "single");
                startActivity(intent);
            }
        });

        btn_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GameLevelActivity.this,GameActivity.class);
                intent.putExtra("level",Constants.MODE_HARD);
                intent.putExtra("type", "single");
                startActivity(intent);
            }
        });
    }
}
