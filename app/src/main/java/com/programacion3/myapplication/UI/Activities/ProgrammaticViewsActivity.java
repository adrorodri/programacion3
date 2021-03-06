package com.programacion3.myapplication.UI.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.programacion3.myapplication.R;

public class ProgrammaticViewsActivity extends AppCompatActivity {

    LinearLayout linearLayoutParent;
    TextView textViewUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatic_views);

        // Get the parent Layout
        linearLayoutParent = findViewById(R.id.linearLayoutParent);

        // Create our child TextView object
        textViewUsuario = new TextView(this);
        textViewUsuario.setText("Usuario");
        textViewUsuario.setTextColor(Color.RED);

        // Create generic Linear Parameters for Linear Layout
        LinearLayout.LayoutParams layoutParamsChild =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        1);

        // Create generic Linear Parameters for Linear Layout
        LinearLayout.LayoutParams layoutParamsLinearLayoutChild =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        1);

        // Apply the layout params
        textViewUsuario.setLayoutParams(layoutParamsChild);

        // Add the Child view (TextView) to the Parent (LinearLayout)
        linearLayoutParent.addView(textViewUsuario);

        // Create our child LinearLayout object
        LinearLayout linearLayoutInternal = new LinearLayout(this);
        linearLayoutInternal.setLayoutParams(layoutParamsLinearLayoutChild);

        // Setting the orientation
        linearLayoutInternal.setOrientation(LinearLayout.HORIZONTAL);

        // Create sub-child Button objects
        Button button1 = new Button(this);
        Button button2 = new Button(this);

        // Set layout params for buttons
        button1.setLayoutParams(layoutParamsChild);
        button2.setLayoutParams(layoutParamsChild);

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