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
    }

}
