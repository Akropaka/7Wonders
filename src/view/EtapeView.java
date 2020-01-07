package view;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import model.Ressource;

public class EtapeView extends Pane {
	
	public static final int WIDTH = 220;
	public static final int HEIGHT = 120;
	private FlowPane cout_panel;
	private FlowPane gain_panel;
	public static final int COUT_SIZE = 24;

	EtapeView(){
		
		setMinSize(WIDTH,HEIGHT);
		setMaxSize(WIDTH,HEIGHT);

		setStyle("-fx-background-color: #ecf0f1;");

		cout_panel = new FlowPane();
		gain_panel = new FlowPane();
		cout_panel.setMaxHeight(COUT_SIZE);
		gain_panel.setMaxHeight(COUT_SIZE);
		getChildren().add(cout_panel);
		getChildren().add(gain_panel);
	}

	void addCoutList(List<Ressource> lst) {
		cout_panel.getChildren().clear();
		for(Ressource r: lst) {
			for(int i=0;i<r.getNumber();i++) {
				addCout(r.getNom().name());
			}
		}
	}
	
	void addGainList(List<Ressource> lst) {
		gain_panel.getChildren().clear();
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
	
	public void setConstruite(boolean etat) {
		if(etat == true) {
			setStyle("-fx-background-color: #1abc9c;");
		}else {
			setStyle("-fx-background-color: #ecf0f1;");
		}
	}
	
	void addGain(String nom) {
		ImageView rect = new ImageView(Images.get(nom).getImage());
		rect.setTranslateX(10);
		rect.setTranslateY(60);
		rect.setFitHeight(COUT_SIZE);
		rect.setFitWidth(COUT_SIZE);
		gain_panel.getChildren().add(rect);
	}
}
