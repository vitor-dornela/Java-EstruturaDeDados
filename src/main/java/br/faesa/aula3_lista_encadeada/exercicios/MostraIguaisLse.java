package br.faesa.aula3_lista_encadeada.exercicios;

import br.faesa.aula3_lista_encadeada.LSEInteiro;
import br.faesa.entidades.NoInt;

public class MostraIguaisLse {

	public static void main(String[] args) {
		LSEInteiro lista1 = new LSEInteiro();
		LSEInteiro lista2 = new LSEInteiro();
		LSEInteiro lista3;
		
		MaiorDaLse.preenche(lista1);
		MaiorDaLse.preenche(lista2);
		lista3 = iguais(lista1, lista2);
		System.out.println("LISTA 1    " + lista1);
		System.out.println("LISTA 2    " + lista2);
		System.out.println("LISTA 3    " + lista3);

	}

	public static LSEInteiro iguais(LSEInteiro lista1, LSEInteiro lista2) {
		LSEInteiro lista3 = new LSEInteiro();
		NoInt auxL1 = lista1.getPrim();
		NoInt auxL2;
		
		while (auxL1!=null) {
			auxL2 = lista2.getPrim();
			while (auxL2!=null) {
				if (auxL1.getElemento()==auxL2.getElemento()
				    && lista3.pesquisa(auxL1.getElemento())==null) {
					lista3.insereFinal(auxL1.getElemento());
				}
				auxL2 = auxL2.getProx();
			}
			auxL1 = auxL1.getProx();
		}
		return lista3;
	}

}
