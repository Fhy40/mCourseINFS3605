package com.example.mcourse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mcourse.friend_request.friend_requests_adapter;
import com.example.mcourse.friend_request.requests;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class friend_requests extends AppCompatActivity implements friend_requests_adapter.OnRequestsListener {

    private List<requests> requestsList = requests.getDummyRequests();
    private RecyclerView recyclerView;
    private friend_requests_adapter mAdapter;
    private Button friend_button;


    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore db;

    private Button road;
    private Button event;
    private Button friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_requests);

        db  = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        final String current_user_uid = firebaseUser.getUid();

        DocumentReference user_profile = db.collection("users").document(current_user_uid);
        user_profile.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("arjun", "DocumentSnapshot data: " + document.getData());
                        //requestsList = document.getString("requests");
                    } else {
                        Log.d("arjun", "No such document");
                    }
                } else {
                    Log.d("arjun", "get failed with ", task.getException());
                }
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new friend_requests_adapter(requestsList, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        road = findViewById(R.id.road_button);
        event = findViewById(R.id.event_button);
        friends = findViewById(R.id.friend_button);

        road.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                road.setBackgroundResource(R.drawable.road_selected);
                event.setBackgroundResource(R.drawable.event_unselected);
                friends.setBackgroundResource(R.drawable.friend_unselected);
                Intent intent = new Intent(friend_requests.this, roadmap.class);
                startActivity(intent);
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                event.setBackgroundResource(R.drawable.event_selected);
                road.setBackgroundResource(R.drawable.road_unselected);
                friends.setBackgroundResource(R.drawable.friend_unselected);
                Intent intent = new Intent(friend_requests.this, roadmap.class);
                startActivity(intent);
            }
        });
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friends.setBackgroundResource(R.drawable.friend_selected);
                road.setBackgroundResource(R.drawable.road_unselected);
                event.setBackgroundResource(R.drawable.event_unselected);
                Intent intent = new Intent(friend_requests.this, friends_page.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onRequestsClick(int position) {
        Log.d("arjun","Current Position: " + requestsList.get(position));
        Log.d("arjun","Current Career: " + requestsList.get(position).getF_name());
    }

    public void goCourseFriends() {
        Intent intent = new Intent(this, user_profile.class);
        startActivity(intent);
    }
}
