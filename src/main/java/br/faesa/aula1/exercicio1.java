package br.faesa.aula1;

import java.util.Scanner;

public class exercicio1 {

    public static void main(String[] args) {

        Aluno[] alunos = pegaAluno();

        Aluno melhorAluno = alunos[0];

        for (Aluno aluno : alunos) {
            if (aluno.faltas > 20) {
                System.out.println(aluno.nome + " está REPROVADO POR FALTA.");
            } else if (aluno.nota < 5) {
                System.out.println(aluno.nome + " está REPROVADO POR NOTA.");
            } else {
                System.out.println(aluno.nome + " está APROVADO.");
            }

            if (aluno.nota > melhorAluno.nota) {
                melhorAluno = aluno;
            }
        }

        System.out.println("Aluno com maior média: " + melhorAluno.nome + " - Nota: " + melhorAluno.nota);
    }

    public static Aluno[] pegaAluno() {
        Scanner scan = new Scanner(System.in);
        Aluno[] alunos = new Aluno[5];

        for (int i = 0; i < alunos.length; i++) {
            System.out.println("Digite o nome do aluno: ");
            String nome = scan.nextLine();
            System.out.println("Digite as faltas do aluno: ");
            int faltas = scan.nextInt();
            System.out.println("Digite a nota do aluno: ");
            double nota = scan.nextDouble();
            scan.nextLine(); // limpa o buffer

            alunos[i] = new Aluno(nome, faltas, nota);
        }

        return alunos;
    }

    static class Aluno {
        String nome;
        int faltas;
        double nota;

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
