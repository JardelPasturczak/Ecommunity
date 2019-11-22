package com.example.ecommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CriarUsuarioActivity extends AppCompatActivity {

    EditText et_criarUsuario_razaoSocial,
            et_criarUsuario_cnpj,

    et_criarUsuario_nomeRepresentante,
            et_criarUsuario_emailRepresentante,
            et_criarUsuario_telefoneRepresentante,

    et_criarUsuario_cep,
            et_criarUsuario_cidade,
            et_criarUsuario_rua,
            et_criarUsuario_numero,

    et_criarUsuario_senha,
            et_criarUsuario_confirmarSenha;

    Button bt_criarUsuario_criarUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_usuario);


        et_criarUsuario_razaoSocial = (EditText) findViewById(R.id.et_criarUsuario_razaoSocial);
        et_criarUsuario_cnpj = (EditText) findViewById(R.id.et_criarUsuario_cnpj);

        et_criarUsuario_nomeRepresentante = (EditText) findViewById(R.id.et_criarUsuario_nomeRepresentante);
        et_criarUsuario_emailRepresentante = (EditText) findViewById(R.id.et_criarUsuario_emailRepresentante);
        et_criarUsuario_telefoneRepresentante = (EditText) findViewById(R.id.et_criarUsuario_telefoneRepresentante);

        et_criarUsuario_cep = (EditText) findViewById(R.id.et_criarUsuario_cep);
        et_criarUsuario_cidade = (EditText) findViewById(R.id.et_criarUsuario_cidade);
        et_criarUsuario_rua = (EditText) findViewById(R.id.et_criarUsuario_rua);
        et_criarUsuario_numero = (EditText) findViewById(R.id.et_criarUsuario_numero);

        et_criarUsuario_senha = (EditText) findViewById(R.id.et_criarUsuario_senha);
        et_criarUsuario_confirmarSenha = (EditText) findViewById(R.id.et_criarUsuario_confirmarSenha);

        bt_criarUsuario_criarUsuario = (Button) findViewById(R.id.bt_criarUsuario_criarUsuario);


    }
}
