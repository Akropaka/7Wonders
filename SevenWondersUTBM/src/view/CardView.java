package view;


import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import model.Ressource;
import model.carte.Carte;
import model.carte.CarteBleue;
import model.carte.CarteGrise;
import model.carte.CarteJaune;
import model.carte.CarteMarron;
import model.carte.CarteRouge;
import model.carte.CarteVerte;
import model.carte.CarteViolette;

public class CardView extends Canvas{

	public static final int WIDTH = (int) (335*0.5);
	public static final int HEIGHT = (int) (515*0.5)+30;
	public static final int COUT_SIZE = 25;

	String name;
	int x=0;
	int y=0;
	int cout_nbr=0;
	int gain_nbr=0;
	
	GraphicsContext gc;
	
	CardView(Carte c, int x, int y, boolean main) {
		super(WIDTH, HEIGHT);
		this.x = x;
		this.y = y;
		setTranslateX(x);
		setTranslateY(y);

		gc = getGraphicsContext2D();
		gc.setFont(Font.font("Arial",FontWeight.BOLD, 17));
		gc.setTextAlign(TextAlignment.CENTER);
        gc.drawImage(Images.get("carte_base").getImage(), 0, 0,WIDTH,HEIGHT);
        
        if(main == true) {
            setOnMouseClicked(event -> {((HandView) getParent()).setSelected(this);drawSelected();});
        }
        setOnMouseEntered(event -> {setTranslateY(y-20);});
        setOnMouseExited(event -> {setTranslateY(y);});
        addCarte(c);
    }
	
	CardView(Carte c,boolean main) {
		this(c,0,0,main);
		
    }
	
	void drawSelected() {
		setStyle("-fx-effect: dropshadow( one-pass-box , #2c3e50 , 80 , 0.5 , 0.5 , 0.5 );");
	}
	void drawUnSelected() {
		setStyle("-fx-effect: dropshadow( one-pass-box , black , 0 , 0.0 , 0 , 0 );;");
	}
	void addCarte(Carte carte) {
		setCouleur(carte);
		setImage("prof0");
		setNom(carte.getNom());
		setNbrJoueur(carte.getAjoutParNbrJoueur());
		
		System.out.println(carte.getNom());
		
		addCoutList(carte.getCoutsRessource());
		addGainList(carte.getGainsRessource());
		
		gc.setFont(new Font("Arial", 16));
        gc.setFill(Color.web("#452205"));
        gc.fillText("Coût ", 30, 47);
        gc.fillText("Gain ", 142, 75);
        gc.drawImage(Images.get("carte_base").getImage(), 0, 0,WIDTH,HEIGHT);

	}
	
	void setNbrJoueur(List<Integer> list) {
        gc.setFill(Color.web("#FFF"));
        gc.fillText(String.valueOf(list) + "+", WIDTH/2, HEIGHT -20);
	}
	
	void setImage(String nom) {
        gc.drawImage(Images.get(nom).getImage(), 0, HEIGHT-WIDTH,WIDTH,WIDTH);

	}
	
	void addCoutList(List<Ressource> lst) {
		for(Ressource r: lst) {
			for(int i=0;i<=r.getNumber();i++) {
				addCout(r.getNom().name());
			}
		}
	}
	
	void addGainList(List<Ressource> lst) {
		for(Ressource r: lst) {
			System.out.println(r.getNom().name());
			for(int i=0;i<=r.getNumber();i++) {
				addGain(r.getNom().name());
			}
		}
	}
	
	void addCout(String nom) {
		cout_nbr ++;
	    gc.drawImage(Images.get(nom).getImage(), (WIDTH -10 - (cout_nbr)*(COUT_SIZE)), 4+COUT_SIZE,COUT_SIZE,COUT_SIZE);
	}
	
	void addGain(String nom) {
		gain_nbr ++;
	    gc.drawImage(Images.get(nom).getImage(), (gain_nbr)*(COUT_SIZE)-18 , 57,COUT_SIZE,COUT_SIZE);
	}
	
	void setCouleur(Carte c) {
		Color couleur = null;
		if(c instanceof CarteJaune) {
			couleur = Color.web("#f1c40f");
		}else if(c instanceof CarteBleue) {
			couleur = Color.web("#3498db");
		}else if(c instanceof CarteRouge) {
			couleur = Color.web("#e74c3c");
		}else if(c instanceof CarteGrise) {
			couleur = Color.web("#95a5a6");
		}else if(c instanceof CarteMarron) {
			couleur = Color.web("#6D4C41");
		}else if(c instanceof CarteVerte) {
			couleur = Color.web("#2ecc71");
		}else if(c instanceof CarteViolette) {
			couleur = Color.web("#9b59b6");
		}
		gc.setFill(couleur);
        gc.fillRect(0, 0, getWidth(), getHeight());
	}
	void setNom(String nom) {
		name = nom;
        gc.setFill(Color.web("#452205"));
        gc.fillText(nom, WIDTH/2, 25);
	}
	
	public String getName(){
		return name;
	}
}
