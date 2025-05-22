package br.faesa.aula3_lista_encadeada.exercicios;

import java.util.Scanner;
import br.faesa.entidades.*;

import br.faesa.aula3_lista_encadeada.LSEItem;

/*
 * 3 - Escreva um programa que, usando métodos, 
 * preencha uma lista da classe LSEItem, 
 * calcula a média dos valores da lista e 
 * imprime tudo na tela. 
 * 
 * Observação: você deve fazer um método para 
 * preencher, outro para calcular a média e outro 
 * para imprimir.
 */
public class Exercicio3 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		LSEItem lista = new LSEItem();
		double media;
		
		Exercicio1.preencher (lista);
		media = calcMedia(lista);
		System.out.println("LISTA ORIGINAL");
		System.out.println(lista.toString());
		System.out.println("MEDIA = "+media);

	}


	private static double calcMedia(LSEItem lista) {
		double total = 0;

		if (lista.eVazia()) {
			return 0;
		}

		for (int i=0; i<lista.getQuant(); i++) {
			total += lista.getItem(i).getCodigo();
		}
		return (total/lista.getQuant());
	}
}
