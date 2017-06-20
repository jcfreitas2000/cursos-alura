package design.patterns.strategy.exerc�cio;

public class RealizadorDeInvestimento {

	public void investir(Conta conta, Investidor investidor) {
		conta.depositar(investidor.retorno(conta));
	}
}
