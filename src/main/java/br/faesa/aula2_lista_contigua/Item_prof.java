package br.faesa.aula2_lista_contigua;

public class Item_prof {
	private int codigo;
	private String nome;
	
	public Item_prof(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Codigo=" + codigo + ", Nome=" + nome;
	}
	
}
