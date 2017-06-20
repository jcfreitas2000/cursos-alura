package design.patterns.state;

public class EstadoReprovado implements Estado {

	@Override
	public double desconto(Orcamento orcamento) {
		throw new RuntimeException("Or�amento reprovado n�o tem desconto");
	}

	@Override
	public Estado aprovar(Orcamento orcamento) {
		throw new RuntimeException("Or�amento reprovado n�o pode ser aprovado");
	}

	@Override
	public Estado reprovar(Orcamento orcamento) {
		throw new RuntimeException("Or�amento reprovado n�o pode ser reprovado");
	}

	@Override
	public Estado finalizar(Orcamento orcamento) {
		return new EstadoFinalizado();
	}

}
