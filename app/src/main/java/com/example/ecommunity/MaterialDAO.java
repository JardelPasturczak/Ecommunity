package com.example.ecommunity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    private Conexao conexao;
    private SQLiteDatabase abc;

    public MaterialDAO(Context context) {
        conexao = new Conexao(context);
        abc = conexao.getWritableDatabase();
    }


    public long inserirMaterial(Material material) {
        ContentValues cv = new ContentValues();

        cv.put("dataLimite", material.getDataLimite());
        cv.put("horaLimite", material.getHoraLimite());
        cv.put("qtdPapel", material.getQtdPapel());
        cv.put("qtdVidro", material.getQtdVidro());
        cv.put("qtdOleo", material.getQtdOleo());
        cv.put("qtdAluminio", material.getQtdAluminio());
        cv.put("idUsuario", material.getIdUsuario());

        return abc.insert("material", null, cv);
    }

    public List<Material> listarMaterial() {
        List<Material> materiais = new ArrayList<>();
        Cursor cursor = abc.query("material", new String[]{
                        "id",
                        "idUsuario",
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

            material.setIdUsuario(cursor.getInt(1));

            material.setDataLimite(cursor.getString(2));
            material.setHoraLimite(cursor.getString(3));
            material.setQtdPapel(cursor.getString(4));
            material.setQtdVidro(cursor.getString(5));
            material.setQtdOleo(cursor.getString(6));
            material.setQtdAluminio(cursor.getString(7));

            materiais.add(material);
        }
        return materiais;
    }


    public void excluirMaterial(Material material) {
        abc.delete("material", "id= ?", new String[]{String.valueOf(material.getId())});
    }

    public void atualizarMaterial(Material material) {
        ContentValues cv = new ContentValues();

        cv.put("dataLimite", material.getDataLimite());
        cv.put("horaLimite", material.getHoraLimite());
        cv.put("qtdPapel", material.getQtdPapel());
        cv.put("qtdVidro", material.getQtdVidro());
        cv.put("qtdOleo", material.getQtdOleo());
        cv.put("qtdAluminio", material.getQtdAluminio());
        abc.update("material", cv, "id = ?", new String[]{String.valueOf(material.getId())});
    }


}
