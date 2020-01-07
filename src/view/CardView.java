package view;


import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Ressource;
import model.carte.Carte;
import model.carte.CarteBleue;
import model.carte.CarteGrise;
import model.carte.CarteJaune;
import model.carte.CarteMarron;
import model.carte.CarteRouge;
import model.carte.CarteVerte;
import model.carte.CarteViolette;

public class CardView extends Pane{

	public static final int WIDTH = (int) (360*0.5);
	public static final int HEIGHT = (int) (540*0.5)+30;
	public static final int COUT_SIZE = 24;
	
	private FlowPane cout_panel;
	private FlowPane gain_panel;
	private String style = "";
	private String name;
	private int x=0;
	private int y=0;
	
	CardView(Carte c, boolean main, int jouable) {
		
		setMaxSize(WIDTH,HEIGHT);
		setTranslateX(x);
		setTranslateY(y);
		cout_panel = new FlowPane();
		gain_panel = new FlowPane();
		cout_panel.setMaxHeight(COUT_SIZE);
		gain_panel.setMaxHeight(COUT_SIZE);
		getChildren().add(cout_panel);
		getChildren().add(gain_panel);
        

        addCarte(c);
        
		ImageView rect = new ImageView(Images.get("carte_base").getImage());
		rect.setFitHeight( HEIGHT);
		rect.setFitWidth(WIDTH);
		
        if(main == true) {
            setOnMouseClicked(event -> {((HandView) getParent()).setSelected(this,jouable,c);drawSelected();});
            if(jouable == 0) {
            	drawJouable();
            }else if(jouable ==1){
            	drawNonJouable();
            }else if(jouable == 2){
            	drawAchetable();
            }
        }
        setOnMouseEntered(event -> {setTranslateY(y-20);});
        setOnMouseExited(event -> {setTranslateY(y);});
		getChildren().add(rect);
    }
	
	CardView(Carte c) {
		this(c, false, 0);
		y=200;
		setTranslateY(200);
	}
	

	void drawSelected() {
		setStyle(style + "-fx-effect: dropshadow( one-pass-box , #000 , 80 , 0.5 , 0.5 , 0.5 );");
	}
	
	void drawJouable() {
		style += "-fx-effect: dropshadow( one-pass-box , #2ecc71 , 40 , 0.6 , 0.6 , 0.6 );";
		setStyle(style);
	}
	
	void drawAchetable() {
		style += "-fx-effect: dropshadow( one-pass-box , #f1c40f , 40 , 0.6 , 0.6 , 0.6 );";
		setStyle(style);
	}
	
	void drawNonJouable() {
		style += "-fx-effect: dropshadow( one-pass-box , #e74c3c , 40 , 0.6 , 0.6 , 0.6 );";
		setStyle(style);
	}
	
	void drawUnSelected() {
		setStyle(style);
	}
	
	void addCarte(Carte carte) {
		setCouleur(carte);
		setImage("prof0");
		setNom(carte.getNom());
		setNbrJoueur(carte.getAjoutParNbrJoueur());		
		addCoutList(carte.getCoutsRessource());
		addGainList(carte.getGainsRessource());

	}
	
	void setNbrJoueur(List<Integer> list) {
		Label label_nom = new Label(String.valueOf(list).replace("[", "").replace("]", "") + "+");
		label_nom.setFont(Font.font("Arial",FontWeight.BOLD,17));
		label_nom.setAlignment(Pos.CENTER);
		label_nom.setTextFill(Color.web("#fff"));
		label_nom.setTranslateY(HEIGHT -40);
		label_nom.layoutXProperty().bind(widthProperty().subtract(label_nom.widthProperty()).divide(2));
		getChildren().add(label_nom);
	}
	
	void setImage(String nom) {
		ImageView rect = new ImageView(Images.get(nom).getImage());
		rect.setLayoutY(HEIGHT-WIDTH);
		rect.setFitHeight(WIDTH);
		rect.setFitWidth(WIDTH);
		getChildren().add(rect);
	}
	
	void addCoutList(List<Ressource> lst) {
		for(Ressource r: lst) {
			for(int i=0;i<r.getNumber();i++) {
				addCout(r.getNom().name());
			}
		}
	}
	
	void addGainList(List<Ressource> lst) {
		for(Ressource r: lst) {
			for(int i=0;i<r.getNumber();i++) {
				addGain(r.getNom().name());
			}
		}
	}
	
	void addCout(String nom) {
		ImageView rect = new ImageView(Images.get(nom).getImage());
		rect.setTranslateX(10);
		rect.setTranslateY(30);
		rect.setFitHeight(COUT_SIZE);
		rect.setFitWidth(COUT_SIZE);
		cout_panel.getChildren().add(rect);
	}
	
	void addGain(String nom) {
		ImageView rect = new ImageView(Images.get(nom).getImage());
		rect.setTranslateX(10);
		rect.setTranslateY(60);
		rect.setFitHeight(COUT_SIZE);
		rect.setFitWidth(COUT_SIZE);
		gain_panel.getChildren().add(rect);
	}
	
	void setCouleur(Carte c) {
		String couleur = "#f1c40f";
		if(c instanceof CarteJaune) {
			couleur = "#f1c40f";
		}else if(c instanceof CarteBleue) {
			couleur = "#3498db";
		}else if(c instanceof CarteRouge) {
			couleur = "#e74c3c";
		}else if(c instanceof CarteGrise) {
			couleur = "#95a5a6";
		}else if(c instanceof CarteMarron) {
			couleur = "#6D4C41";
		}else if(c instanceof CarteVerte) {
			couleur = "#2ecc71";
		}else if(c instanceof CarteViolette) {
			couleur = "#9b59b6";
		}
		setStyle("-fx-background-color: "+couleur.toString()+";");
		style = getStyle();
	}
	
	void setNom(String nom) {
		name = nom;
		Label label_nom = new Label(nom);
		label_nom.setFont(Font.font("Arial",FontWeight.BOLD,17));
		label_nom.setAlignment(Pos.CENTER);
		label_nom.setTranslateY(10);
		label_nom.layoutXProperty().bind(widthProperty().subtract(label_nom.widthProperty()).divide(2));
		getChildren().add(label_nom);
	}
	
	public String getName(){
		return name;
	}
}
