package br.edu.infnet.victorapi.model.domain;

public abstract class Funcionario {

    private String nomeFuncionario;
    private int idadeFuncionario;
    private double faturamento;
    private boolean ativo;
    protected String turno;
    private String verificarAtivo;
    public Funcionario() {
    }

    public void isAtivo(boolean ativo) {
        this.ativo = ativo;
        if (ativo == true) {
            verificarAtivo = "Ativo";
        } else {
            verificarAtivo = "Inativo";
        }
    }

    public Funcionario(String nomeFuncionario, int idadeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.idadeFuncionario = idadeFuncionario;
        System.out.println("Funcionario " + nomeFuncionario + " cadastrado com sucesso");
    }

    @Override
    public String toString() {
        return "Funcionario: " + this.nomeFuncionario + "\nIdade: " + this.idadeFuncionario + " anos\nSituação: " + verificarAtivo + "\nTurno: " + this.turno;
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
        return nomeFuncionario;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public int getIdadeFuncionario() {
        return idadeFuncionario;
    }
}
