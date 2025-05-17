package br.faesa.aula5_pilha.exercicios;

import br.faesa.aula4_lista_dupla_encadeada.LdeInteiro;
import br.faesa.aula5_pilha.PilhaInt;
import br.faesa.aula6_fila.FilaInt;

import java.util.Random;
import java.util.Scanner;

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
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PilhaInt pilha1 = new PilhaInt();
        PilhaInt pilha2 = new PilhaInt();
        FilaInt fila1 = new FilaInt();


        //preencheManual(pilha);
        preencheAleatorio(pilha1, 10, 10);
        System.out.println(pilha1);

    }

    public static void preencheAleatorio(PilhaInt pilha, int tamanho, int max) {
        Random random = new Random();
        int range = max + 1;
        for (int i = 0; i < tamanho; i++) {
            int valor = random.nextInt(range);
            pilha.push(valor);
        }
    }
    public static void preencheManual(PilhaInt pilha) {

        int aux;
        do {
            System.out.println("Digite um inteiro para adicionar na lista ou 0 para sair: ");
            aux = scanner.nextInt();
            pilha.push(aux);
        } while (aux != 0);
    }

    public void dividePilha(PilhaInt pilha) {
        if (pilha.isEmpty()) {
            return;
        }
        if (pil %2 == 0)

    }


}
