package com.example.connectfour;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.example.connectfour.databinding.DataBindingBinding;
import com.example.connectfour.R;

import java.util.ArrayList;


public class DataBinding extends AppCompatActivity {
    private static final String LOG_TAG = "DataBinding";
    private DataBindingBinding binding;
    private String withId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.data_binding);
        Bundle extras = getIntent().getExtras();
        String type = extras.getString("type");
        if (type.equals("wifi")) {
            withId = extras.getString("withId");
            //binding.canvas.setWifiWith(withId);
            String gameId = extras.getString("gameId");
            //binding.canvas.setGameId(gameId);
            //binding.canvas.setMe(extras.getString("me"));

            FirebaseDatabase.getInstance().getReference().child("games")
                    .child(gameId)
                    .setValue(null);
        }
    }
}
