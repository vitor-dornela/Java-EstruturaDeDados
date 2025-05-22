package br.faesa.entidades;

public class NoInt {
	private int elemento;
	private NoInt prox;
	
	// Construtor so recebe o objeto da classe Item
	public NoInt(int elemento) {
		this.elemento = elemento;
		this.prox = null; 
	}

	public int getElemento() {
		return elemento;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}

	public NoInt getProx() {
		return prox;
	}

	public void setProx(NoInt prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		return "Elemento = "+elemento;
	}
}
