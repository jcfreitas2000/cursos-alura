class NegociacaoController{

	constructor(){

		let $ = document.querySelector.bind(document);

		this._inputData = $("#data");
		this._inputQuantidade = $("#quantidade");
		this._inputValor = $("#valor");
		this._listaNegociacoes = new ListaNegociacoes();
	}

	adiciona(event){

		event.preventDefault();
		
		this._listaNegociacoes.adiciona(this._criaNegociacao());
		this._resetaForm();
	}

	_criaNegociacao(){

		return new Negociacao(
			DataHelper.textoParaData(this._inputData.value),
			this._inputQuantidade.value,
			this._inputValor.value
		);
	}

	_resetaForm(){

		this._inputData.value = "";
		this._inputQuantidade.value = "1";
		this._inputValor.value = "0.0";
	}
}