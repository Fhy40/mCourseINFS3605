package com.example.mcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.mcourse.friend_request.friend_requests_adapter;
import com.example.mcourse.friends.friend;
import com.example.mcourse.friends.friends_adapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class friends_page extends AppCompatActivity implements friends_adapter.OnFriendListener{
    private List<friend> friendList = friend.getDummyFriends();
    private RecyclerView recyclerView;
    private friends_adapter mAdapter;
    private Button back_button;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_page);

        db  = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        final String current_user_uid = firebaseUser.getUid();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new friends_adapter(friendList, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onFriendClick(int position) {
        Log.d("arjun","Current Position: " + friendList.get(position));
        Log.d("arjun","Current Career: " + friendList.get(position).getF_name());
    }
}
