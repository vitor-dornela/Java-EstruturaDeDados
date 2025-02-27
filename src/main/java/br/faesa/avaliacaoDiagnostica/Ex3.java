package br.faesa.avaliacaoDiagnostica;

import java.util.Scanner;

public class Ex3 {

    private static Scanner scan = new Scanner(System.in);
    private static int quant = 0;

    public static void main(String[] args) {
        int[] vet = new int[20];

        preenche(vet);
        imprime(vet);
    }

    public static void imprime(int[] vet) {
        System.out.println("| ");
        for (int i = 0; i < quant; i++) {
            System.out.println(vet[i]);
        }
        System.out.println();
    }

    private static void preenche(int[] vet) {
        char op = 0;

        do {
            if (quant < vet.length) {
                System.out.println("Entre com um numero inteiro: ");
                vet[quant] = scan.nextInt();
                quant++;
                System.out.println("Quer continuar preenchendo? <S> ou <N>");
                op = scan.next().toUpperCase().charAt(0);

            } else {
                System.err.println("VETOR CHEIO");
                op = 'N';
            }
        } while (op == 'S');

    }
}
