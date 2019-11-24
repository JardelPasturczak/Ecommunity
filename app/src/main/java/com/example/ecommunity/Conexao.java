package com.example.ecommunity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "ccc.db";
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
}












