package com.programacion3.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewTest;
    EditText editTextUsername;
    EditText editTextPassword;
    String usernameValue;
    String passwordValue;

    String validUsername = "upb";
    String validPassword = "p4ssw0rd";

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

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    /**
     * Click Listener example
     * @param view view from XML
     */

    public void clickAqui(View view) {
        Toast.makeText(this, "Pollito Click Listener", Toast.LENGTH_SHORT).show();
    }

    /**
     * Open new Activity example
     * @param view view from XML
     */

    public void openNewActivity(View view) {
        // Get the new values from the Edit Text
        usernameValue = String.valueOf(editTextUsername.getText());
        passwordValue = String.valueOf(editTextPassword.getText());

        if(usernameValue.equals(validUsername) && passwordValue.equals(validPassword)){
            // Open new Activity (SecondActivity.class)
            Intent intent = new Intent(this, SecondActivity.class);

            // Create serializable object
            Person person = new Person(usernameValue, passwordValue);

            // Add object to intent extra
            intent.putExtra("CredentialsExtra", person);

            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid credentials! Help: " + validUsername + "," + validPassword, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * LifeCycle events
     */

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













