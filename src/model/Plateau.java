package model;

import java.util.ArrayList;
import java.util.List;

public class Plateau 
{
	private String nom;
	
	private Ressource bonusPassif;
	
	public Ressource getBonusPassif() {
		return bonusPassif;
	}

	private List<Etape> etapes;
	
	public List<Etape> getEtapes() {
		return etapes;
	}

	public Plateau(String nom, Ressource bonusPassif, List<Etape> etapes) 
	{
		this.nom = nom;
		this.bonusPassif = new Ressource(bonusPassif);
		this.etapes = new ArrayList<Etape>(etapes);
	}
	
	public String toString() 
	{
		return nom;
	}
}
