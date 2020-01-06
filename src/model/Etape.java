package model;

import java.util.ArrayList;
import java.util.List;

public class Etape 
{
	private int age;
	private List<Ressource> coutsRessource;
	private List<Ressource> gainsRessource;
	boolean construite = false;
	
	public Etape(int age, List<Ressource> coutsRessource, List<Ressource> gainsRessource) 
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

	public List<Ressource> getCoutsRessource() {
		return coutsRessource;
	}

	public List<Ressource> getGainsRessource() {
		return gainsRessource;
	}

	public boolean isConstruite() {
		return construite;
	}

	public void setConstruite(boolean construite) {
		this.construite = construite;
	}
}
