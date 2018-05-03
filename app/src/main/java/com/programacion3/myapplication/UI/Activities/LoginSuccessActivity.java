package com.programacion3.myapplication.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.programacion3.myapplication.Model.Person;
import com.programacion3.myapplication.R;

public class LoginSuccessActivity extends AppCompatActivity {

    TextView credentialsTextView;
    Button buttonNext;
    Person extraPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        Log.d("LIFE CYCLE EVENTS", "ON CREATE (2)");

        // Initializing Views
        credentialsTextView = findViewById(R.id.textViewCredentials);

        // Getting Serializable Object from extra
        extraPerson = (Person) getIntent().getSerializableExtra("CredentialsExtra");
        credentialsTextView.setText(extraPerson.getUsername() + "\n" + extraPerson.getPassword());
    }

    // When back is pressed, we will finish the activity, but we will send the same "Person" object
    // that we received from the extras.

    @Override
    public void onBackPressed() {
        // Set the value to return to the previous activity
        Intent resultIntent = new Intent();
        resultIntent.putExtra("CredentialsExtra", extraPerson);
        setResult(RESULT_OK, resultIntent);
        // Once we have set the result, we finish the activity normally
        finish();
    }
}













