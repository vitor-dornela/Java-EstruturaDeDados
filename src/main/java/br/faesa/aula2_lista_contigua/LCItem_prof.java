package br.faesa.aula2_lista_contigua;


import br.faesa.entidades.Item;

public class LCItem_prof {
/*
 * atributos: lista (array de Itens) e 
 *            quant (int- quantidade de elementos da lista).
 */
	private Item[] lista;
	private int quant;
	
	/*
	 * Construtor vazio que deve instanciar o vetor com tamanho 10.
	 * Construtor que recebe o tamanho do vetor e o instancia.
	 */
	
	public LCItem_prof(){
		this.lista = new Item[10];
		this.quant = 0;
	}
	
	public LCItem_prof(int tamanho){
		this.lista = new Item[tamanho];
		this.quant = 0;
	}
	
	// tamanho() => retorna o tamanho do vetor.
	public int tamanho(){
		return this.lista.length;
	}
	
	// getQuant() => retorna a quantidade de elementos da lista.
	public int getQuant(){
		return this.quant;
	}
	
	// eVazia() => retorna verdadeiro se a lista estiver vazia 
	//             e falso caso contr�rio.
	public boolean eVazia(){
		if (this.quant==0){
			return true;
		}
		return false;
	}
		
	// eCheia() => retorna verdadeiro se a lista estiver cheia 
	//             e falso caso contr�rio.
	public boolean eCheia(){
		if (this.quant==this.lista.length){
			return true;
		}
		return false;
	}
	
	/*
	 * getItem (posi��o) => retorna o elemento que est� na posi��o (par�metro). 
	 *                      Caso a posi��o n�o seja v�lida, retorna null.
	 */
	public Item getItem (int pos){
		if (pos>=0 && pos<tamanho()){
			return this.lista[pos];
		}
		return null;
	}
	
	public int pesquisa (int cod){
		for (int i=0; i<this.quant; i++){
			if(cod==this.lista[i].getCodigo()){
				return i;// achou o codigo e retorna sua posicao
			}
		}
		return -1; // terminou o for e nao achou
	}
	/*
	 * insereFim (Item) => insere um Item no final da lista. 
	 *                     Se ela estiver cheia, deve aumentar 
	 *                     o tamanho em 50%.
	 */
	public void insereFim (Item item){
		if (eCheia()){
			aumenta();
		}
		this.lista[this.quant] = item;
		this.quant++;
	}
	
	private void aumenta (){
		Item[] novo = new Item[(int)(this.lista.length*1.5)];// casting
		for (int i=0; i<this.quant; i++){
			novo[i] = this.lista[i];
		}
		this.lista = novo;
	}
	/*
	 * insere (Item, posicao) => insere um Item em uma posi��o da lista, 
	 *                           deslocando todos os elementos que estiverem 
	 *                           ap�s essa posi��o para o �ndice seguinte, 
	 *                           retornando true. Se a lista estiver cheia, 
	 *                           deve aumentar a lista em 50%. Se a posi��o 
	 *                           for inv�lida (menor que zero ou maior que 
	 *                           quant), deve retornar false.
	 */
	public boolean insere (Item item, int pos){
		if (pos<0 || pos>this.quant){
			return false;
		}
		if (eCheia()){
			aumenta();
		}
		// deslocar os itens da lista umja posicao para frente
		// ate a posicao pos
		for (int i=this.quant-1; i>=pos; i--){
			this.lista[i+1] = this.lista[i];
		}
		this.lista[pos] = item;
		this.quant++;
		return true;
	}
	
	public void insereInicio (Item item){
		insere(item, 0);
	}
	
	/*
	 * remove (pos) => deve remover um elemento que est� na posi��o 
	 *                 pos da lista. Se conseguir, deve retornar o 
	 *                 Item removido, se n�o conseguir, retorna null.
	 */
	
	public Item removePos (int pos) {
		Item aux;
		if (pos<0 || pos>=quant) {
			return null;
		}
		aux = this.lista[pos];
		for (int i = pos; i<quant-1; i++) {
			this.lista[i] = this.lista[i+1];
		}
		this.lista[quant-1] = null;
		this.quant--;
		return aux;
	}
	
	public Item remove (int cod) {
		Item aux;
		int pos = this.pesquisa(cod);
		aux = removePos(pos);
		return aux;
	}
	

	public String toString () {
		String aux = "";
		for (int i=0; i<this.quant; i++) {
			aux += this.lista[i].toString()+"\n";
		}
		return aux;
	}

	
}















