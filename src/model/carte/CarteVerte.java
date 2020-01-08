package model.carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Ressource;

public class CarteVerte extends Carte{

	public static String COULEUR = "#2ecc71";

	
	public CarteVerte(String nom, int age, ArrayList<Ressource> coutsRessource, ArrayList<Ressource> gainsRessource,
			ArrayList<Carte> coutsCarte, List<Integer> ajoutParNbrJoueur) 
	{
		super(nom, age, coutsRessource, gainsRessource, coutsCarte, ajoutParNbrJoueur);
		setCouleur(COULEUR);
	}

	public Object clone()throws CloneNotSupportedException
	{  
		return super.clone();
	}
}
