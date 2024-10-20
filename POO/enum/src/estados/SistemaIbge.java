package estados;

public class SistemaIbge {
	public static void main(String[] args) {
		System.out.println("SIGLA\t NOME\t COD. IBGE");
		for(EstadoBrasileiro e : EstadoBrasileiro.values()) {
			System.out.println(e.getSigla()+"\t"+e.getNomeMaiusculo()+"\t"+e.getIbge());
						
		}
		EstadoBrasileiro eb = EstadoBrasileiro.MINAS_GERAIS;
		System.out.println("MG " + eb.getNomeMaiusculo());
}
}
