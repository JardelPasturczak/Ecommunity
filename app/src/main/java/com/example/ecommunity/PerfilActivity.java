package com.example.ecommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PerfilActivity extends AppCompatActivity {

    private ListView listView;
    private UsuarioDAO dao;
    private List<Usuario> usuarios;
    private List<Usuario> usuariosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        listView = (ListView) findViewById(R.id.lv_perfil_lista);

        dao = new UsuarioDAO(this);

        usuarios = dao.listarUsuario();

        usuariosFiltrados.addAll(usuarios);
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<>(this,  android.R.layout.simple_list_item_1, usuarios);
        listView.setAdapter(adapter);


    }
}
