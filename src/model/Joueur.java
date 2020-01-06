package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
	
	private Map<RessourceEnum,Integer> prixRessource;
	
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
	private ArrayList<Tuplet<Carte,ArrayList<ArrayList<Triplet<Ressource,Joueur,Integer>>>>> achetable;
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
		achetable = new ArrayList<Tuplet<Carte,ArrayList<ArrayList<Triplet<Ressource,Joueur,Integer>>>>>();
		nonjouable = new ArrayList<Carte>();
		this.nom = nom;
		
		prixRessource = new HashMap<RessourceEnum,Integer>();
		
		prixRessource.put(RessourceEnum.ARGILE,2);
		prixRessource.put(RessourceEnum.BOIS,2);
		prixRessource.put(RessourceEnum.FER,2);
		prixRessource.put(RessourceEnum.PIERRE,2);
		prixRessource.put(RessourceEnum.PARCHEMIN,2);
		prixRessource.put(RessourceEnum.VERRE,2);
		prixRessource.put(RessourceEnum.TISSU,2);
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
					ArrayList<Ressource> coutsRessource = new ArrayList<Ressource>(c.getCoutsRessource()); // La liste des couts ï¿½ remplir | Le but rï¿½ussir ï¿½ la vider ! Le reste permettra de vï¿½rifier l'achat.
					int tempOr = or;
					for(Ressource r : new ArrayList<Ressource>(coutsRessource)) 
					{
						if(r.getNom().equals(RessourceEnum.OR))
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
							jouable.add(c);	// Possï¿½de les ressources
							System.out.println("Je possï¿½de les ressources pour "+c);
						}
						else
						{
							for(ArrayList<Ressource> lr : restes) 
							{
								ArrayList<Ressource> achatsPossibleDroite = new ArrayList<Ressource>();
								ArrayList<Ressource> achatsPossibleGauche = new ArrayList<Ressource>();
								
								ArrayList<Ressource> copieLr = new ArrayList<Ressource>(lr);
								
								for(Ressource rBesoin : lr)
								{
									if(this.getJoueurDroit().getTerrain().isEmpty())
									{
										copieLr.clear();
									}
									for(Carte cTerrainDroite : this.getJoueurDroit().getTerrain())
									{
										if(!cTerrainDroite.getGainsRessource().contains(rBesoin))
										{
											copieLr.remove(rBesoin);
										}
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
														achatsPossibleDroite.add(rBesoin);
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
								}
								
								copieLr = new ArrayList<Ressource>(lr);
								
								for(Ressource rBesoin : lr)
								{
									int nombre = rBesoin.getNumber();
									if(this.getJoueurDroit().getTerrain().isEmpty())
									{
										copieLr.clear();
									}
									for(Carte cTerrainGauche : this.getJoueurGauche().getTerrain())
									{
										if(cTerrainGauche instanceof CarteMarron || cTerrainGauche instanceof CarteGrise)
										{
											if(!cTerrainGauche.getGainsRessource().contains(rBesoin))
											{
												copieLr.remove(rBesoin);
											}
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
														achatsPossibleGauche.add(rBesoin);
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
									
								}
								
								ArrayList<Triplet<Ressource,Joueur,Integer>> toutCombinaison = new ArrayList<Triplet<Ressource,Joueur,Integer>>();
								
								for(Ressource r : achatsPossibleDroite)
								{
									toutCombinaison.add(new Triplet<Ressource,Joueur,Integer>(r,this.getJoueurDroit(),prixRessource.get(r.getNom())*r.getNumber()));
									System.out.println(toutCombinaison.size());
								}
								for(Ressource r : achatsPossibleGauche)
								{
									toutCombinaison.add(new Triplet<Ressource,Joueur,Integer>(r,this.getJoueurGauche(),prixRessource.get(r.getNom())*r.getNumber()));
									System.out.println(toutCombinaison.size());
								}
								ArrayList<ArrayList<Triplet<Ressource,Joueur,Integer>>> choixAchat = new ArrayList<ArrayList<Triplet<Ressource,Joueur,Integer>>>();
								
								for(int i=toutCombinaison.size();i>0;--i)
								{
									for(int j=0;j<(factorielle(toutCombinaison.size()))/((factorielle(toutCombinaison.size()-i+1)*factorielle(toutCombinaison.size() - (toutCombinaison.size()-i+1))));++j) 
									{
										ArrayList<Triplet<Ressource,Joueur,Integer>> temp = new ArrayList<Triplet<Ressource,Joueur,Integer>>();
										choixAchat.add(new ArrayList<Triplet<Ressource,Joueur,Integer>>(temp));
									}
									
									for(int r=0;r<choixAchat.size();++r)
									{
										boolean continuer = true;
										if(choixAchat.get(r).isEmpty())
										{
											for(Triplet<Ressource,Joueur,Integer> tripletCombi : toutCombinaison)
											{
												if(peutAjouterUnTriplet(choixAchat.get(r),tripletCombi,choixAchat))
												{
													choixAchat.get(r).add(tripletCombi);
													continuer = false;
												}
											}
										}
										else	// Ne va jamais ICI !
										{
											for(int e=0;e<choixAchat.get(r).size();++e)
											{
												for(Triplet<Ressource,Joueur,Integer> tripletCombi : toutCombinaison)
												{
													if(!(tripletCombi.getFirst().getNom().equals(choixAchat.get(r).get(e).getFirst().getNom()) && tripletCombi.getSecond().getNom().equals(choixAchat.get(r).get(e).getSecond().getNom())) && continuer)
													{
														if(peutAjouterUnTriplet(choixAchat.get(r),tripletCombi,choixAchat))
														{
															choixAchat.get(r).add(tripletCombi);
															continuer = false;
															System.out.println("AJOUT");
														}
													}
												}
											}
										}
									}
								}
								for(ArrayList<Triplet<Ressource,Joueur,Integer>> arrayTriplet : new ArrayList<ArrayList<Triplet<Ressource,Joueur,Integer>>>(choixAchat))
								{
									int coutOr = 0;
									boolean impossible = false;
									for(Triplet<Ressource,Joueur,Integer> triplet : arrayTriplet)
									{
										for(Triplet<Ressource,Joueur,Integer> tripletTest : arrayTriplet)
										{
											if(!(triplet.equals(tripletTest)) && triplet.getFirst().getNom().equals(tripletTest.getFirst().getNom()))
											{
												impossible = true;	// impossibilité par l'excès.
											}
										}
										coutOr+=triplet.getThird();
										if(coutOr>or)
										{
											impossible = true; 	// impossibilité par l'or.
										}
									}
									if(impossible)
									{
										choixAchat.remove(arrayTriplet);
									}
								}
								if(!choixAchat.isEmpty())
								{
									achetable.add(new Tuplet<Carte,ArrayList<ArrayList<Triplet<Ressource,Joueur,Integer>>>>(c,choixAchat));
									System.out.println("Je PEUX ACHETER "+c);
								}
								else
								{
									nonjouable.add(c);	// Pas les ressources
									System.out.println("Je NE possï¿½de PAS les ressources pour "+c);
								}
							}
						}
					}
					else
					{
						System.out.println("Je NE possï¿½de PAS assez d'or pour "+c);
						nonjouable.add(c);	// Pas assez d'or
					}
				}
				else
				{
					jouable.add(c);	// Possï¿½de les cartes prï¿½cï¿½dentes
					System.out.println("Je possï¿½de la carte prï¿½cï¿½dente pour "+c);
				}
			}
			else
			{
				nonjouable.add(c);	// Carte dï¿½jï¿½ sur le Terrain
				System.out.println("Cette carte est dï¿½jï¿½ sur le terrain "+c);
			}
		}
	}
	
	private boolean peutAjouterUnTriplet(ArrayList<Triplet<Ressource,Joueur,Integer>> to, Triplet<Ressource,Joueur,Integer> triplet, ArrayList<ArrayList<Triplet<Ressource,Joueur,Integer>>> reference)
	{
		ArrayList<Triplet<Ressource,Joueur,Integer>> arrayListTriplet = new ArrayList<Triplet<Ressource,Joueur,Integer>>(to);
		arrayListTriplet.add(triplet);
		
		for(ArrayList<Triplet<Ressource,Joueur,Integer>> alt : reference)
		{
			int compteur = 0;
			for(Triplet<Ressource,Joueur,Integer> tripl : alt)
			{
				for(Triplet<Ressource,Joueur,Integer> tripl2 : arrayListTriplet)
				{
					if(tripl.getFirst().getNom().equals(tripl2.getFirst().getNom()) && tripl.getSecond().getNom().equals(tripl2.getSecond().getNom())) 
					{
						compteur++;
					}
				}
			}
			if(compteur == arrayListTriplet.size())
			{
				return false;
			}
		}
		return true;
		/*
		if(!(Arrays.asList(reference).contains(arrayListTriplet)))
		{
			return true;
		}
		else
		{
			return false;
		}
		*/
	}
	
	private int factorielle(int n)
	{
		return  n <= 1 ? 1 : n * factorielle(n - 1);
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
			if(r.getNom().equals(RessourceEnum.OR)) 
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
		
		for(Tuplet<Carte, ArrayList<ArrayList<Triplet<Ressource, Joueur, Integer>>>> ca : achetable) 
		{
			if(ca.getFirst().getNom().equals(c.getNom())) 
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
