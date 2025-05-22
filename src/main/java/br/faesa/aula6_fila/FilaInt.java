package br.faesa.aula6_fila;

import br.faesa.entidades.NoInt;

public class FilaInt {
	/*
	 * Atributos
	 * head, tail -> que são os nós que representa o início e o final da fila
	 * quant -> que representa a quantidade de elementos que foram enfileirados
	 */
	private NoInt head, tail;
	private int quant;
	
	/*
	 * Metodos
	 * Verificar se a fila está vazia (isEmpty)
	 * Enfileirar (enqueue): Inserir um elemento no final da fila
	 * Desenfileirar (dequeue): Remover o elemento do início da fila
	 * Retornar o tamanho da fila (size)
	 * Retorna o elemento do início da fila (peek)
	 */

	public FilaInt() {
		this.head = null;
		this.tail = null;
		this.quant = 0;
	}
	
	public boolean isEmpty() {
		return (this.head==null);
	}
	
	public int size() {
		return this.quant;
	}
	
	public NoInt peek () {
		return this.head;
	}
	
	/*
	 * enqueue (Inserir um elemento no final da fila)
	 */
	public void enqueue (int info) {
		NoInt novoNo = new NoInt(info);
		if (this.isEmpty()) {
			this.head = novoNo;
		}else {
			this.tail.setProx(novoNo);
		}
		this.tail = novoNo;
		this.quant++;
		
	}
	/*
	 * dequeue (Remover o elemento do início da fila)
	 */
	public NoInt dequeue () {
		NoInt aux = this.head;
		if (this.isEmpty()) {
			return null;
		}else {
			if (this.quant==1) {
				this.tail = null;
			}
			this.head = this.head.getProx();
			this.quant--;
			return aux;
		}
	}
	public String toString () {
		String str = "";
		NoInt aux=head;
		
		while (aux!=null) {
			str += aux.getElemento()+"  ";
			aux = aux.getProx();
		}
		return str;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
