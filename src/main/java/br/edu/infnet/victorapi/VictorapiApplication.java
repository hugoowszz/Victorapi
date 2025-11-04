package br.edu.infnet.victorapi;

import br.edu.infnet.victorapi.model.domain.Servico;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class VictorapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VictorapiApplication.class, args);
        Scanner in = new Scanner(System.in);
        boolean continuar = true;
        do {
            System.out.println("----------\n1 - Cadastrar serviço\n0 - Sair\n----------");
            System.out.print("Escolha uma das opções: ");
            int opcao = Integer.parseInt(in.nextLine());
            switch (opcao) {
                case 1:
                    Servico s1 = new Servico();
                    System.out.println("Digite o nome do cliente: ");
                    s1.cliente = in.nextLine();

                    System.out.println("Escolha o serviço desejado:\n 1 - Recuperação e pintura \n 2 - Cyborg \n 3 - Polimento \n 0 - Sair");
                    s1.servico = Integer.parseInt(in.nextLine());

                    System.out.println("Digite o dia previsto para entrega: ");
                    s1.previsaoDiaEntrega = Integer.parseInt(in.nextLine());

                    System.out.println("Digite o mês previsto para entrega: ");
                    s1.previsaoMesEntrega = Integer.parseInt(in.nextLine());

                    System.out.println("Digite o modelo do carro: ");
                    s1.modelo = in.nextLine();

                    System.out.println("Digite o ano do carro: ");
                    s1.ano = Integer.parseInt(in.nextLine());

                    System.out.println("Digite o valor do serviço: ");
                    s1.orcamento = Double.parseDouble(in.nextLine());

                    s1.imprimir();
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

