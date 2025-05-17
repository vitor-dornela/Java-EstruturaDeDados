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
                    + "3 – Inserir um nó numa posição da lista\n"
                    + "4 – Pesquisar na lista\n"
                    + "5 – Remover uma posição da lista\n"
                    + "6 – Remover um código da lista\n"
                    + "7 – Imprimir a lista\n"
                    + "8 – Imprimir a lista invertida\n"
                    + "9 – Sair\n\n"
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
                    int codIP = InOut.leInt("Código do item:");
                    String descIP = InOut.leString("Descrição do item:");
                    int pos = InOut.leInt("Posição a inserir (0 a " + (lista.tamanho() - 1) + "):");
                    boolean ins = lista.insere(new Item(codIP,descIP), pos);
                    if (ins != false) {
                        InOut.msgSemIcone("Sucesso", "Nó inserido em " + pos +".");
                    } else {
                        InOut.msgSemIcone("Falha", "Posição fora da lista.");
                    }
                    break;
                }
                case 4: {
                    int codP = InOut.leInt("Código a pesquisar:");
                    NoItemDupla ach = lista.pesquisa(codP);
                    if (ach != null) {
                        InOut.msgSemIcone("Resultado", "Encontrado: " + ach.getItem());
                    } else {
                        InOut.msgSemIcone("Resultado", "Item não encontrado.");
                    }
                    break;
                }
                case 5: {
                    int pos = InOut.leInt("Posição a remover (0 a " + (lista.tamanho() - 1) + "):");
                    NoItemDupla rem = lista.removePos(pos);
                    if (rem != null) {
                        InOut.msgSemIcone("Sucesso", "Removido: " + rem.getItem());
                    } else {
                        InOut.msgSemIcone("Erro", "Posição inválida.");
                    }
                    break;
                }
                case 6: {
                    int cod = InOut.leInt("Código a remover:");
                    NoItemDupla remCod = lista.removeCod(cod);
                    if (remCod != null) {
                        InOut.msgSemIcone("Sucesso", "Removido: " + remCod.getItem());
                    } else {
                        InOut.msgSemIcone("Erro", "Código inexistente.");
                    }
                    break;
                }
                case 7:
                    InOut.msgSemIcone("Lista", lista.toString());
                    break;
                case 8:
                    InOut.msgSemIcone("Lista Invertida", lista.toStringInverso());
                    break;
                case 9:
                    InOut.msgSemIcone("Saindo", "Encerrando o programa.");
                    break;
                default:
                    InOut.msgSemIcone("Erro", "Opção inválida.");
            }
        } while (opc != 9);
    }
}