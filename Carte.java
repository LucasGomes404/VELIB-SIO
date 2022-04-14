package application;

import java.util.ArrayList;

//Instanciation de l'ArrayList

public class Carte {
	
	public ArrayList<Station> mesStations;
	
	public Carte() {
		
		mesStations = new ArrayList<Station>();
	}

//Mise en place de l'ajout de la station
	
	public void ajouteStation(String codeStation, String unNom, String unArr, String uneDate, String cbisDispo, String isOuvert, int laCapa, int nbDispo, int empDispo) {
		mesStations.add(new Station(codeStation, unNom, unArr, uneDate, cbisDispo, isOuvert, laCapa, nbDispo, empDispo));
	}

//Mise en place de la recherceh de stations 
	
	public Station chercher(String stat) {
		for (Station s : mesStations) {
			if (stat.equals(s.getNumero())) {
				return s;
			}
		}
		return null;
	}

//Instanciation pour prendre la station rechercher
	
	public Station getLaStation(int identifiant) {
		return mesStations.get(identifiant);
	}

//Cela va permettre de savoir le nombre de station disponibles 
	
	public int nbStation() {
		return mesStations.size();
	}
	
	public ArrayList<Station> getTheStations() {
		return mesStations;
	}
}
