package com.programacion3.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.imageViewTest);
    }

    public void switchScaleType(View view) {
        switch (imageView.getScaleType()){
            case CENTER: {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Toast.makeText(this, "CENTER_CROP", Toast.LENGTH_SHORT).show();
                break;
            }
            case CENTER_CROP: {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                Toast.makeText(this, "CENTER_INSIDE", Toast.LENGTH_SHORT).show();
                break;
            }
            case CENTER_INSIDE: {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                Toast.makeText(this, "CENTER", Toast.LENGTH_SHORT).show();
                break;
            }
            case FIT_CENTER: {
                imageView.setScaleType(ImageView.ScaleType.FIT_END);
                Toast.makeText(this, "FIT_END", Toast.LENGTH_SHORT).show();
                break;
            }
            case FIT_END: {
                imageView.setScaleType(ImageView.ScaleType.FIT_START);
                Toast.makeText(this, "FIT_START", Toast.LENGTH_SHORT).show();
                break;
            }
            case FIT_START: {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Toast.makeText(this, "FIT_XY", Toast.LENGTH_SHORT).show();
                break;
            }
            case FIT_XY: {
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                Toast.makeText(this, "MATRIX", Toast.LENGTH_SHORT).show();
                break;
            }
            case MATRIX: {
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                Toast.makeText(this, "CENTER", Toast.LENGTH_SHORT).show();
                break;
            }
            default: {
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                Toast.makeText(this, "CENTER", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
