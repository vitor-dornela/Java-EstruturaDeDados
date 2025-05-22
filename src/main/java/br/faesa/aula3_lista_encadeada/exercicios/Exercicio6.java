package br.faesa.aula3_lista_encadeada.exercicios;

import java.util.Scanner;
import br.faesa.aula2_lista_contigua.LCItem;
/*
 * Escreva um programa que, usando métodos, preencha uma lista 
 * da classe LCItem, recebe um número inteiro e mostre na telas 
 * todos os números da lista que são menores que ele.  
 */
public class Exercicio6 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		LCItem lista = new LCItem();
		
		Exercicio2.preencher(lista);
		mostraMenores(lista);

	}

	private static void mostraMenores(LCItem lista) {
		int num;
		
		System.out.println("Entre com um número");
		num = sc.nextInt();
		System.out.println("Lista digitada");
		System.out.println(lista.toString());
		System.out.println("Menores que "+num);
		for (int i=0; i<lista.getQuant(); i++) {
			if (lista.getItem(i).getCodigo()<num) {
				System.out.print(lista.getItem(i).getCodigo()+"  ");
			}
		}
	}

}
