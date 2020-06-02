package com.example.connectfour.push_notifications;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;

import static com.example.connectfour.Util.savePushToken;


public class MyFirebaseInstanceIdService extends FirebaseMessagingService {
    private static final String LOG_TAG = "MyFirebaseInstanceId";
    @Override
    public void onNewToken(String s) {
        Log.d(LOG_TAG, "onTokenRefresh: ");
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null || currentUser.isAnonymous()) {
            return;
        }

        savePushToken(refreshedToken, currentUser.getUid());
    }
}
