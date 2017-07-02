package com.edn.fixSubtitle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataLegenda {
	
	public static String alterarSegundosLegenda(int segundos, String linha) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		try {
			Date data = sdf.parse(linha);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(data);
			calendar.add(Calendar.SECOND, segundos);
			
			data = calendar.getTime();
			String dataLiteral = data.toString();
			dataLiteral = dataLiteral.replaceAll(" " , ",");
			String[] token = dataLiteral.split(",");
			
			return token[3];
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
