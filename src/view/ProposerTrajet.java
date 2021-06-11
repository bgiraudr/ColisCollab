package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

import model.Colis;
import controler.*;

public class ProposerTrajet extends JPanel {

    private JLabel titre;
    private JButton retour;
    private JButton valider;

    private JTextField lieuDepart;
    private JTextField lieuArrivee;
    private JTextField dateDepart;
    private JTextField dateArrivee;

    private JLabel proposerUnTrajet;
    private JLabel adresse;
    private JLabel date;
    private JLabel detourMax;
    private JLabel detourLabel;

    private JSlider detour;
    static final int MIN = 0;  //valeur minimum du slider
    static final int MAX = 30; //valeur maximum du slider
    static final int INIT = 15; //le point où le slider s'initialise

    public ProposerTrajet(ButtonListener buttonListener) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(new Color(52,212,132));
        this.initComponents();
        this.setListener(buttonListener);
    }

    private void initComponents() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setBackground(new Color(52,212,132));
        topPanel.setAlignmentX(CENTER_ALIGNMENT);

        this.titre = new JLabel("Nouveau Trajet");
        this.titre.setFont(new Font("Candara", Font.BOLD, 30));
        this.retour = new JButton(new ImageIcon("../data/images/retour.png"));
        this.retour.setContentAreaFilled(false);
        this.retour.setBorderPainted(false);

        this.lieuDepart = new JTextField("Ville de départ");
        this.lieuArrivee = new JTextField("Ville d'arrivée");
        this.dateDepart = new JTextField("01/01/2021");
        this.dateArrivee = new JTextField("01/01/2021");

        this.adresse = new JLabel("Adresse");
        this.adresse.setFont(new Font("Candara", Font.BOLD, 20));
        this.date = new JLabel("Date");
        this.date.setFont(new Font("Candara", Font.BOLD, 20));
        this.detourMax = new JLabel("Detour maximum : " + INIT + " kms");
        this.detourMax.setFont(new Font("Candara", Font.BOLD, 20));
        this.detour = new JSlider(JSlider.HORIZONTAL,MIN, MAX, INIT);
        this.detour.setBackground(Color.WHITE);
        this.detourLabel = new JLabel("0");

        this.detour.setMinorTickSpacing(2);
        this.detour.setPaintTicks(true);

        this.valider = new JButton("En route !");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(420,620));
        mainPanel.setBackground(Color.WHITE);

        mainPanel.add(this.adresse);
        mainPanel.add(this.lieuDepart);
        mainPanel.add(this.lieuArrivee);
        mainPanel.add(this.date);
        mainPanel.add(this.dateDepart);
        mainPanel.add(this.dateArrivee);
        mainPanel.add(this.detourMax);
        mainPanel.add(this.detour);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20,100,20,20));
        bottomPanel.setBackground(new Color(52,212,132));

        this.valider.setBackground(Color.WHITE);
        this.valider.setForeground(new Color(30,200,120));
        this.valider.setFont(new Font("Candara", Font.BOLD, 40));
        this.valider.setBorder(BorderFactory.createLineBorder(new Color(30,200,120), 3));
        bottomPanel.add(this.valider);


        topPanel.add(this.retour);
        topPanel.add(this.titre);
        this.add(topPanel);
        this.add(mainPanel);
        this.add(bottomPanel);
    }

    private void setListener(ButtonListener buttonListener) {
        this.retour.addActionListener(buttonListener);
        this.detour.addChangeListener(buttonListener);
        this.valider.addActionListener(buttonListener);
    }

    public JButton getRetour() {
        return this.retour;
    }

    public JSlider getDetour() {
        return this.detour;
    }

    public JLabel getDetourMax() {
        return this.detourMax;
    }

    public JButton getValider() {
        return this.valider;
    }
}