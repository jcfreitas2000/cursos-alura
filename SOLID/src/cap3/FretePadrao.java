package cap3;

public class FretePadrao implements Frete {

	@Override
	public double para(String cidade) {
		if ("SAO PAULO".equals(cidade.toUpperCase())) {
			return 15;
		}
		return 30;
	}

}
