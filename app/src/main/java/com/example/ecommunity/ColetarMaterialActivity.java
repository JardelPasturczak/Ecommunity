package com.example.ecommunity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.io.Serializable;
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
        ArrayAdapter<Material> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, materiaisFiltrados);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);

        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // teste -- System.out.println("Digitou " + s);
                procuraMaterial(s);
                return false;
            }
        });
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_contexto, menu);
    }


    public void excluir(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final Material materialExcluir = materiaisFiltrados.get(menuInfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Deseja realmente excluir a coleta?")
                .setNegativeButton("NÃO", null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        materiaisFiltrados.remove(materialExcluir);
                        materiais.remove(materialExcluir);
                        dao.excluirMaterial(materialExcluir);
                        listView.invalidateViews();
                    }
                }).create();
        dialog.show();

    }

    public void cadastrar(MenuItem menu) {
        Intent i = new Intent(ColetarMaterialActivity.this, InserirMaterialActivity.class);
        startActivity(i);
    }


    public void atualizar(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final Material materialAtualizar = materiaisFiltrados.get(menuInfo.position);

        Intent it = new Intent(ColetarMaterialActivity.this, InserirMaterialActivity.class);
        it.putExtra("material", (CharSequence) materialAtualizar);
        startActivity(it);
    }

    @Override
    public void onResume() {
        super.onResume();
        materiais = dao.listarMaterial();
        materiaisFiltrados.clear();
        materiaisFiltrados.addAll(materiais);
        listView.invalidateViews();
    }

    public void procuraMaterial(String data) {

        materiaisFiltrados.clear();

        for (Material m : materiais) {
            if (m.getDataLimite().toLowerCase().contains(data.toLowerCase())) {
                materiaisFiltrados.add(m);
            }
        }
        listView.invalidateViews();
    }
}
