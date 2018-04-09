package com.programacion3.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("LIFE CYCLE EVENTS", "ON CREATE (2)");

        resultTextView = findViewById(R.id.testJavaText);

        Person extra = (Person) getIntent().getSerializableExtra("testExtra");

        resultTextView.setText(extra.getUsername() + "\n" + extra.getPassword());
    }

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













