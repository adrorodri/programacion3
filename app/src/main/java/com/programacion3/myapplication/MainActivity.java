package com.programacion3.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewTest;

    EditText editTextTest;

    String editTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}













