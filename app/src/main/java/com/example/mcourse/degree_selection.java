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

import com.example.mcourse.degree.degree;
import com.example.mcourse.degree.degree_adapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class degree_selection extends AppCompatActivity implements degree_adapter.OnDegreeListener {

    private List<degree> degreeList = degree.getDegrees();
    private RecyclerView recyclerView;
    private degree_adapter mAdapter;
    private Button next_button;
    private String degree_chosen;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree_selection);

        next_button = (Button) findViewById(R.id.next_button);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new degree_adapter(degreeList, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        db  = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        final String current_user_uid =firebaseUser.getUid();

        next_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            Map<String, Object> cur_degree = new HashMap<>();
            cur_degree.put("degree", degree_chosen);

            db.collection("users").document(current_user_uid)
                    .set(cur_degree, SetOptions.merge())
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("arjun", "DocumentSnapshot successfully written!");
                            goCareerSelection();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("arjun", "Error writing document", e);
                        }
                    });
            }
        });

    }

    @Override
    public void onDegreeClick(int position) {
        Log.d("arjun","Current Position: " + degreeList.get(position));
        Log.d("arjun","Current Degree: " + degreeList.get(position).getName());
        degree_chosen = degreeList.get(position).getName();

        next_button.setVisibility(View.VISIBLE);
    }

    public void goCareerSelection() {
        Intent intent = new Intent(this, career_options_selection.class);
        startActivity(intent);
    }


}
