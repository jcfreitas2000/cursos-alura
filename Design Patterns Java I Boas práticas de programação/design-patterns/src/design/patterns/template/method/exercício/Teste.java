package design.patterns.template.method.exerc�cio;

import java.util.ArrayList;
import java.util.List;

import design.patterns.chain.of.responsability.exerc�cio.Conta;

public class Teste {

	public static void main(String[] args) {
		List<Conta> contas = new ArrayList<>();
		contas.add(new Conta("Jos� Carlos", 80000));
		contas.add(new Conta("Henrique", 100));
		
		System.out.println("Relatorio simples");
		System.out.println(new RelatorioSimples().relatorio(contas));
		
		System.out.println("Relatorio complexo");
		System.out.println(new RelatorioComplexo().relatorio(contas));
	}
}
