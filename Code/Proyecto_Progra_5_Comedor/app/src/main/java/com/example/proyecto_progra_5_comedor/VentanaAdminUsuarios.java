package com.example.proyecto_progra_5_comedor;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class VentanaAdminUsuarios extends AppCompatActivity {

    private ListView lblista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_admin_usuarios);

        lblista = (ListView)findViewById(R.id.lblista);

        ArrayList<String> listausuarios = new ArrayList<>();

        ConexionDB lista = new ConexionDB(this, "Proyecto_Progra_5_Comedor", null, 1);
        SQLiteDatabase bd = lista.getWritableDatabase();
        Cursor fila = bd.rawQuery("select nombre, apellidos,cedula from usuarios", null);
        if(fila.moveToFirst()){
            do{
                listausuarios.add(fila.getString(0) + " - " + fila.getString(1)+ " - " + fila.getInt(2));
            }while(fila.moveToNext());
        }
        bd.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listausuarios);
        lblista.setAdapter(adapter);
    }


}