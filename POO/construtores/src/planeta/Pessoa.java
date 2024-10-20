package planeta;

public class Pessoa {
	private String nome;
	private String cpf;
	private String endereco;
	
	//método contrutor
	//o nome deverá ser igual ao nome da classe
	public Pessoa() {
		super();
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa(String nome, String cpf) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
