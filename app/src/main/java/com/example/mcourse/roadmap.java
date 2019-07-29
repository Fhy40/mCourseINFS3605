package com.example.mcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcourse.year.YearAdapter;

import com.example.mcourse.year.Year;
import java.util.LinkedList;
import java.util.List;

public class roadmap extends AppCompatActivity {
    private List<Year> mData = null;
    private Context mContext;
    private YearAdapter mAdapter = null;
    private ListView list_year;
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


    }
}
