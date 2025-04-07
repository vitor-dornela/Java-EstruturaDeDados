package br.faesa.aula2_lista_contigua;

import io.InOut;
import java.util.Random;

public class UsaLCInteiro {

    public static void main(String[] args) {
        // Variáveis para definir o intervalo de números inteiros
        int min = 0;
        int max = 9;

        // Solicita o tamanho de cada lista
        int tam1 = InOut.leInt("Digite a quantidade de elementos para L1:");
        int tam2 = InOut.leInt("Digite a quantidade de elementos para L2:");

        LCInteiro L1 = new LCInteiro(tam1);
        LCInteiro L2 = new LCInteiro(tam2);

        // Escolha de preenchimento para L1
        int opcaoL1 = InOut.leInt(
                "Para a lista L1, escolha:\n" +
                "1 - Inserir manualmente\n" +
                "2 - Preencher aleatoriamente"
        );
        if(opcaoL1 == 1) {
            preencheManual(L1, tam1, min, max, "L1");
        } else {
            preencheAleatorio(L1, tam1, min, max);
        }

        // Escolha de preenchimento para L2
        int opcaoL2 = InOut.leInt("Para a lista L2, escolha:\n1 - Inserir manualmente\n2 - Preencher aleatoriamente");
        if(opcaoL2 == 1) {
            preencheManual(L2, tam2, min, max, "L2");
        } else {
            preencheAleatorio(L2, tam2, min, max);
        }

        // Exibe as listas e realiza as operações solicitadas
        System.out.println("L1: " + L1);
        System.out.println("L2: " + L2);

        if(L1.igual(L2)) {
            System.out.println("As listas L1 e L2 são iguais.");
        } else {
            System.out.println("As listas L1 e L2 não são iguais.");
        }

        if(L1.estaContida(L2)) {
            System.out.println("L1 está contida em L2.");
        } else {
            System.out.println("L1 não está contida em L2.");
        }

        LCInteiro L3 = L1.concatena(L2);
        System.out.println("L3: " + L3);
    }


    public static void preencheAleatorio(LCInteiro lista, int tamanho, int min, int max) {
        Random random = new Random();
        int range = max - min + 1;
        for (int i = 0; i < tamanho; i++) {
            int valor = random.nextInt(range) + min;
            lista.insereFinal(valor);
        }
    }


    public static void preencheManual(LCInteiro lista, int tamanho, int min, int max, String nomeLista) {
        for (int i = 0; i < tamanho; i++) {
            int valor = InOut.leInt("Digite o valor para " + nomeLista + "[" + i + "] (" + min + " a " + max + "):");
            while (valor < min || valor > max) {
                valor = InOut.leInt("Valor inválido. Digite um valor entre " + min + " e " + max + " para " + nomeLista + "[" + i + "]:");
            }
            lista.insereFinal(valor);
        }
    }
}
