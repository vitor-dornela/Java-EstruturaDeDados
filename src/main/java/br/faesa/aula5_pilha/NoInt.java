package br.faesa.aula5_pilha;

public class NoInt {
    private int valor;
    private NoInt prox;

    public NoInt(int valor) {
        this.valor = valor;
        this.prox = null;
    }

    private int getValor () {
        return this.valor;
    }
    private void setValor (int valor) {
        this.valor = valor;
    }
    private NoInt getProx () {
        return this.prox;
    }
    private void setProx (NoInt prox) {
        this.prox = prox;
    }

    public String toString() {
        return "Valor: " + this.valor + " Prox: " + this.prox;
    }
}
