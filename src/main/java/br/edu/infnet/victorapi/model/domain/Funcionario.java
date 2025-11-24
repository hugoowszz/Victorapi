package br.edu.infnet.victorapi.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {

    private String nome;
    private int idade;
    private double faturamento;
    private double salario;
    protected String turno;

    public enum Turno {
        Manha,
        tarde,
        noite
    }

    public Funcionario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        System.out.println("Funcionario " + nome + " cadastrado com sucesso");
    }

    //a ideia aqui é ter funcionarios que recebem comissão ou salario fixo

    public Funcionario(String nome, int idade, double salario, String turno) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.turno = turno;
        System.out.println("Funcionario " + nome + " cadastrado com sucesso");
    }

    public String toString() {
        return "Funcionario: " + this.nome + "\nIdade: " + this.idade + "anos";
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public int getIdade() {
        return idade;
    }
}
