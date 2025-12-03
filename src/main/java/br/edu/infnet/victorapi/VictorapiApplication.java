package br.edu.infnet.victorapi;

import br.edu.infnet.victorapi.model.domain.Funcionario;
import br.edu.infnet.victorapi.model.domain.Orcamento;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class VictorapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VictorapiApplication.class, args);
        Scanner in = new Scanner(System.in);
        boolean continuar = true;

        List<Funcionario> funcionarios = new ArrayList<>();
        List<Orcamento> orcamentos = new ArrayList<>();
        List<Orcamento> servicosFinalizados = new ArrayList<>();

        List<String> funcionariosDesignados = new ArrayList<>();

        orcamentos.add(new Orcamento("Livia", 3, "chevette", 1990, 29, 05, 2000));
        orcamentos.add(new Orcamento("Victor", 3, "astra", 1990, 21, 05, 3400));
        Funcionario funcionario1 = new Funcionario("Victor", 19);
        funcionario1.isAtivo(true);
        funcionarios.add(funcionario1);

        do {
            System.out.println("----------\n1 - Fazer orçamento\n2 - Cadastrar funcionario\n3 - Designar serviço\n4 - Lista de serviços\n5 - Lista de funcionarios\n6 - Remover serviço\n7 - Finalizar serviço\n8 - Lista de serviços entregues\n9 - Faturamento de funcionarios\n0 - Sair\n----------");
            System.out.print("Escolha uma das opções: ");
            if (!in.hasNextInt()) {
                System.err.println("Digite um numero para selecionar a opção!");
                in.nextLine();
                continue;
            }
            int opcao = Integer.parseInt(in.nextLine());
            switch (opcao) {
                case 1:
                    Orcamento novoOrcamento = new Orcamento();
                    System.out.println("Digite o nome do cliente: ");
                    String cliente = in.nextLine();
                    novoOrcamento.setCliente(cliente);
                    System.out.println("Escolha o serviço desejado:\n 1 - Recuperação e pintura \n 2 - Cyborg \n 3 - Polimento \n 0 - Sair");
                    int servico = Integer.parseInt(in.nextLine());
                    novoOrcamento.setServico(servico);
                    System.out.println("Digite o dia previsto para entrega: ");
                    int previsaoDiaEntrega = Integer.parseInt(in.nextLine());
                    novoOrcamento.setPrevisaoDiaEntrega(previsaoDiaEntrega);
                    System.out.println("Digite o mês previsto para entrega: ");
                    int previsaoMesEntrega = Integer.parseInt(in.nextLine());
                    novoOrcamento.setPrevisaoMesEntrega(previsaoMesEntrega);
                    System.out.println("Digite o modelo do carro: ");
                    String modelo = in.nextLine();
                    novoOrcamento.setModelo(modelo);
                    System.out.println("Digite o ano do carro: ");
                    int ano = Integer.parseInt(in.nextLine());
                    novoOrcamento.setAno(ano);
                    System.out.println("Digite o valor do serviço: ");
                    double orcamento = Double.parseDouble(in.nextLine());
                    novoOrcamento.setOrcamento(orcamento);
                    orcamentos.add(novoOrcamento);
                    novoOrcamento.imprimir();
                    break;
                case 2:
                    System.out.println("Digite o nome do funcionario: ");
                    String nome = in.nextLine();
                    System.out.println("Digite a idade do funcionario: ");
                    int idade = Integer.parseInt(in.nextLine());
                    System.out.println("Em qual turno o funcionario vai trabalhar?\n1 - Manhã\n2 - Tarde\n3 - Noite");
                    int turnoNum = Integer.parseInt(in.nextLine());
                    String turno = "a";
                    switch (turnoNum) {
                        case 1:
                            turno = "manhã";
                            break;
                        case 2:
                            turno = "tarde";
                            break;
                        case 3:
                            turno = "noite";
                            break;
                    }
                    System.out.println("Este funcionario receberá salario fixo?\n1 - Sim\n2 - Não");
                    if (in.nextLine().equals("1")) {
                        System.out.println("Digite o salario do funcionario: ");
                        int salario = Integer.parseInt(in.nextLine());

                        Funcionario novoFuncionario1 = new Funcionario(nome, idade, salario, turno);
                        novoFuncionario1.isAtivo(true);
                        funcionarios.add(novoFuncionario1);
                        break;
                    } else {
                        Funcionario novoFuncionario = new Funcionario(nome, idade);
                        funcionarios.add(novoFuncionario);
                        break;
                    }
                case 3:
                    boolean selecionou = false;
                    System.out.println("----- Lista de serviços -----");
                    for (int i = 0; i < orcamentos.size(); i++) {
                        System.out.println(orcamentos.get(i) + "" + i);
                    }
                    do {
                        System.out.println("Digite o ID do serviço que deseja iniciar: ");
                        int idLido = in.nextInt();
                        for (int i =  0; i < orcamentos.size(); i++) {
                            if(i == idLido) {
                                selecionou = true;
                                break;
                            } else {
                                System.err.println("Id incorreto!");
                                continue;
                            }
                        }
                    } while (selecionou == false);

                    boolean vaiAdicionarFunc = true;

                    do {
                        System.out.println("----- Lista de Funcionarios -----");
                        for (int i = 0; i < funcionarios.size(); i++) {
                            System.out.println(funcionarios.get(i) + "" + i);
                        }
                        boolean selecionou1 = false;
                        String designado = null;
                        do {
                            System.out.println("Digite o id do funcionario que deseja adicionar ao serviço: ");
                            int idLido = in.nextInt();
                            for (int i =  0; i < funcionarios.size(); i++) {
                                if(i == idLido) {
                                    selecionou1 = true;
                                    designado = funcionarios.get(i).getNome();
                                    break;
                                } else {
                                    System.err.println("Id incorreto!");
                                    continue;
                                }
                            }
                        } while (selecionou1 == false);

                        break;
                    } while (vaiAdicionarFunc);
                    break;

                case 4:
                    System.out.println("----- Lista de serviços -----");
                    for (Orcamento s : orcamentos) {
                        System.out.println(s);
                    }
                    break;
                case 5:
                    System.out.println("----- Lista de funcionarios -----");
                    for (Funcionario f : funcionarios) {
                        System.out.println(f);
                    }
                    break;
                case 6:
                    System.out.println("----- Lista de serviços -----");
                    for (int i = 0; i < orcamentos.size(); i++) {
                        System.out.println(orcamentos.get(i) + "ID: " + i + "\n----------\n");
                    }
                    System.out.println("Digite o id do serviço que deseja remover:");
                    int idRemover = Integer.parseInt(in.nextLine());
                    if(idRemover >= 0 && idRemover < orcamentos.size()) {
                        System.out.println("Digite S para a remoção do serviço de ID: " + idRemover);
                        char confirmar = in.nextLine().toUpperCase().charAt(0);
                        if (confirmar == 'S') {
                            orcamentos.remove(idRemover);
                        } else {
                            System.out.println("Remoção cancelada");
                        }
                    } else {
                        System.err.println("ID inválido! nenhum serviço foi removido.");
                    }
                    break;
                case 7:
                    System.out.println("----- Lista de serviços -----");
                    for (int i = 0; i < orcamentos.size(); i++) {
                        System.out.println(orcamentos.get(i) + "ID: " + i + "\n----------\n");
                    }
                    System.out.println("Digite o id do serviço que deseja finalizar");
                    int idFinalizar = Integer.parseInt(in.nextLine());
                    System.out.println("Digite S para dar confirmar a finalização do serviço de ID: " + idFinalizar);
                    char finalizar = in.nextLine().toUpperCase().charAt(0);
                    String pagamento = "";
                    if (finalizar == 'S') {
                        System.out.println("Selecione a forma de pagamento do serviço:\n1 - Dinheiro\n2 - Débito\n3 - Crédito\n4 - Pix");
                        if(!in.hasNextLine()) {
                            System.err.println("Digite um numero para selecionar a forma de pagamento!");
                        }
                        int formaPagamento = Integer.parseInt(in.nextLine());
                        switch (formaPagamento) {
                            case 1:
                                pagamento = "Dinheiro";
                                break;
                            case 2:
                                pagamento = "Débito";
                                break;
                            case 3:
                                pagamento = "Credito";
                                break;
                            case 4:
                                pagamento = "Pix";
                                break;
                        }
                        System.out.println("Forma de pagamento selecionada: " + pagamento);
                        System.out.println("Digite o dia em que a entrega foi feita:");
                        orcamentos.get(idFinalizar).setDiaEntrega(Integer.parseInt(in.nextLine()));
                        System.out.println("Digite o mês em que a entrega foi feita:");
                        orcamentos.get(idFinalizar).setMesEntrega(Integer.parseInt(in.nextLine()));
                        System.out.println("Digite o nome do funcionario que realizou o serviço:");
                        String funcRealizou = in.nextLine();
                        for(int r = 0; r < funcionarios.size(); r++) {
                            if(funcionarios.get(r).getNome().equals(funcRealizou) || funcionarios.get(r).getNome().toLowerCase().equals(funcRealizou.toLowerCase())) {
                                System.out.println("Funcionario selecionado com sucesso!");
                                funcionarios.get(r).setFaturamento(orcamentos.get(idFinalizar).getOrcamento());
                            }
                        }
                        System.out.println("Serviço " + orcamentos.get(idFinalizar).sList() + " foi finalizado com sucesso!");
                        servicosFinalizados.add(orcamentos.get(idFinalizar));
                        orcamentos.remove(idFinalizar);
                    } else {
                        System.out.println("Finalização cancelada");
                    }
                    break;
                case 8:
                    System.out.println("Digite o mês que deseja filtrar a busca");
                    String filtrarMes = in.nextLine().toLowerCase();
                    int idMes = 0;
                    switch (filtrarMes) {
                        case "janeiro":
                            idMes = 1;
                            break;
                        case "fevereiro":
                            idMes = 2;
                            break;
                        case "março":
                            idMes = 3;
                            break;
                        case "abril":
                            idMes = 4;
                            break;
                        case "maio":
                            idMes = 5;
                            break;
                        case "junho":
                            idMes = 6;
                            break;
                        case "julho":
                            idMes = 7;
                            break;
                        case "agosto":
                            idMes = 8;
                            break;
                        case "setembro":
                            idMes = 9;
                            break;
                        case "outubro":
                            idMes = 10;
                            break;
                        case "novembro":
                            idMes = 11;
                            break;
                        case "dezembro":
                            idMes = 12;
                            break;
                        default:
                            System.err.println("Entrada incorreta! Escreva o nome do mês que deseja filtrar a busca,");
                    }
                    int i = 0;
                    boolean encontrado = false;
                    while (i < servicosFinalizados.size()) {
                        if(servicosFinalizados.get(i).getMesEntrega() == idMes) {
                            System.out.println("----- Lista de serviços entregues em " + filtrarMes +"-----");
                            System.out.println(servicosFinalizados.get(i).sList());
                            encontrado = true;
                        }
                        i++;
                    }
                    if(!encontrado) {
                        System.out.println("Nenhum serviço foi entregue no mês de " + filtrarMes + "!");
                    }
                    break;
                case 9:
                    System.out.println("Digite o nome do funcionario que deseja consultar os ganhos");
                    String nomeFunGanho = in.nextLine();
                    for(int f = 0; f < funcionarios.size(); f++) {
                        if(funcionarios.get(f).getNome().equals(nomeFunGanho) || funcionarios.get(f).getNome().toLowerCase().equals(nomeFunGanho.toLowerCase())) {
                            System.out.println("Faturamento: " + funcionarios.get(f).getFaturamento());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Aplicação encerrada!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        } while (continuar);
    }
}


