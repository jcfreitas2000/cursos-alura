package design.patterns.chain.of.responsability.exerc�cio;

public class RealizadorDeInvestimento {

	public void investir(Conta conta, Investidor investidor) {
		conta.depositar(investidor.retorno(conta));
	}
}
