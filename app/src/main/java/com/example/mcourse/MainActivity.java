package com.example.mcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button signup_button = findViewById(R.id.signup_button);

        signup_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                goAccountCreation();
            }
        });
    }

    public void goAccountCreation() {
        Intent intent = new Intent(this, account_creation.class);
        startActivity(intent);
    }
}
