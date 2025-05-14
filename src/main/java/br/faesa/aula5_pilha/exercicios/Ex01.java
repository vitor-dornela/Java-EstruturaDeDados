package br.faesa.aula5_pilha.exercicios;

import br.faesa.aula5_pilha.*;

import java.util.Scanner;

import br.faesa.entidades.*;
/*
 * Faça um programa que leia 10 números inteiros e  
 * armazene-o em uma pilha. Em seguida, retire os 
 * valores maiores que 10 desta pilha. Obs.: Você 
 * deve fazer pelo menos dois métodos: Um para ler 
 * e empilhar os números e outro para fazer a remoção 
 * dos números maiores que 10.
*/ 
public class Ex01 {

	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		PilhaInt pilha = new PilhaInt();
		
		preencher (pilha);
		System.out.println(pilha.toString());
		remover (pilha);
		System.out.println(pilha.toString());

	}

	public static void preencher(PilhaInt pilha) {
		int num;
		System.out.println("Entre com um inteiro ou zero para sair");
		num = scan.nextInt();
		while (num!=0) {
			pilha.push(num);
			System.out.println("Entre com um inteiro ou zero para sair");
			num = scan.nextInt();
		}
	}

	public static void remover(PilhaInt pilha) {
		PilhaInt aux = new PilhaInt();
		NoInt no;
		while (!pilha.isEmpty()) {
			no = pilha.pop();
			if (no.getElemento()<=10) {
				aux.push(no.getElemento());
			}
		}
		while (!aux.isEmpty()) {
			no = aux.pop();
			pilha.push(no.getElemento());
		}
	}

}
