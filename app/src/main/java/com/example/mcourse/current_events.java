package com.example.mcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class current_events extends AppCompatActivity {
    private Button road;
    private Button event;
    private Button friends;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        road = findViewById(R.id.road_button);
        event = findViewById(R.id.event_button);
        friends = findViewById(R.id.friend_button);

//        road.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                road.setBackgroundResource(R.drawable.road_selected);
//                event.setBackgroundResource(R.drawable.event_unselected);
//                friends.setBackgroundResource(R.drawable.friend_unselected);
//                Intent intent = new Intent(current_events.this, roadmap.class);
//                startActivity(intent);
//            }
//        });
//        event.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                event.setBackgroundResource(R.drawable.event_selected);
//                road.setBackgroundResource(R.drawable.road_unselected);
//                friends.setBackgroundResource(R.drawable.friend_unselected);
//                Intent intent = new Intent(current_events.this, current_events.class);
//                startActivity(intent);
//            }
//        });
//        friends.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                friends.setBackgroundResource(R.drawable.friend_selected);
//                road.setBackgroundResource(R.drawable.road_unselected);
//                event.setBackgroundResource(R.drawable.event_unselected);
//                Intent intent = new Intent(current_events.this, friends_page.class);
//                startActivity(intent);
//            }
//        });
    }
}
