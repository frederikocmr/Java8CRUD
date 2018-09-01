/*
 * Copyright 2018, Frederiko Cesar Moreira Ribeiro
 * GitHub: https://github.com/frederikocmr
 */
package view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Frederiko Cesar
 */
public class MainView {

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
           // ex.printStackTrace();
        }

        MenuView.criarJanela();

    }

}
