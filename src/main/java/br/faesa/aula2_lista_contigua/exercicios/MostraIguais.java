package br.faesa.aula2_lista_contigua.exercicios;

import br.faesa.aula2_lista_contigua.LCInteiro;

public class MostraIguais {

	public static void main(String[] args) {
		LCInteiro lista1 = new LCInteiro();
		LCInteiro lista2 = new LCInteiro();
		LCInteiro lista3;
		
		MaiorDaLista.preenche(lista1);
		MaiorDaLista.preenche(lista2);
		lista3 = iguais(lista1, lista2);
		System.out.println("LISTA 1    " + lista1);
		System.out.println("LISTA 2    " + lista2);
		System.out.println("LISTA 3    " + lista3);

	}

	public static LCInteiro iguais(LCInteiro lista1, LCInteiro lista2) {
		LCInteiro lista3 = new LCInteiro();
		
		for (int i=0; i<lista1.getQuant(); i++) {
			for (int j=0; j<lista2.getQuant(); j++) {
				if (lista1.get(i)==lista2.get(j)
					&& lista3.pesquisa(lista1.get(i))==-1) {
					lista3.insereFinal(lista1.get(i));
				}
			}
		}
		return lista3;
	}

}
