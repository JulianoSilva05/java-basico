public class OperadorSeis {
    public static void main(String[] args) {
        //Operadores atitmeticos
        // == compara dois valores
        // != Diferente
        // > Maior
        // >= maior ou igual
        // < menor 
        // <= menor ou igual
        int numero1 = 1;
        int numero2 = 2;
        boolean condicao = numero1 == numero2;
        System.out.println("Numero 1 é igual ao 2 = "+ condicao);

        condicao = numero1 != numero2;
        System.out.println("Numero 1 é diferente de 2 = "+ condicao);

        condicao = numero1 < numero2 ? true : false;
        System.out.println("Numero 1 é menor que o 2 = "+ condicao);

        condicao = numero1 > numero2 ? true : false;
        System.out.println("Numero 1 é maior que o 2 = "+ condicao);

        String nome1 = "Juliano";
        String nome2 = new String("Juliano");
        System.out.println(nome1.equals(nome2));
    }
}
