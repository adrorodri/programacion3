package com.programacion3.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginSuccessActivity extends AppCompatActivity {

    TextView credentialsTextView;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        Log.d("LIFE CYCLE EVENTS", "ON CREATE (2)");

        // Initializing Views
        credentialsTextView = findViewById(R.id.textViewCredentials);

        // Getting Serializable Object from extra
        Person extraPerson = (Person) getIntent().getSerializableExtra("CredentialsExtra");
        credentialsTextView.setText(extraPerson.getUsername() + "\n" + extraPerson.getPassword());
    }
}













