package Cleanit;

public class CelularSujo implements CelularState {

	@Override
	public CelularState Limpar() {
		return new CelularLimpo();
	}

	@Override
	public CelularState Sujar() {
		return this;
	}

}
