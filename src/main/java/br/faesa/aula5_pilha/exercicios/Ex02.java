package br.faesa.aula5_pilha.exercicios;

import br.faesa.aula6_fila.*;

import java.util.Scanner;

import br.faesa.entidades.*;
/*
 * Faça um programa que leia 10 números inteiros e 
 * armazene-o em uma fila. Em seguida, retire os valores 
 * maiores que 10 desta fila. Obs.: Você deve fazer pelo 
 * menos dois métodos: Um para ler e enfileirar os números 
 * e outro para fazer a remoção dos números maiores que 10.
*/ 
public class Ex02 {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		FilaInt fila = new FilaInt();
		
		preencher (fila);
		System.out.println(fila.toString());
		remover (fila);
		System.out.println(fila.toString());

	}

	public static void preencher(FilaInt fila) {
		int num;
		System.out.println("Entre com um inteiro ou zero para sair");
		num = scan.nextInt();
		while (num!=0) {
			fila.enqueue(num);
			System.out.println("Entre com um inteiro");
			num = scan.nextInt();
		}
	}

	public static void remover(FilaInt fila) {
		FilaInt aux = new FilaInt();
		NoInt no;
		while (!fila.isEmpty()) {
			no = fila.dequeue();
			if (no.getElemento() <= 10) {
				aux.enqueue(no.getElemento());
			}
		}
		while (!aux.isEmpty()) {
			no = aux.dequeue();
			fila.enqueue(no.getElemento());
		}
	}

}
