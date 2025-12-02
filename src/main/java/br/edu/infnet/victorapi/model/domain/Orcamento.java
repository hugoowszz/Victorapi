package br.edu.infnet.victorapi.model.domain;

public class Orcamento {
    private String cliente;
    private int servico;
    private String modelo;
    private int ano;
    private int previsaoDiaEntrega;
    private int previsaoMesEntrega;
    private double orcamento;
    private int diaEntrega;
    private int mesEntrega;


    public Orcamento() {
        System.out.println("Servico Iniciado");
    }

    public Orcamento(String cliente, int servico, String modelo, int ano, int previsaoDiaEntrega, int previsaoMesEntrega, double orcamento) {
        this.cliente = cliente;
        this.servico = servico;
        this.modelo = modelo;
        this.ano = ano;
        this.previsaoDiaEntrega = previsaoDiaEntrega;
        this.previsaoMesEntrega = previsaoMesEntrega;
        this.orcamento = orcamento;
    }

    public String toString() {
        return "Cliente: " + this.cliente + "\nTipo de serviço: " + tipoServico() + "\nModelo: " + modelo + "\nAno: " + ano + "\nPrevisão de entrega: " + previsaoDiaEntrega + "/" + previsaoMesEntrega + "\nPreço: " + orcamento + "\n";
    }

    public String sList() {
        return "Cliente: " + this.cliente + " Tipo de serviço: " + tipoServico() + " Modelo: " + modelo + "\nAno: " + ano + " Previsão de entrega: " + previsaoDiaEntrega + "/" + previsaoMesEntrega + " Preço: " + orcamento;
    }

    private String tipoServico() {
        String tipo = null;
        switch (servico) {
            case 1:
                tipo = "Recuperação e pintura";
                break;
            case 2:
                tipo = "Cyborg";
                break;
            case 3:
                tipo = "Polimento";
                break;
            case 0:
                tipo = "Sair";
                break;
        }
        return tipo;
    }

    public void imprimir() {
        System.out.println("Cliente: " + this.cliente + "\nModelo: " + this.modelo + "\nAno: " + this.ano + "\nTipo de serviço: " + this.tipoServico() + "\nPrevisão entrega: " + this.previsaoDiaEntrega + "/" + this.previsaoMesEntrega + "\nOrçamento: " + this.orcamento + " Reais");
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public void setMesEntrega(int mesEntrega) {
        this.mesEntrega = mesEntrega;
    }

    public void setDiaEntrega(int diaEntrega) {
        this.diaEntrega = diaEntrega;
    }

    public void setPrevisaoMesEntrega(int previsaoMesEntrega) {
        this.previsaoMesEntrega = previsaoMesEntrega;
    }

    public void setPrevisaoDiaEntrega(int previsaoDiaEntrega) {
        this.previsaoDiaEntrega = previsaoDiaEntrega;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public int getServico() {
        return servico;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getPrevisaoDiaEntrega() {
        return previsaoDiaEntrega;
    }

    public int getPrevisaoMesEntrega() {
        return previsaoMesEntrega;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public int getDiaEntrega() {
        return diaEntrega;
    }

    public int getMesEntrega() {
        return mesEntrega;
    }

}
