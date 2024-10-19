package edu.classe;

public class Veiculo {
    public String modelo;
    public String marca;
    public int anoFabricacao;
    public float velocidade = 0;

    public void acelerar() {
        velocidade += 10;
    }

    public void informacoes() {
        System.out.println("Dados do carro: ");
        System.out.println("Modelo: " + modelo);
        System.out.println("Marca: " + marca);
        System.out.println("Ano de Fabricação: " + anoFabricacao);
        System.out.println("Sua velocidade atual é: " + velocidade);
    }
}

