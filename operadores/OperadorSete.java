public class OperadorSete {
    public static void main(String[] args) {
        //Operadores logicos
        //&& e
        //  V e V = V
        // V e F = F
        // F e F = F
        // || ou
        // V || V = V
        // V || F = V
        // F || F = F
        boolean condicao1 = true;
        boolean condicao2 = false;
        //condicao1 = !condicao1;
        
        if ( condicao1 & condicao2){
            System.out.println("As duas são verdadeiras");
        }else if (condicao1 || condicao2){
            System.out.println("Pelo menos uma é verdadeira!");
        }
        System.out.println("FIM");
    }
}
