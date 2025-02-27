package br.faesa.avaliacaoDiagnostica;

import java.util.Scanner;

public class VetInt {

    private static Scanner scan = new Scanner(System.in);

    public static void preenche (int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.println("Entre com o valor " + i);
            vet[i] = scan.nextInt();

        }
    }

    public static void imprime(int[] vet) {
        System.out.println("| ");
        for (int i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        }
        System.out.println();
    }

}
