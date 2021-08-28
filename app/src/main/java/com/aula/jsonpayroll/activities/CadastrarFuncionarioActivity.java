package com.aula.jsonpayroll.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aula.jsonpayroll.R;
import com.aula.jsonpayroll.dao.FuncionarioDAO;
import com.aula.jsonpayroll.model.FuncionarioModel;

public class CadastrarFuncionarioActivity extends AppCompatActivity {

    EditText etNomeFuncionario, etValorHora, etQtdeHoras;
    Button bSalvarFuncionario, bCancelarSalvar;
    FuncionarioDAO funcionarioDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_funcionario);

        InitializeComponents();

        bSalvarFuncionario.setOnClickListener(v -> {
            if(etNomeFuncionario.getText().toString().isEmpty() ||
                etQtdeHoras.getText().toString().isEmpty() ||
                etValorHora.getText().toString().isEmpty()){

                Toast.makeText(getApplicationContext(),"Para salvar preencha todos os campos!", Toast.LENGTH_LONG).show();
            }
            else {
                FuncionarioModel funcionario = new FuncionarioModel(
                        etNomeFuncionario.getText().toString(),
                        Double.parseDouble(etValorHora.getText().toString()),
                        Double.parseDouble(etQtdeHoras.getText().toString())
                );

                funcionarioDao.salvar(funcionario);

                Toast.makeText(this, "Funcionário salvo com sucesso!", Toast.LENGTH_LONG).show();

                finish();
            }
        });

        bCancelarSalvar.setOnClickListener(v ->{
            startActivity(new Intent(this, MainActivity.class));
        });

    }

    private void InitializeComponents(){
        etNomeFuncionario = findViewById(R.id.etNomeFuncionario);
        etValorHora = findViewById(R.id.etValorHora);
        etQtdeHoras = findViewById(R.id.etQtdHoras);

        bSalvarFuncionario = findViewById(R.id.bSalvarFuncionario);
        bCancelarSalvar = findViewById(R.id.bCancelarSalvar);

        funcionarioDao = new FuncionarioDAO();
    }
}