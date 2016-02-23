package com.example.bl.roteiro01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CadastroActivity extends AppCompatActivity {

    private TextView mNome;
    private TextView mSobrenome;
    private TextView mUsuario;
    private TextView mSenha;
    private TextView mCsenha;
    private Button mCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mNome = (EditText) findViewById(R.id.nome);
        mSobrenome = (EditText) findViewById(R.id.sobrenome);
        mUsuario = (EditText) findViewById(R.id.usuario);
        mSenha = (EditText) findViewById(R.id.senha);
        mCsenha = (EditText) findViewById(R.id.senhac);
        mCadastrar = (Button) findViewById(R.id.cadastrar);

        mCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });

    }

    private void cadastrarUsuario() {
        String nome = mNome.getText().toString();
        String sobrenome = mSobrenome.getText().toString();
        String usuario = mUsuario.getText().toString();
        String senha = mSenha.getText().toString();
        String cSenha = mCsenha.getText().toString();

        View focus = null;


        if (TextUtils.isEmpty(nome)) {
            mNome.setError("Campo nome vazio");
            focus = mNome;
            focus.requestFocus();
        }
        if (TextUtils.isEmpty(sobrenome)) {
            mSobrenome.setError("Campo sobrenome vazio");
            focus = mSobrenome;
            focus.requestFocus();
        }
        if (TextUtils.isEmpty(usuario)) {
            mUsuario.setError("Campo usuário vazio");
            focus = mUsuario;
            focus.requestFocus();
        }
        if (TextUtils.isEmpty(senha)) {
            mSenha.setError("Campo senha vazio");
            focus = mSenha;
            focus.requestFocus();
        }
        if (senha != cSenha) {

            mSenha.setError("Senhas incompativeis");
            focus = mCsenha;
            focus.requestFocus();
        }

        if (TextUtils.isEmpty(cSenha)) {
            mCsenha.setError("Campo confirma senha vazio");
            focus = mCsenha;
            focus.requestFocus();
        }

        if (senha.equals(cSenha) && !TextUtils.isEmpty(senha) && !TextUtils.isEmpty(nome) && !TextUtils.isEmpty(sobrenome) && !TextUtils.isEmpty(usuario)) {
            ArrayList<String> lista = new ArrayList<String>();
            lista.add(nome);
            lista.add(sobrenome);

            Intent i = new Intent(this, MainActivity.class);
            Bundle b = new Bundle();
            b.putString("nome", usuario);
            b.putStringArrayList("usuario", lista);
            i.putExtras(b);
            startActivity(i);
            finish();
        }

    }
}
