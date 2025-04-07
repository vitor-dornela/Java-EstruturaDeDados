package br.faesa.aula2_lista_contigua;

public class LCInteiro {
	private Integer[] lista;
	private int quant;
	
	public LCInteiro() {
		this.lista = new Integer[10];
		this.quant = 0;
	}
	
	public LCInteiro(int tamanho) {
		this.lista = new Integer[tamanho];
		this.quant = 0;
	}
	
	public int tamanho () {
		return this.lista.length;
	}
	
	public int getQuant() {
		return this.quant;
	}
	/*
	 * eVazia() => retorna verdadeiro se a lista estiver vazia e 
	 *             falso caso contrário.
	 */
	public boolean eVazia() {
		if (this.quant==0) {
			return true;
		}
		return false;
	}
	
	public boolean eCheia() {
		if (this.quant==this.lista.length) {
			return true;
		}
		return false;
	}
	
	public Integer get (int pos) {
		if (pos>=0 && pos<this.quant) {
			return this.lista[pos];
		}
		return null;
	}
	
	public int pesquisa (int cod) {
		for (int i = 0; i<quant; i++) {
			if (this.lista[i] == cod) {
				return i;
			}
		}
		return -1;
	}

	public boolean insere (Integer item, int pos) {
		if (pos<0 || pos>quant) {// posicao invalida
			return false;
		}
		if (quant==this.lista.length) {
			aumenta();
		}
		for (int i = quant; i> pos; i--) {
			this.lista[i] = this.lista[i-1];
		}
		this.lista[pos] = item;
		this.quant++;
		return true;
	}
	
	public void insereInicio (Integer item) {
		insere (item, 0);
	}
	
	public void insereFinal (Integer item) {
		if (quant==this.lista.length) {
			aumenta();
		}
		this.lista[quant] = item;
		this.quant++;
	}
	
	private void aumenta() {
		Integer[] novo;
		novo = new Integer[lista.length+lista.length/2];
		for (int i=0; i<this.quant; i++) {
			novo[i] = this.lista[i];
		}
		this.lista = novo;
	}
	
	public Integer remove (int cod) {
		Integer aux;
		int pos = this.pesquisa(cod);
		if (pos==-1) {
			return null;
		}
		aux = this.lista[pos];
		for (int i = pos; i<quant-1; i++) {
			this.lista[i] = this.lista[i+1];
		}
		this.lista[quant-1] = null;
		this.quant--;
		return aux;
	}
	
	public Integer removePos (int pos) {
		Integer aux;
		if (pos<0 || pos>=quant) {
			return null;
		}
		aux = this.lista[pos];
		for (int i = pos; i<quant-1; i++) {
			this.lista[i] = this.lista[i+1];
		}
		this.lista[quant-1] = null;
		this.quant--;
		return aux;
	}
	
	public String toString () {
		String aux = "";
		for (int i=0; i<this.quant; i++) {
			aux += this.lista[i]+" | ";
		}
		return aux;
	}
	
}
