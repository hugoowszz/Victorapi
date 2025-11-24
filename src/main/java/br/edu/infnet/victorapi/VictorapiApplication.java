package br.edu.infnet.victorapi;

import br.edu.infnet.victorapi.model.domain.Funcionario;
import br.edu.infnet.victorapi.model.domain.Servico;
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
        List<Servico> servicos = new ArrayList<>();
        List<Servico> servicosFinalizados = new ArrayList<>();

        Funcionario funcionario1 = new Funcionario("Victor", 19);
        funcionarios.add(funcionario1);

        do {
            System.out.println("----------\n1 - Cadastrar serviço\n2 - Cadastrar funcionario\n3 - Lista de serviços\n4 - Lista de funcionarios\n5 - Remover serviço\n6 - Finalizar serviço\n7 - Lista de serviços entregues\n8 - Faturamento de funcionarios\n0 - Sair\n----------");
            System.out.print("Escolha uma das opções: ");
            if (!in.hasNextInt()) {
                System.err.println("Digite um numero para selecionar a opção!");
                in.nextLine();
                continue;
            }
            int opcao = Integer.parseInt(in.nextLine());
                switch (opcao) {
                    case 1:
                        Servico novoServico = new Servico();
                        System.out.println("Digite o nome do cliente: ");
                        String cliente = in.nextLine();
                        novoServico.setCliente(cliente);
                        System.out.println("Escolha o serviço desejado:\n 1 - Recuperação e pintura \n 2 - Cyborg \n 3 - Polimento \n 0 - Sair");
                        int servico = Integer.parseInt(in.nextLine());
                        novoServico.setServico(servico);
                        System.out.println("Digite o dia previsto para entrega: ");
                        int previsaoDiaEntrega = Integer.parseInt(in.nextLine());
                        novoServico.setDiaEntrega(previsaoDiaEntrega);
                        System.out.println("Digite o mês previsto para entrega: ");
                        int previsaoMesEntrega = Integer.parseInt(in.nextLine());
                        novoServico.setMesEntrega(previsaoMesEntrega);
                        System.out.println("Digite o modelo do carro: ");
                        String modelo = in.nextLine();
                        novoServico.setModelo(modelo);
                        System.out.println("Digite o ano do carro: ");
                        int ano = Integer.parseInt(in.nextLine());
                        novoServico.setAno(ano);
                        System.out.println("Digite o valor do serviço: ");
                        double orcamento = Double.parseDouble(in.nextLine());
                        novoServico.setOrcamento(orcamento);
                        servicos.add(novoServico);
                        novoServico.imprimir();
                        break;
                    case 2:
                        System.out.println("Digite o nome do funcionario: ");
                        String nome = in.nextLine();
                        System.out.println("Digite a idade do funcionario: ");
                        int idade = Integer.parseInt(in.nextLine());

                        Funcionario novoFuncionario = new Funcionario(nome, idade);
                        funcionarios.add(novoFuncionario);
                        break;
                    case 3:
                        System.out.println("----- Lista de serviços -----");
                        for (Servico s : servicos) {
                            System.out.println(s);
                        }
                        break;
                    case 4:
                        System.out.println("----- Lista de funcionarios -----");
                        for (Funcionario f : funcionarios) {
                            System.out.println(f);
                        }
                        break;
                    case 5:
                        System.out.println("----- Lista de serviços -----");
                        for (int i = 0; i < servicos.size(); i++) {
                            System.out.println(servicos.get(i) + "ID: " + i + "\n----------\n");
                        }
                        System.out.println("Digite o id do serviço que deseja remover:");
                        int idRemover = Integer.parseInt(in.nextLine());
                        if(idRemover >= 0 && idRemover < servicos.size()) {
                            System.out.println("Digite S para a remoção do serviço de ID: " + idRemover);
                            char confirmar = in.nextLine().toUpperCase().charAt(0);
                            if (confirmar == 'S') {
                                servicos.remove(idRemover);
                            } else {
                                System.out.println("Remoção cancelada");
                            }
                        } else {
                            System.err.println("ID inválido! nenhum serviço foi removido.");
                        }

                        break;
                    case 6:
                        System.out.println("----- Lista de serviços -----");
                        for (int i = 0; i < servicos.size(); i++) {
                            System.out.println(servicos.get(i) + "ID: " + i + "\n----------\n");
                        }
                        System.out.println("Digite o id do serviço que deseja finalizar");
                        int  idFinalizar = Integer.parseInt(in.nextLine());
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
                            servicos.get(idFinalizar).setDiaEntrega(Integer.parseInt(in.nextLine()));
                            System.out.println("Digite o mês em que a entrega foi feita:");
                            servicos.get(idFinalizar).setMesEntrega(Integer.parseInt(in.nextLine()));
                            System.out.println("Digite o nome do funcionario que realizou o serviço:");
                            String funcRealizou = in.nextLine();
                            for(int r = 0; r < funcionarios.size(); r++) {
                                if(funcionarios.get(r).nome.equals(funcRealizou) || funcionarios.get(r).nome.toLowerCase().equals(funcRealizou.toLowerCase())) {
                                    System.out.println("Funcionario selecionado com sucesso!");
                                    funcionarios.get(r).faturamento += servicos.get(idFinalizar).getOrcamento();
                                }
                            }
                            System.out.println("Serviço " + servicos.get(idFinalizar).sList() + " foi finalizado com sucesso!");
                            servicosFinalizados.add(servicos.get(idFinalizar));
                            servicos.remove(idFinalizar);
                        } else {
                            System.out.println("Finalização cancelada");
                        }
                        break;
                    case 7:
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
                    case 8:
                        System.out.println("Digite o nome do funcionario que deseja consultar os ganhos");
                        String nomeFunGanho = in.nextLine();
                        for(int f = 0; f < funcionarios.size(); f++) {
                            if(funcionarios.get(f).nome.equals(nomeFunGanho) || funcionarios.get(f).nome.toLowerCase().equals(nomeFunGanho.toLowerCase())) {
                                System.out.println("Faturamento: " + funcionarios.get(f).faturamento);
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
            }
            while (continuar);
        }
	}


