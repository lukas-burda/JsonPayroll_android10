package com.aula.jsonpayroll.model;

public class FuncionarioModel {

    String nome;
    double valorHorasTrabalhadas;
    double qtdeHorasTrabalhadas;

    double salarioBruto;
    double salarioLiquido;
    double IR;
    double INSS;
    double FGTS;

    //Construtores
    public FuncionarioModel(){}

    public FuncionarioModel(String nome, double valorHorasTrabalhadas, double qtdeHorasTrabalhadas) {
        this.nome = nome;
        this.salarioBruto = setSalarioBruto(valorHorasTrabalhadas, qtdeHorasTrabalhadas);

        this.IR = setIR(this.salarioBruto);
        this.INSS = setINSS(this.salarioBruto);
        this.FGTS = setFGTS(this.salarioBruto);

        this.salarioLiquido = getSalarioBruto() - (getIR()+getINSS());
    }

    private double setSalarioBruto(double valorHorasTrabalhadas, double qtdeHorasTrabalhadas){
        return valorHorasTrabalhadas * qtdeHorasTrabalhadas;
    }
    public double setIR(double salario) {
        if(salario > 2743.25){
            return salario * 0.275;
        }
        else if(salario >= 1372.82 && salario <= 2743.25){
            return salario * 0.15;
        }
        else if(salario <= 1372.81){
            return 0;
        }
        return 0;
    }

    public double setINSS(double salario) {
        if(salario <= 868.29){
            return salario * 0.08;
        }
        else if(salario >= 868.30 && salario <= 2894.28){
            return salario * 0.09;
        }
        else if(salario > 2894.28){
            return 318.37;
        }
        return 0;
    }

    public double setFGTS(double salario) {
        return salario * 0.08;
    }

    public String getNome() {
        return nome;
    }


    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getIR() {
        return IR;
    }

    public double getINSS() {
        return INSS;
    }

    public double getFGTS() {
        return FGTS;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
