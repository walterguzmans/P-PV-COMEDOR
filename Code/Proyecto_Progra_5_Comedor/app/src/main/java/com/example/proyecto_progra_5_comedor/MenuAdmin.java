package com.example.proyecto_progra_5_comedor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAdmin extends AppCompatActivity {

    Button btncerrarsesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

        btncerrarsesion= findViewById(R.id.btncerrarsesion);

    }

    public void logout(View view){
        Intent intent = new Intent(MenuAdmin.this,MainActivity.class);
        startActivity(intent);
    }

    public void manteusuarios(View view){
        Intent intent = new Intent(MenuAdmin.this,VentanaAdminUsuarios.class);
        startActivity(intent);
    }

}