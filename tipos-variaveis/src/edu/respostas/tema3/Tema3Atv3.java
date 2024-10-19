/*
 * Escreva uma função que remova todos os espaços em branco 
 * no início e no final de uma string.
 */
public class Tema3Atv3 {
    public static void main(String[] args) {
        String texto = "   O dia está lindo!   ";//note que há espaços antes e depois do texto
        //texto.trim() - texto. -- "chama o texto"  // .trim() → Metodo da classe String que retira os espaços antes e depois
        System.out.println("Texto sem remover os espaços: ");
        System.out.println(texto);
        System.out.println("Texto após passar pelo trim()");
        System.out.println(texto.trim());
    }
}
