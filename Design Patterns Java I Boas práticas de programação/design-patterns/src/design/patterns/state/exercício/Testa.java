package design.patterns.state.exerc�cio;

public class Testa {

	public static void main(String[] args) {
		Conta conta = new Conta("Jos�", 100);

		conta.sacar(101);
		conta.depositar(100);
		conta.sacar(101);
		
		System.out.println(conta);
	}
}
