public class CaixaEletronico {
    /**
     * @param args
     */
    public static void main(String[] args) {
        double saldo = 25.0;
        double valorSolicitado = 30.0;

        if(valorSolicitado < saldo){
            saldo = saldo - valorSolicitado;  
        }else{
            System.out.printf("Saldo insufuciente: R$%.2f",saldo);
        }
    }
}
