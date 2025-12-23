package br.edu.infnet.victorapi.model.domain;

public class FuncionarioFixo extends Funcionario{

    private int salario;

    public FuncionarioFixo(String nomeFuncionario, int idadeFuncionario, int salario, String turno) {
    this.setNomeFuncionario(nomeFuncionario);
    this.setIdadeFuncionario(idadeFuncionario);
    this.salario = salario;
    this.turno = turno;
    this.isAtivo(true);
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + super.getNomeFuncionario() + "\nIdade: " + super.getIdadeFuncionario() + "\nTurno: " + this.turno + "\nSalario: " + this.salario);
    }
}
