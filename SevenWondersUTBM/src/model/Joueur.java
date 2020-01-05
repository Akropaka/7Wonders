package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.carte.Carte;
import model.carte.CarteGrise;
import model.carte.CarteMarron;
import model.carte.CarteViolette;

public class Joueur 
{
	private String nom;

	private Joueur joueurDroit;
	private Joueur joueurGauche;
	
	public Joueur getJoueurDroit() {
		return joueurDroit;
	}

	public Joueur getJoueurGauche() {
		return joueurGauche;
	}
	
	private Map<Ressource,Integer> prixRessource;
	
	public void setJoueurDroit(Joueur joueurDroit) 
	{
		this.joueurDroit = joueurDroit;
	}

	public void setJoueurGauche(Joueur joueurGauche) 
	{
		this.joueurGauche = joueurGauche;
	}

	private ArrayList<Carte> main;
	private ArrayList<Carte> terrain;
	private Plateau plateau;
	
	private int or;
	
	public int getOr() 
	{
		return or;
	}

	public void setOr(int or) 
	{
		this.or = or;
	}

	private ArrayList<Carte> jouable;
	private ArrayList<Carte> achetable;
	private ArrayList<Carte> nonjouable;
	
	public String getNom() 
	{
		return nom;
	}
	
	public void ajoutPlateau(Plateau plateau) 
	{
		this.plateau = plateau;
	}
	public ArrayList<Carte> getMain() 
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
		jouable = new ArrayList<Carte>();
		achetable = new ArrayList<Carte>();
		nonjouable = new ArrayList<Carte>();
		this.nom = nom;
	}
	
	public void prixDefaut() 
	{
		
	}
	
	public void calculJouabilite() 
	{
		jouable.clear();
		achetable.clear();
		nonjouable.clear();
		
		
		for(Carte c : main) 
		{
			boolean constructible = true;
			for(Carte ct : terrain) 
			{
				if(ct.equals(c)) 
				{
					constructible = false;
				}
			}
			if(constructible) 
			{
				List<Carte> coutsCarte = new ArrayList<Carte>(c.getCoutsCarte()); // Permet d'annuler les couts en Ressource
				boolean trouver = false;
				for(Carte cc : coutsCarte) 
				{
					for(Carte ce : terrain) 
					{
						if(ce.equals(cc)) 
						{
							trouver = true;
						}
					}
					if(!trouver) 
					{
						constructible = false;
					}
					trouver = false;
				}
				if(constructible) 
				{
					constructible = true;
					ArrayList<Ressource> coutsRessource = new ArrayList<Ressource>(c.getCoutsRessource()); // La liste des couts à remplir | Le but réussir à la vider ! Le reste permettra de vérifier l'achat.
					int tempOr = or;
					for(Ressource r : new ArrayList<Ressource>(coutsRessource)) 
					{
						if(r.getNom().equals(ressourceType.OR))
						{
							tempOr -= r.getNumber();
							if(tempOr < 0) 
							{
								constructible = false; // Pas assez d'or !
							}
							else 
							{
								coutsRessource.remove(r);
							}
						}
					}
					if(constructible)
					{
						if(!coutsRessource.isEmpty())
						{
							for(Ressource r : new ArrayList<Ressource>(coutsRessource)) 
							{
								if(plateau.getBonusPassif().getNom().equals(r.getNom())) 	// Regarder d'abord si le terrain aide !
								{
									if(r.getNumber()-plateau.getBonusPassif().getNumber() > 0) 
									{
										r.setNumber(r.getNumber()-plateau.getBonusPassif().getNumber());
									}
									else
									{
										coutsRessource.remove(r);
									}
								}
							}
						}
						ArrayList<Carte> choisisable = new ArrayList<Carte>();
						for(Carte ct : terrain) 
						{
							if(ct instanceof Choisisable) 
							{
								if(((Choisisable) ct).possedeChoix()) 
								{
									choisisable.add(ct);
								}
								else
								{
									for(Ressource r : ct.getGainsRessource()) 
									{
										for(Ressource rBesoin : new ArrayList<Ressource>(coutsRessource))
										{
											if(r.getNom().equals(rBesoin.getNom())) 
											{
												if(rBesoin.getNumber()-r.getNumber() > 0)
												{
													rBesoin.setNumber(rBesoin.getNumber()-r.getNumber());
												}
												else
												{
													coutsRessource.remove(rBesoin);
												}
											}
										}
									}
								}
							}
						}
						
						int size = 1;
						
						for(Carte c_choix : choisisable) 
						{
							size*=c_choix.getGainsRessource().size();
						}
						
						ArrayList<ArrayList<Ressource>> posibilites = new ArrayList<ArrayList<Ressource>>(size);
						ArrayList<ArrayList<Ressource>> restes = new ArrayList<ArrayList<Ressource>>(size);
						
						for(int i=0; i<size; ++i)
						{
							posibilites.add(new ArrayList<Ressource>());
						}
						
						int div = size;
						int pas = size;
						for(Carte cc : choisisable) 
						{
							div = div/cc.getGainsRessource().size();
							int nbr = size/cc.getGainsRessource().size();
							int tour = 0;
							for(Ressource r : cc.getGainsRessource()) 
							{
								int creer = 0;
								int index = 0;
								int incremental = div*tour;
								while(creer<nbr) 
								{
									for(index=incremental;index<div+incremental;++index) 
									{
										posibilites.get(index).add(r);
										creer++;
									}
									incremental += pas;
								}
								tour++;
							}
							pas = pas / cc.getGainsRessource().size();
						}
						for(ArrayList<Ressource> lr : posibilites) 
						{
							ArrayList<Ressource> copieCoutsRessource = new ArrayList<Ressource>(coutsRessource);
							for(Ressource r : lr) 
							{
								for(Ressource rBesoin : new ArrayList<Ressource>(copieCoutsRessource)) 
								{
									if(rBesoin.getNom().equals(r.getNom())) 
									{
										if(rBesoin.getNumber()-r.getNumber() > 0)
										{
											rBesoin.setNumber(rBesoin.getNumber()-r.getNumber());
										}
										else
										{
											copieCoutsRessource.remove(rBesoin);
										}
									}
								}
							}
							if(copieCoutsRessource.isEmpty()) 
							{
								coutsRessource.clear();
							}
							else
							{
								restes.add(copieCoutsRessource);
							}
						}
						if(coutsRessource.isEmpty()) 
						{
							jouable.add(c);	// Possède les ressources
							System.out.println("Je possède les ressources pour "+c);
						}
						else
						{
							nonjouable.add(c);	// Pas les ressources
							System.out.println("Je NE possède PAS les ressources pour "+c);
							for(ArrayList<Ressource> lr : restes) 
							{
								// ArrayList<ArrayList<Ressource>> copieRestes = new ArrayList<ArrayList<Ressource>>(restes);
								ArrayList<Ressource> achatsPossibleDroite = new ArrayList<Ressource>();
								ArrayList<Ressource> achatsPossibleGauche = new ArrayList<Ressource>();
								
								ArrayList<Ressource> copieLr = new ArrayList<Ressource>(lr);
								
								for(Ressource rBesoin : lr)
								{
									for(Carte cTerrainDroite : this.getJoueurDroit().getTerrain())
									{
										if(cTerrainDroite instanceof CarteMarron || cTerrainDroite instanceof CarteGrise)
										{
											for(Ressource r : cTerrainDroite.getGainsRessource()) 
											{
												if(r.getNom().equals(rBesoin.getNom())) 
												{
													if(rBesoin.getNumber()-r.getNumber() > 0)
													{
														rBesoin.setNumber(rBesoin.getNumber()-r.getNumber());
													}
													else
													{
														copieLr.remove(rBesoin);
													}
												}
											}
										}
									}
									boolean exist = false;
									for(Ressource r : copieLr)
									{
										if(r.getNom().equals(rBesoin.getNom()))
										{
											exist = true;
											achatsPossibleDroite.add(new Ressource(r.getNom(),rBesoin.getNumber() - r.getNumber()));
										}
									}
									if(!exist)
									{
										achatsPossibleDroite.add(rBesoin);
									}
								}
								
								copieLr = new ArrayList<Ressource>(lr);
								
								for(Ressource rBesoin : lr)
								{
									for(Carte cTerrainGauche : this.getJoueurGauche().getTerrain())
									{
										if(cTerrainGauche instanceof CarteMarron || cTerrainGauche instanceof CarteGrise)
										{
											for(Ressource r : cTerrainGauche.getGainsRessource()) 
											{
												if(r.getNom().equals(rBesoin.getNom())) 
												{
													if(rBesoin.getNumber()-r.getNumber() > 0)
													{
														rBesoin.setNumber(rBesoin.getNumber()-r.getNumber());
													}
													else
													{
														copieLr.remove(rBesoin);
													}
												}
											}
										}
									}
									boolean exist = false;
									for(Ressource r : copieLr)
									{
										if(r.getNom().equals(rBesoin.getNom()))
										{
											exist = true;
											achatsPossibleGauche.add(new Ressource(r.getNom(),rBesoin.getNumber() - r.getNumber()));
										}
									}
									if(!exist)
									{
										achatsPossibleGauche.add(rBesoin);
									}
								}
								//
							}
						}
					}
					else
					{
						System.out.println("Je NE possède PAS assez d'or pour "+c);
						nonjouable.add(c);	// Pas assez d'or
					}
				}
				else
				{
					jouable.add(c);	// Possède les cartes précédentes
					System.out.println("Je possède la carte précédente pour "+c);
				}
			}
			else
			{
				nonjouable.add(c);	// Carte déjà sur le Terrain
				System.out.println("Cette carte est déjà sur le terrain "+c);
			}
		}
	}
	
	public boolean peutJouer(Carte c) 
	{
		for(Carte ca : terrain) 
		{
			if(ca.equals(c)) 
			{
				System.out.println("Vous possÃ©dez dÃ©jÃ  cette carte sur votre terrain !");
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
		for(Ressource r : c.getCoutsRessource())
		{
			if(r.getNom().equals(ressourceType.OR)) 
			{
				or-=r.getNumber();
			}
		}
		terrain.add(c);
		main.remove(c);
	}
	
	public void vend(Carte c)
	{
		or+=2;
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

	public Plateau getPlateau() {
		return plateau;
	}
}
