package com.programacion3.myapplication.UI.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.programacion3.myapplication.Controller.DBController;
import com.programacion3.myapplication.Model.Person;
import com.programacion3.myapplication.R;
import com.programacion3.myapplication.UI.Adapters.PersonRecyclerAdapter;

import java.util.LinkedList;
import java.util.List;

public class DBActivity extends AppCompatActivity {

    EditText editTextNombre;
    EditText editTextApellido;
    EditText editTextCodigoUPB;
    RecyclerView recyclerViewPersonas;

    List<Person> personList;
    PersonRecyclerAdapter adapter;

    DBController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        personList = new LinkedList<>();

        recyclerViewPersonas = findViewById(R.id.recyclerViewPersonas);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextCodigoUPB = findViewById(R.id.editTextCodigoUPB);

        adapter = new PersonRecyclerAdapter(this, personList);
        recyclerViewPersonas.setAdapter(adapter);
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(this));

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

            case R.id.selectButton: {
                this.personList.clear();
                this.personList.addAll(dbController.selectAllPersonas());
                adapter.notifyDataSetChanged();
                break;
            }

            case R.id.updateButton: {
                boolean updated = dbController.updatePersona(editTextNombre.getText().toString(),
                        editTextApellido.getText().toString(),
                        editTextCodigoUPB.getText().toString());
                if (updated) {
                    Toast.makeText(this, "Actualizado correctamente!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Error actualizando persona", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case R.id.deleteButton: {
                boolean deleted = dbController.deletePersona(editTextCodigoUPB.getText().toString());
                if (deleted) {
                    Toast.makeText(this, "Borrado correctamente!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Error borrando persona", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
