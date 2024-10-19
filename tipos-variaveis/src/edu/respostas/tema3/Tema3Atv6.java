import java.util.Scanner;

public class Tema3Atv6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um texto:");
        String texto = scanner.nextLine();

        char primeiro = texto.charAt(0);
        char ultimo = texto.charAt(texto.length() - 1);

        System.out.println("Primeiro caractere: " + primeiro);
        System.out.println("Último caractere: " + ultimo);

        scanner.close();
    }
}