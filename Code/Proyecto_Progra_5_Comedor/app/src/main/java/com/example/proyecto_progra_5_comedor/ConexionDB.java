package com.example.proyecto_progra_5_comedor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ConexionDB extends SQLiteOpenHelper {

    public ConexionDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name , factory, version);
    }

    @Override
    //creacion de la tabla de los usuarios
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(cedula int primary key,nombre text,apellidos text,usuario text,contraseña text,rol text)");

    }

    @Override
    //dropear la tabla en caso de que exista
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.close();

    }
    public void AgregarEstudiante(String CedulaEA, String NombreEA, String ApellidosEA, String UsuarioEA, String ContraseñaEA, String RolEA){
        SQLiteDatabase bd = getWritableDatabase();
        if (bd!=null) {
            bd.execSQL("INSERT INTO usuarios VALUES('"+CedulaEA+"','"+NombreEA+"','"+ApellidosEA+"','"+UsuarioEA+"','"+ContraseñaEA+"','"+RolEA+"')");
            bd.close();
        }
    }

}
