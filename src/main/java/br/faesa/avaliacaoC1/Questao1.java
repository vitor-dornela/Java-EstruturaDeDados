package br.faesa.avaliacaoC1;

// a) Preencha uma lista da classe LCInteiro (deve ser um mét.odo)

import br.faesa.aula2_lista_contigua.LCInteiro;

import java.util.Random;

public class Questao1 {
    public static void preencheLista(LCInteiro lista, int tamanho, int valorMax) {
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            lista.insereFinal(random.nextInt(valorMax + 1));
        }
    }
}
