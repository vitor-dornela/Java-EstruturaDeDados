package br.faesa.aula5_pilha.exercicios;

import br.faesa.aula5_pilha.PilhaInt;

import java.util.Random;

/*
Faça um metödo que recebe das pilhas, da classe PilhaInt, sendo que uma delas já está preenchida e a outra está vazia. Receba também uma fila, da classe FilaInt, vazia. Pegue os elementos da pilha 1 e coloque os PARES na fila e os ÍMPARES na pilha2. Ao final, a pilha 1 ficará vazia e a pilha 2 e a fila estarão como no exemplo:
ANTES
pilha1 = 1 3 5 6 8 10
pilha2 = null
fila = null

DEPOIS
pilha1 = null
pilha2 = 6 8 10
fila = 1 3 5
 */
public class TransferePilha {
    public static void main(String[] args) {
        PilhaInt pilha = new PilhaInt();

        preencheAleatorio(pilha, 10, 100);

    }

    public static void preencheAleatorio(PilhaInt pilha, int tamanho, int max) {
        Random random = new Random();
        int range = max + 1;
        for (int i = 0; i < tamanho; i++) {
            int valor = random.nextInt(range);
            pilha.push(valor);
        }
    }
}
