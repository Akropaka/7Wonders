package model;

enum ressourceType
{
	BOIS,
	PIERRE,
	ARGILE,
	FER,
	TISSU,
	VERRE,
	PARCHEMIN,
	
	OR,
	
	POINTVICTOIRE,
	
	JETONCOMBAT,
	
	ENGRENAGE,
	COMPAS,
	TABLETTE;
}

public class Ressource 
{
	private ressourceType nom;
	private int number;
	
	public void setNumber(int number) {
		this.number = number;
	}

	public ressourceType getNom() {
		return nom;
	}

	public int getNumber() {
		return number;
	}

	public Ressource(ressourceType nom, int number) 
	{
		this.nom = nom;
		this.number = number;
	}
	
	public Ressource(Ressource ressource) 
	{
		this.nom = ressource.getNom();
		this.number = ressource.getNumber();
	}
}
