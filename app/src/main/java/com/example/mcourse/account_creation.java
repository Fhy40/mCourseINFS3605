package com.example.mcourse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class account_creation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText fname_input = findViewById(R.id.fname_input);
        final EditText lname_input = findViewById(R.id.lname_input);
        final EditText email_input = findViewById(R.id.email_input);
        final EditText phone_number_input = findViewById(R.id.phone_number_input);
        final EditText dob_input = findViewById(R.id.dob_input);
        final EditText password_input = findViewById(R.id.password_input);
        final Button create_profile_button = findViewById(R.id.create_profile_button);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        create_profile_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Map<String, Object> user = new HashMap<>();
                user.put("f_name", fname_input.getText());
                user.put("l_name", lname_input.getText());
                user.put("email", email_input.getText());
                user.put("phone_number", phone_number_input.getText());
                user.put("dob", dob_input.getText());
                user.put("password", password_input.getText());
                user.put("finished_creation", false);

                db.collection("users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("arjun", "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("arjun", "Error adding document", e);
                            }
                        });
            }
        });








    }
}
