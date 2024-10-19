public class SmartTv {
    boolean ligada = false;
    int canal = 1;
    int volume = 25;
/**
 * Este metodo fornesse informações sobre o metodo como:
 * Se a tv está ligada ou desligada com o parametro
 * @param ligada
 * Qual o canal atual com o parametro
 * @param canal
 * e o volume da TV, com o parametro 
 * @param volume
 */
    public void informacoes() {
        System.out.println("TV Ligada? : " + ligada);
        System.out.println("Canal Atual? : " + canal);
        System.out.println("Volume Atual? : " + volume);
    }

    public void canal(int ch){
        canal = ch;
    }

    public void ligar(){
        boolean ligada = true;
    }
    public void desligar(){
        boolean ligada = false;
    }
    public void aumentarVolume(){
        volume ++;
        if (volume >=100){
            volume = 100;
        }
    }
    public void diminuirVolume(){
        volume --;
        if (volume <= 0){
            volume = 0;
        }
    }

}
