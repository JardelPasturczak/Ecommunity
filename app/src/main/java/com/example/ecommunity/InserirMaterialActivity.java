package com.example.ecommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InserirMaterialActivity extends AppCompatActivity {

    EditText et_inserirMaterial_data,
            et_inserirMaterial_hora,
            et_inserirMaterial_qtdPapel,
            et_inserirMaterial_qtdVidro,
            et_inserirMaterial_qtdOleo,
            et_inserirMaterial_qtdAluminio;

    Button bt_inserirMaterial_Inserir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_material);

        et_inserirMaterial_data = (EditText) findViewById(R.id.et_inserirMaterial_data);
        et_inserirMaterial_hora = (EditText) findViewById(R.id.et_inserirMaterial_hora);
        et_inserirMaterial_qtdPapel = (EditText) findViewById(R.id.et_inserirMaterial_qtdPapel);
        et_inserirMaterial_qtdVidro = (EditText) findViewById(R.id.et_inserirMaterial_qtdVidro);
        et_inserirMaterial_qtdOleo = (EditText) findViewById(R.id.et_inserirMaterial_qtdOleo);
        et_inserirMaterial_qtdAluminio = (EditText) findViewById(R.id.et_inserirMaterial_qtdAluminio);


        bt_inserirMaterial_Inserir = (Button) findViewById(R.id.bt_inserirMaterial_Inserir);


    }
}
