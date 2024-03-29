package com.example.ecommunity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "abc.db";
    private static final int version = 1;


    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(id integer primary key autoincrement, " +
                "razaoSocial varchar (50)," +
                "cnpj varchar (50)," +
                "nomeRepresentante varchar (50)," +
                "emailRepresentante varchar(50)," +
                "telefoneRepresentante varchar(50)," +
                "cep varchar(50)," +
                "cidade varchar(50)," +
                "rua varchar(50)," +
                "numero varchar(50)," +
                "senha varchar(50))");

        db.execSQL("create table material(id integer primary key autoincrement, " +
                "idUsuario int," +
                "dataLimite varchar (50)," +
                "horaLimite varchar (50)," +
                "qtdPapel varchar (50)," +
                "qtdVidro varchar (50)," +
                "qtdOleo varchar (50)," +
                "qtdAluminio varchar (50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table usuario");

    }

    public int pegarId(String cnpj, String senha) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT id FROM usuario WHERE cnpj=? AND senha=?", new String[]{cnpj, senha});

        c.moveToFirst();
        int id = c.getInt(0);

        return id;
    }


    public String validarLogin(String cnpj, String senha) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM usuario WHERE cnpj=? AND senha=?", new String[]{cnpj, senha});

        if (c.getCount() > 0) {
            return "OK";
        } else {
            return "ERRO";
        }
    }


}












