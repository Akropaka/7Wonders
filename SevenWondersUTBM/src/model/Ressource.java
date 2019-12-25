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
	
	public Ressource(ressourceType nom, int number) 
	{
		this.nom = nom;
		this.number = number;
	}
	
	
}
