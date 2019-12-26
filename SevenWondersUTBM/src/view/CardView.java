package view;


import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.carte.Carte;

public class CardView extends Canvas{

	public static final int WIDTH = (int) (335*0.6);
	public static final int HEIGHT = (int) (515*0.6);
	
	public static final int COUT_SIZE = 30;

	
	int x=0;
	int y=0;
	int cout_nbr=0;
	int gain_nbr=0;
	
	GraphicsContext gc;
	
	CardView(Carte c, int x, int y) {
		super(WIDTH, HEIGHT);
		this.x = x;
		this.y = y;
		setTranslateX(x);
		setTranslateY(y);

		gc = getGraphicsContext2D();
		gc.setFont(new Font("Arial", 20));
		gc.setTextAlign(TextAlignment.CENTER);
        gc.drawImage(Images.get("carte_base").getImage(), 0, 0,WIDTH,HEIGHT);
        setOnMouseEntered(event -> {
            setTranslateY(y-20);
        });
        setOnMouseExited(event -> {
            setTranslateY(y);
        });
        addCarte(c);
    }
	
	CardView(Carte c) {
		super(WIDTH, HEIGHT);

		setTranslateX(x);
		setTranslateY(y);

		gc = getGraphicsContext2D();
		gc.setFont(new Font("Arial", 20));
		gc.setTextAlign(TextAlignment.CENTER);
        gc.drawImage(Images.get("carte_base").getImage(), 0, 0,WIDTH,HEIGHT);
        setOnMouseEntered(event -> {
            setTranslateY(y-20);
        });
        setOnMouseExited(event -> {
            setTranslateY(y);
        });
        addCarte(c);
    }
	void addCarte(Carte carte) {

		setCouleur("#4fa5b9");
		setImage("prof0");
		setNom(carte.getNom());
		setNbrJoueur(carte.getAjoutParNbrJoueur());
		addCout("maths");
		addCout("informatique");
		addCout("physique");
		addCout("physique");
		addGain("informatique");
		addGain("physique");
		addGain("physique");
	}
	
	void setNbrJoueur(List<Integer> list) {
        gc.setFill(Color.web("#FFF"));
        gc.fillText(String.valueOf(list) + "+", WIDTH/2, HEIGHT -20);
	}
	
	void setImage(String nom) {
        gc.drawImage(Images.get(nom).getImage(), 0, HEIGHT-WIDTH,WIDTH,WIDTH);

	}
	void addCout(String nom) {
		cout_nbr ++;
	    gc.drawImage(Images.get(nom).getImage(), (WIDTH -20 - (cout_nbr)*(COUT_SIZE)), 27+COUT_SIZE,COUT_SIZE,COUT_SIZE);
	}
	
	void addGain(String nom) {
		gain_nbr ++;
	    gc.drawImage(Images.get(nom).getImage(), (gain_nbr)*(COUT_SIZE)-15 , 120,COUT_SIZE,COUT_SIZE);
	}
	
	void setCouleur(String couleur) {
		gc.setFill(Color.web(couleur));
        gc.fillRect(0, 0, getWidth(), getHeight());
	}
	void setNom(String nom) {
        gc.setFill(Color.web("#452205"));
        gc.fillText(nom, WIDTH/2, 40);
	}
	
}
