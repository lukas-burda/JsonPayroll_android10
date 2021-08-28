package com.aula.jsonpayroll.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.aula.jsonpayroll.R;

public class MainActivity extends AppCompatActivity {

    Button bGoToCadastrarFuncionario, goToListagemFuncionarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bGoToCadastrarFuncionario = findViewById(R.id.bGoToCadastrarFuncionario);

        bGoToCadastrarFuncionario.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastrarFuncionarioActivity.class));

        });

        goToListagemFuncionarios = findViewById(R.id.goToListagemFuncionarios);

        goToListagemFuncionarios.setOnClickListener(v ->{
            startActivity(new Intent(this, ListagemFuncionariosActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}