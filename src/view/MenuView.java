/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

/**
 *
 * @author frede
 */
public class MenuView extends JPanel
        implements ActionListener {

    protected JButton btnCarregaArquivo, btnMostrarAlunos;

    public MenuView() {

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
        
        JPanel checkPanel = new JPanel();
        checkPanel.add(btnCarregaArquivo);
        checkPanel.add(btnMostrarAlunos);
        
        checkPanel.setPreferredSize( new Dimension( 400, 200) );
        
        add(checkPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if( e.getSource() == btnMostrarAlunos){
                JOptionPane.showMessageDialog(null, "Mostrar alunos aqui.");
            }

            if (e.getSource() == btnCarregaArquivo){
                JOptionPane.showMessageDialog(null, "Abrir pane para arquivo.");
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
