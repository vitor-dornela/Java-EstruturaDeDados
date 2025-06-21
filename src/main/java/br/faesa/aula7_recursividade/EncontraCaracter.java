package br.faesa.aula7_recursividade;

import br.faesa.io.InOut;

public class EncontraCaracter {

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
        
       public static boolean pertence (String frase, char carac){
            return pertence(frase, carac, 0);
        }
        
	private static boolean pertence (String frase, char carac, int i) {
		if (i==frase.length()) {
			return false;
		}else if (carac == frase.charAt(i)){
			return true;
		}else {
			return pertence(frase, carac, i+1);
		}
		
	}

}
