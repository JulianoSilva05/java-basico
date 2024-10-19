package edu.respostas.tema5;

import java.util.Scanner;

public class Atv2 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int num = 0;
        int total = 100;
        int soma = 0;
        while(soma <= total){
            System.out.println("Digite um numero: ");
            num = leitor.nextInt();
            if (num <= total) {
                soma = soma + num;
                System.out.println("Soma atual = " + soma);
                if(soma >=100){
                    break;
                }
            } else if (num > 100) {
                System.out.println("O valor da soma não pode ser maior que 100");
                System.out.println("Digite um valor menor que " + total);
            }
            
        }

    }
}
