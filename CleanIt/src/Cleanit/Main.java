package Cleanit;
import java.util.Scanner;
import java.sql.Connection;
import db.DB;

public class Main {
	public static void main(String[] args) {	
		
		CleanItFacade fachada = new CleanItFacade();
		fachada.EstadoCelular();
		//fachada.ProximaLimpeza();
	}
}
