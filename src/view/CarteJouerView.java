package view;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import model.carte.Carte;


public class CarteJouerView extends FlowPane {
	
	public static final int WIDTH = CardView.WIDTH + 20;
	public static final int HEIGHT = Window.HEIGHT;
	
	ArrayList<CardView> lstCarte;
	
	public CarteJouerView() {
		super(Orientation.VERTICAL);
		setPadding(new Insets(150,0,0,0));
		setMaxSize(WIDTH,HEIGHT);
		setTranslateX(-Window.WIDTH/2+WIDTH/2);
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-color: #34495e;");
	}
	
	public void setCarteListe(List<Carte> list) {
		getChildren().clear();
		for(Carte c:list) {
			CardView cv = new CardView(c);
			setMargin(cv,new Insets(-200,0,0,0));
			getChildren().add(cv);
		}
		setWidth((CardView.WIDTH+10)*list.size()+20);

	}

}
