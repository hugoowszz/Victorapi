package br.edu.infnet.victorapi.model.domain;

public class FuncionarioComissao extends Funcionario {

    private int comissao = 50;

    public FuncionarioComissao(String  nomeFuncionario, int idadeFuncionario) {
        this.setNomeFuncionario(nomeFuncionario);
        this.setIdadeFuncionario(idadeFuncionario);
        this.isAtivo(true);
        this.turno = "Autônomo";
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + this.getNomeFuncionario() + "\nIdade: " + this.getIdadeFuncionario() + "\nTurno: " + this.turno);
    }
}
