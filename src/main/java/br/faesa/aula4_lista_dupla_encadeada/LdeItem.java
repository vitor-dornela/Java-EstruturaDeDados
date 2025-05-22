package br.faesa.aula4_lista_dupla_encadeada;

import br.faesa.entidades.Item;
import br.faesa.entidades.NoItemDupla;

public class LdeItem {
    private NoItemDupla prim, ult;
    private int quant;

    public LdeItem() {
        this.prim = null;
        this.ult = null;
        this.quant = 0;
    }

    public NoItemDupla getPrim() {
        return this.prim;
    }

    public NoItemDupla getUlt() {
        return this.ult;
    }

    public int tamanho () {
        return this.quant;
    }

    public boolean eVazia () {
        return this.quant == 0;
    }

    public NoItemDupla pesquisa (int cod) {
        NoItemDupla aux = this.prim;
        while (aux != null) {
            if (aux.getItem().getCodigo() == cod) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public void insereInicio (Item item) {
        NoItemDupla no = new NoItemDupla(item);

        if (this.eVazia()) {
            this.ult = no;
        } else {
            no.setProx(this.prim);
            this.prim.setAnt(no);
        }
        this.prim = no;
        this.quant++;
    }

    public void insereFinal (Item item) {
        NoItemDupla no = new NoItemDupla(item);
        NoItemDupla aux;

        if (this.eVazia()) {
            this.prim = no;
        } else {
            this.ult.setProx(no);
            no.setAnt(this.ult);
        }
        this.ult = no;
        this.quant++;
    }

    public boolean insere (Item item, int pos) {
        NoItemDupla aux;
        NoItemDupla no = new NoItemDupla(item);

        if (pos >= 0 && pos <= this.quant) {
            if (pos == 0) {
                this.insereInicio(item);
            } else if (pos == this.quant) {
                this.insereFinal(item);
            } else {
                aux = this.get(pos - 1);
                no.setProx(aux.getProx());
                aux.getProx().setAnt(no);
                aux.setProx(no);
                no.setAnt(aux);
                this.quant++;
            }
            return true;
        }
        return false;
    }

    public NoItemDupla removeInicio () {
        NoItemDupla noRemovido;

        if (this.eVazia()) {
            return null;
        }
        noRemovido = this.prim;
        this.prim = this.prim.getProx();
        if (this.prim != null) {
            this.prim.setAnt(null);
        } else {
            this.ult = null;
        }
        this.quant--;
        return noRemovido;
    }

    public NoItemDupla removeFinal () {
        NoItemDupla noRemovido, aux;

        if (this.eVazia()) {
            return null;
        }
        if (this.quant == 1) {
            noRemovido = this.prim;
            this.prim = null;
            this.ult = null;
        } else {
            aux = this.get(this.quant - 2);
            noRemovido = this.ult;
            aux.setProx(null);
            this.ult = aux;
        }
        this.quant--;
        return noRemovido;
    }

    public NoItemDupla removeCod (int cod) {
        NoItemDupla atual = this.prim;
        NoItemDupla ant;

        if (this.eVazia()) {
            return null;
        }
        if (this.prim.getItem().getCodigo() == cod) {
            return this.removeInicio();
        }
        ant = this.prim;
        while (atual != null && atual.getItem().getCodigo() != cod) {
            ant = atual;
            atual = atual.getProx();
        }
        if (atual == null) {
            return null;
        }
        if (atual == this.ult) {
            return this.removeFinal();
        }
        ant.setProx(atual.getProx());
        atual.getProx().setAnt(ant);
        this.quant--;
        return atual;
    }

    public NoItemDupla removePos (int pos) {
        if (pos < 0 || pos >= this.quant) {
            return null;
        }
        if (pos == 0) {
            return this.removeInicio();
        }
        if (pos == this.quant - 1) {
            return this.removeFinal();
        }
        NoItemDupla atual = this.get(pos);
        NoItemDupla ant = this.get(pos - 1);
        ant.setProx(atual.getProx());
        atual.getProx().setAnt(ant);
        this.quant--;
        return atual;
    }

    public String toString() {
        String temp = "";
        NoItemDupla aux = this.prim;

        while (aux != null) {
            temp += aux.getItem() + "\n";
            aux = aux.getProx();
        }
        return temp;
    }

    public String toStringInverso() {
        String temp = "";
        NoItemDupla aux = this.ult;

        while (aux != null) {
            temp += aux.getItem() + "\n";
            aux = aux.getAnt();
        }
        return temp;
    }

    private NoItemDupla get (int pos) {
        if (pos < 0 || pos >= this.quant) {
            return null;
        }
        NoItemDupla aux;
        if (pos < this.quant / 2) {
            aux = this.prim;
            for (int i = 0; i < pos; i++) {
                aux = aux.getProx();
            }
        } else {
            aux = this.ult;
            for (int i = this.quant - 1; i > pos; i--) {
                aux = aux.getAnt();
            }
        }
        return aux;
    }
}
