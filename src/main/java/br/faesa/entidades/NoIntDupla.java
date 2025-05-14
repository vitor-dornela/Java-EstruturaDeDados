package br.faesa.entidades;

/**
 * Nó para lista duplamente encadeada de inteiros.
 * Contém o valor inteiro e referências para o nó anterior e o nó próximo.
 */
public class NoIntDupla {
    private int elemento;
    private NoIntDupla ant;
    private NoIntDupla prox;

    /**
     * Construtor que recebe o valor e inicializa os ponteiros.
     * @param elemento o valor inteiro armazenado no nó
     */
    public NoIntDupla(int elemento) {
        this.elemento = elemento;
        this.ant = null;
        this.prox = null;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public NoIntDupla getAnt() {
        return ant;
    }

    public void setAnt(NoIntDupla ant) {
        this.ant = ant;
    }

    public NoIntDupla getProx() {
        return prox;
    }

    public void setProx(NoIntDupla prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return String.valueOf(elemento);
    }
}
