package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import model.carte.Carte;
import view.Window;

public class ManageurDeTour 
{
	private List<Joueur> joueurs;
	private Bibliotheque bibliotheque;
	private Window w;
	private List<Carte> pile;
	private List<Carte> defausse;
	
	public ManageurDeTour(Window w) 
	{
		this.w = w;
		joueurs = new ArrayList<Joueur>();
		joueurs.add(new Joueur("Thomas"));
		joueurs.add(new Joueur("Louis"));
		joueurs.add(new Joueur("Ryan"));
		joueurs.add(new Joueur("Olivier"));

		pile = new ArrayList<Carte>();
		defausse = new ArrayList<Carte>();
		
		this.bibliotheque = new Bibliotheque();

	}
	
	public void remplirPile(int age) 
	{

		for(Carte c : bibliotheque.getListeCarte()) 
		{
			if(c.getAge() == age) 
			{
				for(Integer i : c.getAjoutParNbrJoueur()) 
				{
					if(i<=joueurs.size()) 
					{
						pile.add(c);
					}
				}
			}
		}
		Collections.shuffle(pile);
		distribuer();
		for(Joueur j : joueurs)
		{
			afficherMain(j);
		}
	}
	
	public void distribuer() 
	{
		int i=0;
		for(Carte c : pile) 
		{
			joueurs.get(i).donneCarte(c);
			++i;
			if(i>=joueurs.size()) {
				i=0;
			}
		}
	}
	
	public void doitJouer(Joueur j) 
	{
		System.out.println("C'est à votre tour "+j.getNom());
		afficherTerrain(j);
		afficherMain(j);
		j.calculJouabilite();
		Scanner sc = new Scanner(System.in);
		
		boolean aJouer = false;
		
		while(aJouer == false)
		{
			String commande = sc.nextLine();
			String arguments[] = commande.split("\\s+");
			if(arguments[0].equals("jouer")) 
			{
				for(Carte c : j.getMain()) 
				{
					if(arguments[1].equals(c.getNom())) 
					{
						if(j.peutJouer(c))
						{
							j.joue(c);
						}
						else if(j.peutAcheter(c)) 
						{
							//TO DO : proposeAchat()
						}
						else
						{
							System.out.println("Cette carte n'est pas jouable !");
						}
					}
				}
			}
			if(arguments[0].equals("info")) 
			{
				for(Carte c : j.getMain()) 
				{
					if(arguments[1].equals(c.getNom())) 
					{
						//TO DO : c.afficherInfo() | Polymorphisme
					}
				}
			}
		}
	}
	
	public void afficherMain(Joueur j)
	{
		System.out.print("Main : ");
		w.hv.setCarteListe(j.getMain());
		w.cjv.setCarteListe(j.getMain());

		for(Carte c : j.getMain())
		{
			System.out.print(c);
		}
		System.out.println();
	}
	
	public void afficherTerrain(Joueur j)
	{
		System.out.print("Terrain : ");
		for(Carte c : j.getTerrain()) 
		{
			//w.cv.set
			System.out.print(c);
		}
		System.out.println();
	}
	
	public void echangerMain(Joueur j1, Joueur j2) 
	{
		Joueur temp = new Joueur("temp");
		for(Carte c : j1.getMain())
		{
			temp.donneCarte(c);
		}
		j1.viderMain();
		for(Carte c : j2.getMain())
		{
			j1.donneCarte(c);
		}
		j2.viderMain();
		for(Carte c : temp.getMain())
		{
			j2.donneCarte(c);
		}
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}
}
