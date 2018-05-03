package com.programacion3.myapplication.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.programacion3.myapplication.Model.Person;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by adro_ on 5/2/2018.
 */

public class DBController extends SQLiteOpenHelper {

    public DBController(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Personas (_id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Apellido TEXT, CodigoUpb TEXT UNIQUE);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Personas;");
        onCreate(sqLiteDatabase);
    }

    public boolean insertPersona(String nombre, String apellido, int codigoUPB) {

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("Nombre", nombre);
            contentValues.put("Apellido", apellido);
            contentValues.put("CodigoUpb", codigoUPB);

            getWritableDatabase().insertOrThrow("Personas", null, contentValues);

        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    public List<Person> selectAllPersonas() {
        List<Person> personList = new LinkedList<>();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM Personas", null);
        while (cursor.moveToNext()) {
            personList.add(new Person(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3)));
        }
        return personList;
    }

    public boolean updatePersona(String nombre, String apellido, String codigoUpb) {
        try {
            getWritableDatabase().execSQL("UPDATE Personas SET Nombre = '" + nombre + "', Apellido = '" + apellido + "' WHERE CodigoUpb = " + codigoUpb);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean deletePersona(String codigoUpb) {
        try {
            getWritableDatabase().delete("Personas", "CodigoUpb = " + codigoUpb, null);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
