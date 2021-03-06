package view;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import model.Joueur;
import model.Ressource;
import model.Triplet;
import model.Tuplet;
import model.carte.Carte;
import model.carte.CarteJaune;


public class HandView extends FlowPane {
	
	public static final int WIDTH = (CardView.WIDTH+10)*7+20;
	public static final int HEIGHT = CardView.HEIGHT + 20;
	
	private String selected;
	private boolean selectedAchetable = false;
	private CardView previous;
	private Window w;
		
	public HandView(Window w) {
		this.w = w;
		setMaxSize(WIDTH,HEIGHT);
		setTranslateY(-150);
		setTranslateX(150);
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-color: #b2bec3;" + "-fx-background-radius: 6;");
	}
	
	public void setCarteListe(Joueur j) {
		getChildren().clear();

		for(Carte c:j.getJouable()) {
			CardView cv = new CardView(c,true,0);
			setMargin(cv,new Insets(0,5,0,5));
			previous = cv;
			getChildren().add(cv);
		}
		
		for(Carte c:j.getNonjouable()) {
			CardView cv = new CardView(c,true,1);
			setMargin(cv,new Insets(0,5,0,5));
			previous = cv;
			getChildren().add(cv);
		}
		
		for(Tuplet<Carte, ArrayList<ArrayList<Triplet<Ressource, Joueur, Integer>>>> ca : j.getAchetable()) 
		{
			CardView cv = new CardView(ca.getFirst(),true,2);
			setMargin(cv,new Insets(0,5,0,5));
			previous = cv;
			getChildren().add(cv);
			w.trade.addTrade(ca.getFirst(),ca.getSecond());
		}
	}
	
	public void setSelected(CardView s,int type, Carte c) {
		selected = s.getName();
		s.drawSelected();
		previous.drawUnSelected();
		previous = s;
		if(type == 2) {
			selectedAchetable = true;
			w.trade.setVisible(true);
			w.trade.drawTrade(c);
		}else {
			selectedAchetable = false;

			w.trade.setVisible(false);
		}
		
	}
	
	public String getSelected() {
		return selected;
	}

	public boolean isSelectedAchetable() {
		return selectedAchetable;
	}
	
}
