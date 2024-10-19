package edu.respostas.tema5;

import java.util.Scanner;
public class Teste {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um numero");
        int x = ler.nextInt();
        System.out.println("Digite outro numero");
        int y = ler.nextInt();
        if( x > y ){
            System.out.println(x);
        }else if( x == y ){
            System.out.println(x + " " + y);
        }else{
            System.out.println(y);
        }
    }
}


/*
 Na linguagem de programação Java, para criarmos um Objeto temos que digitar o nome da classe seguido do nome do objeto e após o operador de atribuição digitamos uma palavra reservada pelo sistema que representa o ato de criação de um novo objeto. Marque a opção correspondente a esta palava:
a) main
b) public
c) class
d) private
e) new
*/