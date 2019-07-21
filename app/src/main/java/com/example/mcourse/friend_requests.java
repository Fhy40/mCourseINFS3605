package com.example.mcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.mcourse.friend_request.friend_requests_adapter;
import com.example.mcourse.friend_request.requests;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class friend_requests extends AppCompatActivity implements friend_requests_adapter.OnRequestsListener {

    private List<requests> requestsList = requests.getDummyRequests();
    private RecyclerView recyclerView;
    private friend_requests_adapter mAdapter;


    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_requests);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new friend_requests_adapter(requestsList, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        db  = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        final String current_user_uid =firebaseUser.getUid();
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
