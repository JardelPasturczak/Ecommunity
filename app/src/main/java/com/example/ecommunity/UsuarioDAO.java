package com.example.ecommunity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public UsuarioDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }


    public long criarUsuario(Usuario usuario) {
        ContentValues cv = new ContentValues();

        cv.put("id", usuario.getId());

        cv.put("razaoSocial", usuario.getRazaoSocial());
        cv.put("cnpj", usuario.getCnpj());

        cv.put("nomeRepresentante", usuario.getNomeRepresentante());
        cv.put("emailRepresentante", usuario.getEmailRepresentante());
        cv.put("telefoneRepresentante", usuario.getTelefoneRepresentante());

        cv.put("cep", usuario.getCep());
        cv.put("cidade", usuario.getCidade());
        cv.put("rua", usuario.getRua());
        cv.put("numero", usuario.getNumero());

        cv.put("senha", usuario.getSenha());


        return banco.insert("usuario", null, cv);
    }


}
