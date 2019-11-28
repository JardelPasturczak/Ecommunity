package com.example.ecommunity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    private Conexao conexao;
    private SQLiteDatabase ccc;

    public MaterialDAO(Context context) {
        conexao = new Conexao(context);
        ccc = conexao.getWritableDatabase();
    }


    public long inserirMaterial(Material material) {
        ContentValues cv = new ContentValues();

        cv.put("dataLimite", material.getDataLimite());
        cv.put("horaLimite", material.getHoraLimite());
        cv.put("qtdPapel", material.getQtdPapel());
        cv.put("qtdVidro", material.getQtdVidro());
        cv.put("qtdOleo", material.getQtdOleo());
        cv.put("qtdAluminio", material.getQtdAluminio());

        return ccc.insert("material", null, cv);
    }

    public List<Material> listarMaterial() {
        List<Material> materiais = new ArrayList<>();
        Cursor cursor = ccc.query("material", new String[]{
                        "id",
                        "dataLimite",
                        "horaLimite",
                        "qtdPapel",
                        "qtdVidro",
                        "qtdOleo",
                        "qtdAluminio",},
                null, null, null, null, null);
// CONSULTA POR ID - "id" + "= 2 "

        while (cursor.moveToNext()) {
            Material material = new Material();

            material.setId(cursor.getInt(0));

            material.setDataLimite(cursor.getString(1));
            material.setHoraLimite(cursor.getString(2));
            material.setQtdPapel(cursor.getString(3));
            material.setQtdVidro(cursor.getString(4));
            material.setQtdOleo(cursor.getString(5));
            material.setQtdAluminio(cursor.getString(6));

            materiais.add(material);
        }
        return materiais;
    }


    public void excluirMaterial(Material material) {
        ccc.delete("material", "id= ?", new String[]{String.valueOf(material.getId())});
    }

    public void atualizarMaterial (Material material){
        ContentValues cv = new ContentValues();

        cv.put("dataLimite", material.getDataLimite());
        cv.put("horaLimite", material.getHoraLimite());
        cv.put("qtdPapel", material.getQtdPapel());
        cv.put("qtdVidro", material.getQtdVidro());
        cv.put("qtdOleo", material.getQtdOleo());
        cv.put("qtdAluminio", material.getQtdAluminio());
        ccc.update("material", cv, "id = ?", new String[]{String.valueOf(material.getId())});
    }


}
