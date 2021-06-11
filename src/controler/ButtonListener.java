/**
 * 
 * @author Benjamin Giraud-Renard
 **/

package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.*;
import java.awt.*;

import model.*;
import view.*;

public class ButtonListener implements ActionListener, ChangeListener {

	private Fenetre fenetre;

	/*
	* create the listener for all the button or component
	*/
	public ButtonListener(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	/*
	* detect a click on a button
	*/
	public void actionPerformed(ActionEvent paramActionEvent) {
		if(paramActionEvent.getSource() == this.fenetre.getMenuPrincipal().getEnvoyer()) {
			switchTo("newColis");
		}
		if(paramActionEvent.getSource() == this.fenetre.getMenuPrincipal().getNouveauTrajet()) {
			switchTo("proposerTrajet");
		}
		if(paramActionEvent.getSource() == this.fenetre.getMenuPrincipal().getReservation()) {
			switchTo("pasPage");
		}
		if(paramActionEvent.getSource() == this.fenetre.getMenuPrincipal().getCompte()) {
			this.fenetre.getMenuPrincipal().getHeadLabel().setText("  " + Colis.getNearColis(this.fenetre.getMenuPrincipal().getDepart(), this.fenetre.getMenuPrincipal().getArrivee()).getModel().getSize() + " colis sur " + this.fenetre.getMenuPrincipal().getDepart() + " : " + this.fenetre.getMenuPrincipal().getArrivee());
		}

		if(paramActionEvent.getSource() == this.fenetre.getNouveauColis().getRetour() ||
			paramActionEvent.getSource() == this.fenetre.getPasPage().getRetour() ||
			paramActionEvent.getSource() == this.fenetre.getProposerTrajet().getRetour()) {
			switchTo("menu");
		}

		if(paramActionEvent.getSource() == this.fenetre.getProposerTrajet().getValider()) {
			switchTo("menu");
		}

		if(paramActionEvent.getSource() == this.fenetre.getNouveauColis().getValider()) {
			Colis nouveauColis = new Colis(this.fenetre.getNouveauColis().getNom().getText(), 50, 30, 40, 20, this.fenetre.getNouveauColis().getDep().getText(), this.fenetre.getNouveauColis().getArr().getText());
			switchTo("menu");
		}
	}

	/*
	* switch to a different panel in the card layout
	*/
	private void switchTo(String pageValue) {
		this.fenetre.getCardLayout().show(this.fenetre.getContentPane(), pageValue);
	}

	/*
	* for the slider
	*/
	public void stateChanged(ChangeEvent event) {
		if(event.getSource() == this.fenetre.getProposerTrajet().getDetour()) {
			this.fenetre.getProposerTrajet().getDetourMax().setText("Detour maximum : " + this.fenetre.getProposerTrajet().getDetour().getValue() + " kms");
		}
	}
}