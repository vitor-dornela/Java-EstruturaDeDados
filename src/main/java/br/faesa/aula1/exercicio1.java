package br.faesa.aula1;

import java.util.Scanner;

    /*

    Faça um programa em Java, somente usando array e tipos
primitivos, que:
. leia o nome de 5 alunos, a média deles e o número de faltas
. escreva na tela se o aluno está aprovado, reprovado por falta ou
reprovado por nota.
Obs.: O aluno está reprovado por falta se tiver mais que 20 faltas e
reprovado por nota se tiver 20 ou menos faltas e nota abaixo de 5,
caso contrário ele está aprovado. Escreva também o aluno com
maior média.

     */

public class exercicio1 {
    Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        Aluno aluno = pegaAluno();

        while(true){


        }

    }

    public static Aluno[] pegaAluno() {

        Aluno[] alunos = new Aluno[0];

        do {

            System.out.println("Digite o nome do aluno: ");
            String nome = scan.nextLine();
            System.out.println("Digite as faltas do aluno: ");
            int faltas = scan.nextInt();
            System.out.println("Digite a nota do aluno: ");
            double nota = scan.nextDouble();

            alunos[i] = new Aluno(nome, faltas, nota);

        }
        return alunos;

    }

    class Aluno{
        private String nome;
        private int faltas;
        private double nota;

        public Aluno(String nome, int faltas, double nota) {
            this.nome = nome;
            this.faltas = faltas;
            this.nota = nota;
        }

        @Override
        public String toString() {
            return "Aluno{nome='" + nome + "', faltas=" + faltas + ", nota=" + nota + "}";
        }
    }




}
