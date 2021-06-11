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

public class MenuPrincipal extends JPanel {

    private JButton envoyer;
    private JButton nouveauTrajet;
    private JButton reservation;
    private JButton compte;
    private JButton messagerie;

    private ImageIcon logo;
    private ImageIcon photoProfil;

    private JLabel trajetLabel;
    private JLabel nbColis;
    private JLabel actionRapide;
    private JLabel head;

    private JList listeColis;
    private JScrollPane listePanel;

    private String depart;
    private String arrivee;

    private JPanel mainPanel;

    /*
    * create the main menu
    */
    public MenuPrincipal(String adDep, String adArr, ButtonListener buttonListener) {
        this.depart = adDep;
        this.arrivee = adArr;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(420, 800));
        this.setBackground(new Color(52,212,132));
        this.listeColis = Colis.getNearColis(adDep, adArr);
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

        this.logo = new ImageIcon("../data/images/logo.png");
        this.logo = new ImageIcon(this.logo.getImage().getScaledInstance(150,70,Image.SCALE_SMOOTH));
        JLabel logoLabel = new JLabel(this.logo);

        this.photoProfil = new ImageIcon("../data/images/photoProfil.png");
        this.compte = new JButton(this.photoProfil);
        this.compte.setContentAreaFilled(false);
        this.compte.setBorderPainted(false);

        this.mainPanel = new JPanel(new GridLayout(4,1));
        this.mainPanel.setPreferredSize(new Dimension(420,620));
        this.mainPanel.setBackground(Color.WHITE);
        
        this.trajetLabel = new JLabel("    Colis sur vos trajets");
        this.actionRapide = new JLabel("    Action Rapide");
        this.trajetLabel.setFont(new Font("Candara", Font.BOLD, 20));
        this.actionRapide.setFont(new Font("Candara", Font.BOLD, 20));

        this.envoyer = new JButton("Envoyer un colis");
        this.envoyer.setFont(new Font("Candara", Font.BOLD, 20));

        this.nouveauTrajet = new JButton("Nouveau trajet");
        this.nouveauTrajet.setFont(new Font("Candara", Font.BOLD, 20));

        this.reservation = new JButton("Réserver un colis");
        this.reservation.setFont(new Font("Candara", Font.BOLD, 20));

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.PAGE_AXIS));
        panelButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        panelButton.setAlignmentX(CENTER_ALIGNMENT);
        this.envoyer.setAlignmentX(CENTER_ALIGNMENT);
        this.nouveauTrajet.setAlignmentX(CENTER_ALIGNMENT);
        this.reservation.setAlignmentX(CENTER_ALIGNMENT);
        this.envoyer.setBackground(new Color(52,212,132));
        this.nouveauTrajet.setBackground(new Color(52,212,132));
        this.reservation.setBackground(new Color(52,212,132));

        this.envoyer.setMaximumSize(new Dimension(300, 100));
        this.nouveauTrajet.setMaximumSize(new Dimension(300, 100));
        this.reservation.setMaximumSize(new Dimension(300, 100));

        panelButton.setBackground(Color.WHITE);

        panelButton.add(this.envoyer);
        panelButton.add(Box.createRigidArea(new Dimension(0,20)));
        panelButton.add(this.nouveauTrajet);
        panelButton.add(Box.createRigidArea(new Dimension(0,20)));
        panelButton.add(this.reservation);

        drawScrollPane();

        topPanel.add(logoLabel);
        topPanel.add(this.compte);
        this.mainPanel.add(this.trajetLabel);
        this.mainPanel.add(this.listePanel);
        this.mainPanel.add(panelButton);
        this.add(topPanel);
        this.add(mainPanel);
    }

    /*
    * set all the listener
    */
    private void setListener(ButtonListener buttonListener) {
        this.envoyer.addActionListener(buttonListener);
        this.nouveauTrajet.addActionListener(buttonListener);
        this.reservation.addActionListener(buttonListener);
        this.compte.addActionListener(buttonListener);
    }

    public void drawScrollPane() {
        this.listePanel = new JScrollPane(this.listeColis);
        this.head = new JLabel("  " + this.listeColis.getModel().getSize() + " colis sur " + this.depart + " : " + this.arrivee);
        head.setFont(new Font("Candara", Font.BOLD, 20));
        this.listePanel.setColumnHeaderView(head);
        this.listePanel.revalidate();
    }

    public String getDepart() {
        return this.depart;
    }

    public String getArrivee() {
        return this.arrivee;
    }

    public JButton getEnvoyer() {
        return this.envoyer;
    }

    public JButton getNouveauTrajet() {
        return this.nouveauTrajet;
    }

    public JButton getReservation() {
        return this.reservation;
    }

    public JButton getCompte() {
        return this.compte;
    }

    public JScrollPane getListePanel() {
        return this.listePanel;
    }

    public JLabel getHeadLabel() {
        return this.head;
    }

    public JList getListe() {
        return this.listeColis;
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}