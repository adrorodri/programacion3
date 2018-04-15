package com.programacion3.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class WidgetsActivity extends AppCompatActivity {

    ToggleButton toggleMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);

        toggleMain = findViewById(R.id.toggleMain);

        toggleMain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(WidgetsActivity.this, "Ahora estas encendido!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Radio button function
    public void radioChanged(View view) {
        switch (view.getId()) {
            case R.id.radio1: {
                Toast.makeText(this, "RADIO 1", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.radio2: {
                Toast.makeText(this, "RADIO 2", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.radio3: {
                Toast.makeText(this, "RADIO 3", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
