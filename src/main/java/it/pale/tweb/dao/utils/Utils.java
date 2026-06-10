package it.pale.tweb.dao.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	//proprietà static è una proprietà di una categoria 
	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static String dateToString(Date date) {
		//il metodo vorrei che facesse Utils.dateToString(una data) ...... chiamare un metodo sulla classe senza usare l'istanza deve essere static utile nel DAO (mi evita di dover creare l'oggetto
		return df.format(date);
	}
	
	//Probabilmente dovro effettuare il processo opposto quando vorro caricare sul db la dta e la inserirò nel formato italiano
	
	public static Date stringToDate(String dateS) throws ParseException{
		return df.parse(dateS);
		
		//invece di usare try catch uso add throws ParseException questo è dovuto a una responsabilità dell'errore con try provvedo io viceversa lanciando
		//add trought dico non è responsabilità mia sanificare l'input utente se passo cazzate il metodo lancia eccezione
		//alla fine qualcuno questa eccezione la deve gestire, sarà la pagina web che ricevendo l'eccezione la gestirà 
	}
}
