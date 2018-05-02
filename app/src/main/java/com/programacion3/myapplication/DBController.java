package com.programacion3.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

        } catch (SQLException e){
            return false;
        }

        return true;
    }
}
