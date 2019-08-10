package com.example.mcourse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mcourse.year.Year;
import com.example.mcourse.year.YearAdapter;

import java.util.LinkedList;
import java.util.List;

public class roadmap extends AppCompatActivity {
    private List<Year> mData = null;
    private Context mContext;
    private YearAdapter mAdapter = null;
    private ListView list_year;
    private Button road;
    private Button event;
    private Button friend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadmap);

        mContext = roadmap.this;
        list_year = (ListView) findViewById(R.id.listView);
        mData = new LinkedList<Year>();
        mData.add(new Year("T1","T2","T3"));
        mData.add(new Year("T1","T2","T3"));
        mData.add(new Year("T1","T2","T3"));
        mData.add(new Year("T1","T2","T3"));
        mData.add(new Year("T1","T2","T3"));
        mAdapter = new YearAdapter((LinkedList<Year>) mData, mContext);
        list_year.setAdapter(mAdapter);

        road = findViewById(R.id.roadmap_button);
        event = findViewById(R.id.event_button);
        friend = findViewById(R.id.friend_button);

        road.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                road.setBackgroundResource(R.drawable.road_selected);
                event.setBackgroundResource(R.drawable.event_unselected);
                friend.setBackgroundResource(R.drawable.friend_unselected);
                Intent intent = new Intent(roadmap.this, roadmap.class);
                startActivity(intent);
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                event.setBackgroundResource(R.drawable.event_selected);
                road.setBackgroundResource(R.drawable.road_unselected);
                friend.setBackgroundResource(R.drawable.friend_unselected);
                Intent intent = new Intent(roadmap.this, roadmap.class);
                startActivity(intent);
            }
        });
        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friend.setBackgroundResource(R.drawable.friend_selected);
                road.setBackgroundResource(R.drawable.road_unselected);
                event.setBackgroundResource(R.drawable.event_unselected);
                Intent intent = new Intent(roadmap.this, friends_page.class);
                startActivity(intent);
            }
        });

        road.setBackgroundResource(R.drawable.road_selected);
    }
}
