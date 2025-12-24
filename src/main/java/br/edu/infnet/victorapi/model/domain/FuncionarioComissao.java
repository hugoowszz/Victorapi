package br.edu.infnet.victorapi.model.domain;

public final class FuncionarioComissao extends Funcionario {

    public static final double TAXA_COMISSAO = 0.5;

    public FuncionarioComissao(String  nomeFuncionario, int idadeFuncionario) {
        super(nomeFuncionario, idadeFuncionario);
        this.turno = "Autônomo";
    }

    @Override
    public double calcularBonus() {
        return this.getFaturamento() * 0.1;
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + this.getNomeFuncionario() + "\nIdade: " + this.getIdadeFuncionario() + "\nTurno: " + this.turno);
    }
}
