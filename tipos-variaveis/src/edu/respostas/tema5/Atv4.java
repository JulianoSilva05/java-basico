package edu.respostas.tema5;

import java.util.Scanner;

public class Atv4 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao;
        double total = 0;

        do {
            // Bebidas
            System.out.println("\t ---Menu de Bebidas--- \t");
            System.out.println("11\t Refrigegante \t R$ 5,00");
            System.out.println("12\t Suco Natural \t R$ 7,00");
            System.out.println("13\t Café \t R$ 3,50");
            System.out.println("14\t Chá \t R$ 3,00");
            // Lanches
            System.out.println("\t ---Menu de Lanches--- \t");
            System.out.println("21\t Hambúrguer \t R$ 12,00");
            System.out.println("22\t X-Tudo \t R$ 18,00");
            System.out.println("23\t Hot Dog \t R$ 8,00");
            System.out.println("24\t Coxinha \t R$ 4,00");
            System.out.println("0\t Sair");
            System.out.print("Digite a opção desejada\t ");

            opcao = ler.nextInt();

            switch (opcao) {
                case 11:
                    total += 5.00;
                    System.out.println("Refrigente adicionado ao pedido.");
                    break;
                case 12:
                    total += 7.00;
                    System.out.println("Suco Natural adicionada ao pedido.");
                    break;
                case 13:
                    total += 3.50;
                    System.out.println("Café adicionada ao pedido.");
                    break;
                case 14:
                    total += 3.00;
                    System.out.println("Chá adicionada ao pedido.");
                    break;
                case 21:
                    total += 12.00;
                    System.out.println("Hambúrguer  adicionada ao pedido.");
                    break;
                case 22:
                    total += 18.00;
                    System.out.println("X-tudo  adicionada ao pedido.");
                    break;
                case 23:
                    total += 8.00;
                    System.out.println("Hot Dog  adicionada ao pedido.");
                    break;
                case 24:
                    total += 4.00;
                    System.out.println("Coxinha  adicionada ao pedido.");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        System.out.printf("Valor total do pedido: R$ %.2f\n", total);
    }
}
