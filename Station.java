package application;

//Cr�ation des constructeur pour la mise en place de V�lib

class Station extends Carte {

	private String nom;
	private String arrondissement;
	private String numero;
	private String date;
	private String cartedispo;
	private String ouvert;
	private int capacite;
	private int nb_dispo;
	private int emp_dispo;

//Modificateur qui seront ulilis� pour les prochaines classes 
	
	public Station(String unArr, String unNom, String unNumero, String uneDate, String cbisDispo, String isOuvert, int laCapa, int nbDispo, int empDispo) {
		this.arrondissement = unArr;
		this.nom = unNom;
		this.numero = unNumero;
		this.date = uneDate;
		this.cartedispo = cbisDispo;
		this.ouvert = isOuvert;
		this.capacite = laCapa;
		this.nb_dispo = nbDispo;
		this.emp_dispo = empDispo;
	}

	public String getArrondissement() {
		return arrondissement;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String getDate() {
		return date.replaceAll("T", "�").substring(0, date.length()-4);	
	}
	
	public String getCardDisp() {
		return cartedispo;
	}

	public String getOuvert() {
		return ouvert;
	}
	
	public int getCapacite() {
		return capacite;
	}
	
	public int getVDispo() {
		return nb_dispo;
	}
	
	public int getEmplacement() {
		return emp_dispo;
	}

	@Override
	public String toString() {
		return "Station [arrondissement=" + arrondissement + ",nom=" + nom + ", numero="
				+ numero + ",date=" + date + ",dispo=" + cartedispo + ", ouvert=" + ouvert + ",capacit�=" + capacite + ",v�lo dispo=" + nb_dispo + ",emplacement dispo=" + emp_dispo + "]";
	}
	
}

