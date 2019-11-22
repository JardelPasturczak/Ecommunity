package com.example.ecommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_login_usuario, et_login_senha;

    Button bt_login_entrar, bt_login_criarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_login_usuario = (EditText) findViewById(R.id.et_login_usuario);
        et_login_senha = (EditText) findViewById(R.id.et_login_senha);

        bt_login_entrar = (Button) findViewById(R.id.bt_login_entrar);
        bt_login_criarUsuario = (Button) findViewById(R.id.bt_login_criarUsuario);


    }
}
