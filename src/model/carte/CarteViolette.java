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

public class CarteViolette extends Carte implements Effectable,Choisisable {

	private List<Bonus> bonus;
	boolean possedeChoix = false;
	public static String COULEUR = "#9b59b6";

	public CarteViolette(String nom, int age, ArrayList<Ressource> coutsRessource, ArrayList<Ressource> gainsRessource,
			ArrayList<Carte> coutsCarte, List<Integer> ajoutParNbrJoueur, boolean possedeChoix)
	{
		super(nom, age, coutsRessource, gainsRessource, coutsCarte, ajoutParNbrJoueur);
		this.possedeChoix = possedeChoix;
		bonus = new ArrayList<Bonus>();
		setCouleur(COULEUR);
	}
	
	public void addBonus(Bonus b)
	{
		this.bonus.add(new Bonus(b));
	}
	
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
				
				case SCIENCE:
					int engrenage = 0;
					int compas = 0;
					int tablette = 0;
					for(Carte c : j.getTerrain())
					{
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
							}
						}
					}
					int premierTotal = engrenage*engrenage + compas*compas + tablette*tablette;
					if(engrenage>0 && compas>0 && tablette>0)
					{
						premierTotal += 7;
					}
					
					int total = 0;
					
					engrenage++;
					int totalEngrenage = engrenage*engrenage + compas*compas + tablette*tablette;
					if(engrenage>0 && compas>0 && tablette>0)
					{
						totalEngrenage += 7;
					}
					
					total = Math.max(total,totalEngrenage);
					
					engrenage--;
					compas++;
					
					int totalCompas = engrenage*engrenage + compas*compas + tablette*tablette;
					if(engrenage>0 && compas>0 && tablette>0)
					{
						totalCompas += 7;
					}
					
					total = Math.max(total,totalCompas);
					
					compas--;
					tablette++;
					
					int totalTablette = engrenage*engrenage + compas*compas + tablette*tablette;
					if(engrenage>0 && compas>0 && tablette>0)
					{
						totalTablette += 7;
					}
					
					total = Math.max(total,totalTablette);
					tablette--;
					
					j.pointsVictoire+=(total-premierTotal);
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
					
				case POINTSPARJETONDEFAITE:
					for(JoueurAffecter ja : b.getJoueurAffecter())
					{
						if(ja.equals(JoueurAffecter.MOI))
						{
							for(Ressource r : b.getRessourceBonus())
							{
								j.pointsVictoire+=r.getNumber()*j.jetonDefaite;
							}
						}
						if(ja.equals(JoueurAffecter.DROITE))
						{
							for(Ressource r : b.getRessourceBonus())
							{
								j.pointsVictoire+=r.getNumber()*j.getJoueurDroit().jetonDefaite;
							}
						}
						if(ja.equals(JoueurAffecter.GAUCHE))
						{
							for(Ressource r : b.getRessourceBonus())
							{
								j.pointsVictoire+=r.getNumber()*j.getJoueurGauche().jetonDefaite;
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
