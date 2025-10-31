package br.edu.infnet.victorapi.model.domain;


public class Funcionario {

    String nome;
    int idade;

    public String NovoFuncionario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        return "Nome: " + nome + ", Idade: " + idade;
    }

    public void imprimir() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}
