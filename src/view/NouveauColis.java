/**
 * 
 * @author Benjamin Giraud-Renard
 **/

package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

import model.Colis;
import controler.*;

public class NouveauColis extends JPanel {

    private JLabel titre;
    private JButton retour;
    private JButton valider;

    private JTextField lieuDepart;
    private JTextField lieuArrivee;
    private JTextField nomColis;

    private JLabel proposerUnTrajet;
    private JLabel adresse;
    private JLabel nomColisLabel;
    private JLabel detourMax;
    private JLabel detourLabel;

    private JSlider detour;
    static final int MIN = 0;  //valeur minimum du slider
    static final int MAX = 30; //valeur maximum du slider
    static final int INIT = 15; //le point où le slider s'initialise

    /*
    * create a new colis panel
    */
    public NouveauColis(ButtonListener buttonListener) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(new Color(52,212,132));
        this.initComponents();
        this.setListener(buttonListener);
    }

    /*
	* init all the graphical components
	*/
    private void initComponents() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setBackground(new Color(52,212,132));
        topPanel.setAlignmentX(CENTER_ALIGNMENT);

        this.titre = new JLabel("Nouveau Colis");
        this.titre.setFont(new Font("Candara", Font.BOLD, 30));
        this.retour = new JButton(new ImageIcon("../data/images/retour.png"));
        this.retour.setContentAreaFilled(false);
        this.retour.setBorderPainted(false);

        this.lieuDepart = new JTextField("Ville de départ");
        this.lieuArrivee = new JTextField("Ville d'arrivée");
        this.nomColis = new JTextField("Nom Colis");

        this.nomColisLabel = new JLabel("Nom Colis");
        this.nomColisLabel.setFont(new Font("Candara", Font.BOLD, 30));

        this.adresse = new JLabel("Adresse");
        this.adresse.setFont(new Font("Candara", Font.BOLD, 20));

        this.valider = new JButton("Envoyer");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(420,620));
        mainPanel.setBackground(Color.WHITE);

        mainPanel.add(this.adresse);
        mainPanel.add(this.lieuDepart);
        mainPanel.add(this.lieuArrivee);
        mainPanel.add(this.nomColisLabel);
        mainPanel.add(this.nomColis);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20,100,20,20));
        bottomPanel.setBackground(new Color(52,212,132));

        this.valider.setBackground(Color.WHITE);
        this.valider.setForeground(new Color(30,200,120));
        this.valider.setFont(new Font("Candara", Font.BOLD, 20));
        this.valider.setBorder(BorderFactory.createLineBorder(new Color(30,200,120), 3));
        bottomPanel.add(this.valider);

        topPanel.add(this.retour);
        topPanel.add(this.titre);
        this.add(topPanel);
        this.add(mainPanel);
        this.add(bottomPanel);
    }

    /*
    * set all the listener
    */
    private void setListener(ButtonListener buttonListener) {
        this.retour.addActionListener(buttonListener);
        this.valider.addActionListener(buttonListener);
    }

    public JButton getRetour() {
        return this.retour;
    }

    public JButton getValider() {
        return this.valider;
    }

    public JTextField getDep() {
    	return this.lieuDepart;
    }

    public JTextField getArr() {
    	return this.lieuArrivee;
    }

    public JTextField getNom() {
    	return this.nomColis;
    }
}