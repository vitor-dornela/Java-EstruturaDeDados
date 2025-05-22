package br.faesa.avaliacaoDiagnosticaResposta;

import java.util.Scanner;

public class Exercicio2 {
/*
 * 1 - preencher 2 vetores[5]
 * 2 - somar os dois e preencher outro
 * 3 - mostrar na tela os 3 vetores
 */
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int[] vet1 = new int[5];
		int[] vet2 = new int[5];
		int[] vSoma = new int[5];
		
		preenche(vet1);
		preenche(vet2);
		vSoma = soma (vet1, vet2);
		System.out.println("VETOR 1");
		imprime (vet1);
		System.out.println("\nVETOR 2");
		imprime (vet2);
		System.out.println("\nVETOR SOMA");
		imprime (vSoma);
	} 

	public static void preenche(int[] vet) {
		for (int i=0; i<vet.length; i++){
			System.out.println("Entre com o elemento " + i +" = ");
			vet[i] = scan.nextInt();
		}
		
	}

	public static int[] soma(int[] vet1, int[] vet2) {
		int[] vetSoma = new int[vet1.length];
		for (int i=0; i<vet1.length; i++){
			vetSoma[i] = vet1[i] + vet2[i];
		}
		return vetSoma;
	}
	
	public static void imprime(int[] vet) {
		System.out.print("| ");
		for (int i=0; i<vet.length; i++){
			System.out.print(vet[i] + " | ");
		}
		System.out.println();
		
	}


}
