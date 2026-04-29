package org.example;

import org.example.service.EnderecoService;
import java.util.Scanner;

public class Main {
    private static final EnderecoService service = new EnderecoService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String opcao = "";

        do {
            menu();
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "0":
                    System.out.println("Fechando programa...");
                    break;
                case "1":
                    service.listarEnderecos();
                    break;
                case "2":
                    service.adicionarEndereco(pedeCep());
                    break;
                case "3":
                    service.removerEndereco(pedeCep());
                    break;
                case "4":
                    service.buscarEndereco(pedeCep());
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }
        }while(!opcao.equals("0"));
    }

    private static void menu() {
        System.out.println("""
                Digite (1) para ver todos os endereços
                Digite (2) para cadastrar um novo endereço
                Digite (3) para remover um endereço cadastrado
                Digite (4) para buscar um endereço 
                Digite (0) para fechar o programa
                """);
    }

    private static String pedeCep() {
        System.out.println("Digite um cep com '-': ");
        String cep = scanner.nextLine();

        return cep;
    }
}
