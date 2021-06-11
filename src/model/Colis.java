/**
 * 
 * @author Benjamin Giraud-Renard
 **/

package model;

import java.util.*;
import javax.swing.*;

public class Colis {
	private String name;
	private String description;
	private int longueur;
	private int largeur;
	private int hauteur;
	private int poids;

	private String adDepart;
	private String adArr;
	private String precision;
	private int dateDepart;
	private int dateArr;

	private int prix;
	private static ArrayList<Colis> liste;

	static {
		Colis.liste = new ArrayList<Colis>();
	}

	/*
    * create a new colis and add it to the class ArrayList
    */
	public Colis(String name, int longueur, int largeur, int hauteur, int poids, String adDepart, String adArr) {
		this.name = name;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.poids = poids;
		this.adDepart = adDepart;
		this.adArr = adArr;
		Colis.liste.add(this);
		System.out.println("Nouveau colis !");
	}

	public void set_description(String des) {
		this.description = des;
	}

	public String get_description() {
		return this.description;
	}

	public void set_name(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getDepart() {
		return this.adDepart;
	}

	public String getArrivee() {
		return this.adArr;
	}

	/*
	* get all the near colis using the start and end pos
	*/
	public static JList getNearColis(String adDep, String adArr) {
		DefaultListModel model = new DefaultListModel();
		System.out.println("----- Liste des colis à proximité -----");
		for(Colis colis : Colis.liste) {
			if(colis.getDepart().equals(adDep) || colis.getArrivee().equals(adArr)) {
				model.addElement(colis.getName() + " : " + colis.getDepart() + " - " + colis.getArrivee());
				System.out.println(colis.getName() + " : " + colis.getDepart() + " - " + colis.getArrivee());
			}
		}
		System.out.println("------------------------------------");
		JList ret = new JList(model);
		return ret;
	}
}