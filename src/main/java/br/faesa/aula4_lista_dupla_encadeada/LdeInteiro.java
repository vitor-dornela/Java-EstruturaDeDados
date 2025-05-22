package br.faesa.aula4_lista_dupla_encadeada;

import br.faesa.entidades.NoIntDupla;

/**
 * Lista duplamente encadeada de inteiros.
 */
public class LdeInteiro {
    private NoIntDupla prim, ult;
    private int quant;

    public LdeInteiro() {
        this.prim  = null;
        this.ult   = null;
        this.quant = 0;
    }

    public boolean eVazia() {
        return quant == 0;
    }

    public int tamanho() {
        return quant;
    }

    public NoIntDupla getPrim() {
        return prim;
    }

    public NoIntDupla getUlt() {
        return ult;
    }

    public void insereInicio(int elemento) {
        NoIntDupla no = new NoIntDupla(elemento);
        if (eVazia()) {
            ult = no;
        } else {
            no.setProx(prim);
            prim.setAnt(no);
        }
        prim = no;
        quant++;
    }

    public void insereFinal(int elemento) {
        NoIntDupla no = new NoIntDupla(elemento);
        if (eVazia()) {
            prim = no;
        } else {
            ult.setProx(no);
            no.setAnt(ult);
        }
        ult = no;
        quant++;
    }

    public boolean insere(int elemento, int pos) {
        if (pos < 0 || pos > quant) {
            return false;
        }
        if (pos == 0) {
            insereInicio(elemento);
        } else if (pos == quant) {
            insereFinal(elemento);
        } else {
            NoIntDupla ant = getNo(pos - 1);
            NoIntDupla no  = new NoIntDupla(elemento);
            NoIntDupla suc = ant.getProx();

            ant.setProx(no);
            no.setAnt(ant);
            no.setProx(suc);
            suc.setAnt(no);
            quant++;
        }
        return true;
    }

    public NoIntDupla pesquisa(int elemento) {
        NoIntDupla aux = prim;
        while (aux != null) {
            if (aux.getElemento() == elemento) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public NoIntDupla pesquisaAoContrario(int elemento) {
        NoIntDupla aux = ult;
        while (aux != null) {
            if (aux.getElemento() == elemento) {
                return aux;
            }
            aux = aux.getAnt();
        }
        return null;
    }

    public boolean remove(int elemento) {
        NoIntDupla no = pesquisa(elemento);
        if (no == null) return false;

        if (no == prim) {
            removeInicio();
        } else if (no == ult) {
            removeFinal();
        } else {
            NoIntDupla ant = no.getAnt();
            NoIntDupla suc = no.getProx();
            ant.setProx(suc);
            suc.setAnt(ant);
            quant--;
        }
        return true;
    }

    public NoIntDupla removeInicio() {
        if (eVazia()) return null;

        NoIntDupla rem = prim;
        prim = prim.getProx();
        if (prim != null) {
            prim.setAnt(null);
        } else {
            ult = null;
        }
        quant--;
        return rem;
    }

    public NoIntDupla removeFinal() {
        if (eVazia()) return null;

        NoIntDupla rem = ult;
        ult = ult.getAnt();
        if (ult != null) {
            ult.setProx(null);
        } else {
            prim = null;
        }
        quant--;
        return rem;
    }

    public NoIntDupla removePos(int pos) {
        if (pos < 0 || pos >= quant) return null;
        if (pos == 0) return removeInicio();
        if (pos == quant - 1) return removeFinal();

        NoIntDupla no = getNo(pos);
        NoIntDupla ant = no.getAnt();
        NoIntDupla suc = no.getProx();
        ant.setProx(suc);
        suc.setAnt(ant);
        quant--;
        return no;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoIntDupla aux = prim;
        while (aux != null) {
            sb.append(aux.getElemento()).append("\n");
            aux = aux.getProx();
        }
        return sb.toString();
    }

    public String toStringInverso() {
        StringBuilder sb = new StringBuilder();
        NoIntDupla aux = ult;
        while (aux != null) {
            sb.append(aux.getElemento()).append("\n");
            aux = aux.getAnt();
        }
        return sb.toString();
    }

    private NoIntDupla getNo(int pos) {
        if (pos < 0 || pos >= quant) return null;
        NoIntDupla aux;
        if (pos < quant / 2) {
            aux = prim;
            for (int i = 0; i < pos; i++) {
                aux = aux.getProx();
            }
        } else {
            aux = ult;
            for (int i = quant - 1; i > pos; i--) {
                aux = aux.getAnt();
            }
        }
        return aux;
    }
}
