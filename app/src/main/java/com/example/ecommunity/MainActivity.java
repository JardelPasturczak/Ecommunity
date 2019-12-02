package com.example.ecommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_login_usuario, et_login_senha;

    Button bt_login_entrar, bt_login_criarUsuario;

    Conexao cxn;

    int idAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cxn = new Conexao(this);

        et_login_usuario = (EditText) findViewById(R.id.et_login_usuario);
        et_login_senha = (EditText) findViewById(R.id.et_login_senha);

        bt_login_entrar = (Button) findViewById(R.id.bt_login_entrar);
        bt_login_criarUsuario = (Button) findViewById(R.id.bt_login_criarUsuario);

        bt_login_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(MainActivity.this, TelaInicialActivity.class);
                //startActivity(i);

                String usuario = et_login_usuario.getText().toString();
                String senha = et_login_senha.getText().toString();

                if (et_login_usuario.equals("")) {
                    Toast.makeText(MainActivity.this, "Usuário não inserido", Toast.LENGTH_SHORT).show();
                } else if (et_login_senha.equals("")) {
                    Toast.makeText(MainActivity.this, "Senha não inserido", Toast.LENGTH_SHORT).show();
                } else {

                    String res = cxn.validarLogin(usuario, senha);

                    if (res.equals("OK")) {
                        Intent i = new Intent(MainActivity.this, TelaInicialActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(MainActivity.this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        bt_login_criarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CriarUsuarioActivity.class);
                startActivity(i);
            }
        });

    }
}
