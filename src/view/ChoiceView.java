package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class ChoiceView extends FlowPane {
	Window w;
	
	ChoiceView(Window w){
		Button poser = new CustomButton("Poser");
		Button constuire_etape = new CustomButton("Constuire etape");
		Button vendre = new CustomButton("Vendre");
		this.w = w;
		getChildren().add(poser);
		getChildren().add(constuire_etape);
		getChildren().add(vendre);
		setMaxSize(500,100);
		setAlignment(Pos.CENTER);
		
		poser.setOnMouseClicked(event -> {
			if(w.hand.getSelected() != null) {
				if (w.hand.isSelectedAchetable()) {
					 w.manager.acheter(w.hand.getSelected(),w.trade.getSelected());
				}else {
					 w.manager.jouer(w.hand.getSelected());
				}
			}	
			;});
		constuire_etape.setOnMouseClicked(event -> {
			w.manager.construireEtape(w.hand.getSelected());
			;});
		vendre.setOnMouseClicked(event -> {
			if(w.hand.getSelected() != null) {
				 w.manager.vendre(w.hand.getSelected());
			}
			;});

		setTranslateY(50);
		
	}

}

class CustomButton extends Button{
	
	CustomButton(String name){
		super(name);
		setMinSize(100,35);
		setFont(new Font("Arial", 16));
	}
	
}