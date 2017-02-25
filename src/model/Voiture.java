package model;

import javafx.beans.property.SimpleStringProperty;

public class Voiture extends Vehicule{
	private final SimpleStringProperty carburant;
	private final int pFiscal;
	public Voiture(String immatriculation, String dateEntreeParc, String dateSortieParc, String marque, String modele,
			String etat,String assurance, double emission, long kilometrage, double consommation, int age,String carburant,int pFiscal) {
		super(immatriculation, dateEntreeParc, dateSortieParc, marque, modele, etat, emission, kilometrage, consommation, age,assurance);
		this.carburant=new SimpleStringProperty(carburant);
		this.pFiscal=pFiscal;
		
	}
	public SimpleStringProperty getCarburant() {
		return carburant;
	}

	public int getpFiscal() {
		return pFiscal;
	}
	
}
