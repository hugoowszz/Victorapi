package br.edu.infnet.victorapi.model.domain;

public class FuncionarioComissao extends Funcionario {

    private int comissao = 50;

    public FuncionarioComissao(String  nomeFuncionario, int idadeFuncionario) {
        super(nomeFuncionario, idadeFuncionario);
        this.isAtivo(true);
        this.turno = "Autônomo";
    }
}
