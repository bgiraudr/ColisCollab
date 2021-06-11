package model;

public class Trajet {

	private String adDepart;
	private String adArr;
	//private ArrayList<Colis> liste;

	public Trajet(String adDep, String adArr) {
		this.adDepart = adDep;
		this.adArr = adArr;
	}

	public String getDepart() {
		return this.adDepart;
	}

	public String getArrivee() {
		return this.adArr;
	}
}