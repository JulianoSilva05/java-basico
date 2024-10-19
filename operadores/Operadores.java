
import java.util.Date;

public class Operadores {
    public static void main(String[] args) {
        // Variaveis
        String nome = "Juliano";
        int idade = 21;
        double peso = 68.5;
        char sexo = 'M';
        boolean estudante = true;
        Date dataNascimento = new Date();

        // Operadores
        double soma = 10.5 + 15.7;
        int subtracao = 113 - 25;
        int multiplicacao = 20 * 7;
        int divisao = 15 / 3;
        int modulo = 18 % 3;
        double resultado = (10 * 7) + (20 / 4);

        // Concatenação
        String nomeCompleto = "Juliano" + "Silva";
        System.err.println(nomeCompleto);

        // qual o resultado da expressão abaixo
        String concatenacao = "?";

        concatenacao = 1 + 1 + 1 + "1";
        System.out.println(concatenacao);

        concatenacao = 1 + 1  + "1" + 1;
        System.out.println(concatenacao);

        concatenacao = 1   + "1" + 1 + 1;
        System.out.println(concatenacao);

        concatenacao = "1"+ (1 + 1 + 1);
        System.out.println(concatenacao);
    }
}
