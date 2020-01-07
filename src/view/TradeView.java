package view;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Joueur;
import model.Ressource;
import model.Triplet;
import model.carte.Carte;

public class TradeView extends FlowPane{
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	
	private HashMap<Carte, ArrayList<ArrayList<Triplet<Ressource, Joueur, Integer>>>> trades;
	
	private int selected;
	
	public TradeView() {
		super(Orientation.VERTICAL);
		
		trades = new HashMap<Carte, ArrayList<ArrayList<Triplet<Ressource, Joueur, Integer>>>>();
		
		setMinSize(WIDTH,HEIGHT);
		setMaxSize(WIDTH,HEIGHT);
		setTranslateX(Window.WIDTH/2 - WIDTH/2 - 55 );
		setTranslateY(Window.HEIGHT/2 - HEIGHT/2 - 20 );
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-color: #b2bec3;" + "-fx-background-radius: 6;");
	}
	public void addTrade(Carte c, ArrayList<ArrayList<Triplet<Ressource, Joueur, Integer>>> trades_lst) {
		trades.put(c, trades_lst);
	}
	
	public void drawTrade(Carte c) {
		ArrayList<ArrayList<Triplet<Ressource, Joueur, Integer>>> trades_lst = trades.get(c);
		getChildren().clear();
		
		ToggleGroup group = new ToggleGroup();

			for(ArrayList<Triplet<Ressource, Joueur, Integer>> possibilites : trades_lst) {
				String possibilite_string = "";
				for(Triplet<Ressource, Joueur, Integer> possibilite : possibilites) {
					possibilite_string += possibilite.getFirst().getNumber() + " " + possibilite.getFirst().getNom() + " de " + possibilite.getSecond().getNom() + " pour " + possibilite.getThird()+ " OR " + "\n";
				}
			    RadioButton button1 = new RadioButton(possibilite_string);
			    button1.setToggleGroup(group);
			    button1.setFont(Font.font("Arial",FontWeight.BOLD,15));

			    button1.setSelected(true);
				getChildren().add(button1);

			
		}
	}

	
	
}
