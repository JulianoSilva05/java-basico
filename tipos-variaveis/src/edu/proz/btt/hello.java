package edu.proz.btt;

import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite uma frase: ");
        String frase = ler.nextLine();
        frase.toLowerCase();
        int cont = 0;
        int contarVogais = 0;
        while (cont < frase.length()) {
            char letra = frase.charAt(cont);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                contarVogais++;
            }
            cont++;
        }
        System.out.println("Quantidade de Vogais: " + contarVogais);
    }
}
