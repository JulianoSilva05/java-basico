import java.util.Scanner;

/*
 * Escreva um programa que verifique a primeira letra de uma string fornecida 
 * pelo usuário método charAt().
*/
public class Tema3Atv1 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um texto: ");
        String texto = ler.nextLine();
        // texto.charAt(0); Metodo da Classe String que imprime o caractere na posição 0
        System.out.println(texto.charAt(0));
    }
}
