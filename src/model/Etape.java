package model;

import java.util.ArrayList;
import java.util.List;

public class Etape 
{
	private int age;
	private ArrayList<Ressource> coutsRessource;
	private ArrayList<Ressource> gainsRessource;
	boolean construite = false;
	
	public Etape()
	{
		age = -1;
	}
	
	public Etape(int age, ArrayList<Ressource> coutsRessource, ArrayList<Ressource> gainsRessource) 
	{
		this.age = age;
		this.coutsRessource = new ArrayList<Ressource>(coutsRessource);
		this.gainsRessource = new ArrayList<Ressource>(gainsRessource);
	}
	
	public String toString() 
	{
		if(construite) 
		{
			return "V | Etape n°"+age;
		}
		else 
		{
			return "X | Etape n°"+age;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Ressource> getCoutsRessource() {
		return coutsRessource;
	}

	public ArrayList<Ressource> getGainsRessource() {
		return gainsRessource;
	}

	public boolean isConstruite() {
		return construite;
	}

	public void setConstruite(boolean construite) {
		this.construite = construite;
	}
}
