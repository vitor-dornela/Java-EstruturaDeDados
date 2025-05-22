package br.faesa.entidades;


public class NoItemDupla {
    private Item item;
    private NoItemDupla ant;
    private NoItemDupla prox;

    public NoItemDupla(Item item) {
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

    public NoItemDupla getAnt() {
        return ant;
    }

    public void setAnt(NoItemDupla ant) {
        this.ant = ant;
    }

    public NoItemDupla getProx() {
        return prox;
    }

    public void setProx(NoItemDupla prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "Item = " + item;
    }
}
