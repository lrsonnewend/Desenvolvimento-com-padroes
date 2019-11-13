package br.com.engine;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EngineData {
	public int calculaIdade(String dt_nasc) {

		// Data de hoje.
		GregorianCalendar hoje = new GregorianCalendar();
		int diah = hoje.get(Calendar.DAY_OF_MONTH);
		int mesh = hoje.get(Calendar.MONTH) + 1;
		int anoh = hoje.get(Calendar.YEAR);

		// Data do nascimento.
		int dian = Integer.valueOf(dt_nasc.substring(0, 2));
		int mesn = Integer.valueOf(dt_nasc.substring(3, 5));
		int anon = Integer.valueOf(dt_nasc.substring(6, 10));

		// Idade.
		int idade;

		if (mesn < mesh || (mesn == mesh && dian <= diah))
			idade = anoh - anon;
		else
			idade = (anoh - anon) - 1;

		return (idade);
	}

}
