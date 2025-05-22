package br.faesa.avaliacaoC1;
import br.faesa.aula2_lista_contigua.LCInteiro;

import java.util.Scanner;

public class Questao4 {
    private static final Scanner scanner = new Scanner(System.in);

/*
    a) Preencha uma lista da classe LCInteiro (deve ser um método_)
    b) Crie uma segunda lista que receberá o dobro de cada elemento da primeira lista (deve ser um método_). Por exemplo:
        lista1 = 1, 3, 6
        lista2 = 2, 6, 12
    c) Tire a média dos elementos da lista1 e depois lista2 (faça por métodos)
    d) Mostre na tela as duas listas e o resultado de cada média
 */

    public static void main(String[] args) {

    }

    private static void preencher(LCInteiro lista1) {
        int tamanho;
        System.out.println("Tamanho do lista: ");
        tamanho = scanner.nextInt();
        int aux;
        for (int i = 0; i < tamanho; i++) {
            aux = (int) (Math.random() * 30 + 1);
            lista1.insereFinal(aux);
        }
    }

    private static void formar(LCInteiro lista2, LCInteiro lista1) {
        int aux;
        for (int i = 0; i < lista1.getQuant(); i++) {
            aux = lista1.get(i) * 2;
            lista2.insereFinal(aux);
        }
    }

    private static double media(LCInteiro lista2) {

        return 0;
    }
}