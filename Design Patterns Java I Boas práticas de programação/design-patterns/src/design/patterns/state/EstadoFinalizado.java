package design.patterns.state;

public class EstadoFinalizado implements Estado {

	@Override
	public double desconto(Orcamento orcamento) {
		throw new RuntimeException("Or�amento finalizado n�o tem desconto");
	}

	@Override
	public Estado aprovar(Orcamento orcamento) {
		throw new RuntimeException("Or�amento finalizado n�o pode ser alterado");
	}

	@Override
	public Estado reprovar(Orcamento orcamento) {
		throw new RuntimeException("Or�amento finalizado n�o pode ser alterado");
	}

	@Override
	public Estado finalizar(Orcamento orcamento) {
		throw new RuntimeException("Or�amento finalizado n�o pode ser alterado");
	}

}
