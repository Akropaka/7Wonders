package model;

import java.util.ArrayList;

import model.carte.*;

public class Bibliotheque {
	private ArrayList<Carte> listeCarte;
	private int nbrJoueur;
	
	ArrayList<Ressource> coutsRessource;
	ArrayList<Ressource> gainsRessource;
	ArrayList<Carte> coutsCarte;
	ArrayList<Integer> ajoutParNbrJoueur;
	
	private EffetType et = EffetType.AUCUN;
	private ArrayList<JoueurAffecter> joueurAffecter;
	private ArrayList<Class<? extends Carte>> carteAffecter;
	private ArrayList<Ressource> ressourceBonus;
	
	private ArrayList<Plateau> plateaux;
	private ArrayList<Etape> etapes;
	
	public ArrayList<Carte> getListeCarte() 
	{
		return listeCarte;
	}

	public ArrayList<Plateau> getListePlateaux()
	{
		return plateaux;
	}
	
	public void resetAll() 
	{
		coutsRessource.clear();
		gainsRessource.clear();
		coutsCarte.clear();
		ajoutParNbrJoueur.clear();
		joueurAffecter.clear();
		carteAffecter.clear();
		ressourceBonus.clear();
		et = EffetType.AUCUN;
	}
	
	public Bibliotheque() 
	{
		coutsRessource = new ArrayList<Ressource>();
		gainsRessource = new ArrayList<Ressource>();
		coutsCarte = new ArrayList<Carte>();
		ajoutParNbrJoueur = new ArrayList<Integer>();
		joueurAffecter = new ArrayList<JoueurAffecter>();
		carteAffecter = new ArrayList<Class<? extends Carte>>();
		ressourceBonus = new ArrayList<Ressource>();
		
		plateaux = new ArrayList<Plateau>();
		etapes = new ArrayList<Etape>();
		
		listeCarte = new ArrayList<Carte>();
		
		/*
		 * ! Cartes Marrons !
		*/
		
		gainsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		
		CarteMarron chantier = new CarteMarron("Mme.DUPLIN"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		resetAll();
		
		gainsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteMarron cavite = new CarteMarron("M.STAUSETTE"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		resetAll();
		
		gainsRessource.add(new Ressource(RessourceEnum.CG,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteMarron bassinArgileux = new CarteMarron("M.ZOUK BAE"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		resetAll();
		
		gainsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		
		CarteMarron filon = new CarteMarron("M.LANUISEL"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.IZLY,1));
		gainsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		gainsRessource.add(new Ressource(RessourceEnum.CG,1));
		ajoutParNbrJoueur.add(6);
		
		CarteMarron friche = new CarteMarron("M.OLINGO"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,true);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.IZLY,1));
		gainsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		gainsRessource.add(new Ressource(RessourceEnum.CG,1));
		ajoutParNbrJoueur.add(4);
		
		CarteMarron excavation = new CarteMarron("M.TROISPONEY"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,true);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.IZLY,1));
		gainsRessource.add(new Ressource(RessourceEnum.CG,1));
		gainsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		ajoutParNbrJoueur.add(3);
		
		CarteMarron fosseArgileuse = new CarteMarron("M.McKINKECT"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,true);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.IZLY,1));
		gainsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		gainsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		ajoutParNbrJoueur.add(3);
		
		CarteMarron exploitationForestiere = new CarteMarron("M.TASHIKART"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,true);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.IZLY,1));
		gainsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		gainsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		ajoutParNbrJoueur.add(5);
		
		CarteMarron gisement = new CarteMarron("M.LAMER"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,true);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.IZLY,1));
		gainsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		gainsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		ajoutParNbrJoueur.add(6);
		
		CarteMarron mine = new CarteMarron("M.BASHART"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,true);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.IZLY,1));
		gainsRessource.add(new Ressource(RessourceEnum.LANGUE,2));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		
		CarteMarron scierie = new CarteMarron("M.BONHARD"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.IZLY,1));
		gainsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,2));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		
		CarteMarron carriere = new CarteMarron("Mme.PLANCH"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.IZLY,1));
		gainsRessource.add(new Ressource(RessourceEnum.CG,2));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		
		CarteMarron briqueterie = new CarteMarron("M.HEIBERGER"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.IZLY,1));
		gainsRessource.add(new Ressource(RessourceEnum.MATHS,2));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		
		CarteMarron fonderie = new CarteMarron("M.TUTURBORGUE"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		resetAll();
		
		/*
		 * ! Cartes Grises !
		*/
		
		gainsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		
		CarteGrise metierTisser1 = new CarteGrise("M.WITZ"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		gainsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		
		CarteGrise verrerie1 = new CarteGrise("M.LAPOSTOL"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		gainsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		
		CarteGrise presse1 = new CarteGrise("M.BESCHRELLE"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		gainsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteGrise metierTisser2 = new CarteGrise("M.WITZ"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		
		gainsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteGrise verrerie2 = new CarteGrise("M.LAPOSTOL"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		gainsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteGrise presse2 = new CarteGrise("M.BESCHRELLE"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		/*
		 * ! Cartes Vertes !
		*/
		
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		gainsRessource.add(new Ressource(RessourceEnum.MECA,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteVerte officine = new CarteVerte("M.MESSERLING"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		gainsRessource.add(new Ressource(RessourceEnum.INFO,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		
		CarteVerte atelier = new CarteVerte("M.GESHTER"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		gainsRessource.add(new Ressource(RessourceEnum.ENERGIE,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		
		CarteVerte scriptorium = new CarteVerte("M.PIKACHU"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,2));
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		gainsRessource.add(new Ressource(RessourceEnum.MECA,1));
		coutsCarte.add(officine);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		
		CarteVerte dispensaire = new CarteVerte("M.ELKEDIM"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CG,2));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		gainsRessource.add(new Ressource(RessourceEnum.INFO,1));
		coutsCarte.add(atelier);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteVerte laboratoire = new CarteVerte("M.ROMMETE"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,2));
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		gainsRessource.add(new Ressource(RessourceEnum.ENERGIE,1));
		coutsCarte.add(scriptorium);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		
		CarteVerte bibliotheque = new CarteVerte("M.FLESH"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		gainsRessource.add(new Ressource(RessourceEnum.ENERGIE,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		
		CarteVerte ecole = new CarteVerte("M.BERTRANT"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CG,2));
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		gainsRessource.add(new Ressource(RessourceEnum.MECA,1));
		coutsCarte.add(dispensaire);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		
		CarteVerte loge = new CarteVerte("M.PHILIPE"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,2));
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		gainsRessource.add(new Ressource(RessourceEnum.INFO,1));
		coutsCarte.add(laboratoire);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		
		CarteVerte observatoire = new CarteVerte("M.FISCHOR"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,2));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		gainsRessource.add(new Ressource(RessourceEnum.ENERGIE,1));
		coutsCarte.add(bibliotheque);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		
		CarteVerte universite = new CarteVerte("M.PAHONS"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,3));
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		gainsRessource.add(new Ressource(RessourceEnum.MECA,1));
		coutsCarte.add(ecole);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		
		CarteVerte academie = new CarteVerte("M.USINEGUERRE"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		gainsRessource.add(new Ressource(RessourceEnum.INFO,1));
		coutsCarte.add(ecole);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteVerte etude = new CarteVerte("M.LORI"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		/*
		 * ! Cartes Bleues !
		*/
		
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,3));
		ajoutParNbrJoueur.add(4);
		ajoutParNbrJoueur.add(7);
		
		CarteBleue preteurSurGages = new CarteBleue("Coworking"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,3));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		
		CarteBleue bains = new CarteBleue("BU"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,2));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteBleue autel = new CarteBleue("Salle de classe"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,2));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		
		CarteBleue theatre = new CarteBleue("Salle de TP"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,3));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,5));
		coutsCarte.add(bains);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		
		CarteBleue aqueduc = new CarteBleue("Bibliothèque"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.CG,1));
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,3));
		coutsCarte.add(autel);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		
		CarteBleue temple = new CarteBleue("Amphithéâtre"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,4));
		coutsCarte.add(theatre);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		
		CarteBleue statue = new CarteBleue("Laboratoire"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CG,2));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,4));
		coutsCarte.add(scriptorium);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteBleue tribunal = new CarteBleue("Machine CNC"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CG,2));
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,7));
		coutsCarte.add(temple);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		
		CarteBleue pantheon = new CarteBleue("Auditorium"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.CG,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,5));
		coutsCarte.add(statue);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		
		CarteBleue jardins = new CarteBleue("Centre de recherche"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,6));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		ajoutParNbrJoueur.add(6);
		
		CarteBleue hotelDeVille = new CarteBleue("FabLab"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		coutsRessource.add(new Ressource(RessourceEnum.CG,1));
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,8));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		
		CarteBleue palace = new CarteBleue("Salle des profs"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,6));
		coutsCarte.add(bibliotheque);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteBleue senat = new CarteBleue("Pile Combustible"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		/*
		 * ! Cartes Rouges !
		*/
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		
		CarteRouge palissade = new CarteRouge("PSA"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		
		CarteRouge caserne = new CarteRouge("Bret's"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CG,1));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,1));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		
		CarteRouge tourDeGarde = new CarteRouge("Alstom"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,3));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,2));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		
		CarteRouge muraille = new CarteRouge("ST40"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,2));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,2));
		ajoutParNbrJoueur.add(4);
		ajoutParNbrJoueur.add(6);
		ajoutParNbrJoueur.add(7);
		CarteRouge placeDarmes = new CarteRouge("Stage étranger"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		coutsRessource.add(new Ressource(RessourceEnum.CG,1));
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,2));
		coutsCarte.add(officine);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		CarteRouge ecuries = new CarteRouge("Airbus"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,2));
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,2));
		coutsCarte.add(atelier);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		CarteRouge champsDeTir = new CarteRouge("Ubisoft"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,2));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,3));
		coutsCarte.add(muraille);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		CarteRouge fortifications = new CarteRouge("ST50"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,3));
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,3));
		coutsCarte.add(placeDarmes);
		ajoutParNbrJoueur.add(4);
		ajoutParNbrJoueur.add(5);
		ajoutParNbrJoueur.add(6);
		CarteRouge cirque = new CarteRouge("Semestre étranger"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,2));
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,3));
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		ajoutParNbrJoueur.add(7);
		CarteRouge arsenal = new CarteRouge("ST00"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.CG,3));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,3));
		coutsCarte.add(laboratoire);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		CarteRouge atelierDeSiege = new CarteRouge("Google"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur);
		resetAll();
		
		/*
		 * ! Cartes Jaunes !
		*/
			
		ajoutParNbrJoueur.add(4);
		ajoutParNbrJoueur.add(5);
		ajoutParNbrJoueur.add(7);
		CarteJaune taverne = new CarteJaune("Troll Penché"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.DONNEOR;
		joueurAffecter.add(JoueurAffecter.MOI);
		ressourceBonus.add(new Ressource(RessourceEnum.IZLY,5));
		taverne.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		CarteJaune comptoirEst = new CarteJaune("UTB'Mousse"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.REDUCTIONPRIX;
		joueurAffecter.add(JoueurAffecter.DROITE);
		ressourceBonus.add(new Ressource(RessourceEnum.CG,1));
		ressourceBonus.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		ressourceBonus.add(new Ressource(RessourceEnum.MATHS,1));
		ressourceBonus.add(new Ressource(RessourceEnum.LANGUE,1));
		comptoirEst.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(7);
		CarteJaune comptoirOuest = new CarteJaune("UTBpm"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.REDUCTIONPRIX;
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		ressourceBonus.add(new Ressource(RessourceEnum.CG,1));
		ressourceBonus.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		ressourceBonus.add(new Ressource(RessourceEnum.MATHS,1));
		ressourceBonus.add(new Ressource(RessourceEnum.LANGUE,1));
		comptoirOuest.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		CarteJaune marche = new CarteJaune("Club carte"
											,1
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.REDUCTIONPRIX;
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		joueurAffecter.add(JoueurAffecter.DROITE);
		ressourceBonus.add(new Ressource(RessourceEnum.ALCOOL,1));
		ressourceBonus.add(new Ressource(RessourceEnum.CHIMIE,1));
		ressourceBonus.add(new Ressource(RessourceEnum.ELEC,1));
		marche.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CG,2));
		gainsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		gainsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		gainsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		coutsCarte.add(comptoirEst);
		coutsCarte.add(comptoirOuest);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		ajoutParNbrJoueur.add(7);
		CarteJaune forum = new CarteJaune("Les potards"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,true);
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,2));
		gainsRessource.add(new Ressource(RessourceEnum.CG,1));
		gainsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		gainsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		gainsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		coutsCarte.add(marche);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		ajoutParNbrJoueur.add(6);
		CarteJaune caravanserail = new CarteJaune("UT'Rsoft"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,true);
		resetAll();
		
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		CarteJaune vignoble = new CarteJaune("BDE"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.ORPARCARTE;
		joueurAffecter.add(JoueurAffecter.MOI);
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		joueurAffecter.add(JoueurAffecter.DROITE);
		carteAffecter.add(CarteMarron.class);
		ressourceBonus.add(new Ressource(RessourceEnum.IZLY,1));
		vignoble.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		ajoutParNbrJoueur.add(4);
		ajoutParNbrJoueur.add(7);
		CarteJaune bazar = new CarteJaune("UT'VR"
											,2
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.ORPARCARTE;
		joueurAffecter.add(JoueurAffecter.MOI);
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		joueurAffecter.add(JoueurAffecter.DROITE);
		carteAffecter.add(CarteGrise.class);
		ressourceBonus.add(new Ressource(RessourceEnum.IZLY,2));
		bazar.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		coutsCarte.add(forum);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(4);
		CarteJaune port = new CarteJaune("BDF"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.ORPARCARTE;
		joueurAffecter.add(JoueurAffecter.MOI);
		carteAffecter.add(CarteMarron.class);
		ressourceBonus.add(new Ressource(RessourceEnum.IZLY,1));
		port.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		resetAll();
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.MOI);
		carteAffecter.add(CarteMarron.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		port.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		coutsCarte.add(caravanserail);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(6);
		CarteJaune phare = new CarteJaune("UT'Gaming"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.ORPARCARTE;
		joueurAffecter.add(JoueurAffecter.MOI);
		carteAffecter.add(CarteJaune.class);
		ressourceBonus.add(new Ressource(RessourceEnum.IZLY,1));
		phare.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		resetAll();
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.MOI);
		carteAffecter.add(CarteJaune.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		phare.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CG,2));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		ajoutParNbrJoueur.add(4);
		ajoutParNbrJoueur.add(6);
		CarteJaune chambreDeCommerce = new CarteJaune("BDS"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.ORPARCARTE;
		joueurAffecter.add(JoueurAffecter.MOI);
		carteAffecter.add(CarteGrise.class);
		ressourceBonus.add(new Ressource(RessourceEnum.IZLY,2));
		chambreDeCommerce.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		resetAll();
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.MOI);
		carteAffecter.add(CarteGrise.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,2));
		chambreDeCommerce.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,1));
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,2));
		coutsCarte.add(dispensaire);
		ajoutParNbrJoueur.add(3);
		ajoutParNbrJoueur.add(5);
		ajoutParNbrJoueur.add(7);
		CarteJaune arene = new CarteJaune("Les assidus"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.ORPARETAPE;
		joueurAffecter.add(JoueurAffecter.MOI);
		ressourceBonus.add(new Ressource(RessourceEnum.IZLY,3));
		arene.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		resetAll();
		et = EffetType.POINTSPARETAPE;
		joueurAffecter.add(JoueurAffecter.MOI);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		arene.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		/*
		 * ! Cartes Violettes !
		*/
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,2));
		coutsRessource.add(new Ressource(RessourceEnum.CG,1));
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,1));
		CarteViolette guildeDesTravailleurs = new CarteViolette("Guilde des Travailleurs"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.DROITE);
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		carteAffecter.add(CarteMarron.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		guildeDesTravailleurs.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,2));
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,2));
		CarteViolette guildeDesArtisans = new CarteViolette("Guilde des Artisans"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.DROITE);
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		carteAffecter.add(CarteGrise.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,2));
		guildeDesArtisans.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		CarteViolette guildeDesCommercants = new CarteViolette("Guilde des Commerçants"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.DROITE);
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		carteAffecter.add(CarteJaune.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		guildeDesCommercants.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CG,3));
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		CarteViolette guildeDesPhilosophes = new CarteViolette("Netflix'n'chill"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.DROITE);
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		carteAffecter.add(CarteVerte.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		guildeDesPhilosophes.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.CG,3));
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		CarteViolette guildeDesEspions = new CarteViolette("Facebook"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.DROITE);
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		carteAffecter.add(CarteRouge.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		guildeDesEspions.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,2));
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		CarteViolette guildeDesStrateges = new CarteViolette("Programmation"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.POINTSPARJETONDEFAITE;
		joueurAffecter.add(JoueurAffecter.DROITE);
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		guildeDesStrateges.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,3));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		CarteViolette guildeDesArmateurs= new CarteViolette("Tweeter"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.MOI);
		carteAffecter.add(CarteMarron.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		guildeDesArmateurs.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		resetAll();
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.MOI);
		carteAffecter.add(CarteGrise.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		guildeDesArmateurs.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		resetAll();
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.MOI);
		carteAffecter.add(CarteViolette.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		guildeDesArmateurs.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,2));
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,2));
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,1));
		gainsRessource.add(new Ressource(RessourceEnum.MECA,1));
		gainsRessource.add(new Ressource(RessourceEnum.INFO,1));
		gainsRessource.add(new Ressource(RessourceEnum.ENERGIE,1));
		CarteViolette guildeDesScientifiques= new CarteViolette("Youtube"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,true);
		et = EffetType.SCIENCE;
		guildeDesScientifiques.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		resetAll();
		
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,3));
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,1));
		coutsRessource.add(new Ressource(RessourceEnum.ALCOOL,1));
		CarteViolette guildeDesMagistrats = new CarteViolette("Comme d'hab' chef"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.POINTSPARCARTE;
		joueurAffecter.add(JoueurAffecter.DROITE);
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		carteAffecter.add(CarteBleue.class);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		guildeDesMagistrats.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,2));
		coutsRessource.add(new Ressource(RessourceEnum.CG,2));
		coutsRessource.add(new Ressource(RessourceEnum.CHIMIE,1));
		CarteViolette guildeDesBatisseurs = new CarteViolette("RU"
											,3
											,coutsRessource
											,gainsRessource
											,coutsCarte
											,ajoutParNbrJoueur
											,false);
		
		et = EffetType.POINTSPARETAPE;
		joueurAffecter.add(JoueurAffecter.MOI);
		joueurAffecter.add(JoueurAffecter.DROITE);
		joueurAffecter.add(JoueurAffecter.GAUCHE);
		ressourceBonus.add(new Ressource(RessourceEnum.POINTVICTOIRE,1));
		guildeDesBatisseurs.addBonus(new Bonus(et,joueurAffecter,carteAffecter,ressourceBonus));
		
		resetAll();
		
		listeCarte.add(fosseArgileuse);
		listeCarte.add(bassinArgileux);
		listeCarte.add(guildeDesBatisseurs);
		listeCarte.add(guildeDesMagistrats);
		listeCarte.add(guildeDesScientifiques);
		listeCarte.add(guildeDesArmateurs);
		listeCarte.add(guildeDesStrateges);
		listeCarte.add(guildeDesEspions);
		listeCarte.add(guildeDesPhilosophes);
		listeCarte.add(guildeDesCommercants);
		listeCarte.add(guildeDesArtisans);
		listeCarte.add(guildeDesTravailleurs);
		listeCarte.add(arene);
		listeCarte.add(chambreDeCommerce);
		listeCarte.add(phare);
		listeCarte.add(port);
		listeCarte.add(bazar);
		listeCarte.add(vignoble);
		listeCarte.add(caravanserail);
		listeCarte.add(forum);
		listeCarte.add(marche);
		listeCarte.add(comptoirOuest);
		listeCarte.add(comptoirEst);
		listeCarte.add(taverne);
		listeCarte.add(atelierDeSiege);
		listeCarte.add(arsenal);
		listeCarte.add(cirque);
		listeCarte.add(fortifications);
		listeCarte.add(champsDeTir);
		listeCarte.add(ecuries);
		listeCarte.add(placeDarmes);
		listeCarte.add(muraille);
		listeCarte.add(tourDeGarde);
		listeCarte.add(caserne);
		listeCarte.add(palissade);
		listeCarte.add(senat);
		listeCarte.add(palace);
		listeCarte.add(hotelDeVille);
		listeCarte.add(jardins);
		listeCarte.add(pantheon);
		listeCarte.add(tribunal);
		listeCarte.add(statue);
		listeCarte.add(temple);
		listeCarte.add(aqueduc);
		listeCarte.add(theatre);
		listeCarte.add(autel);
		listeCarte.add(bains);
		listeCarte.add(preteurSurGages);
		listeCarte.add(etude);
		listeCarte.add(academie);
		listeCarte.add(universite);
		listeCarte.add(observatoire);
		listeCarte.add(loge);
		listeCarte.add(ecole);
		listeCarte.add(bibliotheque);
		listeCarte.add(laboratoire);
		listeCarte.add(dispensaire);
		listeCarte.add(scriptorium);
		listeCarte.add(atelier);
		listeCarte.add(officine);
		listeCarte.add(presse2);
		listeCarte.add(verrerie2);
		listeCarte.add(metierTisser2);
		listeCarte.add(presse1);
		listeCarte.add(verrerie1);
		listeCarte.add(metierTisser1);
		listeCarte.add(fonderie);
		listeCarte.add(briqueterie);
		listeCarte.add(carriere);
		listeCarte.add(scierie);
		listeCarte.add(mine);
		listeCarte.add(gisement);
		listeCarte.add(exploitationForestiere);
		listeCarte.add(excavation);
		listeCarte.add(friche);
		listeCarte.add(cavite);
		listeCarte.add(chantier);
		listeCarte.add(filon);
		
		// ! Plateaux !
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,3));
		Etape etape1 = new Etape(1,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape1);
		
		coutsRessource.add(new Ressource(RessourceEnum.CG,3));
		gainsRessource.add(new Ressource(RessourceEnum.JETONCOMBAT,2));
		Etape etape2 = new Etape(2,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape2);
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,4));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,7));
		Etape etape3 = new Etape(3,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape3);
		
		Plateau leColosseDeRhodes = new Plateau("Le Colosse de Rhodes"
											,new Ressource(RessourceEnum.MATHS,1)
											,etapes);
		etapes.clear();
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,3));
		etape1 = new Etape(1,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape1);
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,3));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,5));
		etape2 = new Etape(2,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape2);
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,4));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,7));
		etape3 = new Etape(3,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape3);
		
		Plateau laGrandePyramideDeGizeh = new Plateau("La Grande Pyramide De Gizeh"
											,new Ressource(RessourceEnum.PHYSIQUE,1)
											,etapes);
		etapes.clear();
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,3));
		etape1 = new Etape(1,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape1);
		
		coutsRessource.add(new Ressource(RessourceEnum.LANGUE,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,5));
		etape2 = new Etape(2,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape2);
		
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,7));
		etape3 = new Etape(3,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape3);
		
		Plateau leTempleDartemis = new Plateau("Le Temple d'Artémis"
											,new Ressource(RessourceEnum.ELEC,1)
											,etapes);
		etapes.clear();
		
		coutsRessource.add(new Ressource(RessourceEnum.PHYSIQUE,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,3));
		etape1 = new Etape(1,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape1);
		
		coutsRessource.add(new Ressource(RessourceEnum.MATHS,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,5));
		etape2 = new Etape(2,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape2);
		
		coutsRessource.add(new Ressource(RessourceEnum.ELEC,2));
		gainsRessource.add(new Ressource(RessourceEnum.POINTVICTOIRE,7));
		etape3 = new Etape(3,coutsRessource,gainsRessource);
		resetAll();
		etapes.add(etape3);
		
		Plateau lePhareDalexandrie = new Plateau("Le Phare d'Alexandrie"
											,new Ressource(RessourceEnum.CHIMIE,1)
											,etapes);
		etapes.clear();
		
		plateaux.add(leColosseDeRhodes);
		plateaux.add(laGrandePyramideDeGizeh);
		plateaux.add(leTempleDartemis);
		plateaux.add(lePhareDalexandrie);
	}
}
