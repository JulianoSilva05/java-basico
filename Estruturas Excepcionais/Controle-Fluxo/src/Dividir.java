public class Dividir {
    public static void main(String[] args) {
        double numeral = 5;
        double divisor = 0;
        double dividendo;

        try {
            if (divisor == 0) {
                throw new ArithmeticException("Divisão por zero");
            }
            dividendo = numeral / divisor;
            System.out.println(dividendo);
        } catch (ArithmeticException e) {
            System.out.println("Número não pode ser divisível por 0");
        }
    }
}