package br.faesa.aula5_pilha;

public class NoInt {
    private int valor;
    private NoInt prox;

    public NoInt(int valor) {
        this.valor = valor;
        this.prox = null;
    }

    public int getValor () {
        return this.valor;
    }
    public void setValor (int valor) {
        this.valor = valor;
    }
    public NoInt getProx () {
        return this.prox;
    }
    public void setProx (NoInt prox) {
        this.prox = prox;
    }

    public String toString() {
        return "Valor: " + this.valor + " Prox: " + this.prox;
    }
}
