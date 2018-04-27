package br.github.superteits.brasille.utils;

import br.teits.brasille.Brasille;

public class ExpParser {
	
	public static String formatXp(float number) {
		return Brasille.formatarXp.format(number).replaceAll(",", ".");	
	}

}
