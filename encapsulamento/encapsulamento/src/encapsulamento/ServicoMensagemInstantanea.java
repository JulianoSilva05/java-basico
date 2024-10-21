package encapsulamento;

public class ServicoMensagemInstantanea {
	public void enviarMensagem() {
		//primeiro confirma se está conectado a internet
		validarConectadoInternet();
		System.out.println("Enviando mensagem");
		salvarHistoricoMensagem();
	}
	public void receberMensagem() {
		System.out.println("Recebendo Mensagem");
		salvarHistoricoMensagem();
	}
	private void validarConectadoInternet() {
		System.out.println("Validando se está conectado a internet");
	}
	private void salvarHistoricoMensagem() {
		System.out.println("Salvando o historico da mensagem");
	}
}
