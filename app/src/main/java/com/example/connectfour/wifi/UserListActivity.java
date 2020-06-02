package com.group2.kotlinapp.wifi;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.group2.kotlinapp.R;
import com.group2.kotlinapp.Util;
import com.group2.kotlinapp.databinding.ActivityUserListBinding;
import com.group2.kotlinapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {
    private static final String LOG_TAG = "UserListActivity";
    private List<User> users = new ArrayList<>();
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list);

        adapter = new Adapter(this, users);
        Log.d("here------------->",String.valueOf(users));
        binding.list.setLayoutManager(new LinearLayoutManager(this));
        binding.list.setAdapter(adapter);
        fetchUsers();
    }

    private void fetchUsers() {
        FirebaseDatabase.getInstance().getReference().child("users")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Log.d("user------------->",String.valueOf(snapshot));
                            User user = snapshot.getValue(User.class);
                            if (!snapshot.getKey().equals(Util.getCurrentUserId())) {
                                users.add(user);
                            }
                        }

                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }
}
