package com.example.ecommunity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Conexao conexao;
    private SQLiteDatabase abc;
    int idAtual;




    public UsuarioDAO(Context context) {
        conexao = new Conexao(context);
        abc = conexao.getWritableDatabase();
    }

    public long criarUsuario(Usuario usuario) {
        ContentValues cv = new ContentValues();

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

        return abc.insert("usuario", null, cv);
    }


    public Usuario listarUsuario2(int id) {

        Usuario usr = new Usuario();
        Cursor cursor = abc.query("usuario", new String[]{
                        "id",
                        "razaoSocial", "cnpj",
                        "nomeRepresentante", "emailRepresentante", "telefoneRepresentante",
                        "cep", "cidade", "rua", "numero",
                        "senha"},
                "id" + "= " + id, null, null, null, null);
// CONSULTA POR ID - "id" + "= 2 "  ------ "id= " + String.valueOf(idAtual)

        while (cursor.moveToNext()) {

            usr.setId(cursor.getInt(0));

            usr.setRazaoSocial(cursor.getString(1));
            usr.setCnpj(cursor.getString(2));

            usr.setNomeRepresentante(cursor.getString(3));
            usr.setEmailRepresentante(cursor.getString(4));
            usr.setTelefoneRepresentante(cursor.getString(5));

            usr.setCep(cursor.getString(6));
            usr.setCidade(cursor.getString(7));
            usr.setRua(cursor.getString(8));
            usr.setNumero(cursor.getString(9));

            usr.setSenha(cursor.getString(10));

        }
        return usr;


    }


    public List<Usuario> listarUsuario() {
        List<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = abc.query("usuario", new String[]{
                        "id",
                        "razaoSocial", "cnpj",
                        "nomeRepresentante", "emailRepresentante", "telefoneRepresentante",
                        "cep", "cidade", "rua", "numero",
                        "senha"},
                null, null, null, null, null);
// CONSULTA POR ID - "id" + "= 2 "  ------ "id= " + String.valueOf(idAtual)

        while (cursor.moveToNext()) {
            Usuario usuario = new Usuario();

            usuario.setId(cursor.getInt(0));

            usuario.setRazaoSocial(cursor.getString(1));
            usuario.setCnpj(cursor.getString(2));

            usuario.setNomeRepresentante(cursor.getString(3));
            usuario.setEmailRepresentante(cursor.getString(4));
            usuario.setTelefoneRepresentante(cursor.getString(5));

            usuario.setCep(cursor.getString(6));
            usuario.setCidade(cursor.getString(7));
            usuario.setRua(cursor.getString(8));
            usuario.setNumero(cursor.getString(9));

            usuario.setSenha(cursor.getString(10));

            usuarios.add(usuario);
        }
        return usuarios;
    }


}
