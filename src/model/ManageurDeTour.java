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
	private int tour = 0;
	
	private Joueur joueur;
	
	public ManageurDeTour(Window w) 
	{
		this.w = w;
		
		bibliotheque = new Bibliotheque();
		plateaux = new ArrayList<Plateau>(bibliotheque.getListePlateaux());

		joueurs = new ArrayList<Joueur>();
		pile = new ArrayList<Carte>();
		defausse = new ArrayList<Carte>();
	}
	
	
	public void aJoue(Joueur j){
		if(j.getJoueurDroit().equals(joueurs.get(0)))
		{
			for(int i = 0; i<joueurs.size() ;++i)
			{
				echangerMain(joueurs.get(i),joueurs.get(i).getJoueurDroit());
			}
			doitJouer(j.getJoueurDroit());
			tour++;
		}
		else
		{
			doitJouer(j.getJoueurDroit());
		}
	}
	
	public void ordreJoueur() 
	{
		
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
	
	public void jouer(String carte) {
		for(Carte c : new ArrayList<Carte>(joueur.getMain())) 
		{

			if(carte.equals(c.getNom())) 
			{
				if(joueur.peutJouer(c))
				{
					
					joueur.joue(c);
					System.out.println("J'ai joué "+c);
					aJoue(joueur);
				}
				else if(joueur.peutAcheter(c)) 
				{
					
				}
				else
				{
					w.setInfo("Cette carte n'est pas jouable !");
				}
			}
		}

	}
	
	public void etape() {} //TODO
	
	public void vendre(String carte) {
		for(Carte c : new ArrayList<Carte>(joueur.getMain())) 
		{

			if(carte.equals(c.getNom())) 
			{
				joueur.vend(c);
				aJoue(joueur);
			}
		}
	}
	
	public void doitJouer(Joueur j) 
	{
		w.setNom(j.getNom());
		w.setNomTerrain(j.getNom());
		System.out.println("C'est à votre tour " + j.getNom());
		j.calculJouabilite();
		afficherPlateau(j);
		afficherTerrain(j);
		afficherMain(j);
		j.calculJouabilite();
		j.calculEtape();
		joueur = j;
		/*Scanner sc = new Scanner(System.in);
		
		boolean aJouer = false;
		
		while(aJouer == false)
		{
			String commande = sc.nextLine();
			String arguments[] = commande.split("\\s+");
			if(arguments[0].equals("jouer")) 
			{
				
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
		}*/
	}
	
	public void donnerOr(Joueur j, int montant)
	{
		j.setOr(j.getOr()+montant);
	}
	
	public void lancerJeu()
	{
		
		ordreJoueur();
		attribuePlateauAleatoirement();
		remplirPile(1);
		
		for(Joueur j : joueurs) 
		{
			donnerOr(j, 2);
		}
		doitJouer(joueurs.get(0));
	}
	
	public void afficherMain(Joueur j)
	{
		System.out.print("Main : ");
		w.hand.setCarteListe(j);
		//w.cjv.setCarteListe(j.getMain());

		for(Carte c : j.getMain())
		{
			System.out.print(c);
		}
		System.out.println();
	}
	
	public void afficherTerrain(Joueur j)
	{
		System.out.print("Terrain : ");
		w.terrain.setCarteListe(j.getTerrain());
		for(Carte c : j.getTerrain()) 
		{
			System.out.print(c);
		}
		System.out.println();
	}
	
	public void afficherPlateau(Joueur j) 
	{
		System.out.print("Plateau : "+j.getPlateau());
		System.out.println();
		w.board.setBoard(j.getPlateau());
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
	public Joueur getJoueur() {
		return joueur;
	}
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
}
