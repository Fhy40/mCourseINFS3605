package com.example.mcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class roadmap extends AppCompatActivity {

    



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadmap);

        ScrollView scrollView = findViewById(R.id.scrollView);

        final Button btn_y3_t3 = findViewById(R.id.button_y3_t3);
        final Button btn_y3_t2 = findViewById(R.id.button_y3_t2);
        final Button btn_y3_t1 = findViewById(R.id.button_y3_t1);
        final Button btn_y2_t3 = findViewById(R.id.button_y2_t3);
        final Button btn_y2_t2 = findViewById(R.id.button_y2_t2);
        final Button btn_y2_t1 = findViewById(R.id.button_y2_t1);
        final Button btn_y1_t3 = findViewById(R.id.button_y1_t3);
        final Button btn_y1_t2 = findViewById(R.id.button_y1_t2);
        final Button btn_y1_t1 = findViewById(R.id.button_y1_t1);

        final Button btn_t9_1 = findViewById(R.id.t9_1);
        final Button btn_t9_2 = findViewById(R.id.t9_2);
        final Button btn_t9_3 = findViewById(R.id.t9_3);
        final Button btn_t8_1 = findViewById(R.id.t8_1);
        final Button btn_t8_2 = findViewById(R.id.t8_2);
        final Button btn_t8_3 = findViewById(R.id.t8_3);
        final Button btn_t7_1 = findViewById(R.id.t7_1);
        final Button btn_t7_2 = findViewById(R.id.t7_2);
        final Button btn_t7_3 = findViewById(R.id.t7_3);

        final Button btn_t6_1 = findViewById(R.id.t6_1);
        final Button btn_t6_2 = findViewById(R.id.t6_2);
        final Button btn_t6_3 = findViewById(R.id.t6_3);
        final Button btn_t5_1 = findViewById(R.id.t5_1);
        final Button btn_t5_2 = findViewById(R.id.t5_2);
        final Button btn_t5_3 = findViewById(R.id.t5_3);
        final Button btn_t4_1 = findViewById(R.id.t4_1);
        final Button btn_t4_2 = findViewById(R.id.t4_2);
        final Button btn_t4_3 = findViewById(R.id.t4_3);

        final Button btn_t3_1 = findViewById(R.id.t3_1);
        final Button btn_t3_2 = findViewById(R.id.t3_2);
        final Button btn_t3_3 = findViewById(R.id.t3_3);
        final Button btn_t2_1 = findViewById(R.id.t2_1);
        final Button btn_t2_2 = findViewById(R.id.t2_2);
        final Button btn_t2_3 = findViewById(R.id.t2_3);
        final Button btn_t1_1 = findViewById(R.id.t1_1);
        final Button btn_t1_2 = findViewById(R.id.t1_2);
        final Button btn_t1_3 = findViewById(R.id.t1_3);

        btn_y1_t1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonAction(btn_t1_1);
                buttonAction(btn_t1_2);
                buttonAction(btn_t1_3);
            }
        });

        btn_y1_t2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonAction(btn_t2_1);
                buttonAction(btn_t2_2);
                buttonAction(btn_t2_3);
            }
        });

        btn_y1_t3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonAction(btn_t3_1);
                buttonAction(btn_t3_2);
                buttonAction(btn_t3_3);
            }
        });

        btn_y2_t1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonAction(btn_t4_1);
                buttonAction(btn_t4_2);
                buttonAction(btn_t4_3);
            }
        });

        btn_y2_t2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonAction(btn_t5_1);
                buttonAction(btn_t5_2);
                buttonAction(btn_t5_3);
            }
        });

        btn_y2_t3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonAction(btn_t6_1);
                buttonAction(btn_t6_2);
                buttonAction(btn_t6_3);
            }
        });

        btn_y3_t1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonAction(btn_t7_1);
                buttonAction(btn_t7_2);
                buttonAction(btn_t7_3);
            }
        });

        btn_y3_t2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonAction(btn_t8_1);
                buttonAction(btn_t8_2);
                buttonAction(btn_t8_3);
            }
        });

        btn_y3_t3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonAction(btn_t9_1);
                buttonAction(btn_t9_2);
                buttonAction(btn_t9_3);
            }
        });

    }
    void buttonAction(Button btn) {
        if(btn.getVisibility() == View.VISIBLE) {
            btn.setVisibility(View.INVISIBLE);
        } else {
            btn.setVisibility(View.VISIBLE);
        }
    }
}
