package com.example.proyecto_progra_5_comedor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText txtUsuario;
    EditText txtContraseña;

    ConexionDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtContraseña = findViewById(R.id.txtContraseña);
    }

    public void Login(View view) {
        db = new ConexionDB(this);

        String usu = txtUsuario.getText().toString();
        String contra = txtContraseña.getText().toString();

        if(usu.equals(Utilidades.NOMBRE_USUARIO) || contra.equals(Utilidades.CONTRASEÑA_USUARIO)){
            Toast.makeText(this, "Logueo exitoso", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Logueo fallido", Toast.LENGTH_SHORT).show();
        }

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

