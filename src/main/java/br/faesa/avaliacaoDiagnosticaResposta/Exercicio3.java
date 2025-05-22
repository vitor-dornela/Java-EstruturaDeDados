package br.faesa.avaliacaoDiagnosticaResposta;

import java.util.Scanner;

/*
 * 3) Fa�a um programa em Java que:
a) instancie um vetor de 20 posi��es. 
b) preencha o vetor: deve pedir ao usu�rio se quer 
inserir mais um. Deve parar de preencher se:
   � o vetor estiver cheio, nesse caso, deve mostrar uma 
     mensagem na tela, 
   � o usu�rio n�o quiser mais inserir. 
c) mostre na tela todos os elementos do vetor
Obs.: Os itens (b) e (c) devem ser m�todos
 */
public class Exercicio3 {

	private static Scanner scan = new Scanner(System.in);
	private static int quant=0;
	
	public static void main(String[] args) {
		int[] vet = new int[20];
		
		preenche(vet);
		imprime (vet);

	}

	private static void preenche(int[] vet) {
		char op;
		do{
			if (quant<vet.length){
				System.out.println("Entre com um numero inteiro = ");
				vet[quant] = scan.nextInt();
				quant++;
				System.out.println("quer continuar preenchendo? <S> ou <N>");
				op = scan.next().toUpperCase().charAt(0);
			} else {
				System.err.println("VETOR CHEIO");
				op = 'N';
			}
		}while (op=='S');
	}

	private static void imprime(int[] vet) {
		System.out.print("| ");
		for (int i=0; i<quant; i++){
			System.out.print(vet[i] + " | ");
		}
		System.out.println();
	}
}
