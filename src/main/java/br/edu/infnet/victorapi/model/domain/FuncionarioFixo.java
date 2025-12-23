package br.edu.infnet.victorapi.model.domain;

public final class FuncionarioFixo extends Funcionario{

    private int salario;

    public FuncionarioFixo(String nomeFuncionario, int idadeFuncionario, int salario, String turno) {
    super(nomeFuncionario, idadeFuncionario);
    this.salario = salario;
    this.turno = turno;
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + super.getNomeFuncionario() + "\nIdade: " + super.getIdadeFuncionario() + "\nTurno: " + this.turno + "\nSalario: " + this.salario);
    }
}
