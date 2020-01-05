package model.carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Bonus;
import model.Choisisable;
import model.Effectable;
import model.EffetType;
import model.Ressource;

public class CarteViolette extends Carte implements Effectable,Choisisable {

	private List<Bonus> bonus;
	boolean possedeChoix = false;
	
	public CarteViolette(String nom, int age, ArrayList<Ressource> coutsRessource, ArrayList<Ressource> gainsRessource,
			ArrayList<Carte> coutsCarte, List<Integer> ajoutParNbrJoueur, boolean possedeChoix)
	{
		super(nom, age, coutsRessource, gainsRessource, coutsCarte, ajoutParNbrJoueur);
		this.possedeChoix = possedeChoix;
		bonus = new ArrayList<Bonus>();
	}
	
	public void addBonus(Bonus b)
	{
		this.bonus.add(new Bonus(b));
	}
	
	public void faitEffet() {
		// TODO Auto-generated method stub
	}

	public Object clone()throws CloneNotSupportedException
	{  
		return super.clone();
	}

	@Override
	public boolean possedeChoix() 
	{
		return possedeChoix;
	}
}
