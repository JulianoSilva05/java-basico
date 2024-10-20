package planeta;

public class SistemaCadastro {
	public static void main(String[] args) { 
		//criamos uma pessoa no sistema
		Pessoa marcos = new Pessoa("Marcos","321");
		Pessoa juliano = new Pessoa("Juliano Silva","0999");
		
	//definimos o endereço de marcos
	marcos.setEndereco("Rua A, 123, Centro - BH");
	
	System.out.println(marcos.getNome() + "\t" + marcos.getCpf());
	System.out.println("NOME : 	" + juliano.getNome()+ "\tCPF: " + juliano.getCpf());
	}
}
