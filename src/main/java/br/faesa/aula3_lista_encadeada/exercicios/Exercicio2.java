package br.faesa.aula3_lista_encadeada.exercicios;

import java.util.Scanner;

import br.faesa.entidades.Item;
import br.faesa.aula2_lista_contigua.LCItem;

/*
 * Escreva um método que recebe três Listas Contíguas 
 * (L1 (preenchida), L2 e L3 vazias). Esse método deve 
 * colocar a primeira metade dos dados da lista L1 na 
 * lista L2 e a segunda metade na lista L3.
 */
public class Exercicio2 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		LCItem lista1 = new LCItem();
		LCItem lista2;
		LCItem lista3;
		int tam;
		
		preencher (lista1);
		tam = lista1.getQuant();
		lista2 = new LCItem(tam/2);
		lista3 = new LCItem(tam - tam/2);
		separa(lista1, lista2, lista3);
		System.out.println("LISTA ORIGINAL");
		System.out.println(lista1.toString());
		System.out.println("LISTA 1");
		System.out.println(lista2.toString());
		System.out.println("LISTA 2");
		System.out.println(lista3.toString());

	}

	public static void preencher(LCItem lista) {
		int valor;
		Item item;
		
		System.out.println("Entre com um inteiro ou 0 para finalizar");
		valor = sc.nextInt();
		while (valor != 0) {
			item = new Item(valor, "");
			lista.insereInicio(item);
			System.out.println("Entre com um inteiro ou 0 para finalizar");
			valor = sc.nextInt();
		}
		
	}

	private static void separa(LCItem l1, LCItem l2, LCItem l3) {
		int tam1 = l1.getQuant()/2;
		
		for (int i=0; i<tam1; i++) {
			l2.insereFinal(l1.getItem(i));
		}
		for (int i=tam1; i<l1.getQuant(); i++) {
			l3.insereFinal(l1.getItem(i));
		}
	}
}
