package br.faesa.aula8_arvore_binaria_busca;

import br.faesa.entidades.NoArv;

public class ABBInt {
    /*
    operações
    1 - construtor
    2 - pesquisa
    3 - inserir
    4 - remover
    5 - como caminhar
    6 - toString
     */
    private NoArv raiz;
    private int quant;

    public ABBInt(NoArv raiz, int quant) {
        this.raiz = null;
        this.quant = 0;
    }

    public NoArv pesquisa(int num) {
        return pesquisa(num, this.raiz);
    }

    private NoArv pesquisa (int num, NoArv no) {
        if (no == null) {
            return null;
        }
        if (num == no.getNum()) {
            return no;
        }
        if (num > no.getNum()) {
            return pesquisa(num, no.getDir());
        }
        return pesquisa(num, no.getEsq());
    }

    public boolean insere (int num) {
        if (pesquisa(num) == null) {
            this.raiz = insere(num, this.raiz);
            return true;
        }
        return false;
    }

    private NoArv insere (int num, NoArv no) {
        if (no == null) {
            NoArv novo = new NoArv(num);
            this.quant++;
            return novo;
        }
        if (num < no.getNum()) {
            no.setEsq(insere(num, no.getEsq()));
        }
        else if (num > no.getNum()) {
            no.setDir(insere(num, no.getDir()));
        }
        return no;
    }

    private NoArv remove (int num, NoArv no) {
        if (no == null) {
            return null;
        }
        if (num < no.getNum()) {
            no.setEsq(remove(num, no.getEsq()));
        } else if (num > no.getNum()) {
            no.setDir(remove(num, no.getDir()));
        } else if (no.getDir() == null) {
            quant--;
            return no.getEsq();
        } else if (no.getEsq() == null) {
            quant--;
            return no.getDir();
        } else {
            no.setEsq(maiorEsq());

        }
        return null;
    }

    private NoArv maiorEsq(NoArv noRemovido, NoArv maior) {
        if (maior.getDir() == null) {
            maior.setDir(maiorEsq(noRemovido, maior.getDir()));
            return maior;
        }
        noRemovido.setNum(maior.getNum());
        return maior.getEsq();
    }


}
