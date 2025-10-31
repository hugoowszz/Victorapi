package br.edu.infnet.victorapi;

import br.edu.infnet.victorapi.model.domain.Funcionario;
import br.edu.infnet.victorapi.model.domain.Servico;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class VictorapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VictorapiApplication.class, args);
        Scanner in = new Scanner(System.in);
        boolean continuar = true;
        Date hoje = new Date();
        int diaHoje = hoje.getDate();
        int mesHoje = hoje.getMonth()+1;
        String[] funcionarios = new String[6];
        int n = 0;
        do {
            System.out.println("----------\n" + diaHoje + "/" + mesHoje + "\n1 - Cadastrar serviço\n2 - Cadastrar funcionario\n3 - Exibir funcionarios\n0 - Sair\n----------");
            System.out.print("Escolha uma das opções: ");
            int opcao = Integer.parseInt(in.nextLine());
            switch (opcao) {
                case 1:
                    Servico s1 = new Servico();
                    System.out.println("Digite o nome do cliente: ");
                    s1.cliente = in.nextLine();
                    for(int i = 0; i < s1.cliente.length(); i++) { // Validação para que o nome não contenha números
                        if (!Character.isLetter(s1.cliente.charAt(i))) {
                            System.err.println("O nome só pode conter letras!");
                            System.exit(0);
                        }
                    }
                    System.out.println("Escolha o serviço desejado:\n 1 - Recuperação e pintura \n 2 - Cyborg \n 3 - Polimento \n 0 - Sair");
                    s1.servico = Integer.parseInt(in.nextLine());

                    System.out.println("Digite o dia previsto para entrega: ");
                    s1.previsaoDiaEntrega = Integer.parseInt(in.nextLine());

                    System.out.println("Digite o mês previsto para entrega: ");
                    s1.previsaoMesEntrega = Integer.parseInt(in.nextLine());

                    System.out.println("Digite o modelo do carro: ");
                    s1.modelo = in.nextLine();
                    for(int i = 0; i < s1.modelo.length(); i++) { // Validação para que o modelo não contenha números
                        if (!Character.isLetter(s1.modelo.charAt(i))) {
                            System.err.println("O modelo só pode conter letras!");
                            System.exit(0);
                        }
                    }

                    System.out.println("Digite o ano do carro: ");
                    s1.ano = Integer.parseInt(in.nextLine());

                    System.out.println("Digite o valor do serviço: ");
                    s1.orcamento = Double.parseDouble(in.nextLine());

                    s1.imprimir();
                    break;
//                    ------------------------------------------------------------------------------------------
                case 2:
                    Funcionario funcionario = new Funcionario();
                    System.out.println("1 - Criar novo funcionario"+"\n0 - Sair");
                    int opcaoFuncionario = Integer.parseInt(in.nextLine());
                        switch(opcaoFuncionario) {
                            case 1:
                                System.out.println("Digite o nome do funcionario: ");
                                String nomeFuncionario = in.nextLine();
                                System.out.println("Digite a idade do funcionario: ");
                                int idadeFuncionario = Integer.parseInt(in.nextLine());
                                funcionarios[n] = funcionario.NovoFuncionario(nomeFuncionario, idadeFuncionario);
                                n++;
                                System.out.println("Funcionario criado com sucesso!");
                                break;
                            case 0:
                                System.out.println("Cadastro encerrado!");
                                break;
                        }
                    break;
//                    ---------------------------------------------------------------------------------------
                case 3:
                    for(int i = 0; i < funcionarios.length; i++) {
                        System.out.println(funcionarios[i]);
                    }
                    break;
//                    ---------------------------------------------------------------------------------------
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

