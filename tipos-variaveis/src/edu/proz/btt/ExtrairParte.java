package edu.proz.btt;

public class ExtrairParte {
    public static void main(String[] args) {
        //Extrair parte de frases
        String frase = "A proz é a melhor escola do Brasil";
        int inicio = 0;
        int fim = 24;
        String parteTexto = frase.substring(inicio,fim);
        System.out.println(parteTexto);
    }
}
