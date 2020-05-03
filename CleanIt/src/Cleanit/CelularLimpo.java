package Cleanit;

public class CelularLimpo implements CelularState{

	@Override
	public CelularState Limpar() {
		return this;
	}

	@Override
	public CelularState Sujar() {
		return new CelularSujo();
	}

}
