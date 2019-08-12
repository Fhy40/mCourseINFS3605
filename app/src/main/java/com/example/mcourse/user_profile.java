package com.example.mcourse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import pl.pawelkleczkowski.customgauge.CustomGauge;

public class user_profile extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore db;
    String progress_actual;
    private Button road;
    private Button event;
    private Button friends;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        final Button roadmap_button = findViewById(R.id.roadmap_button);
        final ImageView profile_picture_imageview = findViewById(R.id.profile_picture_imageview);
        final TextView name_textview = findViewById(R.id.requests_name);
        final TextView degree_textview = findViewById(R.id.degree_textview);
        final TextView connection_textview = findViewById(R.id.connection_textview);
        final CustomGauge progress_percentage_circle = findViewById(R.id.progress_percentage_circle);
        final TextView progress_percentage_textview = findViewById(R.id.progress_percentage_textview);
        final TextView certificate_one_textview = findViewById(R.id.certificate_one_textview);
        final TextView certificate_two_textview = findViewById(R.id.certificate_two_textview);

        db  = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        final String current_user_uid =firebaseUser.getUid().toString();

        DocumentReference user_profile = db.collection("users").document(current_user_uid);
        user_profile.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("arjun", "DocumentSnapshot data: " + document.getData());
                        name_textview.setText(document.getString("f_name") + " " + document.getString("l_name"));
                        degree_textview.setText(document.getString("degree"));

                        progress_actual =document.getLong("progress_percentage").toString();
                        progress_percentage_textview.setText(progress_actual + "%");
                        progress_percentage_circle.setValue(document.getLong("progress_percentage").intValue());
                        certificate_one_textview.setText(document.getString("certificate_1"));
                        certificate_two_textview.setText(document.getString("certificate_2"));
                    } else {
                        Log.d("arjun", "No such document");
                    }
                } else {
                    Log.d("arjun", "get failed with ", task.getException());
                }
            }
        });

        roadmap_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goRoadMap();
            }
        });


        road = findViewById(R.id.road_button);
        event = findViewById(R.id.event_button);
        friends = findViewById(R.id.friend_button);

        road.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                road.setBackgroundResource(R.drawable.road_selected);
                event.setBackgroundResource(R.drawable.event_unselected);
                friends.setBackgroundResource(R.drawable.friend_unselected);
                Intent intent = new Intent(user_profile.this, roadmap.class);
                startActivity(intent);
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                event.setBackgroundResource(R.drawable.event_selected);
                road.setBackgroundResource(R.drawable.road_unselected);
                friends.setBackgroundResource(R.drawable.friend_unselected);
                Intent intent = new Intent(user_profile.this, roadmap.class);
                startActivity(intent);
            }
        });
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friends.setBackgroundResource(R.drawable.friend_selected);
                road.setBackgroundResource(R.drawable.road_unselected);
                event.setBackgroundResource(R.drawable.event_unselected);
                Intent intent = new Intent(user_profile.this, friends_page.class);
                startActivity(intent);
            }
        });

    }

    public void goRoadMap() {
        Intent intent = new Intent(this, roadmap.class);
        startActivity(intent);
    }

    public void goFriendRequests() {
        Intent intent = new Intent(this, friend_requests.class);
        startActivity(intent);
    }

    public void goFriends() {
        Intent intent = new Intent(this, friends_page.class);
        startActivity(intent);
    }

}
