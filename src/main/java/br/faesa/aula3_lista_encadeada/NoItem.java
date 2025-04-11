package br.faesa.aula3_lista_encadeada;

import br.faesa.aula2_lista_contigua.Item;

public class NoItem {
	private Item item;
	private NoItem prox;
	
	// Construtor so recebe o objeto da classe Item
	public NoItem(Item item) {
		this.item = item;
		this.prox = null; 
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public NoItem getProx() {
		return prox;
	}

	public void setProx(NoItem prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		return "Item = "+item;
	}
}
