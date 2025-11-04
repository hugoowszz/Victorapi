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

        do {
            System.out.println("----------\n1 - Cadastrar serviço\n2 - Cadastrar funcionario\n3 - Lista de serviços\n4 - Lista de funcionarios\n0 - Sair\n----------");
            System.out.print("Escolha uma das opções: ");
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
                    System.out.println("----- Lista de serviços -----");
                    for (Servico s: servicos) {
                        System.out.println(s);
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do funcionario: ");
                    String nome = in.nextLine();
                    System.out.println("Digite a idade do funcionario: ");
                    int idade = Integer.parseInt(in.nextLine());

                    Funcionario novoFuncionario = new Funcionario(nome, idade);
                    funcionarios.add(novoFuncionario);
                    System.out.println("----- Lista de funcionarios -----");
                    for (Funcionario f : funcionarios) {
                        System.out.println(f);
                    }
                    break;
                case 3:
                    System.out.println("----- Lista de serviços -----");
                    for (Servico s: servicos) {
                        System.out.println(s);
                    }
                    break;
                case 4:
                    System.out.println("----- Lista de funcionarios -----");
                    for (Funcionario f : funcionarios) {
                        System.out.println(f);
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

