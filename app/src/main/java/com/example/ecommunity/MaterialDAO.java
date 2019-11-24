package com.example.ecommunity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
        cv.put("qtdPapel",material.getQtdPapel());
        cv.put("qtdVidro", material.getQtdVidro());
        cv.put("qtdOleo", material.getQtdOleo());
        cv.put("qtdAluminio", material.getQtdAluminio());

        return ccc.insert("material", null, cv);
    }



}
