package com.example.proyecto_progra_5_comedor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionDB extends SQLiteOpenHelper {
    private static final String NOMBRE_BD = "COMEDOR_BD";
    private static final int VERSION_BD = 1;

    public ConexionDB(Context context) {
        super(context, "COMEDOR_BD", null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + Utilidades.TABLA_USUARIO + " ("
                + Utilidades.ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Utilidades.NOMBRE_USUARIO + " TEXT NOT NULL,"
                + Utilidades.CONTRASEÑA_USUARIO + " TEXT NOT NULL,"
                + "UNIQUE ("+ Utilidades.ID_USUARIO + "))");

        db.execSQL("CREATE TABLE " + Utilidades.TABLA_ADMIN + " ("
                + Utilidades.ID_ADMIN + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Utilidades.NOMBRE_ADMIN + " TEXT NOT NULL,"
                + Utilidades.CONTRASEÑA_ADMIN + " TEXT NOT NULL,"
                + "UNIQUE ("+ Utilidades.ID_ADMIN + "))");


        ContentValues values = new ContentValues();

        values.put(Utilidades.ID_USUARIO, "100");
        values.put(Utilidades.NOMBRE_USUARIO, "Shaquille");
        values.put(Utilidades.CONTRASEÑA_USUARIO, "12345");
        db.insert(Utilidades.TABLA_USUARIO, null, values);

        values.put(Utilidades.ID_ADMIN, "50");
        values.put(Utilidades.NOMBRE_ADMIN, "admin");
        values.put(Utilidades.CONTRASEÑA_ADMIN, "admin");
        db.insert(Utilidades.TABLA_ADMIN, null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS TABLA_USUARIO");
        db.execSQL("DROP TABLE IF EXISTS TABLA_ADMIN");
        onCreate(db);
    }
}
