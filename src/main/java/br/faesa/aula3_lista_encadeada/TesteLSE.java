package br.faesa.aula3_lista_encadeada;

import br.faesa.aula2_lista_contigua.Item;

public class TesteLSE {

	public static void main(String[] args) {
		LSEItem lista = new LSEItem();
		
		lista.insereInicio(new Item(12));
		lista.insereInicio(new Item(55));
		lista.insereInicio(new Item(37));
		lista.insereInicio(new Item(22));
		lista.insere(new Item(89), 3);

		System.out.println(lista);

	}

}
