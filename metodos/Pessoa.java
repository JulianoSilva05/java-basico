package metodos;

import java.util.Scanner;
public class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private int idade;
    private float altura;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    /* 
    public Pessoa(String nome, String endereco,String telefone, int idade, float altura){
        * 
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
        setIdade(idade);
        setAltura(altura);
    }
    */
    
    public void info(){
        System.out.println("Dados do cadastro:");
        System.out.println("Nome:\t" + getNome() + "\nEndereço:\t" + getEndereco() + "\nTelefone:\t"+ getTelefone() + "\nIdade:\t" + getIdade() + "\nAltura:\t" + getAltura());
    }
    public void Registrar(){
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite seu primeiro nome: \t");
        String n = ler.next();
        System.out.print("Endereço: \t");
        ler.next();
        String end = ler.nextLine();
        System.out.print("Telefone: \t");
        String tel = ler.next();
        System.out.print("Idade: \t");
        int ida = ler.nextInt();
        System.out.print("Altura: \t");
        float alt = ler.nextFloat();
        setNome(n);
        setEndereco(end);
        setTelefone(tel);
        setIdade(ida);
        setAltura(alt);
        info();
    }

    public static void main(String[] args) {
        Pessoa n = new Pessoa();
        n.Registrar();
        

    }
}
