
/*
Crie um programa que substitua todas as ocorrências de 
uma letra por outra em uma string, usando o método replace().
*/
import java.util.Scanner;

public class Tema3Atv2 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite uma palavra");
        String texto = leitor.nextLine();
        System.out.println("Qual letra deseja trocar? ");
        String letraAntiga = leitor.nextLine();
        System.out.println("Por qual letra? : ");
        String letraNova = leitor.nextLine();
        // trocando as letras
        // texto.replace(letraAntiga,letraNova)
        System.out.println(texto.replace(letraAntiga, letraNova));

    }
}
