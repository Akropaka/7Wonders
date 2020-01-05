package model.carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Ressource;

public class CarteRouge extends Carte {

	public CarteRouge(String nom, int age, ArrayList<Ressource> coutsRessource, ArrayList<Ressource> gainsRessource,
			ArrayList<Carte> coutsCarte, List<Integer> ajoutParNbrJoueur) 
	{
		super(nom, age, coutsRessource, gainsRessource, coutsCarte, ajoutParNbrJoueur);
	}

	public Object clone()throws CloneNotSupportedException
	{  
		return super.clone();
	}
}
