package design.patterns.chain.of.responsability.exerc�cio;

public class SemResposta implements Resposta {

	@Override
	public String responde(Requisicao requisicao, Conta conta) {
		return "";
	}

	@Override
	public void setProxima(Resposta resposta) {
	}

}
