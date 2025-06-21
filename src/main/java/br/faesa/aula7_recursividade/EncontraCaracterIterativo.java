package br.faesa.aula7_recursividade;

import br.faesa.io.InOut;

public class EncontraCaracterIterativo {

	public static void main(String[] args) {
		String frase = InOut.leString("Entre com uma frase");
		frase = frase.toUpperCase();
		char carac = InOut.leChar("Entre com um caracter");
		carac = Character.toUpperCase(carac);
		if (pertence(frase, carac)) {
			InOut.msgDeInformacao("", carac + " pertence a \n"+frase);
		}else {
			InOut.msgDeErro("", carac + " nao pertence a \n"+frase);
		}
		

	}
	public static boolean pertence (String frase, char carac) {
		for (int i=0; i<frase.length(); i++) {
			if (frase.charAt(i)==carac){
				return true;
			}
		}
		return false;
	}
}
