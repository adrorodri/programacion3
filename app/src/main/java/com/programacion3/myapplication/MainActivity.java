package com.programacion3.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    TextView textViewTest;

    EditText editTextTest;

    String editTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LIFE CYCLE EVENTS", "ON CREATE (1)");

        textViewTest = findViewById(R.id.testJavaText);

        textViewTest.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                textViewTest.setBackgroundResource(R.drawable.pollito);
                return true;
            }
        });

        editTextTest = findViewById(R.id.testEditText);

        editTextValue = String.valueOf(editTextTest.getText());
    }

    public void clickAqui(View view) {
        Toast.makeText(this, "Pollito Click Listener", Toast.LENGTH_SHORT).show();
    }

    public void openNewActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        Person person = new Person(editTextTest.getText().toString(),
                editTextTest.getText().toString().toUpperCase());

        intent.putExtra("testExtra", person);

        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFE CYCLE EVENTS", "ON START (1)");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFE CYCLE EVENTS", "ON RESUME (1)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFE CYCLE EVENTS", "ON PAUSE (1)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFE CYCLE EVENTS", "ON STOP (1)");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFE CYCLE EVENTS", "ON DESTROY (1)");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFE CYCLE EVENTS", "ON RESTART (1)");
    }
}













