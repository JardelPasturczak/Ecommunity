package com.example.ecommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    UsuarioDAO dao;


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

        dao = new UsuarioDAO(this);

        bt_criarUsuario_criarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();
                usuario.setRazaoSocial(et_criarUsuario_razaoSocial.getText().toString());
                usuario.setCnpj(et_criarUsuario_cnpj.getText().toString());

                usuario.setNomeRepresentante(et_criarUsuario_nomeRepresentante.getText().toString());
                usuario.setEmailRepresentante(et_criarUsuario_emailRepresentante.getText().toString());
                usuario.setTelefoneRepresentante(et_criarUsuario_telefoneRepresentante.getText().toString());

                usuario.setCep(et_criarUsuario_cep.getText().toString());
                usuario.setCidade(et_criarUsuario_cidade.getText().toString());
                usuario.setRua(et_criarUsuario_rua.getText().toString());
                usuario.setNumero(et_criarUsuario_numero.getText().toString());

                usuario.setSenha(et_criarUsuario_senha.getText().toString());

                long id = dao.criarUsuario(usuario);
                Toast.makeText(CriarUsuarioActivity.this, "Usuário inserido com id: " + id, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(CriarUsuarioActivity.this, MainActivity.class);
                startActivity(i);

            }
        });


    }
}










