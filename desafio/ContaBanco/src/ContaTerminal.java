import java.util.Scanner;
public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        int conta;
        String agencia, nomeCliente;
        double saldo;

        System.out.print("Por favor, digite o número da Conta: ");
        conta = ler.nextInt();
        System.out.print("Por favor, digite o número da Agência: ");
        agencia = ler.next();
        ler.nextLine();  // Limpa o buffer do scanner
        System.out.print("Por favor, Qual seu nome: ");
        nomeCliente = ler.nextLine();
        System.out.print("Qual o saldo: ");
        saldo = ler.nextDouble();

        System.out.println(String.format("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s , conta %d e seu saldo  R$%.2f já está disponível para saque",nomeCliente,agencia,conta,saldo));
        ler.close();
    }
}
