package Cleanit;

public class CleanItFacade {

	protected Limpeza limpeza;
	protected Celular celular;
	protected Data data;
	protected HistoricoLimpezas hist;
	
	public CleanItFacade() {
		
		limpeza = new Limpeza();
		celular = new Celular();
		data = new Data();
		hist = new HistoricoLimpezas();
		
	}
	
	public void LimpaCelular() {
		limpeza.LimparCelular();
		limpeza.RegistraData();
		celular.Limpar();
		hist.adicionar(limpeza);
	}
	
	public String EstadoCelular() {
		return celular.getEstado();
	}
	
	public String verHistorico() {
		return hist.printHist();
	}
	
	public String ProximaLimpeza() {
		return limpeza.LimpezaFutura();
	}
	
}
