package br.faesa.aula5_pilha.exercicios;

import br.faesa.aula5_pilha.*;

import java.util.Scanner;

import br.faesa.entidades.*;
/*
 * Faça um programa que testa se duas pilhas são 
 * ou não iguais. Ao final da execução, as duas 
 * pilhas devem estar no mesmo estado em que 
 * estavam no início.
*/ 
public class Ex03 {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		PilhaInt pilha = new PilhaInt();
		PilhaInt pilha2 = new PilhaInt();
		boolean igual =false;
		
		preencher (pilha);
		preencher (pilha2);
		igual  = igualdade(pilha, pilha2);
		System.out.println(pilha.toString());
		System.out.println(pilha2.toString());
		if (igual) {
			System.out.println("Pilhas iguais");
		}else {
			System.out.println("Pilhas diferentes");
		}

	}

	private static void preencher(PilhaInt pilha) {
		int num;
		System.out.println("Entre com um inteiro ou zero para sair");
		num = scan.nextInt();
		while (num!=0) {
			pilha.push(num);
			System.out.println("Entre com um inteiro ou zero para sair");
			num = scan.nextInt();
		}
	}

	private static boolean igualdade (PilhaInt pilha, 
			PilhaInt pilha2) {
		PilhaInt aux = new PilhaInt();
		PilhaInt aux2 = new PilhaInt();
		int num1, num2;
		boolean igual = true;
		
		if 	(pilha.size()!=pilha2.size()) {
			return false;
		}
		if (pilha.isEmpty()) {
			return true;
		}
		while (!pilha.isEmpty() && igual) {
			if (pilha.top().getElemento()!=pilha2.top().getElemento()) {
				igual = false;
			} else {
				num1 = pilha.pop().getElemento();
				aux.push(num1);
				num2 = pilha2.pop().getElemento();
				aux2.push(num2);	
			}
		}
		while (!aux.isEmpty()) {
			num1 = aux.pop().getElemento();
			pilha.push(num1);
			num2 = aux2.pop().getElemento();
			pilha2.push(num2);
		}
		return igual;
	}

}
