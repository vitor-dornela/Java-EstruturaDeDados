package br.faesa.aula7_recursividade;

import br.faesa.io.InOut;
public class FatorialIterativo {

    public static void main(String[] args) {
        int num;
        do {
            num = InOut.leInt("Entre com um numero >= 0");
        } while (num < 0);
        System.out.println(num + "! = " + fatorial(num));
    }

    public static int fatorial(int num) {
        int total = 1;
        if (num == 0) {
            return 1;
        } else {
            for (int i = num; i >= 1; i--) {
                total = total * i;
            }
            return total;
        }
    }
}
