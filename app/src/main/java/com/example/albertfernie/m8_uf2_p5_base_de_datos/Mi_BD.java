package com.example.albertfernie.m8_uf2_p5_base_de_datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by albertfernie on 14/02/2017.
 */

public class Mi_BD extends SQLiteOpenHelper {

    String SQLiteCreate = "CREATE TABLE Usuarios (DNI INTEGER PRIMARY KEY, nombre TEXT)";

    // constructor:
    public Mi_BD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(SQLiteCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

}
