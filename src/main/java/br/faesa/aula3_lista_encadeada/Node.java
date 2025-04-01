package br.faesa.aula3_lista_encadeada;

public class Node {
    String valor;
    Node prox;

    Node(String valor) {
        this.valor = valor;
        this.prox = null;
    }

    void setProx(Node prox) {
        this.prox = prox;
    }

    Node getProx() {
        return this.prox;
    }

    @Override
    public String toString() {
        Node atual = this;
        String s = "";
        while (atual != null) {
            s += "[" + atual.valor + "] → ";
            atual = atual.prox;
        }
        s += "null";
        return s;
    }

}
