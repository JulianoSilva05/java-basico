package edu.classe;

public class ClassePrincipal {
    public static void main(String[] args) {
        // Criar uma moto
        Moto motoUm = new Moto();
        motoUm.anoFabricacao = 2024;
        motoUm.marca = "Honda";
        motoUm.cilindrada = 150;
        motoUm.modelo = "CG 160 - Titan";
        motoUm.velocidade = 20;

        motoUm.acelerar();
        motoUm.informacoesMoto();
        // motoUm.informacoesMoto();

    }
}
