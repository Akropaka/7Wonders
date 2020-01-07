package view;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Plateau;


public class BoardView extends Pane{

	public static final int WIDTH = 750;
	public static final int HEIGHT = 330;
	
	private EtapeView etape1;
	private EtapeView etape2;
	private EtapeView etape3;
	private ImageView bonus;
	
	Label label_nom;
	
	BoardView() {
		label_nom = new Label();
		etape1 = new EtapeView();
		etape2 = new EtapeView();
		etape3 = new EtapeView();
		bonus = new ImageView();
				
		etape1.setTranslateY(HEIGHT - EtapeView.HEIGHT);
		etape2.setTranslateY(HEIGHT - EtapeView.HEIGHT);
		etape3.setTranslateY(HEIGHT - EtapeView.HEIGHT);

		etape1.setTranslateX(22);
		etape2.setTranslateX(EtapeView.WIDTH + 2*22);
		etape3.setTranslateX(2*EtapeView.WIDTH + 3*22);

		bonus.setTranslateX(WIDTH-60);
		bonus.setTranslateY(10);

		setMaxSize(WIDTH, HEIGHT);
		setStyle("-fx-background-color: #95a5a6;");
		setTranslateX(0);
		setTranslateY(Window.HEIGHT/2 - HEIGHT/2);

		getChildren().add(label_nom);
		getChildren().add(bonus);
		getChildren().add(etape2);
		getChildren().add(etape1);
		getChildren().add(etape3);

    }
	
	public void setBoard(Plateau p) {
		setNom(p.toString());
		etape1.addCoutList(p.getEtapes().get(0).getCoutsRessource());
		etape1.addGainList(p.getEtapes().get(0).getGainsRessource());

		etape2.addCoutList(p.getEtapes().get(1).getCoutsRessource());
		etape2.addGainList(p.getEtapes().get(1).getGainsRessource());

		etape3.addCoutList(p.getEtapes().get(2).getCoutsRessource());
		etape3.addGainList(p.getEtapes().get(2).getGainsRessource());
		
		etape1.setConstruite(p.getEtapes().get(0).isConstruite());
		etape2.setConstruite(p.getEtapes().get(1).isConstruite());
		etape3.setConstruite(p.getEtapes().get(2).isConstruite());

		bonus.setImage(Images.get(p.getBonusPassif().getNom().name()).getImage());
		bonus.setFitHeight( 50);
		bonus.setFitWidth(50);
	}
	
	public void setNom(String s)
	{
		label_nom.setText(s);
		label_nom.setFont(Font.font("Arial",FontWeight.BOLD,17));
		label_nom.setTextFill(Color.web("#fff"));
		label_nom.setTranslateX(10);
		label_nom.setTranslateY(10);
	}
	
	
}
