package com.programacion3.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView credentialsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("LIFE CYCLE EVENTS", "ON CREATE (2)");

        // Initializing Views
        credentialsTextView = findViewById(R.id.textViewCredentials);

        // Getting Serializable Object from extra
        Person extraPerson = (Person) getIntent().getSerializableExtra("CredentialsExtra");
        credentialsTextView.setText(extraPerson.getUsername() + "\n" + extraPerson.getPassword());

        // Setting click listener to go to the Third Activity
        credentialsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;

                // Get the context by either:
                context = SecondActivity.this;
                // or
                context = v.getContext();

                Intent intent = new Intent(context, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * LifeCycle events
     */

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFE CYCLE EVENTS", "ON START (2)");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFE CYCLE EVENTS", "ON RESUME (2)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFE CYCLE EVENTS", "ON PAUSE (2)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFE CYCLE EVENTS", "ON STOP (2)");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFE CYCLE EVENTS", "ON DESTROY (2)");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFE CYCLE EVENTS", "ON RESTART (2)");
    }
}













