package com.example.ecommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColetarMaterialActivity extends AppCompatActivity {

    private ListView listView;
    private MaterialDAO dao;
    private List<Material> materiais;
    private List<Material> materiaisFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coletar_material);

        listView = (ListView) findViewById(R.id.lv_coletarMaterial_lista);

        dao = new MaterialDAO(this);

        materiais = dao.listarMaterial();

        materiaisFiltrados.addAll(materiais);
        ArrayAdapter<Material> adapter = new ArrayAdapter<>(this,  android.R.layout.simple_list_item_1, materiais);
        listView.setAdapter(adapter);


    }
}
