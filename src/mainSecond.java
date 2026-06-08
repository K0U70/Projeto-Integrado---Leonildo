import java.util.Scanner;

public class mainSecond {

    public static void listarContatosPorCliente(String[][] cadastroCliente, String[][] cadastroContato) {
        Scanner input = new Scanner(System.in);
        int codigoCliente = 0;

        System.out.print("Digite o código do cliente: ");
        codigoCliente = input.nextInt();
        input.nextLine();

        System.out.printf("%-10s | %-8s | %-20s | %-12s | %-25s | %-8s%n",
                "CodCont", "CodCli", "Nome Cliente", "Tipo", "Valor", "Status");
        System.out.println("-".repeat(95));

        for (int j = 0; j < cadastroContato.length; j++) {
            if (cadastroContato[j][0] != null && cadastroContato[j][1].equals(String.valueOf(codigoCliente))) {
                System.out.printf("%-10s | %-8s | %-20s | %-12s | %-25s | %-8s%n",
                        cadastroContato[j][0],
                        cadastroContato[j][1],
                        cadastroContato[j][2],
                        cadastroContato[j][3],
                        cadastroContato[j][4],
                        "ATIVO");
            }
        }
    }

    public static void incluirCliente(String[][] cadastroCliente) {
        Scanner input = new Scanner(System.in);

        int maiorCodigo = 0;
        for (int i = 0; i < cadastroCliente.length; i++) {
            if (cadastroCliente[i][0] != null) {
                int codigo = Integer.parseInt(cadastroCliente[i][0]);
                if (codigo > maiorCodigo) {
                    maiorCodigo = codigo;
                }
            }
        }

        int novoCodigo = maiorCodigo + 1;
        int linha = cadastroCliente.length - 1;

        cadastroCliente[linha][0] = String.valueOf(novoCodigo);
        System.out.print("Nome: ");
        cadastroCliente[linha][1] = input.nextLine();
        System.out.print("CPF ou CNPJ: ");
        cadastroCliente[linha][2] = input.nextLine();
        System.out.print("Data de nascimento: ");
        cadastroCliente[linha][3] = input.nextLine();
        System.out.print("Sexo: ");
        cadastroCliente[linha][4] = input.nextLine();
        System.out.print("Cidade: ");
        cadastroCliente[linha][5] = input.nextLine();
        System.out.print("Estado: ");
        cadastroCliente[linha][6] = input.nextLine();
        System.out.print("Status: ");
        cadastroCliente[linha][7] = input.nextLine();

        System.out.println("Cadastro incluído.");
    }

    public static void incluirContato(String[][] cadastroContato, String[][] cadastroCliente) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o código do cliente: ");
        int codigoCliente = input.nextInt();
        input.nextLine();

        // verificar se o cliente existe
        boolean achou = false;
        for (int i = 0; i < cadastroCliente.length; i++) {
            if (cadastroCliente[i][0] != null && Integer.parseInt(cadastroCliente[i][0]) == codigoCliente) {
                achou = true;
                break;
            }
        }

        if (!achou) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        // gerar código do contato
        int maiorCodigo = 0;
        for (int i = 0; i < cadastroContato.length; i++) {
            if (cadastroContato[i][0] != null) {
                int cod = Integer.parseInt(cadastroContato[i][0]);
                if (cod > maiorCodigo) maiorCodigo = cod;
            }
        }

        int linha = cadastroContato.length - 1;
        cadastroContato[linha][0] = String.valueOf(maiorCodigo + 1);
        cadastroContato[linha][1] = String.valueOf(codigoCliente);

        System.out.print("Tipo: ");
        cadastroContato[linha][2] = input.nextLine();

        System.out.print("Valor: ");
        cadastroContato[linha][3] = input.nextLine();

        cadastroContato[linha][4] = "ATIVO";

        System.out.println("Contato incluído!");
    }

    public static String[][] aumentarMatrizClientes(String[][] matrizAntiga) {
        String[][] nova = new String[matrizAntiga.length + 1][8];

        for (int i = 0; i < matrizAntiga.length; i++) {
            for (int j = 0; j < 8; j++) {
                nova[i][j] = matrizAntiga[i][j];
            }
        }
        return nova;
    }

    public static String[][] aumentarMatrizContatos(String[][] matrizAntiga) {
        String[][] nova = new String[matrizAntiga.length + 1][5];

        for (int i = 0; i < matrizAntiga.length; i++) {
            for (int j = 0; j < 5; j++) {
                nova[i][j] = matrizAntiga[i][j];
            }
        }
        return nova;
    }

    public static void listarClientesTabela(String[][] cadastroCliente) {
        if (cadastroCliente.length == 0) {
            System.out.println("Nenhum cadastro.");
            return;
        }

        System.out.printf("%-8s | %-20s | %-12s | %-12s | %-6s | %-18s | %-7s | %-8s%n",
                "Código", "Nome", "CPF/CNPJ", "Nascimento", "Sexo", "Cidade", "Estado", "Status");
        System.out.println("-".repeat(100));

        for (int i = 0; i < cadastroCliente.length; i++) {
            if (cadastroCliente[i][0] == null) continue;
            System.out.printf("%-8s | %-20s | %-12s | %-12s | %-6s | %-18s | %-7s | %-8s%n",
                    cadastroCliente[i][0],
                    cadastroCliente[i][1],
                    cadastroCliente[i][2],
                    cadastroCliente[i][3],
                    cadastroCliente[i][4],
                    cadastroCliente[i][5],
                    cadastroCliente[i][6],
                    cadastroCliente[i][7]);
        }
    }

    public static void listarContatosTabela(String[][] cadastroContato, String[][] cadastroCliente) {
        if (cadastroContato.length == 0) {
            System.out.println("Nenhum cadastro.");
            return;
        }

        System.out.printf("%-10s | %-8s | %-20s | %-12s | %-25s | %-8s%n",
                "CodCont", "CodCli", "Nome Cliente", "Tipo", "Valor", "Status");
        System.out.println("-".repeat(95));

        for (int i = 0; i < cadastroContato.length; i++) {
            if (cadastroContato[i][0] == null) continue;

            // JOIN manual: busca o nome do cliente pelo código
            String nomeCliente = "Não encontrado";
            for (int j = 0; j < cadastroCliente.length; j++) {
                if (cadastroCliente[j][0] != null && cadastroCliente[j][0].equals(cadastroContato[i][1])) {
                    nomeCliente = cadastroCliente[j][1];
                    break;
                }
            }

            System.out.printf("%-10s | %-8s | %-20s | %-12s | %-25s | %-8s%n",
                    cadastroContato[i][0],
                    cadastroContato[i][1],
                    nomeCliente,
                    cadastroContato[i][2],
                    cadastroContato[i][3],
                    cadastroContato[i][4]);
        }
    }

    public static void buscarClientePorCodigo(String[][] cadastroCliente) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o código que deseja pesquisar: ");
        int codigo = scan.nextInt();

        boolean achou = false;

        for (int i = 0; i < cadastroCliente.length; i++) {
            if (cadastroCliente[i][0] != null && Integer.parseInt(cadastroCliente[i][0]) == codigo) {
                achou = true;

                System.out.printf("%-8s | %-20s | %-12s | %-12s | %-6s | %-18s | %-7s | %-8s%n",
                        "Código", "Nome", "CPF/CNPJ", "Nascimento", "Sexo", "Cidade", "Estado", "Status");
                System.out.println("-".repeat(100));
                System.out.printf("%-8s | %-20s | %-12s | %-12s | %-6s | %-18s | %-7s | %-8s%n",
                        cadastroCliente[i][0],
                        cadastroCliente[i][1],
                        cadastroCliente[i][2],
                        cadastroCliente[i][3],
                        cadastroCliente[i][4],
                        cadastroCliente[i][5],
                        cadastroCliente[i][6],
                        cadastroCliente[i][7]);
                break;
            }
        }

        if (!achou) {
            System.out.println("Cliente não encontrado!");
        }
    }

    public static void alterarCliente(String[][] cadastroCliente) {
        Scanner scan = new Scanner(System.in);

        if (cadastroCliente.length == 0) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Código  |    Nome     |   CPF/CNPJ    | Nasc.     |  Sexo  |   Cidade   | Estado |  Status");
        System.out.println("-".repeat(88));

        for (int i = 0; i < cadastroCliente.length; i++) {
            if (cadastroCliente[i][0] == null) continue;
            System.out.println(
                    cadastroCliente[i][0] + "    |    " +
                            cadastroCliente[i][1] + "    |    " +
                            cadastroCliente[i][2] + "    |    " +
                            cadastroCliente[i][3] + "    |    " +
                            cadastroCliente[i][4] + "    |    " +
                            cadastroCliente[i][5] + "    |    " +
                            cadastroCliente[i][6] + "    |    " +
                            cadastroCliente[i][7] + "    |    "
            );
            System.out.println("-".repeat(88));
        }

        System.out.print("Qual o código do cliente que deseja alterar: ");
        String codBuscado = scan.nextLine();

        int indice = -1;
        for (int i = 0; i < cadastroCliente.length; i++) {
            if (cadastroCliente[i][0] != null && cadastroCliente[i][0].equals(codBuscado)) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("-".repeat(88));
        System.out.println("Cliente encontrado:");
        System.out.println("Código: "  + cadastroCliente[indice][0]);
        System.out.println("Nome:     " + cadastroCliente[indice][1]);
        System.out.println("CPF/CNPJ: " + cadastroCliente[indice][2]);
        System.out.println("Nasc.:    " + cadastroCliente[indice][3]);
        System.out.println("Sexo:     " + cadastroCliente[indice][4]);
        System.out.println("Cidade:   " + cadastroCliente[indice][5]);
        System.out.println("Estado:   " + cadastroCliente[indice][6]);
        System.out.println("Status:   " + cadastroCliente[indice][7]);
        System.out.println("-".repeat(88));

        System.out.print("Deseja alterar este cliente? (S/N): ");
        String confirmacao = scan.nextLine().toUpperCase();

        if (confirmacao.equals("S")) {

            System.out.print("Novo nome: ");
            cadastroCliente[indice][1] = scan.nextLine();

            System.out.print("Novo CPF/CNPJ: ");
            cadastroCliente[indice][2] = scan.nextLine();

            System.out.print("Novo Nascimento: ");
            cadastroCliente[indice][3] = scan.nextLine();

            System.out.print("Novo Sexo: ");
            cadastroCliente[indice][4] = scan.nextLine();

            System.out.print("Nova Cidade: ");
            cadastroCliente[indice][5] = scan.nextLine();

            System.out.print("Novo Estado: ");
            cadastroCliente[indice][6] = scan.nextLine();

            System.out.print("Novo Status: ");
            cadastroCliente[indice][7] = scan.nextLine();

            System.out.println("Cliente alterado com sucesso!");
        } else {
            System.out.println("Operação Cancelada");
        }
    }

    public static String[][] apagarCliente(String[][] matrizAntiga) {
        Scanner scan = new Scanner(System.in);

        String[][] nova = new String[matrizAntiga.length - 1][8];

        listarClientesTabela(matrizAntiga);

        if (matrizAntiga.length > 0) {

            System.out.println("Digite o código:");
            int codigo = scan.nextInt();
            int linhaNova = 0;
            for (int i = 0; i < matrizAntiga.length; i++) {
                if (i != codigo) {
                    for (int j = 0; j < 3; j++) {
                        nova[linhaNova][j] = matrizAntiga[i][j];
                    }
                    linhaNova++;
                }
            }
        }
        return nova;
    }

    public static boolean compararNomeCharPorChar(String nome1, String nome2) {

        nome1 = nome1.toUpperCase();
        nome2 = nome2.toUpperCase();

        int menorTamanho;

        if (nome1.length() < nome2.length()) {
            menorTamanho = nome1.length();
        } else {
            menorTamanho = nome2.length();
        }

        for (int i = 0; i < menorTamanho; i++) {

            char letra1 = nome1.charAt(i);
            char letra2 = nome2.charAt(i);

            if (letra1 > letra2) {
                return true;
            }

            if (letra1 < letra2) {
                return false;
            }
        }

        if (nome1.length() > nome2.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void ordenarClientesPorNome(String[][] cadastroCliente) {

        for (int i = 0; i < cadastroCliente.length - 1; i++) {
            for (int j = i + 1; j < cadastroCliente.length; j++) {

                if (compararNomeCharPorChar(cadastroCliente[i][1], cadastroCliente[j][1])) {

                    for (int col = 0; col < 8; col++) {
                        String temp = cadastroCliente[i][col];
                        cadastroCliente[i][col] = cadastroCliente[j][col];
                        cadastroCliente[j][col] = temp;
                    }
                }
            }
        }
    }

    public static void alterarContato(String[][] cadastroContato, String[][] cadastroCliente) {
        Scanner scan = new Scanner(System.in);

        System.out.println("CodCont | CodCli | Nome Cliente          | Tipo      | Valor                | Status");
        System.out.println("-".repeat(88));

        for (int i = 0; i < cadastroContato.length; i++) {
            if (cadastroContato[i][0] == null) continue;

            String nomeCliente = "Não encontrado";
            for (int j = 0; j < cadastroCliente.length; j++) {
                if (cadastroCliente[j][0].equals(cadastroContato[i][1])) {
                    nomeCliente = cadastroCliente[j][1];
                    break;
                }
            }

            System.out.println(
                    cadastroContato[i][0] + "       | " +
                            cadastroContato[i][1] + "      | " +
                            nomeCliente + "  | " +
                            cadastroContato[i][2] + "  | " +
                            cadastroContato[i][3] + "  | " +
                            cadastroContato[i][4]
            );
        }

        System.out.println("-".repeat(88));
        System.out.print("Digite o CodCont do contato que deseja alterar: ");
        String codBuscado = scan.nextLine();

        int indice = -1;
        for (int i = 0; i < cadastroContato.length; i++) {
            if (cadastroContato[i][0].equals(codBuscado)) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            System.out.println("Contato não encontrado!");
            return;
        }

        System.out.println("-".repeat(88));
        System.out.println("CodCont: " + cadastroContato[indice][0]);
        System.out.println("CodCli:  " + cadastroContato[indice][1]);
        System.out.println("Tipo:    " + cadastroContato[indice][2]);
        System.out.println("Valor:   " + cadastroContato[indice][3]);
        System.out.println("Status:  " + cadastroContato[indice][4]);
        System.out.println("-".repeat(88));

        System.out.print("Deseja alterar este contato? (S/N): ");
        String confirmar = scan.nextLine().toUpperCase();

        if (confirmar.equals("S")) {

            System.out.println("Digite os novos dados:");

            System.out.print("Tipo (email/telefone): ");
            cadastroContato[indice][2] = scan.nextLine();

            System.out.print("Valor: ");
            cadastroContato[indice][3] = scan.nextLine();

            cadastroContato[indice][4] = "Ativo";

            System.out.println("Contato alterado com sucesso!");
        } else
            System.out.println("Operação Cancelada");
    }

    public static String[][] apagarContato(String[][] cadastroContato, String[][] cadastroCliente) {
        Scanner scan = new Scanner(System.in);

        int count = 0;
        for (int i = 0; i < cadastroContato.length; i++) {
            if (cadastroContato[i][0] != null) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Nenhum contato cadastrado.");
            return cadastroContato;
        }

        System.out.println("CodCont | CodCli | Nome Cliente | Tipo | Valor | Status");
        System.out.println("-".repeat(count));

        for (int i = 0; i < cadastroContato.length; i++) {
            if (cadastroContato[i][0] == null) continue;

            String nomeCliente = "Não encontrado";
            for (int k = 0; k < cadastroCliente.length; k++) {
                if (cadastroCliente[k][0] != null && cadastroCliente[k][0].equals(cadastroContato[i][1])) {
                    nomeCliente = cadastroCliente[k][1];
                    break;
                }
            }

            System.out.println(cadastroContato[i][0] + " | " + cadastroContato[i][1] + " | " + nomeCliente + " | " + cadastroContato[i][2] + " | " + cadastroContato[i][3] + " | " + cadastroContato[i][4]);
        }

        System.out.println("-".repeat(count));

        System.out.print("Digite o CodCont do contato que deseja apagar: ");
        String codBuscado = scan.nextLine();

        int indice = -1;
        for (int i = 0; i < cadastroContato.length; i++) {
            if (cadastroContato[i][0] != null && cadastroContato[i][0].equals(codBuscado)) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            System.out.println("Contato não encontrado!");
            return cadastroContato;
        }

        System.out.println("-".repeat(count));
        System.out.println("Contato encontrado:");
        System.out.println("CodCont: " + cadastroContato[indice][0]);
        System.out.println("CodCli:  " + cadastroContato[indice][1]);
        System.out.println("Tipo:    " + cadastroContato[indice][2]);
        System.out.println("Valor:   " + cadastroContato[indice][3]);
        System.out.println("Status:  " + cadastroContato[indice][4]);
        System.out.println("-".repeat(count));

        System.out.print("Deseja apagar este contato? (S/N): ");
        String confirmacao = scan.nextLine();

        if (!confirmacao.equalsIgnoreCase("S")) {
            System.out.println("Remoção cancelada.");
            return cadastroContato;
        }

        String[][] nova = new String[cadastroContato.length - 1][5];
        int linhaNova = 0;

        for (int i = 0; i < cadastroContato.length; i++) {
            if (i != indice) {
                for (int j = 0; j < 5; j++) {
                    nova[linhaNova][j] = cadastroContato[i][j];
                }
                linhaNova++;
            }
        }

        return nova;
    }

    public static void relatorioClientesContatos(String[][] cadastroCliente, String[][] cadastroContato) {
        System.out.println("=== RELATÓRIO: CLIENTES E TOTAL DE CONTATOS ===");
        System.out.println("-".repeat(50));

        int totalClientes = 0;
        int totalContatos = 0;
        int clientesSemContato = 0;

        for (int i = 0; i < cadastroCliente.length; i++) {
            if (cadastroCliente[i][0] == null) continue;

            totalClientes++;

            int contatosDoCliente = 0;
            for (int j = 0; j < cadastroContato.length; j++) {
                if (cadastroContato[j][0] != null &&
                        cadastroContato[j][0].equals(cadastroCliente[i][0])) {
                    contatosDoCliente++;
                }
            }

            if (contatosDoCliente == 0) clientesSemContato++;
            totalContatos += contatosDoCliente;

            System.out.println("Código: " + cadastroCliente[i][0]);
            System.out.println("Nome:   " + cadastroCliente[i][1]);
            System.out.println("Total de contatos: " + contatosDoCliente);
            System.out.println("-".repeat(50));
        }

        System.out.println("Total de clientes:    " + totalClientes);
        System.out.println("Total de contatos:    " + totalContatos);
        System.out.println("Sem contato:          " + clientesSemContato);
        System.out.println("=".repeat(50));
    }

    public static void relatorio(String[][] cadastroCliente, String[][] cadastroContato) {
        System.out.println("=== RELATÓRIO: SUMARIZAÇÃO DE DADOS ===");
        System.out.println("-".repeat(50));

        int totalClientes = 0;
        int totalContatos = 0;
        int clientesSemContato = 0;

        for (int i = 0; i < cadastroCliente.length; i++) {
            if (cadastroCliente[i][0] == null) continue;
            totalClientes++;

            int contatosDoCliente = 0;
            for (int j = 0; j < cadastroContato.length; j++) {
                if (cadastroContato[j][0] != null &&
                        cadastroContato[j][0].equals(cadastroCliente[i][0])) {
                    contatosDoCliente++;
                }
            }
            if (contatosDoCliente == 0) clientesSemContato++;
            totalContatos += contatosDoCliente;
        }

        double media = (totalClientes > 0) ? (double) totalContatos / totalClientes : 0;

        System.out.println("Total de clientes:          " + totalClientes);
        System.out.println("Total de contatos:          " + totalContatos);
        System.out.printf( "Contatos por cliente (med): %.2f%n", media);
        System.out.println("Clientes sem contato:       " + clientesSemContato);
        System.out.println("=".repeat(50));
    }

    public static void main(String[] args) {
        String[][] cadastroCliente = new String[0][8];
        String[][] cadastroContato = new String[0][5];

        Scanner input = new Scanner(System.in);

        int opcaoUsuario = 0;
        int opcaoPrincipal = 0;

        do {
            System.out.println("1 - Gerenciar clientes");
            System.out.println("2 - Gerenciar contatos");
            System.out.println("3 - Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Selecione uma opção:");
            opcaoPrincipal = input.nextInt();

            if (opcaoPrincipal == 1) {
                do {
                    System.out.println("1 - Incluir cliente");
                    System.out.println("2 - Listar clientes");
                    System.out.println("3 - Consultar cliente por código");
                    System.out.println("4 - Alterar cliente");
                    System.out.println("5 - Apagar cliente");
                    System.out.println("6 - Ordenar por nome");
                    System.out.println("0 - Voltar");
                    System.out.print("Digite uma opção:");
                    opcaoUsuario = input.nextInt();

                    if (opcaoUsuario == 1) {
                        cadastroCliente = aumentarMatrizClientes(cadastroCliente);
                        incluirCliente(cadastroCliente);
                    } else if (opcaoUsuario == 2) {
                        listarClientesTabela(cadastroCliente);
                    } else if (opcaoUsuario == 3) {
                        buscarClientePorCodigo(cadastroCliente);
                    } else if (opcaoUsuario == 4) {
                        alterarCliente(cadastroCliente);
                    } else if (opcaoUsuario == 5) {
                        cadastroCliente = apagarCliente(cadastroCliente);
                    } else if (opcaoUsuario == 6) {
                        ordenarClientesPorNome(cadastroCliente);
                        System.out.println("Cadastro ordenado!");
                    } else if (opcaoUsuario == 0) {
                        System.out.println("Retornando ao menu!");
                    } else {
                        System.out.println("Opção inválida!");
                    }

                } while (opcaoUsuario != 0);

            } else if (opcaoPrincipal == 2) {
                do {
                    System.out.println("1 - Incluir contato");
                    System.out.println("2 - Listar contatos (Todos os clientes)");
                    System.out.println("3 - Listar contatos de um cliente");
                    System.out.println("4 - Alterar contato");
                    System.out.println("5 - Apagar contato");
                    System.out.println("0 - Voltar");
                    System.out.print("Digite uma opção:");
                    opcaoUsuario = input.nextInt();

                    if (opcaoUsuario == 1) {
                        cadastroContato = aumentarMatrizContatos(cadastroContato);
                        incluirContato(cadastroContato, cadastroCliente);
                    } else if (opcaoUsuario == 2) {
                        listarContatosTabela(cadastroContato, cadastroCliente);
                    } else if (opcaoUsuario == 3) {
                        // CORRIGIDO: parâmetros estavam invertidos na chamada original
                        listarContatosPorCliente(cadastroCliente, cadastroContato);
                    } else if (opcaoUsuario == 4) {
                        alterarContato(cadastroContato, cadastroCliente);
                    } else if (opcaoUsuario == 5) {
                        cadastroContato = apagarContato(cadastroContato, cadastroCliente);
                    } else if (opcaoUsuario == 0) {
                        System.out.println("Retornando ao menu!");
                    }
                } while (opcaoUsuario != 0);

            } else if (opcaoPrincipal == 3) {
                do {
                    System.out.println("1 - Clientes e total de contatos");
                    System.out.println("2 - Relatório");
                    System.out.println("0 - Voltar");
                    System.out.print("Digite uma opção: ");
                    opcaoUsuario = input.nextInt();

                    if (opcaoUsuario == 1) {
                        relatorioClientesContatos(cadastroCliente, cadastroContato);
                    } else if (opcaoUsuario == 2) {
                        relatorio(cadastroCliente, cadastroContato);
                    } else if (opcaoUsuario == 0) {
                        System.out.println("Retornando ao menu!");
                    } else {
                        System.out.println("Opção inválida!");
                    }

                } while (opcaoUsuario != 0);
            }
        } while (opcaoPrincipal != 0);
    }
}