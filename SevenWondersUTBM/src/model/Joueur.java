package model;

import java.util.ArrayList;
import java.util.List;

import model.carte.Carte;

public class Joueur 
{
	private String nom;

	private List<Carte> main;
	private List<Carte> terrain;
	private Plateau plateau;
	
	private List<Carte> jouable;
	private List<Carte> achetable;
	private List<Carte> nonjouable;
	
	public String getNom() 
	{
		return nom;
	}
	
	public List<Carte> getMain() 
	{
		return main;
	}
	
	public List<Carte> getTerrain()
	{
		return terrain;
	}
	
	public void viderMain() 
	{
		main.clear();
	}

	public void donneCarte(Carte c) 
	{
		main.add(c);
	}
	
	public Joueur(String nom) 
	{
		main = new ArrayList<Carte>();
		terrain = new ArrayList<Carte>();
		this.nom = nom;
	}
	
	public void calculJouabilite() 
	{
		// TO DO :
	}
	
	public boolean peutJouer(Carte c) 
	{
		for(Carte ca : terrain) 
		{
			if(ca.equals(c)) 
			{
				System.out.println("Vous possédez déjà cette carte sur votre terrain !");
				return false;
			}
		}
		
		for(Carte ca : jouable) 
		{
			if(ca.equals(c)) 
			{
				return true;
			}
		}
		return false;
	}
	
	public void joue(Carte c)
	{
		terrain.add(c);
		main.remove(c);
	}

	public boolean peutAcheter(Carte c) 
	{
		for(Carte ca : terrain) 
		{
			if(ca.equals(c)) 
			{
				return false;
			}
		}
		
		for(Carte ca : achetable) 
		{
			if(ca.equals(c)) 
			{
				return true;
			}
		}
		return false;
	}
}
