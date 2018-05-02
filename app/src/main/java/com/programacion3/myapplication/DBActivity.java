package com.programacion3.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DBActivity extends AppCompatActivity {

    EditText editTextNombre;
    EditText editTextApellido;
    EditText editTextCodigoUPB;
    TextView textViewJSON;

    DBController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        textViewJSON = findViewById(R.id.textViewJSON);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextCodigoUPB = findViewById(R.id.editTextCodigoUPB);

        dbController = new DBController(this, "Programacion3.db", null, 1);
    }

    public void buttonClick(View view) {
        switch (view.getId()) {

            case R.id.insertButton: {
                boolean inserted = dbController.insertPersona(editTextNombre.getText().toString(),
                        editTextApellido.getText().toString(),
                        Integer.parseInt(editTextCodigoUPB.getText().toString()));
                if (inserted) {
                    Toast.makeText(this, "Insertado correctamente!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Error insertando persona", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case R.id.updateButton: {
                break;
            }

            case R.id.deleteButton: {
                break;
            }
        }
    }
}
