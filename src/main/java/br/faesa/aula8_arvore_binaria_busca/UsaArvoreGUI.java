package br.faesa.aula8_arvore_binaria_busca;

import br.faesa.aula2_lista_contigua.LCInteiro;
import br.faesa.entidades.NoArv;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UsaArvoreGUI {

    private ABBInt treeOriginal;
    private ABBInt treeModified;
    private LCInteiro origInseridos;
    private LCInteiro modInseridos;

    // coluna Original
    private JTextArea origInserida, origIn, origPre, origPos, origNiveis;
    private JLabel    origAltura;
    // coluna Modificada
    private JTextArea modInserida, modIn, modPre, modPos, modNiveis;
    private JLabel    modAltura;

    private JPanel    rightPanel;
    private JButton   btnBalance;

    /** aceita espaços, vírgula, ponto, dois-pontos, ponto-e-vírgula */
    private static final String DELIM_REGEX = "[\\s,;:.]+";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UsaArvoreGUI().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Árvore Binária de Busca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10,10));

        // Top: entrada e Atualizar
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        JTextField inputField = new JTextField(40);
        JButton btnUpdate = new JButton("Atualizar");
        btnUpdate.addActionListener((ActionEvent e) -> {
            updateTrees(inputField.getText().trim());
            rightPanel.setVisible(false);
            btnBalance.setEnabled(true);
        });
        top.add(new JLabel("Entrada (sep: espaço, vírg., :, ., ;):"));
        top.add(inputField);
        top.add(btnUpdate);
        frame.add(top, BorderLayout.NORTH);

        // Coluna Original
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBorder(new TitledBorder(new EmptyBorder(5,10,5,10),"Árvore Original"));
        left.add(makeSection("Inserida",  "", true));
        left.add(Box.createVerticalStrut(8));
        left.add(makeSection("In-ordem",  "", true));
        left.add(Box.createVerticalStrut(8));
        left.add(makeSection("Pré-ordem", "", true));
        left.add(Box.createVerticalStrut(8));
        left.add(makeSection("Pós-ordem", "", true));
        left.add(Box.createVerticalStrut(8));
        // Altura Original
        origAltura = new JLabel();
        JPanel altOrig = new JPanel(new FlowLayout(FlowLayout.LEFT));
        altOrig.setBorder(BorderFactory.createTitledBorder("Altura"));
        altOrig.add(origAltura);
        left.add(altOrig);
        left.add(Box.createVerticalStrut(8));
        // Níveis Original
        origNiveis = new JTextArea(4,30);
        origNiveis.setEditable(false);
        origNiveis.setLineWrap(true);
        origNiveis.setWrapStyleWord(true);
        JPanel nivOrig = new JPanel(new BorderLayout());
        nivOrig.setBorder(BorderFactory.createTitledBorder("Níveis"));
        nivOrig.add(new JScrollPane(origNiveis), BorderLayout.CENTER);
        left.add(nivOrig);

        // Coluna Modificada
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(new TitledBorder(new EmptyBorder(5,10,5,10),"Árvore Modificada"));
        rightPanel.setVisible(false);
        rightPanel.add(makeSection("Inserida",  "", false));
        rightPanel.add(Box.createVerticalStrut(8));
        rightPanel.add(makeSection("In-ordem",  "", false));
        rightPanel.add(Box.createVerticalStrut(8));
        rightPanel.add(makeSection("Pré-ordem", "", false));
        rightPanel.add(Box.createVerticalStrut(8));
        rightPanel.add(makeSection("Pós-ordem", "", false));
        rightPanel.add(Box.createVerticalStrut(8));
        // Altura Modificada
        modAltura = new JLabel();
        JPanel altMod = new JPanel(new FlowLayout(FlowLayout.LEFT));
        altMod.setBorder(BorderFactory.createTitledBorder("Altura"));
        altMod.add(modAltura);
        rightPanel.add(altMod);
        rightPanel.add(Box.createVerticalStrut(8));
        // Níveis Modificada
        modNiveis = new JTextArea(4,30);
        modNiveis.setEditable(false);
        modNiveis.setLineWrap(true);
        modNiveis.setWrapStyleWord(true);
        JPanel nivMod = new JPanel(new BorderLayout());
        nivMod.setBorder(BorderFactory.createTitledBorder("Níveis"));
        nivMod.add(new JScrollPane(modNiveis), BorderLayout.CENTER);
        rightPanel.add(nivMod);

        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(left),
                new JScrollPane(rightPanel)
        );
        split.setResizeWeight(0.5);
        frame.add(split, BorderLayout.CENTER);

        // Sul: Remover / Rebalancear
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        JTextField fldRemove = new JTextField(5);
        JButton btnRemove = new JButton("Remover");
        btnRemove.addActionListener(e -> {
            try {
                int v = Integer.parseInt(fldRemove.getText().trim());
                NoArv excl = treeModified.remove(v);
                JOptionPane.showMessageDialog(frame,
                        excl!=null? "Valor "+v+" removido.":"Valor "+v+" não encontrado."
                );
                if (excl!=null) {
                    modInseridos.remove(v);
                    updateModified();
                    rightPanel.setVisible(true);
                    btnBalance.setEnabled(true);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Digite um inteiro válido","Erro",JOptionPane.ERROR_MESSAGE);
            }
        });
        controls.add(new JLabel("Valor para remover:"));
        controls.add(fldRemove);
        controls.add(btnRemove);

        btnBalance = new JButton("Rebalancear");
        btnBalance.addActionListener(e -> {
            treeModified = treeModified.balancear();
            LCInteiro sorted = treeModified.CamInOrdem();
            modInseridos = new LCInteiro(sorted.getQuant());
            buildBalancedOrder(sorted,modInseridos,0,sorted.getQuant()-1);
            updateModified();
            rightPanel.setVisible(true);
            btnBalance.setEnabled(false);
        });
        controls.add(Box.createHorizontalStrut(20));
        controls.add(btnBalance);

        frame.add(controls, BorderLayout.SOUTH);

        frame.setSize(900,550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /** reconstrói árvores sem duplicatas */
    private void updateTrees(String input) {
        String[] toks = input.split(DELIM_REGEX);
        origInseridos = new LCInteiro(toks.length);
        for (String tok: toks) {
            try {
                int v=Integer.parseInt(tok);
                if(origInseridos.pesquisa(v)==-1) origInseridos.insereFinal(v);
            } catch(NumberFormatException ignored){}
        }
        treeOriginal = new ABBInt();
        for(int i=0;i<origInseridos.getQuant();i++)
            treeOriginal.insere(origInseridos.get(i));

        modInseridos = new LCInteiro(origInseridos.getQuant());
        for(int i=0;i<origInseridos.getQuant();i++)
            modInseridos.insereFinal(origInseridos.get(i));
        treeModified = new ABBInt();
        for(int i=0;i<modInseridos.getQuant();i++)
            treeModified.insere(modInseridos.get(i));

        updateOriginal();
        rightPanel.setVisible(false);
    }

    private JPanel makeSection(String title,String content,boolean isOrig) {
        JTextArea area=new JTextArea(content,2,30);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JPanel p=new JPanel(new BorderLayout(5,5));
        p.setBorder(BorderFactory.createTitledBorder(title));
        p.add(new JScrollPane(area),BorderLayout.CENTER);
        if(isOrig) {
            switch(title) {
                case "Inserida": origInserida=area; break;
                case "In-ordem": origIn      =area; break;
                case "Pré-ordem": origPre     =area; break;
                case "Pós-ordem": origPos     =area; break;
            }
        } else {
            switch(title) {
                case "Inserida": modInserida=area; break;
                case "In-ordem": modIn      =area; break;
                case "Pré-ordem": modPre     =area; break;
                case "Pós-ordem": modPos     =area; break;
            }
        }
        return p;
    }

    private void updateOriginal() {
        origInserida.setText(fmt(origInseridos));
        origIn.setText(fmt(treeOriginal.CamInOrdem()));
        origPre.setText(fmt(treeOriginal.CamPreOrdem()));
        origPos.setText(fmt(treeOriginal.CamPosOrdem()));
        origAltura.setText(String.valueOf(treeOriginal.altura()));

        LCInteiro[] porNivel = treeOriginal.nosPorNivel();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<porNivel.length;i++){
            sb.append(i).append(":");
            for(int j=0;j<porNivel[i].getQuant();j++){
                sb.append(" | ").append(porNivel[i].get(j));
            }
            sb.append(" |\n");
        }
        origNiveis.setText(sb.toString());
    }

    private void updateModified() {
        modInserida.setText(fmt(modInseridos));
        modIn.setText(fmt(treeModified.CamInOrdem()));
        modPre.setText(fmt(treeModified.CamPreOrdem()));
        modPos.setText(fmt(treeModified.CamPosOrdem()));
        modAltura.setText(String.valueOf(treeModified.altura()));

        LCInteiro[] porNivel = treeModified.nosPorNivel();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<porNivel.length;i++){
            sb.append(i).append(":");
            for(int j=0;j<porNivel[i].getQuant();j++){
                sb.append(" | ").append(porNivel[i].get(j));
            }
            sb.append(" |\n");
        }
        modNiveis.setText(sb.toString());
    }

    /** " | x | y | z |" */
    private String fmt(LCInteiro lst) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<lst.getQuant();i++){
            sb.append(" | ").append(lst.get(i));
        }
        sb.append(" |");
        return sb.toString();
    }

    /** monta ordem balanceada recursivamente */
    private void buildBalancedOrder(LCInteiro sorted, LCInteiro out,int lo,int hi){
        if(lo>hi) return;
        int mid=(lo+hi)/2;
        out.insereFinal(sorted.get(mid));
        buildBalancedOrder(sorted,out,lo,mid-1);
        buildBalancedOrder(sorted,out,mid+1,hi);
    }
}
