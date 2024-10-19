import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
public class AboutMe {
    public static void main(String[] args) throws Exception {
        try{

            Scanner ler = new Scanner(System.in).useLocale(Locale.US);
            System.out.println("Digite seu nome: ");
            String nome = ler.next();
            
            System.out.println("Digite seu sobrenome");
            String sobrenome = ler.next();
            
            System.out.println("Digite sua idade: ");
            int idade = ler.nextInt();
            
            System.out.println("Digite sua altura: ");
            double altura = ler.nextDouble();
            
            System.out.println("Olá. me chamo " + nome.toUpperCase() + " " + sobrenome.toUpperCase());
            System.out.println("Tenho " + idade + " anos");
            System.out.println("Minha altura é " + altura +" cm");
        }catch(InputMismatchException e){
            System.err.println("Os campos idade e altura devem ser numericos");
        }

    }
}
