package com.example.ecommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicialActivity extends AppCompatActivity {

    Button bt_inicial_perfil, bt_inicial_inserirMaterial, bt_inicial_coletarMaterial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        bt_inicial_perfil = (Button) findViewById(R.id.bt_inicial_perfil);
        bt_inicial_inserirMaterial = (Button) findViewById(R.id.bt_inicial_inserirMaterial);
        bt_inicial_coletarMaterial = (Button) findViewById(R.id.bt_inicial_coletarMaterial);

        bt_inicial_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaInicialActivity.this, PerfilActivity.class);
                startActivity(i);
            }
        });




    }
}
