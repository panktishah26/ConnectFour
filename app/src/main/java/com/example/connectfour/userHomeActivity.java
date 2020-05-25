package com.example.connectfour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userHomeActivity extends AppCompatActivity {
TextView tv_user;
TextView tv_won;
TextView tv_lost;
TextView tv_rank;
Button btn_play;
Button btn_logout;
int won=0;
int lost=0;
private FirebaseAuth mAuth;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        FirebaseAuth.getInstance().signOut();
        finish();
        Intent intent = new Intent(userHomeActivity.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);
        tv_user=findViewById(R.id.tv_user);
        tv_lost=findViewById(R.id.tv_lost);
        tv_won=findViewById(R.id.tv_won);
        tv_rank=findViewById(R.id.tv_rank);
        btn_play=findViewById(R.id.btn_play);
        btn_logout=findViewById(R.id.btn_logout);
        mAuth = FirebaseAuth.getInstance();
        showUserData();

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finishAffinity();
                Intent intent = new Intent(userHomeActivity.this, loginActivity.class);
                startActivity(intent);

            }
        });

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(userHomeActivity.this," Button play",Toast.LENGTH_SHORT).show();
                //updateScores();
                startActivity(new Intent(userHomeActivity.this, MainActivity.class));
            }
        });
    }

       private void showUserData() {
        //Intent intent=getIntent();
        //String username=intent.getStringExtra("username");
        //String pass=intent.getStringExtra("password");

        String uid = mAuth.getCurrentUser().getUid();
        DatabaseReference reference2= FirebaseDatabase.getInstance().getReference().child("Score").child(uid);
        //Query checkUser2=reference2.orderByChild("username").equalTo(username);
        //Toast.makeText(this,"in show user data function "+uid,Toast.LENGTH_SHORT).show();
        //tv_user.setText(username);
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){

                    //String lost=dataSnapshot.child("lost").getValue().toString();
                    tv_lost.setText(dataSnapshot.child("lost").getValue().toString());
                    tv_rank.setText(dataSnapshot.child("ranking").getValue().toString());
                    tv_user.setText(dataSnapshot.child("username").getValue().toString());
                    tv_won.setText(dataSnapshot.child("won").getValue().toString());

                    //Toast.makeText(getApplicationContext(),"lost count "+lost,Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    private void updateScores() {
        //Toast.makeText(this,"in button play",Toast.LENGTH_SHORT).show();
        String uid = mAuth.getCurrentUser().getUid();
        DatabaseReference reference2= FirebaseDatabase.getInstance().getReference().child("Score").child(uid);

        won=Integer.parseInt(tv_won.getText().toString());
        lost=Integer.parseInt(tv_lost.getText().toString());

        won=won+1;
        reference2.child("won").setValue(String.valueOf(won));
        tv_won.setText(String.valueOf(won));


    }
}
