package Cleanit;
import java.util.ArrayList;

public class HistoricoLimpezas implements Historico{
	
	ArrayList<Limpeza> historico = new ArrayList<Limpeza>();
	String str = "Histórico:\n";
	
	public void adicionar(Limpeza limpeza) {
		this.historico.add(limpeza);
	}
	
	public String printHist() {
		for(Iterator it = criarIterator(); !it.isDone(); it.next()) {
			str += it.Item().RegistraData()+'\n';
		}
		return str;

	}

	@Override
	public Iterator criarIterator() {
		return new HistoricoIterator(historico);
	}
}
