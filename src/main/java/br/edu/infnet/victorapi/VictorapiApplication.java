package br.edu.infnet.victorapi;

import br.edu.infnet.victorapi.model.domain.Funcionario;
import br.edu.infnet.victorapi.model.domain.FuncionarioComissao;
import br.edu.infnet.victorapi.model.domain.FuncionarioFixo;
import br.edu.infnet.victorapi.model.domain.Servico;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class VictorapiApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(VictorapiApplication.class, args);
        Scanner in = new Scanner(System.in);
        boolean continuar = true;

        List<Funcionario> funcionarios = new ArrayList<>();
        List<Servico> orcamentos = new ArrayList<>();
        List<Servico> servicosFinalizados = new ArrayList<>();

        List<String> funcionariosDesignados = new ArrayList<>();
        //Funcionario funcionario1 = new Funcionario("Victor", 19);
        //funcionario1.isAtivo(true);
        //funcionarios.add(funcionario1);

        Funcionario funcFixo1 = new FuncionarioFixo("Victor", 19, 2000, "8h/ dia");
        Funcionario funcComissao1 = new FuncionarioComissao("Carlos", 45);
        funcionarios.add(funcComissao1);
        funcionarios.add(funcFixo1);

        Servico  servico1 = new Servico("Elberth", 3, 15, 1, "Corolla", 2025, 7000, "Victor");
        orcamentos.add(servico1);

        do {
            boolean escolheu = false;
            final int opcoes = 10;
            int opcao;
            do {
                System.out.println("----------\n1 - Fazer orçamento\n2 - Cadastrar funcionario\n3 - Iniciar serviço\n4 - Lista de orçamentos" +
                        "\n5 - Lista de funcionarios\n6 - Remover serviço\n7 - Finalizar serviço\n8 - Lista de serviços entregues" +
                        "\n9 - Faturamento de funcionarios\n0 - Sair\n----------");
                System.out.print("Escolha uma das opções: ");
                if(!in.hasNextInt()) {
                    System.err.println("Erro, digite um numero para selecionar!");
                    in.nextLine();
                    opcao = -1;
                } else {
                    opcao = in.nextInt();
                    in.nextLine();
                    escolheu = true;
                }
                if(opcao == 0) {
                    escolheu = true;
                }

            } while (!escolheu);
            switch (opcao) {
                case 1:
                    Servico servico = new Servico();
                    servico.novoOrcamento();
                    orcamentos.add(servico);
                    servico.imprimir();
                    break;
                case 2:
                    boolean hasNome = false;
                    String nome = "";
                    do {
                        System.out.println("Digite o nome do funcionario: ");
                        nome = in.nextLine();
                        if(nome.isEmpty() || nome.length() < 3) {
                            System.err.println("Erro, digite no minimo 3 letras!");
                        } else {
                            System.out.println("Nome cadastrado com sucesso!");
                            hasNome = true;
                        }
                    } while(!hasNome);

                    boolean hasIdade = false;
                    int idade = 0;
                    do {
                        System.out.println("Digite a idade do funcionario: ");
                        String StrIdade = in.nextLine();
                        try {
                            idade = Integer.parseInt(StrIdade);
                            System.out.println("Idade cadastrada com sucesso!");
                            hasIdade = true;
                        } catch (NumberFormatException e) {
                            System.err.println("Erro, digite apenas numeros para a idade!");
                        }
                    } while(!hasIdade);

                    System.out.println("Em qual turno o funcionario vai trabalhar?\n1 - 8h / dia\n2 - 4h / dia\n3 - Autônomo");
                    int turnoNum = 0;
                    try {
                        turnoNum = Integer.parseInt(in.nextLine());
                    } catch (NumberFormatException e) {
                        turnoNum = 1;
                    }
                    String turno = "a";
                    String tipoFunc;

                    switch (turnoNum) {
                        case 1:
                            turno = "8 horas / dia";
                            tipoFunc = "1";
                            break;
                        case 2:
                            turno = "4 horas / dia";
                            tipoFunc = "1";
                            break;
                        case 3:
                            turno = "Autônomo";
                            tipoFunc = "2";
                        default:
                            turno = "Autônomo";
                            tipoFunc = "2";
                    }
                    if (tipoFunc.equals("1")) {
                        System.out.println("Digite o salario do funcionario: ");
                        int salario = Integer.parseInt(in.nextLine());

                        Funcionario novoFuncionarioFixo = new FuncionarioFixo(nome, idade, salario, turno);
                        novoFuncionarioFixo.isAtivo(true);
                        funcionarios.add(novoFuncionarioFixo);
                        novoFuncionarioFixo.imprimir();
                        break;
                    } else {
                        Funcionario novoFuncionarioComissao = new FuncionarioComissao(nome, idade);
                        funcionarios.add(novoFuncionarioComissao);
                        novoFuncionarioComissao.imprimir();
                    }
                    BufferedWriter bw = new BufferedWriter(new FileWriter("funcionarios.txt"));
                    break;
                case 3:
                    boolean selecionou = false;
                    System.out.println("----- Lista de Orçamentos -----");
                    for (int i = 0; i < orcamentos.size(); i++) {
                        System.out.println(orcamentos.get(i) + "\nId: " + i);
                    }
                    do {
                        System.out.println("Digite o nome do cliente que fez o orçamento: ");
                        String nomeLido = in.nextLine();
                        for (int i = 0; i < orcamentos.size(); i++) {
                            if (nomeLido.toLowerCase().equals(orcamentos.get(i).getCliente().toLowerCase())) {
                                selecionou = true;
                                System.out.println("Orçamento do(a) cliente: " + nomeLido + " selecionado!");
                                break;
                            }
                            if (i == orcamentos.size() - 1) {
                                System.err.println("Erro: orçamento não encontrado!");
                                break;
                            }
                        }
                    } while (!selecionou);
                    System.out.println("Serviço iniciado com sucesso!");
                    break;
                case 4:
                    System.out.println("----- Lista de serviços -----");
                    for (Servico s : orcamentos) {
                        System.out.println(s);
                    }
                    break;
                case 5:
                    System.out.println("----- Lista de funcionarios -----");
                    for (Funcionario f : funcionarios) {
                        System.out.println(f);
                        System.out.println("\n ---------- \n");
                    }
                    break;
                case 6:
                    System.out.println("----- Lista de serviços -----");
                    for (int i = 0; i < orcamentos.size(); i++) {
                        System.out.println(orcamentos.get(i) + "ID: " + i + "\n----------\n");
                    }
                    System.out.println("Digite o id do serviço que deseja remover:");
                    int idRemover = Integer.parseInt(in.nextLine());
                    if (idRemover >= 0 && idRemover < orcamentos.size()) {
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
                        System.out.println(orcamentos.get(i) + "\nId: " + i + "\n----------\n");
                    }
                    System.out.println("Digite o id do serviço que deseja finalizar");
                    try {
                        int idFinalizar = Integer.parseInt(in.nextLine());
                        if(idFinalizar < 0 || idFinalizar >= orcamentos.size()) {
                            System.err.println("Erro: id inválido");
                            break;
                        }
                        System.out.println("Digite S para dar confirmar a finalização do serviço de ID: " + idFinalizar);
                        char finalizar = in.nextLine().toUpperCase().charAt(0);
                        String pagamento = "";
                        if(finalizar == 'S') {
                            System.out.println("Selecione a forma de pagamento do serviço:\n1 - Dinheiro\n2 - Débito\n3 - Crédito\n4 - Pix");
                            int formaPagamento = 0;
                            try{
                                formaPagamento = Integer.parseInt(in.nextLine());
                            } catch (NumberFormatException e) {
                                System.err.println("ERRO");
                            }
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
                                default:
                                    pagamento = "Dinheiro";
                            }
                            System.out.println("Forma de pagamento selecionada: " + pagamento);
                            System.out.println("Digite o dia em que a entrega foi feita:");
                            orcamentos.get(idFinalizar).setDiaEntrega(Integer.parseInt(in.nextLine()));
                            System.out.println("Digite o mês em que a entrega foi feita:");
                            orcamentos.get(idFinalizar).setMesEntrega(Integer.parseInt(in.nextLine()));
                            System.out.println("Digite o nome do funcionario que realizou o serviço:");
                            String funcRealizou = in.nextLine();
                            orcamentos.get(idFinalizar).setNomeFuncionario(funcRealizou);
                            for (int r = 0; r < funcionarios.size(); r++) {
                                if (funcionarios.get(r).getNomeFuncionario().equals(funcRealizou) || funcionarios.get(r).getNomeFuncionario().toLowerCase().equals(funcRealizou.toLowerCase())) {
                                    System.out.println("Funcionario selecionado com sucesso!");
                                    funcionarios.get(r).setFaturamento(orcamentos.get(idFinalizar).getOrcamento());
                                }
                            }
                            System.out.println("-----Serviço:-----\n" + orcamentos.get(idFinalizar).toString() + "\n-----foi finalizado com sucesso!-----");
                            servicosFinalizados.add(orcamentos.get(idFinalizar));
                            orcamentos.remove(idFinalizar);
                        } else {
                            System.out.println("Finalização cancelada");
                        }

                        } catch (NumberFormatException e) {
                        System.err.println("Erro: digite apenas números");
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
                        if (servicosFinalizados.get(i).getMesEntrega() == idMes) {
                            System.out.println("----- Lista de serviços entregues em " + filtrarMes + "-----");
                            System.out.println(servicosFinalizados.get(i).toString());
                            encontrado = true;
                        }
                        i++;
                    }
                    if (!encontrado) {
                        System.out.println("Nenhum serviço foi entregue no mês de " + filtrarMes + "!");
                    }
                    break;
                case 9:
                    System.out.println("Digite o nome do funcionario que deseja consultar os ganhos");
                    String nomeFunGanho = in.nextLine();
                    for (int f = 0; f < funcionarios.size(); f++) {
                        if (funcionarios.get(f).getNomeFuncionario().equals(nomeFunGanho) || funcionarios.get(f).getNomeFuncionario().toLowerCase().equals(nomeFunGanho.toLowerCase())) {
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


