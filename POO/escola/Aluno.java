package escola;

public class Aluno {
	private String nome;
	private int idade;
	private String sexo;
	//O metodo get é responsavel por obter o valor atual do atributo, logo ele precisa ser PUBLIC retonar um tipo correspondente ao valor.
	//Ex.: public String getNome() {};
	public String getNome() {
		return nome;
	}
	/*
	 * @param setNome
	 *	O método SET é responsável por definir ou modificar o valor de um 
	 *	atributo em um objeto, logo ele também precisa ser PUBLIC, 
	 *	receber um parâmetro do mesmo tipo da variável mas não retorna
	 *	nenhum valor void.
	 *	Ex.: public void setNome(String newNome){} ;
	 * */
	public void setNome(String newNome) {
		this.nome = newNome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getSexo() {
		return sexo;
	}
}
