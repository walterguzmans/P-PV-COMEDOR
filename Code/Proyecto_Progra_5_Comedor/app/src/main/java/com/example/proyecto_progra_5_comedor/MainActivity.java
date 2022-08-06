package com.example.proyecto_progra_5_comedor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUsuario;
    EditText txtContraseña;
    String usuario,contraseña;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtContraseña = findViewById(R.id.txtContraseña);

        this.agregarusuario();

    }

    public void Login(View view) {
        usuario = txtUsuario.getText().toString();
        contraseña = txtContraseña.getText().toString();

        if (usuario == null || "".equals(contraseña)) {
            Toast.makeText(this, "Complete los Campos", Toast.LENGTH_SHORT).show();
        } else {
            boolean existe = this.existeusuario(usuario, contraseña);
            if (existe) {
                boolean tipousuario = this.tipousuario(usuario);
                if (tipousuario) {
                    Intent i = new Intent(MainActivity.this, MenuAdmin.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(MainActivity.this, MenuEstudiante.class);
                    startActivity(i);
                }
            } else {
                Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
        txtUsuario.setText("");
        txtContraseña.setText("");

    }

    // se agregan los usuarios dentro de la tabla
   public void agregarusuario() {
        ConexionDB conex = new ConexionDB(this,"Proyecto_Progra_5_Comedor",null,1);
        SQLiteDatabase db = conex.getReadableDatabase();

        db.execSQL("INSERT OR IGNORE INTO usuarios (cedula ,nombre ,apellidos ,usuario ,contraseña ,rol) Values (123456789,'Shaquille','Lackwood Blanco','Shaco06','1234','Usuario')");
        db.execSQL("INSERT OR IGNORE INTO usuarios (cedula ,nombre ,apellidos ,usuario ,contraseña ,rol) Values (987654321,'Steven','Sibaja Araya','Stevensiar','1739','Administrador')");
        db.close();

    }
    //si existe el usuario se verifica
    public boolean existeusuario(String usuario, String contraseña) {
        ConexionDB conex = new ConexionDB(this,"Proyecto_Progra_5_Comedor",null,1);
        SQLiteDatabase db =conex.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from usuarios where usuario=? and  contraseña=?", new String[]{usuario, contraseña});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            db.close();
        }
        return false;
    }
    //se compara el tipo de usuario a ingresar
    public boolean tipousuario(String usuario) {
        ConexionDB conex= new ConexionDB(this,"Proyecto_Progra_5_Comedor",null,1);
        SQLiteDatabase db =conex.getReadableDatabase();

        Cursor cursor = db.rawQuery("select  rol  from usuarios where usuario=?", new String[]{usuario});

        if (cursor.moveToFirst()) {
            if (cursor.getString(cursor.getColumnIndexOrThrow("rol")).equals("Administrador"))
                return true;
        } else {
            db.close();
        }
        return false;
    }


    public void cancelar (View pView){
        Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show();
        this.limpiar();
    }
    public void limpiar (){
        txtUsuario.setText("");
        txtContraseña.setText("");
    }
}

