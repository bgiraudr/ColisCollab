package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

import model.Colis;
import controler.*;

public class PasPage extends JPanel {

	private JLabel titre;
	private JButton retour;
	private ImageIcon notFoundImage;

	public PasPage(ButtonListener buttonListener) {
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

		this.titre = new JLabel("Erreur 404 !");
		this.titre.setFont(new Font("Candara", Font.BOLD, 40));
		this.retour = new JButton(new ImageIcon("../data/images/retour.png"));
		this.retour.setContentAreaFilled(false);
        this.retour.setBorderPainted(false);


		JPanel mainPanel = new JPanel(new GridLayout(3,1));
		mainPanel.setPreferredSize(new Dimension(420,620));
		mainPanel.setBackground(Color.WHITE);
		
		JLabel notFound = new JLabel("La page n'existe pas !");
		notFound.setFont(new Font("Candara", Font.BOLD, 30));
		notFound.setHorizontalAlignment(JLabel.CENTER);

		this.notFoundImage = new ImageIcon("../data/images/notfound.png");
		JLabel notFoundLabel = new JLabel(this.notFoundImage);

		mainPanel.add(notFound);
		mainPanel.add(notFoundLabel);

		topPanel.add(this.retour);
		topPanel.add(this.titre);
		this.add(topPanel);
		this.add(mainPanel);
	}

	private void setListener(ButtonListener buttonListener) {
		this.retour.addActionListener(buttonListener);
	}

	public JButton getRetour() {
		return this.retour;
	}
}