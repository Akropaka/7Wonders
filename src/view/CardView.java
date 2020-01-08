package view;


import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Bonus;
import model.Choisisable;
import model.Effectable;
import model.EffetType;
import model.JoueurAffecter;
import model.Ressource;
import model.RessourceEnum;
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
	private FlowPane bonus_panel;
	private Label effet;

	private Label nbr;

	private String style = "";
	private String name;
	private int victPOintCount = 0;
	private int rescount = 0;

	private int x=0;
	private int y=0;
	private Carte c;
	
	CardView(Carte c, boolean main, int jouable) {
		this.c = c;
		
		setMaxSize(WIDTH,HEIGHT);
		setTranslateX(x);
		setTranslateY(y);
		setCursor(Cursor.HAND);
		nbr = new Label();
		cout_panel = new FlowPane();
		gain_panel = new FlowPane();
		bonus_panel = new FlowPane();
		effet = new Label("Effet:");
		effet.setFont(Font.font("Arial",FontWeight.BOLD,14));
		effet.setTranslateX(11);
		effet.setTranslateY(98);
		
		cout_panel.setMaxHeight(COUT_SIZE);
		cout_panel.setMaxWidth(WIDTH);
		cout_panel.setTranslateX(10);
		cout_panel.setTranslateY(30);
		
		gain_panel.setMaxHeight(COUT_SIZE);
		gain_panel.setMaxWidth(WIDTH);
		gain_panel.setTranslateX(10);
		gain_panel.setTranslateY(30+COUT_SIZE+5);
		
		bonus_panel.setMaxHeight(COUT_SIZE+5);
		bonus_panel.setMaxWidth(WIDTH);
		bonus_panel.setTranslateX(10);
		bonus_panel.setTranslateY(115);
		
		getChildren().add(effet);
		getChildren().add(cout_panel);
		getChildren().add(gain_panel);
		getChildren().add(bonus_panel);


        addCarte();
		
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
    }
	
	CardView(Carte c) {
		this(c, false, 0);
		y=200;
		setTranslateY(200);
	}
	
	CardView(String color) {
		setCouleur(color);
		setBase();
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
	
	void addCarte() {
		setCouleur(c.getCouleur());
		setBonus();
		setImage("logo");
		setNom();
		setNbrJoueur(c.getAjoutParNbrJoueur());		
		addCoutList(c.getCoutsRessource());
		addGainList(c.getGainsRessource());
		gain_panel.getChildren().add(nbr);
		setBase();
	}
	
	void setBase() {
		ImageView rect = new ImageView(Images.get("carte_base").getImage());
		rect.setFitHeight( HEIGHT);
		rect.setFitWidth(WIDTH);
		getChildren().add(rect);
	}
	void setNbrJoueur(List<Integer> list) {
		if(c instanceof CarteViolette) {
			return;
		}
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
	
	void addBonusList(List<Ressource> lst) {
		for(Ressource r: lst) {
			for(int i=0;i<r.getNumber();i++) {
				addBonus(r.getNom().name());
			}
		}
	}
	
	void addBonus(String nom) {
		ImageView rect = new ImageView(Images.get(nom).getImage());
		rect.setFitHeight(COUT_SIZE);
		rect.setFitWidth(COUT_SIZE);
		bonus_panel.getChildren().add(rect);
	}
	
	void addCout(String nom) {
		ImageView rect = new ImageView(Images.get(nom).getImage());
		rect.setFitHeight(COUT_SIZE);
		rect.setFitWidth(COUT_SIZE);
		cout_panel.getChildren().add(rect);
	}
	
	void setBonus() {
		if(c instanceof CarteJaune) {
			CarteJaune jaune = (CarteJaune) c;
			for(Bonus b: jaune.getBonus()) {
				if(b.getEt() == EffetType.REDUCTIONPRIX){
					addBonusList(b.getRessourceBonus());
				
				}else if(b.getEt() == EffetType.ORPARCARTE){
					for(Class<? extends Carte> ca: b.getCarteAffecter()) {
						addBonus(ca.getSimpleName());
					}
					for(Ressource r: b.getRessourceBonus()) {
						addBonus(r.getNom().name());
					}
					for(JoueurAffecter ja: b.getJoueurAffecter()) {
						addBonus(ja.name());
					}
					//TODO
				}
			}

			
		}else if(c instanceof CarteJaune) {
			CarteViolette violette = (CarteViolette) c;
			for(Bonus b: violette.getBonus()) {
				if(b.getEt() == EffetType.REDUCTIONPRIX){
					addBonusList(b.getRessourceBonus());
				
				}else if(b.getEt() == EffetType.ORPARCARTE){
					for(Class<? extends Carte> ca: b.getCarteAffecter()) {
						addBonus(ca.getSimpleName());
					}
					for(Ressource r: b.getRessourceBonus()) {
						addBonus(r.getNom().name());
					}
					for(JoueurAffecter ja: b.getJoueurAffecter()) {
						addBonus(ja.name());
					}
					//TODO
				}
			}
		}
	}
	
	
	
	void addGain(String nom) {
		ImageView rect = new ImageView(Images.get(nom).getImage());
		rect.setFitHeight(COUT_SIZE);
		rect.setFitWidth(COUT_SIZE);
		
		if(nom == RessourceEnum.POINTVICTOIRE.name() && victPOintCount == 0) {
			victPOintCount++;
		}else if(nom == RessourceEnum.POINTVICTOIRE.name()){
			victPOintCount++;
			nbr.setFont(Font.font("Arial",FontWeight.BOLD,17));
			nbr.setTranslateX(5);
			nbr.setText(victPOintCount + "");
			return;
		}
		
		rescount++;
		
		if(c instanceof Choisisable && rescount > 1) {
			ImageView slash = new ImageView(Images.get("slash").getImage());
			slash.setFitHeight(COUT_SIZE);
			slash.setFitWidth(10);
			gain_panel.getChildren().add(slash);

		}
		
		gain_panel.getChildren().add(rect);
	}
	
	void setCouleur(String s) {
		setStyle("-fx-background-color: "+s+";");
		style = getStyle();
	}
	
	void setNom() {
		name = c.getNom();
		Label label_nom = new Label(name);
		int txtsize = 17;
		if(name.length()>20) txtsize = 15;
		label_nom.setFont(Font.font("Arial",FontWeight.BOLD,txtsize));
		if(c instanceof CarteMarron) {
			label_nom.setTextFill(Color.web("#fff"));
		}
		label_nom.setAlignment(Pos.CENTER);
		label_nom.setTranslateY(10);
		label_nom.layoutXProperty().bind(widthProperty().subtract(label_nom.widthProperty()).divide(2));
		getChildren().add(label_nom);
	}
	
	public String getName(){
		return name;
	}
}
