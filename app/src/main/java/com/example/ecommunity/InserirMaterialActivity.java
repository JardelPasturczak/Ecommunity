package com.example.ecommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InserirMaterialActivity extends AppCompatActivity {

    EditText et_inserirMaterial_data,
            et_inserirMaterial_hora,
            et_inserirMaterial_qtdPapel,
            et_inserirMaterial_qtdVidro,
            et_inserirMaterial_qtdOleo,
            et_inserirMaterial_qtdAluminio;

    Button bt_inserirMaterial_Inserir;

    MaterialDAO dao;


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

        dao = new MaterialDAO(this);

        bt_inserirMaterial_Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Material material = new Material();
                material.setDataLimite(et_inserirMaterial_data.getText().toString());
                material.setHoraLimite(et_inserirMaterial_hora.getText().toString());
                material.setQtdPapel(et_inserirMaterial_qtdPapel.getText().toString());
                material.setQtdVidro(et_inserirMaterial_qtdVidro.getText().toString());
                material.setQtdOleo(et_inserirMaterial_qtdOleo.getText().toString());
                material.setQtdAluminio(et_inserirMaterial_qtdAluminio.getText().toString());

                long id = dao.inserirMaterial(material);
                Toast.makeText(InserirMaterialActivity.this, "Material inserido com id: " + id, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
