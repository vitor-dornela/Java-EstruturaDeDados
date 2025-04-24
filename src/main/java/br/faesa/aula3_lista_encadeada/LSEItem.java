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

    public NoItem getPrim() {
        return prim;
    }

    public NoItem getUlt() {
        return ult;
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

        if (this.eVazia()) {
            this.ult = no;
        } else {
            no.setProx(this.prim);
        }
        this.prim = no;
        this.quant++;
    }

    public void insereFinal (Item item) {
        NoItem no = new NoItem(item);

        if (this.eVazia()) {
            this.prim = no;
        }else {
            this.ult.setProx(no);
        }
        this.ult = no;
        this.quant++;
    }

    public boolean insere (Item item, int pos) {
        NoItem no = new NoItem(item);
        NoItem aux;

        if (pos>=0 && pos<=this.quant) {// e uma posicao valida
            if (pos==0) {
                insereInicio(item);
            }else if (pos==this.quant-1) {
                insereFinal(item);
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

    public NoItem removeInicio () {
        NoItem noRemovido;
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

    public NoItem removeFinal () {
        NoItem noRemovido, aux;

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
	public Integer remove (int cod) {

	}

	public Integer removePos (int pos) {

	}

*/

}
