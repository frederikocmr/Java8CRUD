/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProcessaArquivoController;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author frede
 */
public class MenuView extends JPanel
        implements ActionListener {

    protected JButton btnCarregaArquivo, btnMostrarAlunos;
    protected JTextArea log;
    private String dadosProcessados;

    public MenuView() {
        log = new JTextArea(8, 45);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);

        log.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        JScrollPane logScrollPane = new JScrollPane(log);

        btnCarregaArquivo = new JButton("Carregar Arquivos");
        btnCarregaArquivo.setVerticalTextPosition(AbstractButton.CENTER);
        btnCarregaArquivo.setHorizontalTextPosition(AbstractButton.LEADING);
        btnCarregaArquivo.setMnemonic(KeyEvent.VK_D);

        btnMostrarAlunos = new JButton("Mostrar Alunos");
        btnMostrarAlunos.setMnemonic(KeyEvent.VK_E);

        btnCarregaArquivo.addActionListener(this);
        btnMostrarAlunos.addActionListener(this);

        btnCarregaArquivo.setToolTipText("Clique aqui para abrir um arquivo e "
                + "processar os dados de alunos.");
        btnMostrarAlunos.setToolTipText("Clique aqui para mostrar os alunos que"
                + "foram processados.");

        JPanel painel = new JPanel();
        painel.add(btnCarregaArquivo);
        painel.add(btnMostrarAlunos);
        painel.add(logScrollPane);

        painel.setPreferredSize(new Dimension(400, 200));

        add(painel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMostrarAlunos) {
            try {
                int valoresInseridos = 0;
                while (valoresInseridos < 2) {
                    String valorSeq = JOptionPane.showInputDialog("Escolha o valor inicial da sequência:");
                    if (valorSeq.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nada inserido!");
                    } else {
                        valoresInseridos++;
                        log.append("Valor inicial seq escolhida: " + valorSeq + "\n");
                        String qtdDigitos = JOptionPane.showInputDialog("Escolha a quantidade de digitos da sequência:");
                        if (qtdDigitos.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nada inserido!");
                        } else {
                            valoresInseridos++;
                            log.append("Quantidade de digitos escolhida: " + qtdDigitos + "\n\n");
                            log.append(dadosProcessados); //temporário
                        }
                    }
                }
            } catch (Exception ex) {
                System.out.println("Janela valores foi fechada pelo usuário.");
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnCarregaArquivo) {

            JFileChooser escolherArquivo = new JFileChooser();

            int returnVal = escolherArquivo.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = escolherArquivo.getSelectedFile();
                try {
                    ProcessaArquivoController processa = new ProcessaArquivoController();
                    String textoDoArquivo = new Scanner(new FileReader(file.getAbsolutePath())).useDelimiter("\\A").next();

                    log.append("Processando arquivo: \n" + file.getAbsolutePath() + "\n\n");
                    dadosProcessados = processa.leitura(textoDoArquivo);
                    log.append("Arquivo processado com sucesso. \n\n");
                    
                    

                    //verificar lógica pois preciso montar o arquivo de acordo com o que foi informado na dialog. 
                    //Talvez não precisa voltar a string dele aqui e criar outro metodo para invocar a leitura com
                    //os parametros do usuario de sequencia...
                } catch (IOException ex) {
                    System.out.println("Problemas ao acessar: " + file.getAbsolutePath());
                }
            } else {
                System.out.println("Escolher arquivo foi fechado pelo usuário.");
            }
        }
    }

    public static void criarJanela() {

        JFrame frame = new JFrame("Programa SGBD - Atividade prática 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuView conteudoPainel = new MenuView();
        conteudoPainel.setOpaque(true);

        frame.setContentPane(conteudoPainel);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
