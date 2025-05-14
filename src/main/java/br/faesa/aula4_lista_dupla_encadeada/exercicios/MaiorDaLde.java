package br.faesa.aula4_lista_dupla_encadeada.exercicios;
import br.faesa.aula4_lista_dupla_encadeada.LdeInteiro;
import br.faesa.entidades.NoIntDupla;


import java.util.Scanner;

/*
1) criar lista
    a) manual -> Scanner
    b) automatica -> Math
2) verificar um a um qual é o maior e guardar

 */

public class MaiorDaLde {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LdeInteiro lista = new LdeInteiro();

        preencheManual(lista);
        System.out.println("Maior da Lde: " + maior(lista));


    }

    public static void preencheManual(LdeInteiro lista) {

        int aux;
        do {
            System.out.println("Digite um inteiro para adicionar na lista ou 0 para sair: ");
            aux = scanner.nextInt();
            lista.insereFinal(aux);
        } while (aux != 0);
    }

    public static int maior (LdeInteiro lista) {

        NoIntDupla maior = lista.getPrim();
        NoIntDupla aux = lista.getPrim().getProx();
        while (aux != null) {
            if (aux.getElemento() > maior.getElemento()) {
                maior = aux;
            }
            aux = aux.getProx();
        }
        return maior.getElemento();


    }
}
