package model.carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Choisisable;
import model.Ressource;

public class CarteMarron extends Carte implements Choisisable{
	
	boolean possedeChoix = false;
	
	public boolean possedeChoix() 
	{
		return possedeChoix;
	}

	public CarteMarron(String nom, int age, ArrayList<Ressource> coutsRessource, ArrayList<Ressource> gainsRessource,
			ArrayList<Carte> coutsCarte, List<Integer> ajoutParNbrJoueur, boolean possedeChoix) 
	{
		super(nom, age, coutsRessource, gainsRessource, coutsCarte, ajoutParNbrJoueur);
		this.possedeChoix = possedeChoix;
	}
	
	public Object clone()throws CloneNotSupportedException
	{  
		return super.clone();
	}
}
