package design.patterns.decorator.exerc�cio;

import java.util.ArrayList;
import java.util.List;

import design.patterns.chain.of.responsability.exerc�cio.Conta;

public abstract class Filtro {

	private Filtro proxFiltro;
	
	public Filtro(Filtro proxFiltro) {
		this.proxFiltro = proxFiltro;
	}

	public Filtro() {
	}

	public abstract List<Conta> filtra(List<Conta> contas);
	
	protected List<Conta> filtraProx(List<Conta> contas){
		if(proxFiltro == null) return new ArrayList<>();
		return proxFiltro.filtra(contas);
	}
}
