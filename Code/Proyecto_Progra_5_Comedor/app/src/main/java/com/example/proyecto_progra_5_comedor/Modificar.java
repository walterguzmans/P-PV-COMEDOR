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

public class Modificar extends AppCompatActivity {
    EditText txtModCedula, txtModNombre, txtModApellidos, txtModNomUsu, txtModContra, txtModRol;
    Button btnBuscar, btnAgregar, btnActualizar, btnEliminar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        txtModCedula = findViewById(R.id.txtModCedula);
        txtModNombre = findViewById(R.id.txtModNombre);
        txtModApellidos = findViewById(R.id.txtModApellidos);
        txtModNomUsu = findViewById(R.id.txtModNomUsu);
        txtModContra = findViewById(R.id.txtModContra);
        txtModRol = findViewById(R.id.txtModRol);

        btnBuscar = findViewById(R.id.btnBuscar);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnRegresar = findViewById(R.id.btnRegresar);

    }
    public void BuscarEst(View vBuscar){
        ConexionDB conex = new ConexionDB(getApplicationContext(),"Proyecto_Progra_5_Comedor",null,1);
        SQLiteDatabase db = conex.getReadableDatabase();

       String CedulaEst = txtModCedula.getText().toString();

        try {
            Cursor cursor = db.rawQuery("select nombre, apellidos, usuario, contraseña, rol from usuarios where cedula == " + CedulaEst + "", null);
            cursor.moveToFirst();

            txtModNombre.setText(cursor.getString(0));
            txtModApellidos.setText(cursor.getString(1));
            txtModNomUsu.setText(cursor.getString(2));
            txtModContra.setText(cursor.getString(3));
            txtModRol.setText(cursor.getString(4));
            cursor.close();

            Toast.makeText(this, "Se ha Cargado el Estudiante correctamente", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El Estudiante no existe", Toast.LENGTH_LONG).show();
            limpiar();
        }


    }
    public void AgregarEst(View vAgregar){

        Toast.makeText(this, "Se ha Agregado el Estudiante correctamente", Toast.LENGTH_LONG).show();
    }
    public void ActualizarEst(View vActualizar){

        Toast.makeText(this, "Se ha Actualizado el Estudiante correctamente", Toast.LENGTH_LONG).show();
    }
    public void EliminarEst(View vEliminar){

        Toast.makeText(this, "Se ha Eliminado el Estudiante correctamente", Toast.LENGTH_LONG).show();
    }

    //Regresa a la ventana de Mantenimiento de estudiante  y limpiar los datos
    public void Regresar(View vRegresar){
        limpiar();

        Intent i = new Intent(Modificar.this, VentanaAdminUsuarios.class);
        startActivity(i);
    }
    public void limpiar(){
        txtModCedula.setText("");
        txtModNombre.setText("");
        txtModApellidos.setText("");
        txtModNomUsu.setText("");
        txtModContra.setText("");
        txtModRol.setText("");
    }
}