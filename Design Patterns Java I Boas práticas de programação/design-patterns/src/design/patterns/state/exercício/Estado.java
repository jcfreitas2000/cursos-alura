package design.patterns.state.exerc�cio;

public interface Estado {

	public Estado atualiza(Conta conta);
	public double sacar(double valor);
	public double depositar(double valor);
}
