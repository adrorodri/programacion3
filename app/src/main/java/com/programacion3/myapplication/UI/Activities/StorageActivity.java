package com.programacion3.myapplication.UI.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.programacion3.myapplication.Model.Person;
import com.programacion3.myapplication.R;

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

public class StorageActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";
    static final String FILE_NAME = "myText.txt";
    EditText editTextUsername;
    TextView textViewJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        editTextUsername = findViewById(R.id.editTextUsername);
        textViewJSON = findViewById(R.id.textViewJSON);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);

        // Building a JSON object on the go:
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

            // READ TO SHARED PREFERENCES
            case R.id.readSharedPreferencesButton: {
                String usernameFromPreferences = sharedPreferences.getString(KEY_USERNAME, "No existe username!");
                if (!usernameFromPreferences.equals("")) {
                    Toast.makeText(this, usernameFromPreferences, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Username Vacio!", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            // WRITE TO SHARED PREFERENCES
            case R.id.writeSharedPreferencesButton: {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_USERNAME, editTextUsername.getText().toString());
                editor.apply();
                Toast.makeText(this, "Valor guardado correctamente!", Toast.LENGTH_SHORT).show();
                break;
            }

            // WRITE TO INTERNAL STORAGE FILE
            case R.id.writeFileButton: {
                Person person = new Person("UPB", "p4ssw0rd");
                String message = new Gson().toJson(person);
                try {
                    FileOutputStream fileOutputStream = null;
                    fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
                    fileOutputStream.write(message.getBytes());
                    fileOutputStream.close();

                    Toast.makeText(this, "Escritura correcta", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    Toast.makeText(this, "Error al escribir", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                } catch (IOException e) {
                    Toast.makeText(this, "Error al escribir", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                break;
            }

            // READ FROM INTERNAL STORAGE FILE
            case R.id.readFileButton: {
                try {
                    FileInputStream fileInputStream = openFileInput(FILE_NAME);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String lines;
                    while ((lines = bufferedReader.readLine()) != null) {
                        stringBuffer.append(lines + "\n");
                    }

                    Person person = new Gson().fromJson(stringBuffer.toString().trim(), Person.class);
                    Toast.makeText(this, person.getUsername(), Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

            // WRITE TO EXTERNAL STORAGE FILE
            case R.id.writeSDFileButton: {
                Person person = new Person("UPB", "p4ssw0rd");
                String message = new Gson().toJson(person);
                File externalSDFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), FILE_NAME);
                try {
                    FileOutputStream fileOutputStream = null;
                    fileOutputStream = new FileOutputStream(externalSDFile);
//                    fileOutputStream = openFileOutput("my_textt.txt", MODE_PRIVATE);
                    fileOutputStream.write(message.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(this, "Escritura correcta SD", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    Toast.makeText(this, "Error al escribir SD", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                } catch (IOException e) {
                    Toast.makeText(this, "Error al escribir SD", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                break;
            }

            // READ FROM EXTERNAL STORAGE FILE
            case R.id.readSDFileButton: {
                try {
                    File externalSDFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), FILE_NAME);
                    FileInputStream fileInputStream = new FileInputStream(externalSDFile);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String lines;
                    while ((lines = bufferedReader.readLine()) != null) {
                        stringBuffer.append(lines + "\n");
                    }
                    Person person = new Gson().fromJson(stringBuffer.toString().trim(), Person.class);
                    Toast.makeText(this, person.getUsername(), Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

            // READ FROM RAW FILE
            case R.id.readRawFileButton: {
                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.my_text);
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String lines;
                    while ((lines = bufferedReader.readLine()) != null) {
                        stringBuffer.append(lines + "\n");
                    }
                    Person person = new Gson().fromJson(stringBuffer.toString().trim(), Person.class);
                    Toast.makeText(this, person.getUsername(), Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
