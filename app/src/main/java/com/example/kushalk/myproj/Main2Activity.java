package com.example.kushalk.myproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Main2Activity extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private Button btnSignup ,btnjmplogin;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        btnSignup = (Button) findViewById(R.id.sign_up_button);
        btnjmplogin = (Button) findViewById(R.id.sign_in_button);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputEmail = (EditText) findViewById(R.id.email);
                inputPassword = (EditText) findViewById(R.id.password);


                String inputEmail_string = inputEmail.getText().toString();
                final String inputpassword_string = inputPassword.getText().toString();


                if (TextUtils.isEmpty(inputEmail_string)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(inputpassword_string)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth=FirebaseAuth.getInstance();


                Toast.makeText(getApplicationContext(), "Wait!", Toast.LENGTH_SHORT).show();
                auth.createUserWithEmailAndPassword(inputEmail_string,inputpassword_string).addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Task Successfull!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Main2Activity.this,MainActivity.class));


                        }
                    }
                });
                btnjmplogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Main2Activity.this,MainActivity.class));
                    }
                });


            }
        });


    }
}
