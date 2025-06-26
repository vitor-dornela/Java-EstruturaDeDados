# Estruturas de Dados Clássicas em Java

Este repositório oferece diversas implementações práticas de estruturas de dados utilizadas frequentemente na construção de algoritmos, como listas contíguas, listas encadeadas, pilhas, filas, árvores binárias e muito mais. Ele visa o aprendizado e aplicação de conceitos importantes, simulando cenários de processamento de dados através de operações bem definidas.

## Estruturas e Funcionalidades por Áreas

### **Lista Contígua (`LCInteiro`, `LCItem`)**
Implementa uma lista baseada em arrays com suporte dinâmico:
- **LCInteiro**: Gerencia números inteiros com operações de inserção, remoção e pesquisa.
  - Capacidade de concatenar ou verificar igualdade entre listas.
  - Suporte a ajustamento automático de tamanho (crescendo em 50% quando cheia).
- **LCItem**: Estrutura para armazenar objetos do tipo `Item`. Possui funcionalidades semelhantes ao `LCInteiro`, mas voltadas para objetos.

---

### **Lista Simplesmente Encadeada (`LSEInteiro`, `LSEItem`)**
Funciona utilizando referências entre nós:
- **LSEInteiro**: Manipula inteiros dinamicamente sem restrição de tamanho fixo.
  - Inserção e remoção em várias posições.
  - Excelente para problemas onde operações dinâmicas são necessárias.
- **LSEItem**: Similar ao `LSEInteiro`, mas trabalha com objetos do tipo `Item`.

---

### **Lista Duplamente Encadeada (`LdeInteiro`, `LdeItem`)**
Extensão da lista encadeada com navegação bidirecional:
- **LdeInteiro**: Permite acesso tanto para frente quanto para trás na lista.
- **LdeItem**: Versão para objetos do tipo `Item`.

Estas estruturas são efetivas para cenários com iterações e processamentos complexos interligados.

---

### **Pilha (`PilhaInt`)**
Estrutura do tipo LIFO (*Last In, First Out*):
- Operações básicas como **push** (inserção) e **pop** (remoção).
- Ideal para aplicações como algoritmos de backtracking, validação de expressões, entre outros.

---

### **Fila (`FilaInt`)**
Estrutura FIFO (*First In, First Out*):
- Suporte a **enqueue** (inserir no final) e **dequeue** (remover do início).
- Útil em áreas como gerenciamento de tarefas, simulação e pipelines de processamento.

---

### **Árvore Binária de Busca (`ABBInt`)**
Uma Árvore Binária de Busca completa para armazenar e gerenciar dados:
- Operações fundamentais (inserção, remoção, pesquisa).
- Caminhamentos diferentes: in-ordem, pré-ordem, pós-ordem.
- Operações:
  - Soma de todos os nós.
  - Valor máximo encontrado.
- Balanceamento automático para otimização da estrutura.
- Criação de subárvores contendo apenas elementos pares ou ímpares.

Links para auxiliar no aprendizado:
- [Criando árvore manualmente](https://www.canva.com/design/DAGqFsACsPk/VcdoJMVpVDGR2Y5LjNPijw/edit?utm_content=DAGqFsACsPk&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton) - Feito no Canva.
- [Criando árvore automaticamente](https://treeconverter.com/?input=+48,+30,+15,+10,+34,+27,+53,+21,+18+,45) - Rápida visualização. Necessário trocar input para _binary search tree_.
- [Tutorial interativo](https://kubokovac.eu/gnarley-trees/BST.html) - Serve para adicionar, remover e pesquisar elementos.

---

## Como Executar

Certifique-se que você possui o **Java 21** ou versões superiores instaladas. Para executar a interface gráfica relacionada à árvore binária de busca, utilize o arquivo `UsaArvoreGUI`.

### Passos para execução:
1. Compile o arquivo:
   ```bash
   javac UsaArvoreGUI.java
   ```
2. Execute o programa:
   ```bash
   java UsaArvoreGUI
   ```

A interface gráfica permitirá que você:
- Insira valores na árvore.
- Visualize diferentes caminhamentos (in-ordem, pré-ordem, pós-ordem).
- Rebalanceie a árvore dinamicamente e visualize os resultados.