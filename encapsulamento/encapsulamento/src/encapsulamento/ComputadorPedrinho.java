package encapsulamento;
public class ComputadorPedrinho {
	public static void main(String[] args) {
		tool.saldacao();
		//abrindo MSN Mensseger
		MSNMessenger msn = new MSNMessenger();
		tool.linha("MSN");
		msn.enviarMensagem();
		msn.receberMensagem();
		
		
		FacebookMessenger fcb = new FacebookMessenger();
		tool.linha("Facebook");
		fcb.enviarMensagem();
		fcb.receberMensagem();
		
		
		Telegram  tlg = new Telegram ();
		tool.linha("Telegram");
		tlg.enviarMensagem();
		tlg.receberMensagem();
		
		
	}

}
