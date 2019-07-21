package com.example.mcourse;

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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button signup_button = findViewById(R.id.signup_button);
        final Button login_button = findViewById(R.id.login_button);
        final EditText email_input = findViewById(R.id.email_input);
        final EditText password_input = findViewById(R.id.password_input);

        final FirebaseAuth auth = FirebaseAuth.getInstance();


        signup_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                goAccountCreation();
            }
        });

        login_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                auth.signInWithEmailAndPassword(email_input.getText().toString(), password_input.getText().toString())
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("arjun", "signInWithEmail:success");
                                    FirebaseUser user = auth.getCurrentUser();
                                    Log.d("arjun", "current user_id =" + user.toString());
                                    goProfilePage();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("arjun", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }

                                // ...
                            }
                        });
            }
        });
    }

    public void goAccountCreation() {
        Intent intent = new Intent(this, roadmap.class);
        startActivity(intent);
    }

    public void goProfilePage() {
        Intent intent = new Intent(this, user_profile.class);
        startActivity(intent);
    }

    public void goDegreeSelection() {
        Intent intent = new Intent(this, degree_selection.class);
        startActivity(intent);
    }

    private void updateUI(FirebaseUser user) {

        if (user != null) {
            Toast.makeText(MainActivity.this, "User is signed in",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "No user signed in",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
