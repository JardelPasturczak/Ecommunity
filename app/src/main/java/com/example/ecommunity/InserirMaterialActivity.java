package com.example.ecommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InserirMaterialActivity extends AppCompatActivity {

    private EditText et_inserirMaterial_data,
            et_inserirMaterial_hora,
            et_inserirMaterial_qtdPapel,
            et_inserirMaterial_qtdVidro,
            et_inserirMaterial_qtdOleo,
            et_inserirMaterial_qtdAluminio;

    private Button bt_inserirMaterial_Inserir;

    private MaterialDAO dao;

    private Material material = null;

    private int idUsuario;


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

        idUsuario = 1;

        bt_inserirMaterial_Inserir = (Button) findViewById(R.id.bt_inserirMaterial_Inserir);

        dao = new MaterialDAO(this);

        Intent i = new Intent();
        if (i.hasExtra("material")) {
            material = (Material) i.getSerializableExtra(String.valueOf(material));

            et_inserirMaterial_data.setText(material.getDataLimite());
            et_inserirMaterial_hora.setText(material.getHoraLimite());
            et_inserirMaterial_qtdPapel.setText(material.getQtdPapel());
            et_inserirMaterial_qtdVidro.setText(material.getQtdVidro());
            et_inserirMaterial_qtdOleo.setText(material.getQtdOleo());
            et_inserirMaterial_qtdAluminio.setText(material.getQtdAluminio());


        }


        bt_inserirMaterial_Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (material == null) {

                    material = new Material();
                    material.setDataLimite(et_inserirMaterial_data.getText().toString());
                    material.setHoraLimite(et_inserirMaterial_hora.getText().toString());
                    material.setQtdPapel(et_inserirMaterial_qtdPapel.getText().toString());
                    material.setQtdVidro(et_inserirMaterial_qtdVidro.getText().toString());
                    material.setQtdOleo(et_inserirMaterial_qtdOleo.getText().toString());
                    material.setQtdAluminio(et_inserirMaterial_qtdAluminio.getText().toString());
                    material.setIdUsuario(idUsuario);


                    long id = dao.inserirMaterial(material);
                    Toast.makeText(InserirMaterialActivity.this, "Material inserido com id: " + id, Toast.LENGTH_SHORT).show();
                } else {
                    material.setDataLimite(et_inserirMaterial_data.getText().toString());
                    material.setHoraLimite(et_inserirMaterial_hora.getText().toString());
                    material.setQtdPapel(et_inserirMaterial_qtdPapel.getText().toString());
                    material.setQtdVidro(et_inserirMaterial_qtdVidro.getText().toString());
                    material.setQtdOleo(et_inserirMaterial_qtdOleo.getText().toString());
                    material.setQtdAluminio(et_inserirMaterial_qtdAluminio.getText().toString());
                    dao.atualizarMaterial(material);
                    Toast.makeText(InserirMaterialActivity.this, "Material atualizado", Toast.LENGTH_SHORT).show();


                }


            }
        });

    }
}
