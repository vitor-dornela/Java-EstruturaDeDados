package br.faesa.aula2_lista_contigua.exercicios;

import java.util.Scanner;
import br.faesa.aula2_lista_contigua.LCInteiro;

public class MaiorDaLista {
	static Scanner scan = new Scanner (System.in);
	public static void main(String[] args) {
		LCInteiro lista = new LCInteiro();
		int maior;
		
		preenche(lista);
		maior = maior(lista);
		System.out.println("LISTA");
		System.out.println(lista);
		System.out.println("O maior elemento : "+maior);

	}

	public static void preenche(LCInteiro lista) {
		
		int quant, num;
		
		System.out.println(" entre com a quantidade de elementos da lista: ");
		quant = scan.nextInt();
		
		for (int i=0; i<quant; i++) {
			num = (int)(Math.random()*50)+1;
			lista.insereFinal(num);
		}
	}

	public static int maior(LCInteiro lista) {
		int maior = lista.get(0);
		for (int i=1; i<lista.getQuant(); i++) {
			if (lista.get(i)>maior) {
				maior = lista.get(i);
			}
		}
		return maior;
	}

}
