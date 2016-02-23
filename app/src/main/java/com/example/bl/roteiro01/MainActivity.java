package com.example.bl.roteiro01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTexto;
    private String nome;
    private String sobrenome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTexto = (TextView) findViewById(R.id.texto);
        Bundle b = getIntent().getExtras();
        ArrayList<String> l = new ArrayList <String>() ;
        l = b.getStringArrayList("usuario");
        nome = l.get(0);
        sobrenome = l.get(1);

        mTexto.setText("Olá "+nome+" "+sobrenome+" seja bem vindo!! XD");

    }
}
