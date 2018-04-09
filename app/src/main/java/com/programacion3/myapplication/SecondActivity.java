package com.programacion3.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
        Person extra = (Person) getIntent().getSerializableExtra("CredentialsExtra");
        credentialsTextView.setText(extra.getUsername() + "\n" + extra.getPassword());
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













