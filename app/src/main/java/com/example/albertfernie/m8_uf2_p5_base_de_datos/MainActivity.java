package com.example.albertfernie.m8_uf2_p5_base_de_datos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton insert, search, delete;
    EditText name, id, points;
    Mi_BD bd = new Mi_BD(this, "Mi_DB", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicio();
    }

    private void inicio(){
        msToast("Se ha creado la base de datos.");
        traerReferencias();
    }

    public void clickInsertar(View view){
        String nom = name.getText().toString();
        String dni = id.getText().toString();
        String punts = points.getText().toString();
        if(nom.equals("") || dni.equals("") || punts.equals("")) msToast("Escribe todos los datos");
        int _res = bd.insertar(nom, dni, punts); // se envian los datos para insertar
        if(_res == 1){
            limpiarDatos();
            msToast("Se ha insertado correctamente");
        }
        else{
            msToast("No se ha podido insertar");
        }
    }

    public void clickBuscar(View view){
        String dni = String.valueOf(id.getText());
        String nom = bd.buscarNom(dni);// y visualizamos el _nom
        String punts = bd.buscarPunt(dni);
        name.setText(nom);
        points.setText(punts);
    }

    public void clickCambiar(View view){
        String dni = String.valueOf(id.getText());
        int _res = bd.eliminar(dni);
        if(_res==0) {
            String nom = name.getText().toString();
            dni = id.getText().toString();
            String punts = points.getText().toString();
            if(nom.equals("") || dni.equals("") || punts.equals("")) msToast("Escribe todos los datos");
            int _res2 = bd.insertar(nom, dni, punts); // se envian los datos para insertar
            if(_res2 == 1){
                limpiarDatos();
                msToast("Se ha modificado correctamente");
            }
            else{
                msToast("No se ha podido modificar el registro");
            }
        }
        else{
            msToast("No se ha podido modificar el registro");
        }
    }

    public void clickBorrar(View view){
        String dni = String.valueOf(id.getText());
        int _res = bd.eliminar(dni); //borrar el registro con dni
        if(_res==0) {
            limpiarDatos();
            msToast("Se ha borrado correctamente");
        }
        else{
            msToast("No se ha podido borrar");
        }
    }

    private void traerReferencias(){
        insert = (ImageButton) findViewById(R.id.ibInsert);
        search = (ImageButton) findViewById(R.id.ibSearch);
        delete = (ImageButton) findViewById(R.id.ibDelete);
        name = (EditText) findViewById(R.id.etNombre);
        id = (EditText) findViewById(R.id.etDNI);
        points = (EditText) findViewById(R.id.etPuntos);
    }

    public void msToast(String text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void limpiarDatos(){
        name.setText("");
        id.setText("");
        points.setText("");
    }
}
