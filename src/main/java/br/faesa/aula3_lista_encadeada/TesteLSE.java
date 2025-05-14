package br.faesa.aula3_lista_encadeada;

import br.faesa.aula2_lista_contigua.Item;

public class TesteLSE {

	public static void main(String[] args) {
		LSEItem lista = new LSEItem();
		
		lista.insereInicio(new Item(12));
		lista.insereInicio(new Item(55));
		lista.insereInicio(new Item(37));
		lista.insereInicio(new Item(22));
		lista.insere(new Item(89), 3);

		//System.out.println(lista);

		LSEItem Q = new LSEItem();
		Q.insereInicio(new Item(12));
		Q.getPrim().getItem().setCodigo(2*Q.getPrim().getItem().getCodigo());
		Q.insereInicio(new Item(2*Q.getPrim().getItem().getCodigo()));
		Q.limpa();
		System.out.println(Q);

		LSEItem P = new LSEItem();
		P.insereInicio(new Item(12));
		P.insereInicio(new Item(55));
		P.insereInicio(new Item(37));
		//P = null;
		P.limpa();


		System.out.println(P);


		// P → p1 → p2 → p3
		P.insereFinal(new Item(12, "p1"));
		P.insereFinal(new Item(55, "p2"));
		P.insereFinal(new Item(37, "p3"));

		// P → p1 → p2
		P.getPrim().getProx().setProx(null); //faz ponteiro de p2 apontar para null
		P.setUlt(P.getPrim().getProx()); //faz ponteiro ult apontar para p2

		System.out.println(P.getUlt());
		System.out.println(P);
	}

}
