package br.edu.infnet.victorapi.model.domain;

public class Servico {
    public String cliente;
    public int servico;
    public String modelo;
    public int ano;
    public int previsaoDiaEntrega;
    public int previsaoMesEntrega;
    public double orcamento;
    public int diaEntrega;
    public int mesEntrega;

    public Servico(String cliente, int servico, String modelo, int ano, int previsaoDiaEntrega, int previsaoMesEntrega, double orcamento) {
        this.cliente = cliente;
        this.servico = servico;
        this.modelo = modelo;
        this.ano = ano;
        this.previsaoDiaEntrega = previsaoDiaEntrega;
        this.previsaoMesEntrega = previsaoMesEntrega;
        this.orcamento = orcamento;
        System.out.println("Serviço cadastrado com sucesso!");
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

}
