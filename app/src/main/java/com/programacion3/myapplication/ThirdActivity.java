package com.programacion3.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    LinearLayout linearLayoutParent;
    TextView textViewUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Get the parent Layout
        linearLayoutParent = findViewById(R.id.linearLayoutParent);

        // Create our child TextView object
        textViewUsuario = new TextView(this);
        textViewUsuario.setText("Usuario");
        textViewUsuario.setTextColor(Color.RED);

        // Create generic Linear Parameters for Linear Layout
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        1);

        // Apply the layout params
        textViewUsuario.setLayoutParams(layoutParams);

        // Add the Child view (TextView) to the Parent (LinearLayout)
        linearLayoutParent.addView(textViewUsuario);

        // Create our child LinearLayout object
        LinearLayout linearLayoutInternal = new LinearLayout(this);
        linearLayoutInternal.setLayoutParams(layoutParams);

        // Setting the orientation
        linearLayoutInternal.setOrientation(LinearLayout.HORIZONTAL);

        // Create sub-child Button objects
        Button button1 = new Button(this);
        Button button2 = new Button(this);

        // Set layout params for buttons
        button1.setLayoutParams(layoutParams);
        button2.setLayoutParams(layoutParams);

        // Set other attributes...
        button1.setText("ENVIAR");
        button2.setText("LIMPIAR");

        // Add the Child Buttons to the Internal Linear Layout.
        linearLayoutInternal.addView(button1);
        linearLayoutInternal.addView(button2);

        // Add the Child Internal LinearLayout to the Parent Linear Layout
        linearLayoutParent.addView(linearLayoutInternal);
    }
}