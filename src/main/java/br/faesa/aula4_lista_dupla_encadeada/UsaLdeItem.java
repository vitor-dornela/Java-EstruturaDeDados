package br.faesa.aula4_lista_dupla_encadeada;

import br.faesa.entidades.Item;
import br.faesa.entidades.NoItemDupla;
import br.faesa.io.InOut;

public class UsaLdeItem {
    public static void main(String[] args) {
        LdeItem lista = new LdeItem();
        int opc;

        do {
            String menu = "Menu LDE \n"
                    + "1 – Inserir um nó no final da lista\n"
                    + "2 – Inserir um nó no início da lista\n"
                    + "3 – Pesquisar na lista\n"
                    + "4 – Remover uma posição da lista\n"
                    + "5 – Imprimir a lista\n"
                    + "6 – Imprimir a lista invertida\n"
                    + "7 – Sair\n\n"
                    + "Escolha uma opção:";
            opc = InOut.leInt(menu);

            switch (opc) {
                case 1: {
                    int codF = InOut.leInt("Código do item:");
                    String descF = InOut.leString("Descrição do item:");
                    lista.insereFinal(new Item(codF, descF));
                    InOut.msgSemIcone("Sucesso", "Nó inserido no final.");
                    break;
                }
                case 2: {
                    int codI = InOut.leInt("Código do item:");
                    String descI = InOut.leString("Descrição do item:");
                    lista.insereInicio(new Item(codI, descI));
                    InOut.msgSemIcone("Sucesso", "Nó inserido no início.");
                    break;
                }
                case 3: {
                    int codP = InOut.leInt("Código a pesquisar:");
                    NoItemDupla ach = lista.pesquisa(codP);
                    if (ach != null) {
                        InOut.msgSemIcone("Resultado", "Encontrado: " + ach.getItem());
                    } else {
                        InOut.msgSemIcone("Resultado", "Item não encontrado.");
                    }
                    break;
                }
                case 4: {
                    int pos = InOut.leInt("Posição a remover (0 a " + (lista.tamanho() - 1) + "):");
                    NoItemDupla rem = lista.removePos(pos);
                    if (rem != null) {
                        InOut.msgSemIcone("Sucesso", "Removido: " + rem.getItem());
                    } else {
                        InOut.msgSemIcone("Erro", "Posição inválida.");
                    }
                    break;
                }
                case 5:
                    InOut.msgSemIcone("Lista", lista.toString());
                    break;
                case 6:
                    InOut.msgSemIcone("Lista Invertida", lista.toStringInverso());
                    break;
                case 7:
                    InOut.msgSemIcone("Saindo", "Encerrando o programa.");
                    break;
                default:
                    InOut.msgSemIcone("Erro", "Opção inválida.");
            }
        } while (opc != 7);
    }
}