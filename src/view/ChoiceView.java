package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ChoiceView extends FlowPane {
	
	private Window w;
	ChoiceView(Window w){
		Button poser = new CustomButton("Poser");
		Button constuire_etape = new CustomButton("Constuire etape");
		Button vendre = new CustomButton("Vendre");
		this.w = w;
		setTranslateX(100);
		getChildren().add(poser);
		getChildren().add(constuire_etape);
		getChildren().add(vendre);
		setMaxSize(500,100);
		setAlignment(Pos.CENTER);
		setMargin(constuire_etape,new Insets(0,7,0,7));

		poser.setOnMouseClicked(event -> {
			if(w.hand.getSelected() != null) {
				if (w.hand.isSelectedAchetable()) {
					 w.manager.acheter(w.hand.getSelected(),w.trade.getSelected());
				}else {
					 w.manager.jouer(w.hand.getSelected());
				}
			}else {
				showError();
			}
			;});
		constuire_etape.setOnMouseClicked(event -> {
			if(w.hand.getSelected() != null) {
				w.manager.construireEtape(w.hand.getSelected());
			}else {
				showError();
			}
			;});
		vendre.setOnMouseClicked(event -> {
			if(w.hand.getSelected() != null) {
				 w.manager.vendre(w.hand.getSelected());
			}else {
				showError();

			}
			;});

		setTranslateY(50);
		
	}
	
	public void showError() {
		w.setInfo("Vous devez selectionner une carte !");
	}
}


class CustomButton extends Button{
	
	CustomButton(String name){
		super(name);
		setMinSize(100,40);
		setStyle("-fx-background-color: #bdc3c7; ");
		setFont(Font.font("Arial", FontWeight.BOLD ,16));
		setCursor(Cursor.HAND);
		setOnMouseEntered(e -> setStyle("-fx-background-color: #95a5a6; "));
		setOnMouseExited(e -> setStyle("-fx-background-color: #bdc3c7; "));

	}
	
}