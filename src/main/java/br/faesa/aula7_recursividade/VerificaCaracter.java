package br.faesa.aula7_recursividade;

import java.util.Scanner;

public class VerificaCaracter {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String frase, aux;
        char carac;
        System.out.println("Entre com uma frase: ");
        frase = sc.nextLine();
        frase = frase.toUpperCase();

        System.out.println("Entre com um caracter: ");
        aux = sc.next();

        carac = aux.charAt(0);
        carac = Character.toUpperCase(carac);

        // Chama mét.odo iterativo
        System.out.print("Usando método iterativo: ");
        if (pertenceIterativa(frase, carac)) {
            System.out.println("Caracter " + carac + " está presente!");
        }
        else {
            System.out.println("Caracter não está presente!");
        }

        // Chama mét.odo recursivo
        System.out.print("Usando método recursivo: ");
        if (pertenceRecursiva(frase, carac)) {
            System.out.println("Caracter " + carac + " está presente!");
        }
        else {
            System.out.println("Caracter não está presente!");
        }

    }


    public static boolean pertenceIterativa(String palavra, char carac) {
        for (int i = 0; i < palavra.length(); i++) {
            if (carac == palavra.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean pertenceRecursiva (String frase, char carac) {
        return pertenceRecursiva(frase, carac, 0);
    }

    private static boolean pertenceRecursiva(String frase, char carac, int i) {
        if (i == frase.length()) {
            return false;
        }
        if (frase.charAt(i) == carac) {
            return true;
        }
        return pertenceRecursiva(frase, carac, i + 1);
    }

}
