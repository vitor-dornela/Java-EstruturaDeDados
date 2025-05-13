package br.faesa.aula3_lista_encadeada.outro;

public class Node_Principal {
    public static void main(String[] args) {
        Node q1 = new Node("q1");
        Node q2 = new Node("q2");
        Node q3 = new Node("q3");


        q1.setProx(q2);
        q2.setProx(q3);

        // Q → [q1] → [q2] → [q3] → null
        Node Q = q1;
        System.out.println(Q);

        // Q → [q1] → null
        q1.setProx(null);
        System.out.println(Q);

        // Q → null
        q1.setProx(q2);
        q2.setProx(q3);
        System.out.println(Q);


        Q.setProx(Q.getProx().getProx());
        System.out.println(Q);

        Q.setProx(q2);




    }

}
