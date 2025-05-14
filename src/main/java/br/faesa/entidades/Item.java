package br.faesa.entidades;

public class Item {
    int codigo;
    String nome;

    public Item(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Item(int codigo) {
        this.codigo = codigo;
        this.nome = "";
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
        return "{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
