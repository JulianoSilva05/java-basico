//Desenvolva um programa que encontre a primeira e a última ocorrência de uma letra em uma frase, usando os métodos indexOf() e lastIndexOf().
import java.util.Scanner;
public class Tema3Atv5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite uma frase:");
        String frase = scanner.nextLine();
        
        System.out.println("Digite a letra que deseja procurar:");
        char letra = scanner.next().charAt(0);
        
        int primeiraOcorrencia = frase.indexOf(letra);
        int ultimaOcorrencia = frase.lastIndexOf(letra);
        
        if (primeiraOcorrencia != -1) {
            System.out.println("A primeira ocorrência da letra '" + letra + "' está na posição: " + primeiraOcorrencia);
            System.out.println("A última ocorrência da letra '" + letra + "' está na posição: " + ultimaOcorrencia);
        } else {
            System.out.println("A letra '" + letra + "' não foi encontrada na frase.");
        }
        
        scanner.close();
    }
}
