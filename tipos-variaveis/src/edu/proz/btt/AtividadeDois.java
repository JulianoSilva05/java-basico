package edu.proz.btt;
import java.util.Scanner;
public class AtividadeDois {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        System.out.println("Primeiro Nome: ");
        String x = ler.nextLine();
        System.out.println("Sobrenome: ");
        String y = ler.nextLine();
        System.out.println("Seu nome é: " + y + " " + x);
    }
}