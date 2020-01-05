package model;

import java.util.ArrayList;
import java.util.List;
import model.carte.Carte;

public class Bonus
{
	private EffetType et;
	private List<JoueurAffecter> joueurAffecter;
	private List<Class<? extends Carte>> carteAffecter;
	private List<Ressource> ressourceBonus;
	
	public EffetType getEt() 
	{
		return et;
	}

	public List<JoueurAffecter> getJoueurAffecter() 
	{
		return joueurAffecter;
	}

	public List<Class<? extends Carte>> getCarteAffecter() 
	{
		return carteAffecter;
	}

	public List<Ressource> getRessourceBonus() 
	{
		return ressourceBonus;
	}
	
	public Bonus(EffetType et,List<JoueurAffecter> joueurAffecter, List<Class<? extends Carte>>carteAffecter,List<Ressource> ressourceBonus) 
	{
		this.et = et;
		this.joueurAffecter = new ArrayList<JoueurAffecter>(joueurAffecter);
		this.carteAffecter = new ArrayList<Class<? extends Carte>>(carteAffecter);
		this.ressourceBonus = new ArrayList<Ressource>(ressourceBonus);
	}

	public Bonus(Bonus b) 
	{
		this.et = b.getEt();
		this.joueurAffecter = new ArrayList<JoueurAffecter>(b.getJoueurAffecter());
		this.carteAffecter = new ArrayList<Class<? extends Carte>>(b.getCarteAffecter());
		this.ressourceBonus = new ArrayList<Ressource>(b.getRessourceBonus());
	}
}
