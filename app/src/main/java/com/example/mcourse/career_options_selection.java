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


import com.example.mcourse.career_selection.career;
import com.example.mcourse.career_selection.career_adapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class career_options_selection extends AppCompatActivity implements career_adapter.OnCareerListener {

    private List<career> careerList = career.getCareers();
    private RecyclerView recyclerView;
    private career_adapter mAdapter;
    private Button next_button;
    private String career_chosen;
    ArrayList<String> careers_selected = new ArrayList<>();

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_options_selection);

        next_button = (Button) findViewById(R.id.next_button);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new career_adapter(careerList, this);

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
                Map<String, Object> cur_careers = new HashMap<>();
                cur_careers.put("careers", careers_selected);

                db.collection("users").document(current_user_uid)
                        .set(cur_careers, SetOptions.merge())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("arjun", "DocumentSnapshot successfully written!");
                                goCoursePreferenceSelection();
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
    public void onCareerClick(int position) {
        Log.d("arjun","Current Position: " + careerList.get(position));
        Log.d("arjun","Current Career: " + careerList.get(position).getName());
        career_chosen = careerList.get(position).getName();
        if(careers_selected.contains(careerList.get(position).getName())){
            careers_selected.remove(careerList.get(position).getName());
        } else {
            careers_selected.add(careerList.get(position).getName());
        }
        Log.d("arjun", "Careers Selected: " + careers_selected);
        next_button.setVisibility(View.VISIBLE);
    }

    public void goCoursePreferenceSelection() {
        Intent intent = new Intent(this, course_preference_selection.class);
        startActivity(intent);
    }
}
