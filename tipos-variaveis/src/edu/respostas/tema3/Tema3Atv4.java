//RESPOSTA
/*
 * Implemente um validador de senhas que verifique se uma string contém pelo menos 8 caracteres, usando o método length() .
 */
import java.util.Scanner;
public class Tema3Atv4 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Senha: ");
        String senha = ler.nextLine();
        //senha.length(); // retorna o tamanho da String
        int tamanho = senha.length();
        if(tamanho >= 8){
            System.out.println("Senha ok");
        }else{
            System.out.println("Senha inválida");
        }
    }
}
