package Cleanit;
import java.util.ArrayList;

public class HistoricoIterator implements Iterator{
	
	protected ArrayList<Limpeza> hist = new ArrayList<Limpeza>();
	protected int cont = 0;
	
	protected HistoricoIterator(ArrayList<Limpeza> hist) {
		this.hist = hist;
		cont = 0;
	}

	@Override
	public void first() {
		cont = 0;
	}

	@Override
	public void next() {
		cont++;
	}

	@Override
	public boolean isDone() {
		return cont == hist.size();
	}

	@Override
	public Limpeza Item() {
		if(isDone()) cont = hist.size()-1;
		else if(cont < 0) cont = 0;
		return hist.get(cont);
		
	}

}
