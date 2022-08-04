package com.example.proyecto_progra_5_comedor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PerfilEstudiante extends AppCompatActivity {
    EditText txtNombreE, txtApellidosE, txtCedulaE, txtTipoBecaE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_estudiante);

        txtNombreE = findViewById(R.id.txtNombreE);
        txtApellidosE = findViewById(R.id.txtApellidosE);
        txtCedulaE = findViewById(R.id.txtCedulaE);
        txtTipoBecaE = findViewById(R.id.txtTipoBecaE);

    }

    public void consultaEstudiante(View view) {
    }

    public void QR(View view) {
    }
}