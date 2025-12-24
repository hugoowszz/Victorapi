package br.edu.infnet.victorapi.model.domain;

import java.util.Scanner;


public class Servico {
    private String cliente;
    private int servico;
    private int previsaoDiaEntrega;
    private int previsaoMesEntrega;
    private int diaEntrega;
    private int mesEntrega;
    private String modelo;
    private int ano;
    private double orcamento;
    private boolean servicoCancelado = false;

    Funcionario funcionarioResponsavel;

    public Servico() {}

    public Servico(String cliente, int servico, int previsaoDiaEntrega, int previsaoMesEntrega, String modelo, int ano, double orcamento) {
        super();
        this.cliente = cliente;
        this.servico = servico;
        this.previsaoDiaEntrega = previsaoDiaEntrega;
        this.previsaoMesEntrega = previsaoMesEntrega;
        this.modelo = modelo;
        this.ano = ano;
        this.orcamento = orcamento;
    }

    public final void novoOrcamento() throws IllegalArgumentException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        this.cliente = scan.nextLine();
        System.out.println("Escolha o serviço desejado:\n 1 - Recuperação e pintura \n 2 - Cyborg \n 3 - Polimento");
        this.servico = Integer.parseInt(scan.nextLine());
        System.out.println("Digite o dia previsto para entrega: ");
        this.previsaoDiaEntrega = Integer.parseInt(scan.nextLine());
        System.out.println("Digite o mês previsto para entrega: ");
        this.previsaoMesEntrega = Integer.parseInt(scan.nextLine());
        System.out.println("Digite o modelo do carro: ");
        this.modelo = scan.nextLine();
        System.out.println("Digite o ano do carro: ");
        this.ano = Integer.parseInt(scan.nextLine());
        System.out.println("Digite o valor do serviço: ");
        double valor = Double.parseDouble(scan.nextLine());
        if(valor < 0) {
            throw new IllegalArgumentException("o  valor  não pode ser menor que zero!");
        }
        this.orcamento = valor;
    }

    public void imprimir() {
        System.out.println("Cliente: " + this.cliente + "\nTipo de Serviço: " + this.servico + "\nPrevisão entrega: " + this.previsaoDiaEntrega + "/" + this.previsaoMesEntrega + "\nModelo: " + this.modelo + "\nAno: " + this.ano + "\nValor: " + this.orcamento);
    }

    @Override
    public String toString() {
        return "Cliente: " + this.getCliente() +
                "\nTipo de serviço: " + this.getServico() +
                "\nFuncionario Responsavel: " + this.getFuncionarioResponsavel() +
                "\nModelo: " + this.getModelo() +
                "\nAno: " + this.getAno() +
                "\nPrevisão de entrega: " + this.getPrevisaoDiaEntrega()+ "/" + this.getPrevisaoMesEntrega() +
                "\nPreço: " + this.getOrcamento() +
                "\nServiço cancelado: " + this.servicoCancelado;
    }

    public void isServicoCancelado(boolean servicoCanc) {
        if(servicoCanc == true) {
            this.servicoCancelado = true;
        } else {
            this.servicoCancelado = false;
        }
    }

    public int getDiaEntrega() {
        return diaEntrega;
    }

    public int getMesEntrega() {
        return mesEntrega;
    }

    public void setMesEntrega(int mesEntrega) {
        this.mesEntrega = mesEntrega;
    }

    public void setDiaEntrega(int diaEntrega) {
        this.diaEntrega = diaEntrega;
    }

    public void setPrevisaoMesEntrega(int previsaoMesEntrega) {
        previsaoMesEntrega = previsaoMesEntrega;
    }

    public void setOrcamento(int orcamento) {
        this.orcamento = orcamento;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrevisaoDiaEntrega(int previsaoDiaEntrega) {
        previsaoDiaEntrega = previsaoDiaEntrega;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {this.funcionarioResponsavel = funcionarioResponsavel;}

    public Funcionario getFuncionarioResponsavel() { return funcionarioResponsavel; }

    public double getOrcamento() {
        return orcamento;
    }

    public int getAno() {
        return ano;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPrevisaoMesEntrega() {
        return previsaoMesEntrega;
    }

    public int getPrevisaoDiaEntrega() {
        return previsaoDiaEntrega;
    }

    public int getServico() {
        return servico;
    }

    public String getCliente() {
        return cliente;
    }
}
