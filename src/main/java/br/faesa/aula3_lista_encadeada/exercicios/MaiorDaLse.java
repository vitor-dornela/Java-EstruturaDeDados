package br.faesa.aula3_lista_encadeada.exercicios;

import java.util.Scanner;

import br.faesa.aula3_lista_encadeada.LSEInteiro;
import br.faesa.entidades.NoInt;


public class MaiorDaLse {
	static Scanner scan = new Scanner (System.in);
	public static void main(String[] args) {
		LSEInteiro lista = new LSEInteiro();
		int maior;
		
		preenche(lista);
		maior = maior(lista);
		System.out.println("LISTA");
		System.out.println(lista);
		System.out.println("O maior elemento : "+maior);

	}

	public static void preenche(LSEInteiro lista) {
		
		int quant, num;
		
		System.out.println(" entre com a quantidade de elementos da lista: ");
		quant = scan.nextInt();
		
		for (int i=0; i<quant; i++) {
			num = (int)(Math.random()*50)+1;
			lista.insereFinal(num);
		}
	}

	public static int maior(LSEInteiro lista) {
		NoInt maior = lista.getPrim();
		NoInt aux = lista.getPrim().getProx();
		while (aux!=null){
			if (aux.getElemento()>maior.getElemento()) {
				maior = aux;
			}
			aux = aux.getProx();
		}
		return maior.getElemento();
	}

}
