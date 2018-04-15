package com.programacion3.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsername;
    EditText editTextPassword;
    String usernameValue;
    String passwordValue;
    String validUsername = "upb";
    String validPassword = "p4ssw0rd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    /**
     * Open new Activity example
     *
     * @param view view from XML
     */

    public void login(View view) {
        // Get the new values from the Edit Text
        usernameValue = String.valueOf(editTextUsername.getText());
        passwordValue = String.valueOf(editTextPassword.getText());

        if (usernameValue.equals(validUsername) && passwordValue.equals(validPassword)) {
            // Open new Activity (SecondActivity.class)
            Intent intent = new Intent(this, LoginSuccessActivity.class);

            // Create serializable object
            Person person = new Person(usernameValue, passwordValue);

            // Add object to intent extra
            intent.putExtra("CredentialsExtra", person);

            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid credentials! Help: " + validUsername + "," + validPassword, Toast.LENGTH_SHORT).show();
        }
    }
}