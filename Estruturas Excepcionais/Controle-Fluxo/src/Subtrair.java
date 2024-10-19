import java.util.InputMismatchException;
public class Subtrair {
     int num1 ;
     int num2 ;
     int subtracao;
    public static void  subtrair(int n1, int n2){
        try{int sub = n1 - n2;
        System.out.println(sub);
    }catch(InputMismatchException e){
        System.out.println("Valor invalido");
    }
    
}
}
