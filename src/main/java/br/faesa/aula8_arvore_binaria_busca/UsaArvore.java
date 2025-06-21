package br.faesa.aula8_arvore_binaria_busca;

import java.util.Random;
import br.faesa.aula2_lista_contigua.LCInteiro;

public class UsaArvore {

    public static void main(String[] args) {
        ABBInt   arvore    = new ABBInt();
        Random   rand      = new Random();
        LCInteiro inseridos = new LCInteiro(20);

        // a) Insira c/ 20 elementos aleatórios (sem repetir) na árvore e mostre quais foram
        int count = 0;
        while (count < 20) {
            int v = rand.nextInt(100);
            // pesquisa(v) devolve null se não existir
            if (arvore.pesquisa(v) == null) {
                arvore.insere(v);
                inseridos.insereFinal(v);
                count++;
            }
        }
        System.out.println("a) Árvore c/ 20 elementos aleatórios: " + inseridos);

        // b) Árvore original, com elementos ordenados (in-ordem)
        LCInteiro inOrdem = arvore.CamInOrdem();
        System.out.println("b) Árvore c/ 20 elementos em ordem:   " + inOrdem);

        // c) Soma dos nós e maior elemento da árvore
        System.out.println("c) Soma dos nós: " + arvore.soma()
                + "\n   Maior elemento: " + arvore.maior());

        // d) Cria duas árvores — pares e ímpares — e mostra o conteúdo de cada uma
        ABBInt pares   = new ABBInt();
        ABBInt impares = new ABBInt();
        for (int i = 0; i < inOrdem.getQuant(); i++) {
            int w = inOrdem.get(i);
            if (w % 2 == 0) pares.insere(w);
            else            impares.insere(w);
        }
        System.out.println("d) Árvore de pares em ordem:    " + pares.CamInOrdem());
        System.out.println("   Árvore de ímpares em ordem:  " + impares.CamInOrdem());

        // e) Vetor do caminhamento pós-ordem da árvore de pares
        LCInteiro posPares = pares.CamPosOrdem();
        System.out.println("e) Pós-ordem (pares):           " + posPares);

        // f) Vetor do caminhamento pré-ordem da árvore de ímpares
        LCInteiro preImpares = impares.CamPreOrdem();
        System.out.println("f) Pré-ordem (ímpares):         " + preImpares);
    }
}
