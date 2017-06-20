package design.patterns.strategy.exerc�cio;

public class Testa {

	public static void main(String[] args) {
		Investidor conservador = new Conservador();
		Investidor moderado = new Moderado();
		Investidor arrojado = new Arrojado();
		
		Conta conta = new Conta(100);
		
		RealizadorDeInvestimento realizadorDeInvestimento = new RealizadorDeInvestimento();
		
		realizadorDeInvestimento.investir(conta, arrojado);
		
		System.out.println("saldo: " + conta.getValor());
	}
	
}
