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
    String[] validUsernames = {"upb", "ucb"};
    String[] validPasswords = {"p4ssw0rd", "p4ssw0rd"};
    Person person;
    private static int REQUEST_CODE_CREDENTIALS = 123; // Must be lower than 16 bits

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

        for(int i = 0; i < validUsernames.length ; i++) {
            if (usernameValue.equals(validUsernames[i]) && passwordValue.equals(validPasswords[i])) {
                // Open new Activity (SecondActivity.class)
                Intent intent = new Intent(this, LoginSuccessActivity.class);

                // Create serializable object
                person = new Person(usernameValue, passwordValue);

                // Add object to intent extra
                intent.putExtra("CredentialsExtra", person);

                // Instead of calling just startActivity(intent), we call
                // startActivityForResult(intent, SOME_REQUEST_CONSTANT)
                // to expect a return value from the next activity (when it finishes).
                // We handle the returned value in the method onActivityResult

                startActivityForResult(intent, REQUEST_CODE_CREDENTIALS);

                return;
            }
        }

        Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
    }

    // Called only if another activity was started with startActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CREDENTIALS) {
            // Save or update the Person variable from this activity
            person = (Person) data.getSerializableExtra("CredentialsExtra");
            Toast.makeText(this, "Received credentials: " + person.getUsername() + ", " + person.getPassword(), Toast.LENGTH_SHORT).show();
        }
    }
}
