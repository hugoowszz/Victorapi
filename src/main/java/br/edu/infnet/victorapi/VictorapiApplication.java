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
        Funcionario[] funcionariosDestaque = new Funcionario[3];

        Funcionario funcComissao1 = new FuncionarioComissao("Carlos", 45);
        Funcionario funcComissao2 = new FuncionarioComissao("Victor", 19);
        Funcionario funcComissao3 = new FuncionarioComissao("Maciel", 43);
        Funcionario funcComissao4 = new FuncionarioComissao("Denilson", 30);


        funcionarios.add(funcComissao1);
        funcComissao1.setFaturamento(5000.0);

        funcionarios.add(funcComissao2);
        funcComissao2.setFaturamento(3000.0);

        funcionarios.add(funcComissao3);
        funcComissao3.setFaturamento(4000.0);

        funcionarios.add(funcComissao4);
        funcComissao4.setFaturamento(7000.0);


        Servico  servico1 = new Servico("Elberth", 3, 15, 1, "Corolla", 2025, 7000);
        orcamentos.add(servico1);

        do {
            boolean escolheu = false;
            final int opcoes = 10;
            int opcao;
            do {
                System.out.println("----------\n1 - Fazer orçamento\n2 - Cadastrar funcionario\n3 - Iniciar serviço\n4 - Lista de orçamentos" +
                        "\n5 - Lista de funcionarios\n6 - Remover serviço\n7 - Finalizar serviço\n8 - Lista dos serviços entregues" +
                        "\n9 - Funcionarios destaque\n10 - Ler arquivo de funcionarios\n11 - Ler arquivos de orçamentos\n12 - ler arquivo de serviços finalizados\n13 - Consultar faturamento dos funcionarios\n0 - Sair\n----------");
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

                    Servico salvarServico = servico;

                    if (salvarServico != null) {
                        BufferedWriter wr = null;
                        try {
                            wr = new BufferedWriter(new FileWriter("orcamentos.txt", true));

                            wr.write(salvarServico.toString());
                            wr.newLine();
                            wr.write("-----------------------------");

                            System.out.println("Orçamento salvo com sucesso no arquivo orcamentos.txt!");

                        } catch (IOException e) {
                            System.err.println("Erro ao salvar orçamento: " + e.getMessage());
                        } finally {
                            try {
                                if (wr != null) wr.close();
                            } catch (IOException e) {
                                System.err.println("Erro ao fechar o arquivo: " + e.getMessage());
                            }
                        }
                    }

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

                    Funcionario salvarFuncionario = null;

                    if (tipoFunc.equals("1")) {
                        System.out.println("Digite o salario do funcionario: ");
                        int salario = Integer.parseInt(in.nextLine());

                        Funcionario novoFuncionarioFixo = new FuncionarioFixo(nome, idade, salario, turno);
                        novoFuncionarioFixo.isAtivo(true);
                        funcionarios.add(novoFuncionarioFixo);
                        novoFuncionarioFixo.imprimir();

                        salvarFuncionario = novoFuncionarioFixo;
                    } else {
                        Funcionario novoFuncionarioComissao = new FuncionarioComissao(nome, idade);
                        funcionarios.add(novoFuncionarioComissao);
                        novoFuncionarioComissao.imprimir();

                        salvarFuncionario = novoFuncionarioComissao;
                    }

                    if (salvarFuncionario != null) {
                        BufferedWriter wr = null;
                        try {
                            wr = new BufferedWriter(new FileWriter("funcionarios.txt", true));

                            wr.write(salvarFuncionario.toString());
                            wr.newLine();
                            wr.write("-----------------------------");

                            System.out.println("Funcionario salvo com sucesso no arquivo funcionarios.txt!");

                        } catch (IOException e) {
                            System.err.println("Erro ao salvar funcionário: " + e.getMessage());
                        } finally {
                            try {
                                if (wr != null) wr.close();
                            } catch (IOException e) {
                                System.err.println("Erro ao fechar o arquivo: " + e.getMessage());
                            }
                        }
                    }
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
                        System.out.println(f + "\n");
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
                        String confirmar = in.nextLine();
                        if ("s".equalsIgnoreCase(confirmar)) {
                            orcamentos.get(idRemover).isServicoCancelado(true);
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
                            Funcionario funcionarioEncontrado = null;
                            for(Funcionario funcionario : funcionarios) {
                                if(funcionario.getNomeFuncionario().equalsIgnoreCase(funcRealizou)) {
                                    funcionarioEncontrado = funcionario;
                                    break;
                                }
                            }
                            if(funcionarioEncontrado != null) {
                                orcamentos.get(idFinalizar).setFuncionarioResponsavel(funcionarioEncontrado);
                                if(funcionarioEncontrado instanceof FuncionarioComissao) {
                                    funcionarioEncontrado.setFaturamento(orcamentos.get(idFinalizar).getOrcamento() * FuncionarioComissao.TAXA_COMISSAO);
                                }
                                System.out.println("Funcionario " + funcionarioEncontrado.getNomeFuncionario() + " selecionado com sucesso!");
                            }
                            System.out.println("-----Serviço:-----\n" + orcamentos.get(idFinalizar).toString() + "\n-----foi finalizado com sucesso!-----");
                            servicosFinalizados.add(orcamentos.get(idFinalizar));
                            Servico salvarServicoFinalizado = orcamentos.get(idFinalizar);
                            orcamentos.remove(idFinalizar);

                            if (salvarServicoFinalizado != null) {
                                BufferedWriter wr = null;
                                try {
                                    wr = new BufferedWriter(new FileWriter("servicosFinalizados.txt", true));

                                    wr.write(salvarServicoFinalizado.toString());
                                    wr.newLine();
                                    wr.write("-----------------------------");

                                    System.out.println("Serviço salvo com sucesso no arquivo servicosFinalizados.txt!");

                                } catch (IOException e) {
                                    System.err.println("Erro ao salvar serviço: " + e.getMessage());
                                } finally {
                                    try {
                                        if (wr != null) wr.close();
                                    } catch (IOException e) {
                                        System.err.println("Erro ao fechar o arquivo: " + e.getMessage());
                                    }
                                }
                            }

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
                    funcionarios.sort((f1, f2) -> Double.compare(f2.getFaturamento(), f1.getFaturamento()));

                    int min = Math.min(funcionarios.size(), 3);

                    for(int c = 0; c < min; c++) {
                        funcionariosDestaque[c] = funcionarios.get(c);
                        System.out.println(funcionariosDestaque[c].toString() + "\n");
                    }
                    break;
                case 10:
                    java.io.BufferedReader leitorFuncionarios = null;
                    try {
                        java.io.File file = new java.io.File("funcionarios.txt");
                        if (!file.exists()) {
                            System.err.println("O arquivo 'funcionarios.txt' não existe.");
                        } else {
                            leitorFuncionarios = new java.io.BufferedReader(new java.io.FileReader("funcionarios.txt"));
                            String linha;
                            while ((linha = leitorFuncionarios.readLine()) != null) {
                                System.out.println(linha);
                            }
                        }
                    } catch (java.io.IOException e) {
                        System.err.println("Erro ao ler o arquivo: " + e.getMessage());
                    } finally {
                        try {
                            if (leitorFuncionarios != null) {
                                leitorFuncionarios.close();
                            }
                        } catch (java.io.IOException e) {
                            System.err.println("Erro ao fechar o leitor: " + e.getMessage());
                        }
                    }
                    break;
                case 11:
                    java.io.BufferedReader leitorOrcamentos = null;
                    try {
                        java.io.File file = new java.io.File("orcamentos.txt");
                        if (!file.exists()) {
                            System.err.println("O arquivo 'orcamentos.txt' não existe.");
                        } else {
                            leitorOrcamentos = new java.io.BufferedReader(new java.io.FileReader("orcamentos.txt"));
                            String linha;
                            while ((linha = leitorOrcamentos.readLine()) != null) {
                                System.out.println(linha);
                            }
                        }
                    } catch (java.io.IOException e) {
                        System.err.println("Erro ao ler o arquivo: " + e.getMessage());
                    } finally {
                        try {
                            if (leitorOrcamentos != null) {
                                leitorOrcamentos.close();
                            }
                        } catch (java.io.IOException e) {
                            System.err.println("Erro ao fechar o leitor: " + e.getMessage());
                        }
                    }
                    break;
                case 12:
                    java.io.BufferedReader leitorServicosFinalizados = null;
                    try {
                        java.io.File file = new java.io.File("servicosFinalizados.txt");
                        if (!file.exists()) {
                            System.err.println("O arquivo 'servicosFinalizados.txt' não existe.");
                        } else {
                            leitorServicosFinalizados = new java.io.BufferedReader(new java.io.FileReader("servicosFinalizados.txt"));
                            String linha;
                            while ((linha = leitorServicosFinalizados.readLine()) != null) {
                                System.out.println(linha);
                            }
                        }
                    } catch (java.io.IOException e) {
                        System.err.println("Erro ao ler o arquivo: " + e.getMessage());
                    } finally {
                        try {
                            if (leitorServicosFinalizados != null) {
                                leitorServicosFinalizados.close();
                            }
                        } catch (java.io.IOException e) {
                            System.err.println("Erro ao fechar o leitor: " + e.getMessage());
                        }
                    }
                    break;
                case 13:
                    System.out.println("----- Lista de funcionarios -----");
                    for (int f = 0; f < funcionarios.size(); f++) {
                        funcionarios.get(f).imprimir(true);
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


