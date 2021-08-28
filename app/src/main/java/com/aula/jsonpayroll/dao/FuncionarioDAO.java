package com.aula.jsonpayroll.dao;

import com.aula.jsonpayroll.model.FuncionarioModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private static List<FuncionarioModel> ListaFuncionarios = new ArrayList<>();

    public void salvar(FuncionarioModel func){
        ListaFuncionarios.add(func);
    }

    public List<FuncionarioModel> getListaFuncionarios (){
        return ListaFuncionarios;
    }

    public void excluir(int p){

        ListaFuncionarios.remove(p);
    }


    public FuncionarioModel getFuncionario(int p) {
        List<FuncionarioModel> lista = getListaFuncionarios();
        return lista.get(p);
    }
}
