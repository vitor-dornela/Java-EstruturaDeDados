package br.faesa.avaliacaoDiagnosticaResposta;

import java.util.Scanner;

public class Exercicio1 {

	@SuppressWarnings("resource")
	public static void main	(String[] args) {
		/*
		 * 1) Faca um algoritmo para preencher 
		 * um vetor de 10 numeros inteiros e
		 * mostra-los na tela.
		 */
		Scanner entrada = new Scanner(System.in);
		int[] vetor = new int[10];
		for (int i=0; i<vetor.length; i++) {
			System.out.println ("vetor["+i+"] = ");
			vetor[i] = entrada.nextInt();
		}
		System.out.print("\nVetor Lido: \n| ");
		for (int i=0; i<vetor.length; i++) {
			System.out.print (vetor[i]+" | ");
		}
	}

}
