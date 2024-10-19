import java.util.concurrent.ThreadLocalRandom;
public class ExemploWhile {
    
    /**
     * @param args
     */

    public static void main(String[] args) {
        double mesada = 50.0;
        while(mesada > 0 ){
            double valorDoce = valorAleatorio();
            if(valorDoce > mesada){
                valorDoce = mesada;
            }
        System.out.println("Doce do valor: R$" + valorDoce + " Adicionado no carrinho");
        mesada -= valorDoce;
        }
        
    }
    private static double valorAleatorio(){
        return ThreadLocalRandom.current().nextDouble(2,8);
    }
}
