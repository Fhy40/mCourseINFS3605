package com.example.mcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mcourse.degree.degree;
import com.example.mcourse.degree.degree_adapter;

import java.util.List;

public class degree_selection extends AppCompatActivity {

    private List<degree> degreeList = degree.getDegrees();
    private RecyclerView recyclerView;
    private degree_adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree_selection);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new degree_adapter(degreeList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    public interface RecyclerviewOnClickListener{
        void recyclerviewClick(int position);
    }
}
