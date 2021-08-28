package com.aula.jsonpayroll.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.aula.jsonpayroll.R;
import com.aula.jsonpayroll.activities.CadastrarFuncionarioActivity;
import com.aula.jsonpayroll.dao.FuncionarioDAO;

public class ListagemFuncionariosActivity extends AppCompatActivity {

    Button bCadastrarFuncionario, bBackToMain;
    ListView lvFuncionarios;

    FuncionarioDAO funcionarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_funcionarios);

        funcionarioDAO = new FuncionarioDAO();

        lvFuncionarios = findViewById(R.id.lvFuncionarios);
        bCadastrarFuncionario = findViewById(R.id.bCadastrarFuncionario);
        bBackToMain = findViewById(R.id.bBackToMain);

        bBackToMain.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        bCadastrarFuncionario.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastrarFuncionarioActivity.class));
        });

        lvFuncionarios.setOnItemClickListener((parent, view, position, id) ->{
            Intent intent = new Intent(this, DetalhesActivity.class);
            intent.putExtra("position",position);
            startActivity(intent);
        });

        lvFuncionarios.setOnItemLongClickListener((parent, view, position, id) -> {

            funcionarioDAO.excluir(position);

            Toast.makeText(this, "Funcionário Excluído com sucesso!", Toast.LENGTH_LONG).show();

            onResume();

            return false;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        lvFuncionarios.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                funcionarioDAO.getListaFuncionarios()
        ));
    }
}