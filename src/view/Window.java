package view;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Joueur;
import model.ManageurDeTour;

public class Window extends Application {

	public static final int WIDTH = 1800;
	public static final int HEIGHT = 890;
	
	public ManageurDeTour manager;
	public BoardView board;
	public HandView hand ;
	public CarteJouerView terrain;
	public ChoiceView choice;
	private MainMenu menu;
	private Label nomJoueur;
	private Label nomJoueurTerrain;

	private Label info;
	private ImageView next;
	private Joueur voir;
	
	StackPane root;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Images.buildImageList();
		manager = new ManageurDeTour(this);
		root = new StackPane();
		menu = new MainMenu(this);
		primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
		primaryStage.show();
		primaryStage.setTitle("7 Wonders - UTBM");
		primaryStage.setResizable(false);
		
		//TODO DEBUG ONLY
        //root.getChildren().add(menu);

	}
	
	public void lancerJeu() {
		root.getChildren().remove(menu);
		
		board = new BoardView();
		hand = new HandView();
		terrain = new CarteJouerView();
		choice = new ChoiceView(this);
		
		nomJoueur = new Label();
		nomJoueur.setFont(new Font("Arial", 25));
		nomJoueur.setTranslateY(-360);
		
		nomJoueurTerrain = new Label();
		nomJoueurTerrain.setFont(new Font("Arial", 25));
		nomJoueurTerrain.setTranslateY(-HEIGHT/2+20);
		nomJoueurTerrain.setTranslateX(-WIDTH/2+90);
		nomJoueurTerrain.setTextFill(Color.web("#fff"));

		info = new Label();
		info.setFont(new Font("Arial", 25));
		info.setTranslateY(-410);
	    info.setTextFill(Color.web("#e67e22"));
		next = new ImageView(Images.get("next").getImage());
		next.setTranslateX(800);
		next.setTranslateY(0);


        root.getChildren().add(info);
        root.getChildren().add(nomJoueur);

        root.getChildren().add(terrain);
        root.getChildren().add(hand);
        root.getChildren().add(board);
        root.getChildren().add(next);

        root.getChildren().add(choice);	
		manager.lancerJeu();
		voir = manager.getJoueur();
		next.setOnMouseClicked(e -> {
			voir = voir.getJoueurDroit();
			setNomTerrain(voir.getNom());
			changerVue();
		});
        root.getChildren().add(nomJoueurTerrain);

	}
	
	public void changerVue() {
		terrain.setCarteListe(voir.getTerrain());
		board.setBoard(voir.getPlateau());
		//setNom(voir.getNom());
	}
	
	public void setNom(String s) {
		nomJoueur.setText("Joueur: " + s);
	}
	
	public void setNomTerrain(String s) {
		nomJoueurTerrain.setText(s);
	}
	
	public void setInfo(String s) {
		info.setText(s);
		PauseTransition delay = new PauseTransition(Duration.seconds(2));
		delay.setOnFinished( event -> info.setText("") );
		delay.play();
	}
	
}
