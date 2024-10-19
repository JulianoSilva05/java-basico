import java.util.InputMismatchException;
public class Calculadora {
    public static void main(String[] args) {
        //somar
        Soma.somar( 2 , 2);
    
        try{Subtrair.subtrair(15,2);
        }catch(InputMismatchException e){
            System.out.println("Erro!");
        }


    }
}
