package edu.proz.btt;

public class ContarVogais{
    public static void main(String[] args) {
        //retornar a quantidade de caracteres
        String frase = "A proz é a melhor escola do Brasil";
        int tamanho = frase.length();
        System.out.println(tamanho);

        //retorna um caractere em uma posição especifica
        int posicao = 0;
        char letra = frase.charAt(posicao);
        System.out.println("Letra na posição "+ posicao + " = " + letra);
        String fraseMaiuscula = frase.toUpperCase();

        // Contar a quantidade de vogais
        posicao = 0;
        int qntVogais = 0;
        String vogais = "AEIOUaeiou"; // Verificar tanto maiúsculas quanto minúsculas
        while (posicao < tamanho) {
            char atual = frase.charAt(posicao);
            System.out.println("PALAVRA ATUAL = "+ atual);
            
            if (vogais.indexOf(atual) != -1) {
                qntVogais++;
                System.out.println("vogais: " + qntVogais);
            }
            posicao++;
        }
        System.out.println("Quantidade de vogais: " + qntVogais);
    }
}


