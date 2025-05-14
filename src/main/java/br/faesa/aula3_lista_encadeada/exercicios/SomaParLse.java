package br.faesa.aula3_lista_encadeada.exercicios;

import br.faesa.aula3_lista_encadeada.LSEInteiro;
import br.faesa.entidades.NoInt;

public class SomaParLse {
/*
 * Faça um programa que preencha uma lista números inteiros e mostre 
 * na tela essa lista e a soma de todos os pares dessa lista. 
 */
	public static void main(String[] args) {
		LSEInteiro lista = new LSEInteiro();
		int total;
		
		MaiorDaLse.preenche(lista);
		System.out.println(lista);
		total = somaPar (lista);
		System.out.println("A SOMA DE TODOS OS PARES = "+ total);
		
	}

	public static int somaPar(LSEInteiro lista) {
		int total=0;
		NoInt aux = lista.getPrim().getProx();
		while (aux!=null){
			if (aux.getElemento()%2 == 0) {
				total += aux.getElemento();
			}
			aux = aux.getProx();
		}
		return total;
	}

}
