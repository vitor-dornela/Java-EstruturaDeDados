package br.faesa.entidades;

public class NoArv {
    private int num;
    private NoArv esq;
    private NoArv dir;

    public NoArv(int elemento) {
        this.num = elemento;
        this.esq = null;
        this.dir = null;
    }

    public NoArv getEsq() {
        return esq;
    }

    public void setEsq(NoArv esq) {
        this.esq = esq;
    }

    public NoArv getDir() {
        return dir;
    }

    public void setDir(NoArv dir) {
        this.dir = dir;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return ""+this.num;
    }
}
