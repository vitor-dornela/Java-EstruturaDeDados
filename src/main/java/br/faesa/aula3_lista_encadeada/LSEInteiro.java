package br.faesa.aula3_lista_encadeada;


import br.faesa.entidades.NoInt;

public class LSEInteiro {
	private NoInt prim, ult;
	private int quant;
	
	public LSEInteiro() {
		this.prim = null;
		this.ult = null;
		this.quant = 0;
	}
	
	public NoInt getPrim() {
		return prim;
	}

	public NoInt getUlt() {
		return ult;
	}


	public int tamanho () {
		return this.quant;
	}
	
	public boolean eVazia() {
		return (quant==0);
	}
	
	public NoInt get (int pos) {
		NoInt aux;
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
	
	public NoInt pesquisa (int cod) {
		NoInt aux;
		aux = this.prim;
		while (aux!=null) {
			if (aux.getElemento()==cod) {
				return aux;
			}
			aux = aux.getProx();
		}
		return aux;
	}
	
	public void insereInicio (int elemento) {
		NoInt no = new NoInt(elemento);
		
		if (this.eVazia()) {
			this.ult = no;
		} else {
			no.setProx(this.prim);
		}
		this.prim = no;
		this.quant++;
	}
	
	public void insereFinal (int elemento) {
		NoInt no = new NoInt(elemento);
		
		if (this.eVazia()) {
			this.prim = no;
		}else {
			this.ult.setProx(no);
		}
		this.ult = no;
		this.quant++;
	}

	public boolean insere (int elemento, int pos) {
		NoInt no = new NoInt(elemento);
		NoInt aux;
		
		if (pos>=0 && pos<=this.quant) {// e uma posicao valida
			if (pos==0) {
				insereInicio(elemento);
			}else if (pos==this.quant) {
				insereFinal(elemento);
			} else {
				aux = this.get(pos-1);
				no.setProx(aux.getProx());
				aux.setProx(no);
				this.quant++;
			}
			return true;
		}
		return false;

	}
	
	public NoInt removeInicio () {
		NoInt noRemovido;
		if (this.eVazia()) {
			return null;
		}
		noRemovido = this.prim;
		this.prim = this.prim.getProx();
		this.quant--;
		if (this.quant==0) {
			this.ult = null;
		}
		return noRemovido;
	}
	
	public NoInt removeFinal () {
		NoInt noRemovido, aux;
		
		if (this.eVazia()) {
			return null;
		}
		if (this.quant==1) {
			noRemovido = this.prim;
			this.prim=null;
			this.ult = null;
		} else {
			aux = this.get(quant-2);
			aux.setProx(null);
			noRemovido = this.ult;
			this.ult = aux;			
		}
		this.quant--;
		return noRemovido;
	}
	
	public NoInt remove (int cod) {
		NoInt atual = this.prim;
		NoInt ant;
		
		if (eVazia()) {
			return null;
		}
		if (this.prim.getElemento()==cod) {
			return this.removeInicio();
		}
		while (atual!= null) {
			ant = atual;
			atual = atual.getProx();
			if (atual.getElemento()==cod) {
				ant.setProx(atual.getProx());
				this.quant--;
				return atual;
			}
		}
		return null;
	}

	public NoInt removePos (int pos) {
		NoInt atual;
		NoInt ant;
		if (pos<0 || pos>=this.quant) {
			return null;
		}
		if (pos==0) {
			return removeInicio();
		}
		atual = get(pos);
		ant = get(pos-1);
		ant.setProx(atual.getProx());
		this.quant--;
		return atual;
		
	}
	
	
	public String toString() {
		String temp="";
		NoInt aux = this.prim;
		
		while (aux != null) {
			temp += aux.getElemento()+"  ";
			aux = aux.getProx();
		}
		return temp;
	}

}
