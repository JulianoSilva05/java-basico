public class Usuario {
    public static void main(String[] args) throws Exception {
        Info.Informacoes();
        
        
        /**
         * Abaixo estamos criando um objeto
         * @param minhaTv, da classe
         * @param SmartTv.
         */
        SmartTv minhaTv = new SmartTv();
        
        System.out.println("TV Ligada? : "+minhaTv.ligada);
        System.out.println("Canal Atual? : "+minhaTv.canal);
        System.out.println("Volume Atual? :"+ minhaTv.volume);

        minhaTv.canal = 2;
        minhaTv.ligada = true;
        minhaTv.volume = 50;

        minhaTv.informacoes();
        minhaTv.ligar();
        minhaTv.aumentarVolume();
        minhaTv.canal(12);
        minhaTv.diminuirVolume();
        minhaTv.diminuirVolume();
        minhaTv.diminuirVolume();

        minhaTv.informacoes();
    }
}
