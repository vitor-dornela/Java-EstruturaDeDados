package br.faesa.aula3_lista_encadeada.exercicios;

import java.util.Scanner;

import br.faesa.entidades.Item;
import br.faesa.entidades.NoItem;
import br.faesa.aula3_lista_encadeada.LSEItem;

public class LSEMain {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcao;
		LSEItem lista = new LSEItem();
		
		do {
			System.out.println("Digite uma opcao\n"+
								"1 - Cadastrar\n"+
								"2 - Pesquisar\n"+
								"3 - Alterar nome\n"+
								"4 - Remover ultimo\n"+
								"5 - Remover Item\n"+
								"6 - Imprimir\n "+
								"7 - Terminar");
			opcao = scan.nextInt();
			switch (opcao) {
			case 1:
				cadastrar (lista);
				break;
			case 2: 
				pesquisar (lista);
				break;
			case 3:
				alterar (lista);
				break;
			case 4: 
				removerUltimo(lista);
				break;
			case 5:
				remover (lista);
				break;
			case 6:
				System.out.println(lista.toString());
				break;
			case 7:
				System.out.println("FIM");
				break;
			default:
				System.out.println("OPCAO INVALIDA");
			}
			
		}while (opcao != 7);

	}

	public static void cadastrar(LSEItem lista) {
		System.out.println("Entre com uma posicao");
		int pos = scan.nextInt();
		System.out.println("Entre com o nome");
		String nome = scan.next();
		System.out.println("Entre com o codigo");
		int codigo = scan.nextInt();
		Item item = new Item(codigo, nome);
		boolean ok = lista.insere(item, pos);
		if (!ok) {
			System.out.println("Posicao invalida. Nao pode cadastrar");
		}else {
			System.out.println("CADASTRO EFETUADO COM SUCESSO");
		}
	}

	private static void pesquisar(LSEItem lista) {
		System.out.println("Entre com o codigo");
		int codigo = scan.nextInt();
		NoItem no = lista.pesquisa(codigo);
		if (no==null) {
			System.out.println(codigo+"  nao existe");
		}else {
			System.out.println(codigo + "  "+no.getItem().getNome());
		}
	}

	private static void alterar(LSEItem lista) {
		String novoNome;
		System.out.println("Entre com o codigo");
		int codigo = scan.nextInt();
		NoItem no = lista.pesquisa(codigo);
		if (no==null) {
			System.out.println(codigo+"  nao existe");
		}else {
			System.out.println(no.getItem().toString());
			System.out.println("Entre com o novo nome");
			novoNome = scan.next();
			no.getItem().setNome(novoNome);
		}		
	}

	private static void removerUltimo(LSEItem lista) {
		NoItem no = lista.removePos(lista.tamanho()-1);
		if (no==null) {
			System.out.println("nao foi possivel remover");
		}else {
			System.out.println("Item "+no.getItem().toString()+
					"   removido com sucesso");
		}
	}

	private static void remover(LSEItem lista) {
		System.out.println("Entre com o codigo");
		int codigo = scan.nextInt();
		NoItem no = lista.remove(codigo);
		if (no==null) {
			System.out.println("Item nao existe. Nao foi removido");
		}else {
			System.out.println("Item "+no.getItem().toString()+
					"   removido com sucesso");
		}	
	}
}
