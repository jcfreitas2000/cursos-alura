package design.patterns.strategy;

public class CalculadorDeImpostos {

	public void calculaImposto(Orcamento orcamento, Imposto imposto){
		double valor = orcamento.getValor() + imposto.calcula(orcamento);
		
		System.out.println(valor);
	}
}
