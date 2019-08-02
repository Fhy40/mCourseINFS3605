package com.example.mcourse;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mcourse.Adapter.CardAdapter;
import com.huxq17.swipecardsview.SwipeCardsView;
import com.example.mcourse.Model.Model;

import java.util.ArrayList;
import java.util.List;

public class career_preference extends AppCompatActivity {
    private SwipeCardsView swipeCardsView;
    private List<Model> modelList = new ArrayList<>();
    private TextView question;
    private ProgressBar progressBar;
    private int count = 0;
    private Button button;
    private ImageView imageView;
    private TextView explanation;
    private TextView career;
    private ImageView yes;
    private ImageView no;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_preference);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);
        question = findViewById(R.id.question);
        career = findViewById(R.id.career);
        explanation = findViewById(R.id.explanation);
        swipeCardsView = (SwipeCardsView) findViewById(R.id.scview);
        swipeCardsView.retainLastCard(false);
        swipeCardsView.enableSwipe(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.GONE);
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                swipeCardsView.setVisibility(View.VISIBLE);
                button.setText("VIEW COURSES");
                question.setText("I'm curious..do u like working with people?");
            }
        });
        swipeCardsView.setCardsSlideListener(new SwipeCardsView.CardsSlideListener() {
            @Override
            public void onShow(int index) {

            }

            @Override
            public void onCardVanish(int index, SwipeCardsView.SlideType type) {
                count++;
                switch (type){
                    case LEFT:
                        if(count == 1) {
                            question.setText("How about working with data?");
                            progressBar.setProgress(33);
                            break;
                        } else if(count == 2) {
                            question.setText("Finally, do you like creative work?");
                            progressBar.setProgress(66);
                            break;
                        } else if(count == 3) {
                            question.setText("We think that this is right for you");
                            progressBar.setVisibility(View.GONE);
                            imageView.setVisibility(View.VISIBLE);
                            explanation.setVisibility(View.VISIBLE);
                            career.setVisibility(View.VISIBLE);
                            button.setVisibility(View.VISIBLE);
                            yes.setVisibility(View.GONE);
                            no.setVisibility(View.GONE);
                        }

                    case RIGHT:
                        if(count == 1) {
                            question.setText("How about working with data?");
                            progressBar.setProgress(33);
                            break;
                        } else if(count == 2) {
                            question.setText("Finally, do you like creative work?");
                            progressBar.setProgress(66);
                            break;
                        } else if(count == 3) {
                            question.setText("We think that this is right for you");
                            progressBar.setVisibility(View.GONE);
                            imageView.setVisibility(View.VISIBLE);
                            explanation.setVisibility(View.VISIBLE);
                            career.setVisibility(View.VISIBLE);
                            button.setVisibility(View.VISIBLE);
                            yes.setVisibility(View.GONE);
                            no.setVisibility(View.GONE);
                        }
                }
            }

            @Override
            public void onItemClick(View cardImageView, int index) {

            }
        });

        getData();
    }

    private void getData() {
        modelList.add(new Model("", R.drawable.teamwork));
        modelList.add(new Model("", R.drawable.designer));
        modelList.add(new Model("", R.drawable.creative));


        CardAdapter cardAdapter = new CardAdapter(modelList, this);
        swipeCardsView.setAdapter(cardAdapter);
    }
}
