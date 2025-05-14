package br.faesa.aula6_fila;


/*
2) Faça um programa que leia 10 números inteiros e armazene-o numa fila. Em
seguida, retire os valores maiores que 10 desta fila. Obs.: Você deve fazer pelo menos
dois métodos: um para ler e enfileirar os números e outro para fazer a remoção dos
números maiores que 10.
 */


import br.faesa.entidades.NoInt;

import java.util.Random;


public class UsaFila {
    static final int quant = 10;


    public static void main(String[] args) {

        FilaInt fila = new FilaInt();
        preencheAleatorio( fila, quant, 0, 100 );
        removeMaior(fila, 10);

    }


    public static void preencheAleatorio(FilaInt fila, int tamanho, int min, int max) {
        Random random = new Random();
        int range = max - min + 1;

        for (int i = 0; i < tamanho; i++) {
            int valor = random.nextInt(range) + min;
            fila.enqueue(valor);
        }
    }

    public static void removeMaior(FilaInt fila, int valor) {
        FilaInt filaAux = new FilaInt();
        NoInt no;

        for (int i = 0; i < quant; i++) {
            no = fila.dequeue();
            if (no.getElemento() > valor) {
                filaAux.enqueue(no.getElemento());
            }
        }
        while (!filaAux.isEmpty()) {
            no = filaAux.dequeue();
            fila.enqueue(no.getElemento());
        }

    }
}
