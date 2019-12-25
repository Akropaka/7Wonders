package model.carte;

import java.util.List;
import java.util.Set;

import model.Ressource;

public class CarteMarron extends Carte{
	
	boolean possedeChoix = false;
	
	public CarteMarron(String nom, int age, List<Ressource> coutsRessource, List<Ressource> gainsRessource,
			List<Carte> coutsCarte, List<Integer> ajoutParNbrJoueur, boolean possedeChoix) 
	{
		super(nom, age, coutsRessource, gainsRessource, coutsCarte, ajoutParNbrJoueur);
		this.possedeChoix = possedeChoix;
	}
	
	public Object clone()throws CloneNotSupportedException
	{  
		return super.clone();
	}
}
