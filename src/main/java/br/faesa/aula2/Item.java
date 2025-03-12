package br.faesa.aula2;

public class Item {
    int codigo;
    String nome;

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
        return "Item{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
