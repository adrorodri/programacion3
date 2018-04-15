package com.programacion3.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LayoutsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);
    }

    public void openLayoutActivity (View view) {
        switch (view.getId()) {
            case R.id.buttonFrameLayout: {
                Intent intent = new Intent(this, FrameLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.buttonLinearLayout: {
                Intent intent = new Intent(this, LinearLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.buttonRelativeLayout: {
                Intent intent = new Intent(this, RelativeLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.buttonTableLayout: {
                Intent intent = new Intent(this, TableLayoutActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
