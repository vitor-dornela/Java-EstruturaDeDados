package br.faesa.aula3_lista_encadeada;

import br.faesa.aula2_lista_contigua.Item;

public class LSEItem {
	private NoItem prim, ult;
	private int quant;
	
	public LSEItem() {
		this.prim = null;
		this.ult = null;
		this.quant = 0;
	}
	
	public int tamanho () {
		return this.quant;
	}
	
	public boolean eVazia() {
		return (quant==0);
	}
	
	public NoItem get (int pos) {
		NoItem aux;
		// verificar se a posicao e valida
		if (pos>=0 && pos<quant) {
			if (pos==quant-1) {
				return this.ult;
			}
			aux = this.prim;
			for (int i=0; i<pos; i++) {
				aux = aux.getProx();
			}
			return aux;	
		}
		return null; // se a posicao for invalida
	}
	
	public NoItem pesquisa (int cod) {
		NoItem aux;
		aux = this.prim;
		while (aux!=null) {
			if (aux.getItem().getCodigo()==cod) {
				return aux;
			}
			aux = aux.getProx();
		}
		return aux;
	}
	
	public void insereInicio (Item item) {
		NoItem no = new NoItem(item);
		
		if (eVazia()) {
			this.prim = no;
			this.ult = no;
		} else {
			no.setProx(this.prim);
			this.prim = no;
		}
		this.quant++;
	}
	
	public String toString() {
		String temp="";
		NoItem aux = this.prim;
		
		while (aux != null) {
			temp += aux.getItem()+"\n";
			aux = aux.getProx();
		}
		return temp;
	}
	/*
	
	public boolean insere (Integer item, int pos) {

	}
	
	public void insereFinal (Integer item) {
	}
	
	
	public Integer remove (int cod) {

	}
	
	public Integer removePos (int pos) {

	}
	
*/

}
