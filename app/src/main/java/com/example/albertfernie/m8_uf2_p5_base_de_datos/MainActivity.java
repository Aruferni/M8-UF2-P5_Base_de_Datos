package com.example.albertfernie.m8_uf2_p5_base_de_datos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView create, insert, search, modify, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicio();
    }

    private void inicio(){
        traerReferencias();
    }

    private void traerReferencias(){
        create=(ImageView) findViewById(R.id.ivCreate);
        insert=(ImageView) findViewById(R.id.ivInsert);
        search=(ImageView) findViewById(R.id.ivSearch);
        modify=(ImageView) findViewById(R.id.ivModify);
        delete=(ImageView) findViewById(R.id.ivDelete);
    }

    public void msToast(String text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
