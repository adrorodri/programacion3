package com.programacion3.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StorageActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";
    EditText editTextUsername;
    TextView textViewJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        editTextUsername = findViewById(R.id.editTextUsername);
        textViewJSON = findViewById(R.id.textViewJSON);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);

        try {
            JSONObject person = new JSONObject();
            person.put("username", "UPB");
            person.put("password", "pollito");
            person.put("edad", 40);

            JSONObject mascota1 = new JSONObject();
            mascota1.put("nombre", "Cachuchin");
            mascota1.put("tipo", "Cocodrilo");
            mascota1.put("pelaje", "Rastas");

            JSONObject mascota2 = new JSONObject();
            mascota2.put("nombre", "Cachuchin2");
            mascota2.put("tipo", "Cocodrilo2");
            mascota2.put("pelaje", "Rastas2");

            JSONArray mascotaArray = new JSONArray();
            mascotaArray.put(mascota1);
            mascotaArray.put(mascota2);

            person.put("mascotas", mascotaArray);

            textViewJSON.setText(person.toString(3));

        } catch (JSONException e) {
            textViewJSON.setText("Error parsing JSON");
        }
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.readSharedPreferencesButton: {
                String usernameFromPreferences = sharedPreferences.getString(KEY_USERNAME, "No hay username");
                if (!usernameFromPreferences.equals("")) {
                    Toast.makeText(this, usernameFromPreferences, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Username Vacio", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.writeSharedPreferencesButton: {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_USERNAME, editTextUsername.getText().toString());
                editor.apply();
                break;
            }
        }
    }
}
