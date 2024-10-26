package encapsulamento;

public class FacebookMessenger extends ServicoMensagemInstantanea{
	@Override
	public void enviarMensagem() {
		System.out.println("Enviando mensagem pelo Fecebook Messenger");
	}
	@Override
	public void receberMensagem() {
		System.out.println("Recebendo mensagem pelo Fecebook Messenger");
	}
}
