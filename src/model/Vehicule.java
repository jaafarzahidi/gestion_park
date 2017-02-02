package model;

import javafx.beans.property.SimpleStringProperty;

public class Vehicule {
	private final SimpleStringProperty immatriculation;
	private final SimpleStringProperty dateEntreeParc;
	private final SimpleStringProperty dateSortieParc;
	private final SimpleStringProperty marque;
	private final SimpleStringProperty modele;
	private final SimpleStringProperty carburant;
	private final SimpleStringProperty etat;
	public Vehicule(String immatriculation,String dateEntreeParc,String dateSortieParc,String marque,String modele,String carburant,String etat){
		super();
		this.immatriculation = new SimpleStringProperty(immatriculation);
		this.dateEntreeParc = new SimpleStringProperty(dateEntreeParc);
		this.dateSortieParc = new SimpleStringProperty(dateSortieParc);
		this.marque = new SimpleStringProperty(marque);
		this.modele = new SimpleStringProperty(modele);
		this.carburant = new SimpleStringProperty(carburant);
		this.etat = new SimpleStringProperty(etat);
	}

	public String getImmatriculation() {
		return immatriculation.get();
	}
	public String getDateEntreeParc() {
		return dateEntreeParc.get();
	}
	public String getDateSortieParc() {
		return dateSortieParc.get();
	}
	public String getMarque() {
		return marque.get();
	}
	public String getModele() {
		return modele.get();
	}
	public String getCarburant() {
		return carburant.get();
	}
	public String getEtat() {
		return etat.get();
	}




}
