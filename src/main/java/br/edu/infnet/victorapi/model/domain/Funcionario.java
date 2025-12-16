package br.edu.infnet.victorapi.model.domain;

public class Funcionario {

    private String nomeFuncionario;
    private int idadeFuncionario;
    private double faturamento;
    private double salario;
    private boolean ativo;
    protected String turno;

    public Funcionario() {
    }

    public void isAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void isNotAtivo() {
        this.ativo = false;
    }

    public Funcionario(String nomeFuncionario, int idadeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.idadeFuncionario = idadeFuncionario;
        System.out.println("Funcionario " + nomeFuncionario + " cadastrado com sucesso");
    }

    //a ideia aqui é ter funcionarios que recebem comissão ou salario fixo

    public Funcionario(String nomeFuncionario, int idadeFuncionario, double salario, String turno) {
        this.nomeFuncionario = nomeFuncionario;
        this.idadeFuncionario = idadeFuncionario;
        this.salario = salario;
        this.turno = turno;
        System.out.println("Funcionario " + nomeFuncionario + " cadastrado com sucesso");
    }
    @Override
    public String toString() {
        return "Funcionario: " + this.nomeFuncionario + "\nIdade: " + this.idadeFuncionario + " anos\nSituação: " + ativo + "\nId: " + "\nSalário: " + this.salario + "\nTurno: " + this.turno;
    }
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }

    public void setIdadeFuncionario(int idadeFuncionario) {
        this.idadeFuncionario = idadeFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public double getSalario() {
        return salario;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public int getIdadeFuncionario() {
        return idadeFuncionario;
    }
}
