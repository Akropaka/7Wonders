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
	private List<Plateau> plateaux;
	
	public ManageurDeTour(Window w) 
	{
		this.w = w;
		
		this.bibliotheque = new Bibliotheque();
		plateaux = new ArrayList<Plateau>(bibliotheque.getListePlateaux());

		joueurs = new ArrayList<Joueur>();
		pile = new ArrayList<Carte>();
		defausse = new ArrayList<Carte>();
		
		demandeJoueurs(3);
		attribuePlateauAleatoirement();
		remplirPile(1);
		
		for(Joueur j : joueurs) 
		{
			donnerOr(j, 2);
		}
		
		update(joueurs.get(0),0);
	}
	
	public void update(Joueur j,int tour) 
	{
		doitJouer(j);
		if(j.getJoueurDroit().equals(joueurs.get(0)))
		{
			for(int i = 0; i<joueurs.size() ;++i)
			{
				echangerMain(joueurs.get(i),joueurs.get(i).getJoueurDroit());
			}
			update(j.getJoueurDroit(),tour+1);
		}
		else
		{
			update(j.getJoueurDroit(),tour);
		}
	}
	
	public void demandeJoueurs(int number) 
	{
		for(int i=0; i<number ;++i) 
		{
			String nom;
			boolean continuer = false;
			Scanner sc = new Scanner(System.in);
			while(continuer == false)
			{
				continuer = true;
				int numero = i+1;
				System.out.println("Entrez le nom du Joueur n° : "+numero);
				nom = sc.nextLine();
				if(nom.isEmpty()) 
				{
					continuer = false;
					System.out.println("Erreur dans la saisie, votre nom est vide");
				}
				else
				{
					for(Joueur j : joueurs) 
					{
						if(nom.equals(j.getNom()))
						{
							continuer = false;
							System.out.println("Erreur dans la saisie, ce nom est déjà prit !");
							break;
						}
					}
				}
				if(continuer) 
				{
					ajoutJoueur(nom);
				}
			}
		}
		for(int i=0; i<joueurs.size();++i) // Set les joueurs droits & gauches
		{
			if(i==0) 
			{
				joueurs.get(i).setJoueurGauche(joueurs.get(joueurs.size()-1));
			}
			else
			{
				joueurs.get(i).setJoueurGauche(joueurs.get(i-1));
			}
			
			if(i==joueurs.size()-1) 
			{
				joueurs.get(i).setJoueurDroit(joueurs.get(0));
			}
			else
			{
				joueurs.get(i).setJoueurDroit(joueurs.get(i+1));
			}
		}
	}
	
	public void attribuePlateauAleatoirement() 
	{
		Collections.shuffle(plateaux);
		int i = 0;
		for(Joueur j : joueurs) 
		{
			j.ajoutPlateau(plateaux.get(i));
			++i;
		}
	}
	
	public void ajoutJoueur(String name) 
	{
		joueurs.add(new Joueur(name));
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
		System.out.println("C'est Ã  votre tour "+j.getNom());
		afficherPlateau(j);
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
				for(Carte c : new ArrayList<Carte>(j.getMain())) 
				{
					String nom = "";
					for(int i=1;i<arguments.length;++i)
					{
						nom += arguments[i];
						if(i!=arguments.length-1) 
						{
							nom += " ";
						}
					}
					
					if(nom.equals(c.getNom())) 
					{
						if(j.peutJouer(c))
						{
							j.joue(c);
							System.out.println("J'ai joué "+c);
							aJouer = true;
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
			if(arguments[0].equals("vendre")) 
			{
				for(Carte c : new ArrayList<Carte>(j.getMain())) 
				{
					String nom = "";
					for(int i=1;i<arguments.length;++i)
					{
						nom += arguments[i];
						if(i!=arguments.length-1) 
						{
							nom += " ";
						}
					}
					if(nom.equals(c.getNom())) 
					{
						j.vend(c);
						aJouer = true;
					}
				}
			}
		}
	}
	
	public void donnerOr(Joueur j, int montant)
	{
		j.setOr(j.getOr()+montant);
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
	
	public void afficherPlateau(Joueur j) 
	{
		System.out.print("Plateau : "+j.getPlateau());
		System.out.println();
		for(Etape e : j.getPlateau().getEtapes()) 
		{
			System.out.println(e);
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
