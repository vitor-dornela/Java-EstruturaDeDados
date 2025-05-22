package br.faesa.aula3_lista_encadeada.exercicios;

import br.faesa.aula3_lista_encadeada.*;

import java.util.Scanner;

import br.faesa.entidades.Item;


/*
 * Escreva um método que recebe três Listas Simplesmente Encadeadas 
 * (L1 (preenchida), L2 e L3 vazias). Esse método deve colocar 
 * a primeira metade dos dados da lista L1 na lista L2 e a segunda 
 * metade na lista L3.
 */
public class Exercicio1 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		LSEItem lista1 = new LSEItem();
		LSEItem lista2 = new LSEItem();
		LSEItem lista3 = new LSEItem();
		
		preencher (lista1);
		separa(lista1, lista2, lista3);
		System.out.println("LISTA ORIGINAL");
		System.out.println(lista1.toString());
		System.out.println("LISTA 1");
		System.out.println(lista2.toString());
		System.out.println("LISTA 2");
		System.out.println(lista3.toString());

	}

	public static void preencher(LSEItem lista) {
		int valor;
		Item item;
		
		System.out.println("Entre com um inteiro ou 0 para finalizar");
		valor = sc.nextInt();
		while (valor != 0) {
			item = new Item(valor, "");
			lista.insereFinal(item);
			System.out.println("Entre com um inteiro ou 0 para finalizar");
			valor = sc.nextInt();
		}
		
	}	private static void separa(LSEItem l1, LSEItem l2, LSEItem l3) {
		int tam1 = l1.getQuant()/2;
		
		for (int i=0; i<tam1; i++) {
			l2.insereFinal(l1.getItem(i));
		}
		for (int i=tam1; i<l1.getQuant(); i++) {
			l3.insereFinal(l1.getItem(i));
		}
	}
}
