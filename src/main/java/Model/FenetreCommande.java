package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreCommande extends JFrame {

    private JFrame jFrame = new JFrame("Etat des commandes");
    private int tailleFenetre = 50;

    public FenetreCommande() {

        super("Etat des commandes");

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        jFrame.setLayout(new GridLayout(0, 1));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
                jFrame.setSize(550, tailleFenetre);
                jFrame.pack();
                jFrame.setVisible(true);
            }
        });
    }

    public void ajouterLabel(String label){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFrame.setSize(550, tailleFenetre);
                jFrame.add(new JLabel(label));
                jFrame.validate();
                jFrame.repaint();
            }
        });
        this.setTailleFenetre(tailleFenetre + 50);
    }

    public void setTailleFenetre(int tailleFenetre) {
        this.tailleFenetre = tailleFenetre;
    }
}