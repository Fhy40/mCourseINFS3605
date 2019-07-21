package com.example.mcourse;
//its for test

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;



public class account_creation extends AppCompatActivity {
    boolean profile_creation_success;
    boolean account_auth_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button create_profile_button;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);
        final EditText fname_input = findViewById(R.id.fname_input);
        final EditText lname_input = findViewById(R.id.lname_input);
        final EditText email_input = findViewById(R.id.email_input);
        final EditText phone_number_input = findViewById(R.id.phone_number_input);
        final EditText dob_input = findViewById(R.id.dob_input);
        final EditText password_input = findViewById(R.id.password_input);
        create_profile_button = (Button) findViewById(R.id.create_profile_button);

        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        final FirebaseAuth auth = FirebaseAuth.getInstance();

        Log.d("arjun", "REACHED THE CREATE PROFILE POINT");

        create_profile_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                profile_creation_success = false;
                account_auth_success = false;

                auth.createUserWithEmailAndPassword(email_input.getText().toString(), password_input.getText().toString())
                        .addOnCompleteListener(account_creation.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("arjun", "createUserWithEmail:success");
                                    FirebaseUser c_user = auth.getCurrentUser();
                                    account_auth_success = true;
                                    Toast.makeText(account_creation.this, "Authentication Successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Log.d("arjun", "Was a profile successfully authenticated? = " + account_auth_success);

                                    Map<String, Object> user = new HashMap<>();
                                    user.put("f_name", fname_input.getText().toString());
                                    user.put("l_name", lname_input.getText().toString());
                                    user.put("email", email_input.getText().toString());
                                    user.put("phone_number", phone_number_input.getText().toString());
                                    user.put("dob", dob_input.getText().toString());
                                    user.put("password", password_input.getText().toString());
                                    user.put("timestamp", FieldValue.serverTimestamp());
                                    user.put("finished_creation", false);
                                    user.put("progress_percentage", 2);
                                    user.put("certificate_1", "Empty");
                                    user.put("certificate_2", "Empty");

                                    db.collection("users").document(c_user.getUid())
                                            .set(user, SetOptions.merge())
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Log.d("arjun", "DocumentSnapshot successfully written!");
                                                    profile_creation_success = true;
                                                    if(profile_creation_success){
                                                        goDegreeSelection();
                                                    }
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Log.w("arjun", "Error adding document", e);
                                                    profile_creation_success = false;
                                                }
                                            });

                                    Log.d("arjun", "Was a profile successfully authenticated? = " + account_auth_success);
                                    Log.d("arjun", "Was a profile successfully created? = " + profile_creation_success);



                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("arjun", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(account_creation.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    account_auth_success = false;

                                }
                            }
                        });

            }
        });








    }

    public void goDegreeSelection() {
        Intent intent = new Intent(this, degree_selection.class);
        startActivity(intent);
    }
}
