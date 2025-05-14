package br.faesa.aula3_lista_encadeada.exercicios;

import br.faesa.aula2_lista_contigua.LCInteiro;

public class SomaPar {
/*
 * Faça um programa que preencha uma lista números inteiros e mostre 
 * na tela essa lista e a soma de todos os pares dessa lista. 
 */
	public static void main(String[] args) {
		LCInteiro lista = new LCInteiro();
		int total;
		
		MaiorDaLista.preenche(lista);
		System.out.println(lista);
		total = somaPar (lista);
		System.out.println("A SOMA DE TODOS OS PARES = "+ total);
		
	}

	public static int somaPar(LCInteiro lista) {
		int total=0;
		
		for (int i=0; i<lista.getQuant(); i++) {
			if (lista.get(i)%2 == 0) {
				total += lista.get(i);
			}
		}
		return total;
	}

}
