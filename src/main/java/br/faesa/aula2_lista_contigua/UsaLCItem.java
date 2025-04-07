package br.faesa.aula2_lista_contigua;

import io.InOut;


public class UsaLCItem {

	public static void main(String[] args) {
		int opcao;
		LCItem lista = new LCItem();
		
		do {
			opcao = InOut.leInt("Digite uma opcao\n"+
								"1 - Cadastrar\n"+
								"2 - Pesquisar\n"+
								"3 - Alterar nome\n"+
								"4 - Remover ultimo\n"+
								"5 - Remover Item\n"+
								"6 - Imprimir\n "+
								"7 - Terminar");
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

	public static void cadastrar(LCItem lista) {
		/*
		 * 1 - pedir a posicao, o nome e o codigo
		 * 2 - Instanciar um Item (com nome e codigo)
		 * 3 - Chamar o metodo inserir da classe LCItem
		 */

		int pos = InOut.leInt("Entre com uma posicao");
		String nome = InOut.leString("Entre com o nome");
		int codigo = InOut.leInt("Entre com o codigo");
		Item item = new Item(codigo, nome);
		boolean ok = lista.insere(pos, item);
		if (!ok) {// (ok == false) ou (ok != true)
			System.out.println("Posicao invalida. Nao pode cadastrar");
		}else {
			System.out.println("CADASTRO EFETUADO COM SUCESSO");
		}
	}

	private static void pesquisar(LCItem lista) {
		/*
		 * 1 - pedir o codigo
		 * 2 - chamar o metodo pesquisar da classe LCItem
		 * 3 - imprimir o resultado na tela
		 */
		int codigo = InOut.leInt("Entre com o codigo");
		int pos = lista.pesquisa(codigo);
		if (pos < 0) {
			System.out.println(codigo+"  nao existe");
		}else {
			System.out.println(lista.getItem(pos).toString());
		}
	}

	private static void alterar(LCItem lista) {
		/*
		 * 1 - pedir o codigo
		 * 2 - chamar o metodo pesquisa
		 * 3 - acessar o elemento da posicao pesquisada e modificar seu nome
		 *     ou mostrar mensagem se o elemento n�o existir
		 */
		String novoNome;
		int codigo = InOut.leInt("Entre com o codigo");
		int pos = lista.pesquisa(codigo);
		Item item;
		if (pos < 0) {
			System.out.println(codigo+"  nao existe");
		}else {
			item = lista.getItem(pos);
			System.out.println(item.toString());
			novoNome = InOut.leString(item.toString()+
					"\nEntre com o novo nome");
			item.setNome(novoNome);
		}		
	}

	private static void removerUltimo(LCItem lista) {
		/*
		 * 1 - chamar o remover na posicao getQuant-1
		 * 2 - mostrar na tela msg de erro ou o elemento removido
		 */
		Item item = lista.remover(lista.getQuant()-1);
		if (item==null) {
			System.out.println("nao foi possivel remover");
		}else {
			System.out.println("Item "+item.toString()+
					"   removido com sucesso");
		}
	}

	private static void remover(LCItem lista) {
	/*
	 * 1 - pedir o codigo
	 * 2 - chamar o remover pelo codigo
	 * 3 - mostrar na tela msg de erro ou o elemento removido
	 */
		int codigo = InOut.leInt("Digite o codigo");
		Item item = lista.removerCod(codigo);
		if (item==null) {
			System.out.println("Item nao existe. Nao foi removido");
		}else {
			System.out.println("Item "+item.toString()+
					"   removido com sucesso");
		}	
	}
}
