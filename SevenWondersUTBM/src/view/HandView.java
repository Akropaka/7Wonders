package view;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import model.carte.Carte;
import model.carte.CarteJaune;


public class HandView extends FlowPane {
	
	public static final int WIDTH = (CardView.WIDTH+10)*7+20;
	public static final int HEIGHT = CardView.HEIGHT + 20;
	String selected;
	CardView previous;
	
	public HandView() {

		setMaxSize(WIDTH,HEIGHT);
		setTranslateY(-150);
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-color: #b2bec3;" + "-fx-background-radius: 6;");
	}
	
	public void setCarteListe(List<Carte> list) {
		getChildren().clear();
		for(Carte c:list) {
			CardView cv = new CardView(c,true);
			setMargin(cv,new Insets(0,5,0,5));
			previous = cv;
			getChildren().add(cv);
		}
		setWidth((CardView.WIDTH+10)*list.size()+20);

	}
	
	public void setSelected(CardView s) {
		selected = s.getName();
		s.drawSelected();
		previous.drawUnSelected();
		previous = s;
	}
	
	public String getSelected() {
		return selected;
	}
	
}
