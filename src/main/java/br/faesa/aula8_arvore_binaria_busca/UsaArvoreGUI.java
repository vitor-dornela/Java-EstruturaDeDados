package br.faesa.aula8_arvore_binaria_busca;

import br.faesa.aula2_lista_contigua.LCInteiro;
import br.faesa.entidades.NoArv;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UsaArvoreGUI {

    private ABBInt treeOriginal;
    private ABBInt treeModified;
    private LCInteiro origInseridos;
    private LCInteiro modInseridos;

    // componentes da coluna Original
    private JTextArea origInserida, origIn, origPre, origPos;
    // componentes da coluna Modificada
    private JTextArea modInserida, modIn, modPre, modPos;
    private JPanel rightPanel;
    private JButton btnBalance;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new UsaArvoreGUI().createAndShowGUI()
        );
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Árvore Binária de Busca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10,10));

        // -- Topo: entrada e botão Atualizar --
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JTextField inputField = new JTextField(40);
        JButton btnUpdate = new JButton("Atualizar");
        btnUpdate.addActionListener((ActionEvent e) -> {
            updateTrees(inputField.getText().trim());
            rightPanel.setVisible(false);
            btnBalance.setEnabled(true);
        });
        top.add(new JLabel("Entrada (inteiros separados por espaço):"));
        top.add(inputField);
        top.add(btnUpdate);
        frame.add(top, BorderLayout.NORTH);

        // -- Centro: colunas Original e Modificada --
        // Coluna Original
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(5,10,5,10),
                "Árvore Original"));
        left.add(makeSection("Inserida",  "", true));
        left.add(Box.createVerticalStrut(8));
        left.add(makeSection("In-ordem",  "", true));
        left.add(Box.createVerticalStrut(8));
        left.add(makeSection("Pré-ordem", "", true));
        left.add(Box.createVerticalStrut(8));
        left.add(makeSection("Pós-ordem", "", true));

        // Coluna Modificada (inicialmente oculta)
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(5,10,5,10),
                "Árvore Modificada"));
        rightPanel.setVisible(false);
        rightPanel.add(makeSection("Inserida",  "", false));
        rightPanel.add(Box.createVerticalStrut(8));
        rightPanel.add(makeSection("In-ordem",  "", false));
        rightPanel.add(Box.createVerticalStrut(8));
        rightPanel.add(makeSection("Pré-ordem", "", false));
        rightPanel.add(Box.createVerticalStrut(8));
        rightPanel.add(makeSection("Pós-ordem", "", false));

        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(left),
                new JScrollPane(rightPanel)
        );
        split.setResizeWeight(0.5);
        frame.add(split, BorderLayout.CENTER);

        // -- Sul: controles Remover e Rebalancear --
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,10));
        JTextField fldRemove = new JTextField(5);
        JButton btnRemove    = new JButton("Remover");
        btnRemove.addActionListener(e -> {
            try {
                int v = Integer.parseInt(fldRemove.getText().trim());
                NoArv excl = treeModified.remove(v);
                JOptionPane.showMessageDialog(frame,
                        excl != null
                                ? "Valor " + v + " removido."
                                : "Valor " + v + " não encontrado."
                );
                if (excl != null) {
                    modInseridos.remove(v);    // remove pelo valor
                    updateModified();
                    rightPanel.setVisible(true);
                    btnBalance.setEnabled(true);  // reabilita rebalancear após remoção
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Digite um inteiro válido",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        controls.add(new JLabel("Valor para remover:"));
        controls.add(fldRemove);
        controls.add(btnRemove);

        btnBalance = new JButton("Rebalancear");
        btnBalance.addActionListener(e -> {
            treeModified = treeModified.balancear();
            // reconstrói vetor de inserção balanceada
            LCInteiro sorted = treeModified.CamInOrdem();
            modInseridos = new LCInteiro(sorted.getQuant());
            buildBalancedOrder(sorted, modInseridos, 0, sorted.getQuant() - 1);
            updateModified();
            rightPanel.setVisible(true);
            btnBalance.setEnabled(false);
        });
        controls.add(Box.createHorizontalStrut(20));
        controls.add(btnBalance);

        frame.add(controls, BorderLayout.SOUTH);

        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /** Recria origInseridos, treeOriginal, modInseridos e treeModified sem duplicatas */
    private void updateTrees(String input) {
        // origInseridos: só valores únicos, na ordem de entrada
        origInseridos = new LCInteiro(input.split("\\s+").length);
        for (String tok : input.split("\\s+")) {
            try {
                int v = Integer.parseInt(tok);
                if (origInseridos.pesquisa(v) == -1) {
                    origInseridos.insereFinal(v);
                }
            } catch (NumberFormatException ignored) {}
        }
        // reconstrói árvore original
        treeOriginal = new ABBInt();
        for (int i = 0; i < origInseridos.getQuant(); i++) {
            treeOriginal.insere(origInseridos.get(i));
        }
        // prepara árvore e lista modificadas iguais
        modInseridos = new LCInteiro(origInseridos.getQuant());
        for (int i = 0; i < origInseridos.getQuant(); i++) {
            modInseridos.insereFinal(origInseridos.get(i));
        }
        treeModified = new ABBInt();
        for (int i = 0; i < modInseridos.getQuant(); i++) {
            treeModified.insere(modInseridos.get(i));
        }
        // atualiza coluna Original e oculta Modificada
        updateOriginal();
        rightPanel.setVisible(false);
    }

    private JPanel makeSection(String title, String content, boolean isOriginal) {
        JTextArea area = new JTextArea(content, 2, 30);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        JPanel panel = new JPanel(new BorderLayout(5,5));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.add(new JScrollPane(area), BorderLayout.CENTER);

        if (isOriginal) {
            switch (title) {
                case "Inserida": origInserida = area; break;
                case "In-ordem": origIn       = area; break;
                case "Pré-ordem": origPre      = area; break;
                case "Pós-ordem": origPos      = area; break;
            }
        } else {
            switch (title) {
                case "Inserida": modInserida = area; break;
                case "In-ordem": modIn       = area; break;
                case "Pré-ordem": modPre      = area; break;
                case "Pós-ordem": modPos      = area; break;
            }
        }
        return panel;
    }

    private void updateOriginal() {
        origInserida.setText(fmt(origInseridos));
        origIn.setText(fmt(treeOriginal.CamInOrdem()));
        origPre.setText(fmt(treeOriginal.CamPreOrdem()));
        origPos.setText(fmt(treeOriginal.CamPosOrdem()));
    }

    private void updateModified() {
        modInserida.setText(fmt(modInseridos));
        modIn.setText(fmt(treeModified.CamInOrdem()));
        modPre.setText(fmt(treeModified.CamPreOrdem()));
        modPos.setText(fmt(treeModified.CamPosOrdem()));
    }

    /** Formata lista como " | x | y | z |" */
    private String fmt(LCInteiro list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.getQuant(); i++) {
            sb.append(" | ").append(list.get(i));
        }
        sb.append(" |");
        return sb.toString();
    }

    /** Reconstrói ordem de inserção balanceada */
    private void buildBalancedOrder(LCInteiro sorted, LCInteiro out,
                                    int lo, int hi) {
        if (lo > hi) return;
        int mid = (lo + hi)/2;
        out.insereFinal(sorted.get(mid));
        buildBalancedOrder(sorted, out, lo, mid-1);
        buildBalancedOrder(sorted, out, mid+1, hi);
    }
}
