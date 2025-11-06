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

        Servico novoServico1 = new Servico("Victor", 3, "Civic", 2020, 10, 12, 2000);// auto cadastramento de serviço para facilitar testes
        servicos.add(novoServico1);
        Servico novoServico2 = new Servico("Carlos", 3, "Corolla", 2020, 12, 1, 2500);
        servicos.add(novoServico2);

        do {
            System.out.println("----------\n1 - Cadastrar serviço\n2 - Cadastrar funcionario\n3 - Lista de serviços\n4 - Lista de funcionarios\n5 - Remover serviço\n6 - Finalizar serviço\n7 - Lista de serviços entregues\n0 - Sair\n----------");
            System.out.print("Escolha uma das opções: ");
            if (!in.hasNextInt()) {
                System.err.println("Digite um numero para selecionar a opção!");
                break;
            }
            int opcao = Integer.parseInt(in.nextLine());
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o nome do cliente: ");
                        String cliente = in.nextLine();
                        System.out.println("Escolha o serviço desejado:\n 1 - Recuperação e pintura \n 2 - Cyborg \n 3 - Polimento \n 0 - Sair");
                        int servico = Integer.parseInt(in.nextLine());
                        System.out.println("Digite o dia previsto para entrega: ");
                        int previsaoDiaEntrega = Integer.parseInt(in.nextLine());
                        System.out.println("Digite o mês previsto para entrega: ");
                        int previsaoMesEntrega = Integer.parseInt(in.nextLine());
                        System.out.println("Digite o modelo do carro: ");
                        String modelo = in.nextLine();
                        System.out.println("Digite o ano do carro: ");
                        int ano = Integer.parseInt(in.nextLine());
                        System.out.println("Digite o valor do serviço: ");
                        double orcamento = Double.parseDouble(in.nextLine());

                        Servico novoServico = new Servico(cliente, servico, modelo, ano, previsaoDiaEntrega, previsaoMesEntrega, orcamento);
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
                        System.out.println("Digite o id do serviço que deseja remover");
                        int idRemover = Integer.parseInt(in.nextLine());
                        System.out.println("Digite S para a remoção do serviço de ID: " + idRemover);
                        char confirmar = in.nextLine().toUpperCase().charAt(0);
                        if (confirmar == 'S') {
                            servicos.remove(idRemover);
                        } else {
                            System.out.println("Remoção cancelada");
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
                            System.out.println("Serviço " + servicos.get(idFinalizar).sList() + " finalizado com sucesso!");
                            servicosFinalizados.add(servicos.get(idFinalizar));
                            servicos.remove(idFinalizar);
                        } else {
                            System.out.println("Finalização cancelada");
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


