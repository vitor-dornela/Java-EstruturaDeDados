package br.faesa.aula5_pilha;

public class PilhaInt {
/*
 * Atributos
 * top -> que é o nó que representa o topo da pilha
 * quant -> que representa a quantidade de elementos que foram empilhados
 */
	
	private NoInt top;
	private int quant;
	
	/*
	 * Metodos:
	 * Verificar se a pilha está vazia (isEmpty)
	 * Empilhar (push): Inserir um elemento no topo da pilha
	 * Desempilhar (pop): Remover o elemento do topo da pilha
	 * Retornar o tamanho da pilha (size)
	 * Retorna o elemento do topo da pilha (top)
	 */
	
	public PilhaInt () {
		this.top = null;
		this.quant = 0;
	}
	
	public boolean isEmpty() {
		return (this.top==null);
	}
	
	public int size() {
		return this.quant;
	}
	
	public NoInt top(){
		return this.top;
	}
	
	public void push (int num) {
		NoInt novo = new NoInt(num);
		novo.setProx(this.top);
		this.top = novo;
		this.quant++;
	}
	
	public NoInt pop() {
		NoInt removido = this.top;
		if (!isEmpty()) {
			this.top = this.top.getProx();
			this.quant--;
		}
		return removido;
	}
	
	public String toString() {
		NoInt aux = this.top;
		String str = "";
		while (aux != null) {
			str += aux.getElemento()+"  ";
			aux = aux.getProx();
		}
		return str;
	}
	
}
