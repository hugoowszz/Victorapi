package br.edu.infnet.victorapi.model.domain;

public class Servico {
    public String cliente;
    public int servico;
    public String modelo;
    public int ano;

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
        System.out.println("Cliente: " + this.cliente + "\nModelo: " + this.modelo + "\nAno: " + this.ano + "\nTipo de serviço: " + this.tipoServico());
    }
}
