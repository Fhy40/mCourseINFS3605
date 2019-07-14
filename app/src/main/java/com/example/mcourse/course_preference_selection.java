package com.example.mcourse;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcourse.course_preference.course_preference;
import com.example.mcourse.course_preference.course_preference_adapter;
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

public class course_preference_selection extends AppCompatActivity implements course_preference_adapter.OnCoursePreferenceListener {

    private List<course_preference> coursePreferenceList = course_preference.getCoursePreferences();
    private RecyclerView recyclerView;
    private course_preference_adapter mAdapter;
    private Button next_button;
    private String coursePreference_chosen;
    ArrayList<String> coursePreferences_selected = new ArrayList<>();

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_preference_selection);

        next_button = (Button) findViewById(R.id.next_button);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new course_preference_adapter(coursePreferenceList, this);

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
                Map<String, Object> cur_coursePreferences = new HashMap<>();
                cur_coursePreferences.put("coursePreferences", coursePreferences_selected);

                db.collection("users").document(current_user_uid)
                        .set(cur_coursePreferences, SetOptions.merge())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("arjun", "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("arjun", "Error writing document", e);
                            }
                        });
                //goCoursePreferenceSelection();
            }
        });

    }

    @Override
    public void onCoursePreferenceClick(int position) {
        Log.d("arjun","Current Position: " + coursePreferenceList.get(position));
        Log.d("arjun","Current CoursePreference: " + coursePreferenceList.get(position).getName());
        coursePreference_chosen = coursePreferenceList.get(position).getName();
        if(coursePreferences_selected.contains(coursePreferenceList.get(position).getName())){
            coursePreferences_selected.remove(coursePreferenceList.get(position).getName());
        } else {
            coursePreferences_selected.add(coursePreferenceList.get(position).getName());
        }
        Log.d("arjun", "CoursePreferences Selected: " + coursePreferences_selected);
        next_button.setVisibility(View.VISIBLE);
    }
}
