package br.edu.infnet.victorapi.model.domain;

public class FuncionarioFixo extends Funcionario{

    private int salario;

    public FuncionarioFixo(String nomeFuncionario, int idadeFuncionario, int salario, String turno) {
    super(nomeFuncionario, idadeFuncionario);
    this.salario = salario;
    this.turno = turno;
    this.isAtivo(true);
    }
}
