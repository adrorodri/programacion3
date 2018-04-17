package com.programacion3.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.buttonMainLayouts: {
                intent = new Intent(this, LayoutsActivity.class);
                break;
            }
            case R.id.buttonMainMarginPadding: {
                intent = new Intent(this, MarginPaddingActivity.class);
                break;
            }
            case R.id.buttonMainImage: {
                intent = new Intent(this, ImageActivity.class);
                break;
            }
            case R.id.buttonMainLifeCycle: {
                intent = new Intent(this, LifeCycleActivity.class);
                break;
            }
            case R.id.buttonMainLogin: {
                intent = new Intent(this, LoginActivity.class);
                break;
            }
            case R.id.buttonMainProgrammaticViews: {
                intent = new Intent(this, ProgrammaticViewsActivity.class);
                break;
            }
            case R.id.buttonMainWidgets: {
                intent = new Intent(this, WidgetsActivity.class);
                break;
            }
            case R.id.buttonMainList: {
                intent = new Intent(this, ListActivity.class);
                break;
            }
            default: {
                intent = new Intent(this, LayoutsActivity.class);
                break;
            }
        }

        startActivity(intent);
    }
}













