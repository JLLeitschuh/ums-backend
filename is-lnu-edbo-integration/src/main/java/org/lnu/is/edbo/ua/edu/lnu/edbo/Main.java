package org.lnu.is.edbo.ua.edu.lnu.edbo;


import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class Main {

	public static String getActualDate(int year,int month,int date) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, date);

		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		return formatter.format(c.getTime());
	}
	
	public static String getActualDate() {
		Date now = new Date();
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		return formatter.format(now);
	}

	public void synchronize() {
		try {
			Edbo.Instanse().GetAllSpecoffer();
			//Edbo.Instans	e().GetAllRequest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
	public static void main(String[] args) {
		try {
			Edbo.Instanse().GetAllSpecoffer();
			//Edbo.Instanse().GetAllRequest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
