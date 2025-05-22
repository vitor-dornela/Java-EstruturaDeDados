package br.faesa.aula5_pilha.exercicios;

import br.faesa.aula6_fila.*;

import java.util.Scanner;

/*
 * Faça um programa que testa se duas pilhas são 
 * ou não iguais. Ao final da execução, as duas 
 * pilhas devem estar no mesmo estado em que 
 * estavam no início.
 */ 
public class Ex04V2 {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		FilaInt fila = new FilaInt();
		FilaInt fila2 = new FilaInt();
		boolean igual =false;

		preencher (fila);
		preencher (fila2);
		igual  = igualdade(fila, fila2);
		System.out.println(fila.toString());
		System.out.println(fila2.toString());
		if (igual) {
			System.out.println("Filas iguais");
		}else {
			System.out.println("Filas diferentes");
		}

	}

	private static void preencher(FilaInt fila) {
		int num;
		System.out.println("Entre com um inteiro ou zero para sair");
		num = scan.nextInt();
		while (num!=0) {
			fila.enqueue(num);
			System.out.println("Entre com um inteiro ou zero para sair");
			num = scan.nextInt();
		}
	}

	private static boolean igualdade (FilaInt fila, 
			FilaInt fila2) {
		FilaInt aux = new FilaInt();
		FilaInt aux2 = new FilaInt();
		boolean igual = true;
		int num1, num2;

		if 	(fila.size()!=fila2.size()) {
			return false;
		}
		if (fila.isEmpty()) {
			return true;
		}
		for (int i=0; i<fila.size(); i++) {
			if (fila.peek().getElemento()!=fila2.peek().getElemento()) {
				igual = false;
			}
			num1 = fila.dequeue().getElemento();
			fila.enqueue(num1);
			num2 = fila2.dequeue().getElemento();
			fila2.enqueue(num2);	
		}
		return igual;
	}

}
