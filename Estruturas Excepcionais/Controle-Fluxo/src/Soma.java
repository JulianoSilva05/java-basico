
import java.util.InputMismatchException;

public class Soma {
    private int num1;
    private int num2;
    private int soma;

    // Getter and Setters
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getSoma() {
        return soma;
    }

    public void setSoma(int soma) {
        this.soma = soma;
    }

    // Método estático
    public static void somar(int n1, int n2) {
        Soma s = new Soma();
        s.setNum1(n1);
        s.setNum2(n2);
        try {
            s.setSoma(s.getNum1() + s.getNum2());
            System.out.println(s.getSoma());
        } catch (InputMismatchException e) {
            System.out.println("Digite um valor valido");
        }
    }
}
