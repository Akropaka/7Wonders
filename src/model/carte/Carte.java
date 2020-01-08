package model.carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Ressource;

public abstract class Carte implements Cloneable
{
	private String nom;
	
	public String getNom() {
		return nom;
	}
	
	protected String couleur;
	private int age;
	private ArrayList<Ressource> coutsRessource;
	private ArrayList<Ressource> gainsRessource;
	private ArrayList<Carte> coutsCarte;
	
	public ArrayList<Ressource> getCoutsRessource() 
	{
		return coutsRessource;
	}

	private List<Integer> ajoutParNbrJoueur;
	
	public List<Integer> getAjoutParNbrJoueur() 
	{
		return ajoutParNbrJoueur;
	}

	public int getAge() 
	{
		return age;
	}

	public Carte(String nom, int age, List<Ressource> coutsRessource, ArrayList<Ressource> gainsRessource,
			ArrayList<Carte> coutsCarte, List<Integer> ajoutParNbrJoueur) 
	{
		this.nom = nom;
		this.age = age;
		this.coutsRessource = new ArrayList<Ressource>(coutsRessource);
		this.gainsRessource = new ArrayList<Ressource>(gainsRessource);
		this.coutsCarte = new ArrayList<Carte>(coutsCarte);
		this.ajoutParNbrJoueur = new ArrayList<Integer>(ajoutParNbrJoueur);
	}

	public List<Ressource> getGainsRessource() 
	{
		return gainsRessource;
	}
	
	public String toString() 
	{
		return nom + "   ";
	}
	
	public Object clone()throws CloneNotSupportedException
	{  
		return super.clone();
	}

	public List<Carte> getCoutsCarte() 
	{
		return coutsCarte;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
}
