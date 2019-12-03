package com.example.ecommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PerfilActivity extends AppCompatActivity {

    private ListView listView;
    private UsuarioDAO dao;
    private List<Usuario> usuarios;
    private List<Usuario> usuariosFiltrados = new ArrayList<>();
    Usuario usr = new Usuario();

    Conexao cxn;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        listView = (ListView) findViewById(R.id.lv_perfil_lista);

        dao = new UsuarioDAO(this);

        cxn = new Conexao(this);

        // int idAtual = cxn.pegarId(id);

        usr = dao.listarUsuario2(1);
        // usuarios = dao.listarUsuario(); // LISTAR TODOS OS USUARIOS

        //usuariosFiltrados.addAll(usuarios); // LISTAR TODOS OS USUARIOS
        usuariosFiltrados.add(usr);

        ArrayAdapter<Usuario> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usuariosFiltrados);
        listView.setAdapter(adapter);
    }
}
