package view;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class MainMenu extends Pane {

	
	List<String> joueurs = new ArrayList<String>();
	Window w;
	
	MainMenu(Window w) {
		this.w = w;
		FlowPane boutonlst = new FlowPane();
		Button ajouter = new CustomButton("Ajouter un joueur");
		Button retirer = new CustomButton("Retirer un joueur");
		Button jouer = new CustomButton("Jouer");

		boutonlst.setTranslateX(Window.WIDTH / 2 - 200);
		boutonlst.setTranslateY(Window.HEIGHT / 2 + 200);
		boutonlst.getChildren().add(ajouter);
		boutonlst.getChildren().add(retirer);
		boutonlst.getChildren().add(jouer);

		TextInputDialog td = new TextInputDialog();
		td.setHeaderText("Entrez vorte nom :");

		getChildren().add(boutonlst);

		FlowPane nom_joueurs = new FlowPane(Orientation.VERTICAL);
		nom_joueurs.setStyle("-fx-background-color: #b2bec3;" + "-fx-background-radius: 6;");
		nom_joueurs.setTranslateY(0);
		nom_joueurs.setMinSize(400, 500);
		nom_joueurs.setTranslateX(Window.WIDTH / 2 - 210);
		nom_joueurs.setTranslateY(Window.HEIGHT / 2 - 360);
		nom_joueurs.setAlignment(Pos.CENTER);

		ajouter.setOnAction(e -> {
			td.showAndWait();
			String name = td.getEditor().getText();
			if(!joueurs.contains(name)) {
				Label l = new Label(name);
				nom_joueurs.getChildren().add(l);
				joueurs.add(l.getText());
			}else {
				errorExist();
			}
			
		});
		
		retirer.setOnAction(e -> {
			td.showAndWait();
			String name = td.getEditor().getText();
			joueurs.remove(name);
			retirerJoueur(nom_joueurs,name);
		});
		
		jouer.setOnAction(e -> {
			for(String s:joueurs) {
				w.manager.ajoutJoueur(s);
			}
			w.lancerJeu();
		});
		getChildren().add(nom_joueurs);

		//TODO DEBUG ONLY
		w.manager.ajoutJoueur("Thomas");
		w.manager.ajoutJoueur("Louis");
		w.manager.ajoutJoueur("Ryan");

		w.lancerJeu();
	}

	void errorExist() {
		Alert alert = new Alert(AlertType.ERROR, "Ce nom existe déjà !", ButtonType.OK);
		alert.show();
	}
	
	void retirerJoueur(FlowPane fp,String s) {
		Node noderetirer = null;
		
		for(Node n: fp.getChildren()) {
			if (((Label) n).getText().equals(s)) {
				noderetirer = n;
			}
		}
		fp.getChildren().remove(noderetirer);
		
	}
}
