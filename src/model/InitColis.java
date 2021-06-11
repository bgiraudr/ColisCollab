/**
 * 
 * @author Benjamin Giraud-Renard
 **/

package model;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InitColis {

	public InitColis() {
		initializeColis();
	}

	/*
	* initialize the ArrayList of colis by reading the data/colis.txt file
	*/
	public void initializeColis() {
		try {
			BufferedReader lineReader = new BufferedReader(new FileReader("../data/colis.txt"));
			String line;
			while((line = lineReader.readLine()) != null) {
				Scanner in = new Scanner(line).useDelimiter(":");
				while(in.hasNext()) {
					String name = in.next();
					int longueur = in.nextInt();
					int largeur = in.nextInt();
					int hauteur = in.nextInt();
					int poids = in.nextInt();
					String adDepart = in.next();
					String adArr = in.next();
					Colis colis = new Colis(name,longueur,largeur,hauteur,poids,adDepart,adArr);
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println("Fichier non trouvé");
		} catch(IOException e) {
			System.out.println(e);
		}
	}
}