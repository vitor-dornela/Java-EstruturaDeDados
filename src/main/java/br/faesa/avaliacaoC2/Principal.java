package br.faesa.avaliacaoC2;

/* Enunciado da prova
Usando as classes: NoInt.java, LSEInteiro.java, PilhaInt.java e FilaInt.java, faça um programa que, usando métodos,

(0,5) a) Preencha uma Pilha com 10 elementos (deve ser um mét.odo)
(0,25) b) Preencha uma LSE com os elementos da Pilha que estão na posição par. No final do mét.odo a pilha deve permanecer como no início do mét.odo (deve ser um mét.odo)
(0,25) c) Preencha uma Fila com os outros elementos da Pilha. No final do méto.do a pilha deve permanecer como no início do mét.odo (deve ser um mét.odo)
(0,5) d) Some todos os elementos da LSE
(0,5) e) Encontre o maior elemento da Pilha, mas a Pilha não pode ser destruída nem alterada
(0,5) f) Peça ao usuário um número e mostre quantas vezes ele aparece na Fila, mas a Fila não pode ser destruída nem alterada
(0,5) g) Imprima no Programa Principal as 3 estruturas e os resultados dos itens d, e, f.
 */

import java.util.Scanner;
import java.util.Random;
import br.faesa.entidades.NoInt;
import br.faesa.aula5_pilha.PilhaInt;
import br.faesa.aula3_lista_encadeada.LSEInteiro;
import br.faesa.aula6_fila.FilaInt;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaInt pilha = new PilhaInt();

        preenchePilha(pilha, sc);
        LSEInteiro lse = preencheLSEPosPar(pilha);
        FilaInt fila = preencheFilaPosImpar(pilha);

        int somaLSE = somaLSE(lse);
        int maior = maxPilha(pilha);

        System.out.print("Digite um número para contar na Fila: ");
        int numero = sc.nextInt();
        int ocorrencias = contaOcorrenciasFila(fila, numero);

        System.out.println();
        System.out.println("a) Pilha = " + pilha);
        System.out.println("b) LSE   = " + lse);
        System.out.println("c) Fila  = " + fila);
        System.out.println("d) Soma dos elementos da LSE = " + somaLSE);
        System.out.println("e) Maior elemento da Pilha  = " + maior);
        System.out.println("f) O número " + numero + " aparece " + ocorrencias + " vezes na Fila");

        //sc.close();
    }

    public static void preenchePilha(PilhaInt pilha, Scanner sc) {
    	//Random rand = new Random();
        for (int i = 1; i <= 10; i++) {
            System.out.print("Digite o elemento " + i + " da Pilha: ");            
            pilha.push(sc.nextInt());
          //pilha.push(rand.nextInt(100));
            }
    }

    public static LSEInteiro preencheLSEPosPar(PilhaInt pilha) {
        LSEInteiro lse = new LSEInteiro();
        NoInt aux = pilha.top();
        int pos = 1;
        while (aux != null) {
            if (pos % 2 == 0) {
                lse.insereFinal(aux.getElemento());
            }
            pos++;
            aux = aux.getProx();
        }
        return lse;
    }

    public static FilaInt preencheFilaPosImpar(PilhaInt pilha) {
        FilaInt fila = new FilaInt();
        NoInt aux = pilha.top();
        int pos = 1;
        while (aux != null) {
            if (pos % 2 != 0) {
                fila.enqueue(aux.getElemento());
            }
            pos++;
            aux = aux.getProx();
        }
        return fila;
    }

    public static int somaLSE(LSEInteiro lse) {
        int soma = 0;
        NoInt aux = lse.getPrim();
        while (aux != null) {
            soma += aux.getElemento();
            aux = aux.getProx();
        }
        return soma;
    }

    public static int maxPilha(PilhaInt pilha) {
        NoInt aux = pilha.top();
        int maior = 0;
        while (aux != null) {
            if (aux.getElemento() > maior) {
                maior = aux.getElemento();
            }
            aux = aux.getProx();
        }
        return maior;
    }

    public static int contaOcorrenciasFila(FilaInt fila, int valor) {
        int count = 0;
        NoInt aux = fila.peek();
        while (aux != null) {
            if (aux.getElemento() == valor) {
                count++;
            }
            aux = aux.getProx();
        }
        return count;
    }
}
