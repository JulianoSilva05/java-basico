
//Escreva um programa que verifique se o último caractere de uma string fornecida pelo usuário é “.”
import java.util.Scanner;

public class Tema3Atv7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma string:");
        String texto = scanner.nextLine();

        if (texto.charAt(texto.length() - 1) == '.') {
            System.out.println("O último caractere é um ponto.");
        } else {
            System.out.println("O último caractere não é um ponto.");
        }

        scanner.close();
    }
}