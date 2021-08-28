package com.aula.jsonpayroll.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aula.jsonpayroll.R;
import com.aula.jsonpayroll.dao.FuncionarioDAO;
import com.aula.jsonpayroll.model.FuncionarioModel;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvSalarioLiquido, tvINSS, tvFGTS, tvIR, tvSalarioBruto, tvNomeFuncionario;

    Button bBackToListagem;

    FuncionarioDAO funcDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        bBackToListagem = findViewById(R.id.bBackToListagem);

        bBackToListagem.setOnClickListener(view -> {
            startActivity(new Intent(this, ListagemFuncionariosActivity.class));
        });

        tvFGTS = findViewById(R.id.tvFGTS);
        tvINSS = findViewById(R.id.tvINSS);
        tvIR = findViewById(R.id.tvIR);
        tvNomeFuncionario = findViewById(R.id.tvNomeFuncionario);
        tvSalarioBruto = findViewById(R.id.tvSalarioBruto);
        tvSalarioLiquido = findViewById(R.id.tvSalarioLiquido);

        funcDAO = new FuncionarioDAO();

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", -1);

        if(position==-1){ finish();
            Toast.makeText(this, "Não há funcionários cadastrados.", Toast.LENGTH_SHORT).show();
        }
        else {
            FuncionarioModel funcionario = funcDAO.getFuncionario(position);

            tvNomeFuncionario.setText(funcionario.getNome());
            tvSalarioBruto.setText(Double.toString(funcionario.getSalarioBruto()));
            tvIR.setText(Double.toString(funcionario.getIR()));
            tvINSS.setText(Double.toString(funcionario.getINSS()));
            tvFGTS.setText(Double.toString(funcionario.getFGTS()));
            tvSalarioLiquido.setText(Double.toString(funcionario.getSalarioLiquido()));

        }
    }
}