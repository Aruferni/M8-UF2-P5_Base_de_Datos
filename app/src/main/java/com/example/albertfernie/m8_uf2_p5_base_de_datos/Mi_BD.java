package com.example.albertfernie.m8_uf2_p5_base_de_datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by albertfernie on 14/02/2017.
 */

public class Mi_BD extends SQLiteOpenHelper {

    String SQLiteCreate = "CREATE TABLE Usuarios (DNI TEXT PRIMARY KEY, Nombre TEXT, Puntos TEXT)";

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

    public int insertar(String nombre, String Dni, String puntos){
        SQLiteDatabase _descp_ins;
        SQLiteDatabase _descp_busc;
        _descp_ins = this.getWritableDatabase();
        _descp_busc = this.getReadableDatabase();
        String _cad = "INSERT INTO Usuarios VALUES ('" + Dni + "' , '" + nombre +"' , '" + puntos + "')";
        boolean _unico = true;
        try{
            _descp_ins.execSQL(_cad);
        }catch(Exception _e){
            _e.getStackTrace();
            _unico = false;
        }
        String[] campos = new String[]{"DNI", "Nombre", "Puntos"};
        String[] argumentos = new String[]{Dni};
        Cursor _res = _descp_busc.query("Usuarios", campos, "DNI = ?", argumentos, null, null, null);
        int i =_res.getCount();
        _descp_ins.close();
        _descp_busc.close();
        System.out.println("Usuarios actuales con dicho DNI: "+i);
        if(!_unico){
            return -1;
        }else if(i==1){
            return 1;
        }else{
            return 0;
        }
    }

    public String buscar(String _dni){
        SQLiteDatabase _descp_busc;
        _descp_busc = this.getReadableDatabase();
        String[] campos = new String[]{"Nombre"};
        String[] argumentos = new String[]{_dni};
        Cursor _res = _descp_busc.query("Usuarios", campos, "DNI = ?", argumentos, null, null, null);
        if(_res.getCount()>=1){
            _res.moveToNext();
            String _sol = _res.getString(0);
            return _sol;
        }else{
            return "No existe";
        }
    }

    public int eliminar(String _dni){
        SQLiteDatabase _descp_del;
        _descp_del = this.getWritableDatabase();
        String[] _val = new String[] {_dni};
        int _sol = _descp_del.delete("Usuarios", "DNI=?", _val);
        return _sol;
    }

}
