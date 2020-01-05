package model;

public class Ressource 
{
	private RessourceEnum nom;
	private int number;
	
	public void setNumber(int number) {
		this.number = number;
	}

	public RessourceEnum getNom() {
		return nom;
	}

	public int getNumber() {
		return number;
	}

	public Ressource(RessourceEnum nom, int number) 
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
