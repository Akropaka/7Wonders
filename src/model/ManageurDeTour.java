package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.carte.Carte;
import model.carte.CarteBleue;
import model.carte.CarteVerte;
import model.carte.CarteViolette;
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
	private int age = 1;
	String message = "";

	
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

	public void finDeJeu()
	{
		message = "";
		for(Joueur j : joueurs)
		{
			int engrenage = 0;
			int compas = 0;
			int tablette = 0;
			for(Carte c : j.getTerrain())
			{
				if(c instanceof CarteBleue)
				{
					for(Ressource r : c.getGainsRessource())
					{
						j.pointsVictoire+=r.getNumber();
					}
				}
				
				if(c instanceof CarteVerte)
				{
					for(Ressource r : c.getGainsRessource())
					{
						if(r.getNom().equals(RessourceEnum.INFO))
						{
							engrenage+=r.getNumber();
						}
						if(r.getNom().equals(RessourceEnum.MECA))
						{
							compas+=r.getNumber();
						}
						if(r.getNom().equals(RessourceEnum.ENERGIE))
						{
							tablette+=r.getNumber();
						}
					}
				}
				
				if(c instanceof Effectable)
				{
					((Effectable) c).faitEffetFin(j);
				}
			}
			for(Etape e : j.getPlateau().getEtapes())
			{
				if(e.isConstruite())
				{
					for(Ressource r : e.getGainsRessource())
					{
						if(r.getNom().equals(RessourceEnum.INFO))
						{
							engrenage+=r.getNumber();
						}
						if(r.getNom().equals(RessourceEnum.MECA))
						{
							compas+=r.getNumber();
						}
						if(r.getNom().equals(RessourceEnum.ENERGIE))
						{
							engrenage+=r.getNumber();
						}
						if(r.getNom().equals(RessourceEnum.POINTVICTOIRE))
						{
							j.pointsVictoire+=r.getNumber();
						}
					}
				}
			}
			int total = engrenage*engrenage + compas*compas + tablette*tablette;
			if(engrenage>0 && compas>0 && tablette>0)
			{
				total += 7;
			}
			j.pointsVictoire+=total;
			int orFinDePartie = j.getOr();
			orFinDePartie = (orFinDePartie-(orFinDePartie % 3))/3;
			j.pointsVictoire+=orFinDePartie;
			message += j.getNom() + " fini la partie avec : " + j.pointsVictoire + " Crédits ECTS" + "\n";
		}

		w.afficherMessageCombat(message);
	}
	
	public void faireGuerre()
	{
		message = "";
		Map<Joueur,Integer> scoresCombat = new HashMap<Joueur,Integer>();
		for(Joueur js : joueurs)
		{
			int score = 0;
			for(Carte c : js.getTerrain())
			{
				for(Ressource res : c.getGainsRessource())
				{
					if(res.getNom().equals(RessourceEnum.JETONCOMBAT))
					{
						score+=res.getNumber();
					}
				}
			}
			for(Etape e : js.getPlateau().getEtapes())
			{
				for(Ressource res : e.getGainsRessource())
				{
					if(res.getNom().equals(RessourceEnum.JETONCOMBAT) && e.construite)
					{
						score+=res.getNumber();
					}
				}
			}
			scoresCombat.put(js,score);
		}
		
		scoresCombat.forEach((key,value) -> 
		{
			if(scoresCombat.get(key.getJoueurDroit())>scoresCombat.get(key)) 
			{
				((Joueur)key).pointsVictoire-=1;
				((Joueur)key).jetonDefaite += 1;
				
			}
			else if(scoresCombat.get(key.getJoueurDroit())<scoresCombat.get(key))
			{
				((Joueur)key).pointsVictoire+=age+(age-1);
				int points = age+(age-1);
				message += ((Joueur)key).getNom() + " gagne le combat contre " + ((Joueur)key).getJoueurDroit().getNom() + " il gagne " + points + " points" +"\n";
				
			}
			else
			{
				message += ((Joueur)key).getNom() + " et " + ((Joueur)key).getJoueurDroit().getNom() + " font une égalités ils ne gagnent pas de points "+ "\n";
			}
			if(scoresCombat.get(key.getJoueurGauche())>scoresCombat.get(key)) 
			{
				((Joueur)key).pointsVictoire -= 1;
				((Joueur)key).jetonDefaite += 1;
			}
			else if(scoresCombat.get(key.getJoueurGauche())<scoresCombat.get(key))
			{
				((Joueur)key).pointsVictoire+=age+(age-1);
			}
		});
		
		w.afficherMessageCombat(message);

	}
	
	public void aJoue(Joueur j){
		if(j.getJoueurDroit().equals(joueurs.get(0)))
		{
			for(int i = 0; i<joueurs.size()-1;++i)
			{
				echangerMain(joueurs.get(i),joueurs.get(i).getJoueurDroit());
			}
			tour++;
			if(tour==6)
			{
				faireGuerre();
				// remplir age suivant
				++age;
				for(Joueur jr : joueurs)
				{
					jr.getMain().clear();
				}
				
				if(age==4)
				{
					finDeJeu();
				}
				
				remplirPile(age);
				tour=0;
				
			}
			doitJouer(j.getJoueurDroit());
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
		pile.clear();
		int intGuildeMax = joueurs.size()+2;
		int intGuilde=0;
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
			if(age==3 && c instanceof CarteViolette && intGuilde < intGuildeMax)
			{
				pile.add(c);
				intGuilde++;
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
		String age_txt = null;	
		if(age == 1) {
			age_txt = "Tronc Commun";
		}else if (age == 2){
			age_txt = "Branche";
		}else if (age == 30) {
			age_txt = "Fillière";
		}
		w.setNom("Joueur: " + j.getNom() + " \nIzly Money: " + j.getOr() + " \nAge: " + age_txt + "\nCredit  ECTS: " + j.pointsVictoire);
		w.setNomTerrain(j.getNom());
		System.out.println("C'est à votre tour " + j.getNom());
		j.calculJouabilite();
		afficherPlateau(j);
		afficherTerrain(j);
		afficherMain(j);
		j.calculJouabilite();
		j.calculEtape();
		joueur = j;
	}
	
	public void donnerOr(Joueur j, int montant)
	{
		j.setOr(j.getOr()+montant);
	}
	
	public void lancerJeu()
	{
		
		ordreJoueur();
		attribuePlateauAleatoirement();
		remplirPile(age);
		
		for(Joueur j : joueurs) 
		{
			donnerOr(j, 2);
		}
		doitJouer(joueurs.get(0));
	}
	
	public void construireEtape(String c) 
	{
		if(joueur.isEtapeConstructible())
		{
			joueur.setEtapeConstructible(false);
			boolean construite = false;
			for(Etape e : joueur.getPlateau().getEtapes())
			{
				if(!(e.construite) && !(construite))
				{
					e.construite = true;
					construite = true;
					joueur.retirerCarte(c);
				}
			}
			if(construite == true) {
				aJoue(joueur);
			}
		}else {
			w.setInfo("L'étape n'est pas constructible !");
		}
	}
	
	public void afficherMain(Joueur j)
	{
		System.out.print("Main : ");
		w.hand.setCarteListe(j);

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
	
	public void acheter(String name, ArrayList<Triplet<Ressource,Joueur,Integer>> possibilite)
	{
		for(Triplet<Ressource,Joueur,Integer> triplet : possibilite)
		{
			triplet.getSecond().donneOr(triplet.getThird());
			joueur.donneOr(-triplet.getThird());
		}
		jouer(name);
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
