package br.faesa.aula2;

public class LCItem {

    private Item[] lista;
    private int quant;

    public LCItem() {
        this.lista = new Item[10];
        this.quant = 0;
    }
    public LCItem(int tamanho) {
        this.lista = new Item[tamanho];
        this.quant = 0;
    }

    public int tamanho() {
        return this.lista.length;
    }

    public int getQuant() {
        return this.quant;
    }

    public boolean eVazia() {
        return this.quant == 0;
    }

    public boolean eCheia() {
        return this.getQuant() == this.tamanho();
    }

    public Item getItem(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho()) {
            return null;
        }
        return this.lista[posicao];
    }

    public Item pesquisa(Item cod) {
        for (int i = 0; i < this.tamanho(); i++) {
            if (this.lista[i] == cod) {
                return this.lista[i];
            }
            return -1;
        }
    }



}
