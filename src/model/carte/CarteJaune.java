package model.carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Bonus;
import model.Choisisable;
import model.Effectable;
import model.EffetType;
import model.Etape;
import model.Joueur;
import model.JoueurAffecter;
import model.Ressource;
import model.RessourceEnum;

public class CarteJaune extends Carte implements Effectable,Choisisable {

	private List<Bonus> bonus;
	private boolean possedeChoix = false;
	public static String COULEUR = "#f1c40f";
	
	public CarteJaune(String nom, int age, ArrayList<Ressource> coutsRessource, ArrayList<Ressource> gainsRessource,
			ArrayList<Carte> coutsCarte, List<Integer> ajoutParNbrJoueur, boolean possedeChoix) 
	{
		super(nom, age, coutsRessource, gainsRessource, coutsCarte, ajoutParNbrJoueur);
		setCouleur(COULEUR);
		this.possedeChoix = possedeChoix;
		bonus = new ArrayList<Bonus>();
	}

	public void addBonus(Bonus b)
	{
		this.bonus.add(new Bonus(b));
	}
	
	@Override
	public void faitEffet(Joueur j) {
		for(Bonus b : bonus)
		{
			EffetType et = b.getEt();
			switch(et)
			{
				case REDUCTIONPRIX:
					System.out.println("REDUC");
					for(JoueurAffecter ja : b.getJoueurAffecter())
					{
						if(ja.equals(JoueurAffecter.DROITE))
						{
							j.getPrixRessourceDroite().forEach((key,value) -> 
							{
								for(Ressource r : b.getRessourceBonus())
								{
									if(((RessourceEnum)key).equals(r.getNom())) 
									{
										value=1;
									}
								}
							});
						}
						if(ja.equals(JoueurAffecter.GAUCHE))
						{
							j.getPrixRessourceDroite().forEach((key,value) -> 
							{
								for(Ressource r : b.getRessourceBonus())
								{
									if(((RessourceEnum)key).equals(r.getNom())) 
									{
										value=1;
									}
								}
							});
						}
					}
					break;
				
				case DONNEOR:
					System.out.println("DONNEOR");
					for(Ressource r : b.getRessourceBonus())
					{
						j.donneOr(r.getNumber());
					}
					break;
				
				case ORPARCARTE:
					for(JoueurAffecter ja : b.getJoueurAffecter())
					{
						if(ja.equals(JoueurAffecter.MOI))
						{
							for(Carte c : j.getTerrain())
							{
								if(b.getCarteAffecter().contains(c.getClass()))
								{
									for(Ressource r : b.getRessourceBonus())
									{
										j.donneOr(r.getNumber());
									}
								}
							}
						}
						if(ja.equals(JoueurAffecter.DROITE))
						{
							for(Carte c : j.getJoueurDroit().getTerrain())
							{
								if(b.getCarteAffecter().contains(c.getClass()))
								{
									for(Ressource r : b.getRessourceBonus())
									{
										j.donneOr(r.getNumber());
									}
								}
							}
						}
						if(ja.equals(JoueurAffecter.GAUCHE))
						{
							for(Carte c : j.getJoueurGauche().getTerrain())
							{
								if(b.getCarteAffecter().contains(c.getClass()))
								{
									for(Ressource r : b.getRessourceBonus())
									{
										j.donneOr(r.getNumber());
									}
								}
							}
						}
					}
					break;
				case ORPARETAPE:
					for(JoueurAffecter ja : b.getJoueurAffecter())
					{
						if(ja.equals(JoueurAffecter.MOI))
						{
							for(Etape e : j.getPlateau().getEtapes())
							{
								if(e.isConstruite())
								{
									for(Ressource r : b.getRessourceBonus())
									j.donneOr(r.getNumber());
								}
							}
						}
						if(ja.equals(JoueurAffecter.DROITE))
						{
							for(Etape e : j.getJoueurDroit().getPlateau().getEtapes())
							{
								if(e.isConstruite())
								{
									for(Ressource r : b.getRessourceBonus())
									j.donneOr(r.getNumber());
								}
							}
						}
						if(ja.equals(JoueurAffecter.GAUCHE))
						{
							for(Etape e : j.getJoueurGauche().getPlateau().getEtapes())
							{
								if(e.isConstruite())
								{
									for(Ressource r : b.getRessourceBonus())
									j.donneOr(r.getNumber());
								}
							}
						}
					}
					break;
				default : 
			}
		}
	}
	
	public void faitEffetFin(Joueur j) 
	{
		for(Bonus b : bonus)
		{
			EffetType et = b.getEt();
			switch(et)
			{
				case POINTSPARCARTE:
					for(JoueurAffecter ja : b.getJoueurAffecter())
					{
						if(ja.equals(JoueurAffecter.MOI))
						{
							for(Carte c : j.getTerrain())
							{
								if(b.getCarteAffecter().contains(c.getClass()))
								{
									for(Ressource r : b.getRessourceBonus())
									{
										j.pointsVictoire+=r.getNumber();
									}
								}
							}
						}
						if(ja.equals(JoueurAffecter.DROITE))
						{
							for(Carte c : j.getJoueurDroit().getTerrain())
							{
								if(b.getCarteAffecter().contains(c.getClass()))
								{
									for(Ressource r : b.getRessourceBonus())
									{
										j.pointsVictoire+=r.getNumber();
									}
								}
							}
						}
						if(ja.equals(JoueurAffecter.GAUCHE))
						{
							for(Carte c : j.getJoueurGauche().getTerrain())
							{
								if(b.getCarteAffecter().contains(c.getClass()))
								{
									for(Ressource r : b.getRessourceBonus())
									{
										j.pointsVictoire+=r.getNumber();
									}
								}
							}
						}
					}
					break;
				case POINTSPARETAPE:
					for(JoueurAffecter ja : b.getJoueurAffecter())
					{
						if(ja.equals(JoueurAffecter.MOI))
						{
							for(Etape e : j.getPlateau().getEtapes())
							{
								if(e.isConstruite())
								{
									for(Ressource r : b.getRessourceBonus())
									j.pointsVictoire+=r.getNumber();
								}
							}
						}
						if(ja.equals(JoueurAffecter.DROITE))
						{
							for(Etape e : j.getJoueurDroit().getPlateau().getEtapes())
							{
								if(e.isConstruite())
								{
									for(Ressource r : b.getRessourceBonus())
									j.pointsVictoire+=r.getNumber();
								}
							}
						}
						if(ja.equals(JoueurAffecter.GAUCHE))
						{
							for(Etape e : j.getJoueurGauche().getPlateau().getEtapes())
							{
								if(e.isConstruite())
								{
									for(Ressource r : b.getRessourceBonus())
									j.pointsVictoire+=r.getNumber();
								}
							}
						}
					}
					break;
					
				default:
			}
		}
	}
	
	public Object clone()throws CloneNotSupportedException
	{  
		return super.clone();
	}

	@Override
	public boolean possedeChoix() 
	{
		return possedeChoix;
	}

	public List<Bonus> getBonus() {
		return bonus;
	}
}
