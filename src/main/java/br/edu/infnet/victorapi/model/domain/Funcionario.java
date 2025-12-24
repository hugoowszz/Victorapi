package br.edu.infnet.victorapi.model.domain;

import br.edu.infnet.victorapi.model.domain.interfaces.Exibir;

public abstract class Funcionario implements Exibir {

    private String nomeFuncionario;
    private int idadeFuncionario;
    private double faturamento;
    private boolean ativo;
    protected String turno;
    private String verificarAtivo;

    public abstract double calcularBonus();

    public Funcionario() {
        this.ativo = true;
        this.verificarAtivo = "Ativo";
    }

    public Funcionario(String nomeFuncionario, int idadeFuncionario) {
        this();
        this.nomeFuncionario = nomeFuncionario;
        this.idadeFuncionario = idadeFuncionario;
    }

    public void isAtivo(boolean ativo) {
        this.ativo = ativo;
        if (ativo == true) {
            verificarAtivo = "Ativo";
        } else {
            verificarAtivo = "Inativo";
        }
    }

    public void imprimir(boolean mostrarFaturamento) {
        System.out.println("Nome: " + this.nomeFuncionario + "\nTurno: " + this.turno);
        if(mostrarFaturamento) {
            System.out.println("Faturamento: " + this.faturamento);
        }
    }

    @Override
    public String toString() {
        return "Funcionario: " + this.nomeFuncionario + "\nIdade: " + this.idadeFuncionario + " anos\nSituação: " + verificarAtivo + "\nTurno: " + this.turno + "\nFaturamento: " + this.faturamento;
    }
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }

    public void setIdadeFuncionario(int idadeFuncionario) {
        this.idadeFuncionario = idadeFuncionario;
    }

    public String getNomeFuncionario() {
        return this.nomeFuncionario;
    }

    public double getFaturamento() {
        return this.faturamento;
    }

    public int getIdadeFuncionario() {
        return this.idadeFuncionario;
    }
}
