package br.faesa.aula4_lista_dupla_encadeada;

import br.faesa.entidades.Item;


public class NoDupla {
    private Item item;
    private NoDupla ant;
    private NoDupla prox;

    public NoDupla(Item item) {
        this.item = item;
        this.ant = null;
        this.prox = null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public NoDupla getAnt() {
        return ant;
    }

    public void setAnt(NoDupla ant) {
        this.ant = ant;
    }

    public NoDupla getProx() {
        return prox;
    }

    public void setProx(NoDupla prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "Item = " + item;
    }
}
