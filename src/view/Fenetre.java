/**
 * 
 * @author Benjamin Giraud-Renard
 **/

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controler.*;

public class Fenetre extends JFrame {

	private MenuPrincipal menuPrincipal;
	private NouveauColis nouveauColis;
	private PasPage pasPage;
	private ProposerTrajet proposerTrajet;

	private ButtonListener buttonListener;
	private CardLayout cardLayout;

	public Fenetre() {
		this.initComponents();
	}

	/*
	* init all the graphical components with a cardlayout
	*/
	private void initComponents() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setSize(420,800);
		this.setTitle("ColisCollab");
		this.getContentPane().setBackground(new Color(52,212,132));
		this.setVisible(true);

		this.buttonListener = new ButtonListener(this);

		this.menuPrincipal = new MenuPrincipal("Vannes","Rennes", this.buttonListener);
		this.nouveauColis = new NouveauColis(this.buttonListener);
		this.pasPage = new PasPage(this.buttonListener);
		this.proposerTrajet = new ProposerTrajet(this.buttonListener);
		
		this.cardLayout = new CardLayout();
		this.setLayout(this.cardLayout);
		
		add(this.menuPrincipal,"menu");
		add(this.nouveauColis,"newColis");
		add(this.pasPage,"pasPage");
		add(this.proposerTrajet, "proposerTrajet");
	}

	public MenuPrincipal getMenuPrincipal() {
		return this.menuPrincipal;
	}

	public NouveauColis getNouveauColis() {
		return this.nouveauColis;
	}

	public PasPage getPasPage() {
		return this.pasPage;
	}

	public ProposerTrajet getProposerTrajet() {
		return this.proposerTrajet;
	}

	public CardLayout getCardLayout() {
		return this.cardLayout;
	}
}