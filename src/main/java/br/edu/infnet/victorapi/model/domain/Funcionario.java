package br.edu.infnet.victorapi.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    public String nome;
    public int idade;
    public double faturamento;

    public Funcionario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        System.out.println("Funcionario " + nome + " cadastrado com sucesso");
    }

    public String toString() {
        return "Funcionario: " + this.nome + "\nIdade: " + this.idade + "anos";
    }
}
