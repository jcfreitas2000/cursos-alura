package design.patterns.chain.of.responsability.exerc�cio;

public interface Resposta {

	public String responde (Requisicao requisicao, Conta conta);
	public void setProxima(Resposta resposta);
}
