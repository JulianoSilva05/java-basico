package encapsulamento;

public  class Telegram extends ServicoMensagemInstantanea{

	@Override
	public void enviarMensagem() {
		System.out.println("Enviando mensagem pelo Telegram Messenger");
	}
	@Override
	public void receberMensagem() {
		System.out.println("Recebendo mensagem pelo Telegram Messenger");
	}
	
}
