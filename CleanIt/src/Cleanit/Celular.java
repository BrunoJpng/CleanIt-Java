package Cleanit;

public class Celular {

	Usuario dono;
	String modelo;
	
	protected CelularState estado;
	
	public Celular() {
		estado = new CelularSujo();
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public String getEstado() {
		if(estado instanceof CelularLimpo) {
			return "O seu celular est� limpo.";
		}
		return "O seu celular est� sujo.";
	}
	
	public void Limpar() {
		estado = new CelularLimpo();
	}
	
	public void Sujar() {
		estado = new CelularSujo();
	}
}
