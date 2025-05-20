package br.faesa.avaliacaoC1;

import br.faesa.aula2_lista_contigua.LCInteiro;

/*

Dada a classe lista de inteiros (LCInteiro) na Unidade 2, faça um programa que, usando métodos,

    a) Preencha uma lista da classe LCInteiro (deve ser um mét.odo)
    b) Crie uma segunda lista que receberá o dobro de cada elemento da primeira lista (deve ser um mét.odo). Por exemplo:
    lista1 = 1, 3, 6
    lista2 = 2, 6, 12
    c) Tire a média dos elementos da lista1 e depois da lista 2. (faça por mét.odo)
    d) Mostre na tela as duas listas e o resultado de cada média, por exemplo,
    lista1 = 1, 3, 6 → Média = 3,3 (10/3)
    lista2 = 2, 6, 12 → Média = 6,6 (20/3)

 */

public class Principal {

    public static void main(String args[]){
        LCInteiro L1 = new LCInteiro();
        int tamanho = 3;
        int valorMax = 10;

        Questao1.preencheLista(L1,tamanho,valorMax);
        System.out.println(L1);

        LCInteiro L2 = dobro(L1);
        System.out.println(L2);

        System.out.println("Lista 1: "+ L1 + "--> Média = " + media(L1));
        System.out.println("Lista 2: "+ L2 + "--> Média = " + media(L2));

    }



    public static LCInteiro dobro(LCInteiro lista1){
        LCInteiro lista2 = new LCInteiro();
        for (int i = 0; i < lista1.getQuant(); i++) {
            int aux = lista1.get(i);
            aux *= 2;

            lista2.insereFinal(aux);
        }
        return lista2;
    }

    public static double media(LCInteiro lista){
        int soma = 0;
        for (int i = 0; i < lista.getQuant(); i++) {
            soma += lista.get(i);
        }

        double media = (double) soma / lista.getQuant();

        return media;
    }

}
