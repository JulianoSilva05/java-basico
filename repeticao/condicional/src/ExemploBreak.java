public class ExemploBreak {
    public static void contar(){
        for(int i = 0; i<=20; i++){
            if(i == 13){
                continue;
            }else if(i == 17){
                break;
            }
            System.out.println(i);
        }
    }
}
