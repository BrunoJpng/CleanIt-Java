package Cleanit;
import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;

public class Data {

	Date date = new Date();
	DateFormat df = DateFormat.getDateInstance();
	Calendar c = Calendar.getInstance();
	
	public String getData() {
		return df.format(date);
	}
	
	public String setData(int dia, int mes, int ano) {
		c.set(Calendar.DAY_OF_MONTH, dia);
		c.set(Calendar.MONTH, mes-1);
		c.set(Calendar.YEAR, ano);
		return df.format(c.getTime());
	}
	
	public String ProximaLimpeza() {
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		return df.format(c.getTime());
	}
	
	
}
