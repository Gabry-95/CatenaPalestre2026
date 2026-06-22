package it.pale.tweb.dao.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	

	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String dateToString(Date date) {
		return df.format(date);
	}
	
	public static Date stringToDate(String dateS) throws ParseException{
		return df.parse(dateS);
	}
}
