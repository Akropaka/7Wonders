package view;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
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
	public TradeView trade;

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
		primaryStage.setScene(new Scene(root, WIDTH, HEIGHT, Color.web("#ecf0f1")));
		primaryStage.show();
		primaryStage.setTitle("7 Wonders - UTBM");
		primaryStage.setResizable(false);
		
		//TODO DEBUG ONLY
        //root.getChildren().add(menu);

	}
	
	public void lancerJeu() {
		root.getChildren().remove(menu);
		
		board = new BoardView();
		hand = new HandView(this);
		terrain = new CarteJouerView();
		choice = new ChoiceView(this);
		trade = new TradeView();

		nomJoueur = new Label();
		nomJoueur.setFont(new Font("Arial", 25));
		nomJoueur.setTranslateY(260);
		nomJoueur.setTranslateX(-530);
		nomJoueur.setTextAlignment(TextAlignment.CENTER);

		
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
		next.setFitHeight(100);
		next.setFitWidth(100);
		next.setCursor(Cursor.HAND);
		next.setTranslateX(800);
		next.setTranslateY(0);

        root.getChildren().add(info);
        root.getChildren().add(nomJoueur);
        root.getChildren().add(terrain);
        root.getChildren().add(hand);
        root.getChildren().add(board);
        root.getChildren().add(next);
        root.getChildren().add(choice);	
        root.getChildren().add(trade);
        root.getChildren().add(nomJoueurTerrain);

		manager.lancerJeu();
		
		voir = manager.getJoueur();
		
		trade.setVisible(false);
		
		next.setOnMouseClicked(e -> {
			voir = voir.getJoueurDroit();
			setNomTerrain(voir.getNom());
			changerVue();
		});
		

	}
	
	public void changerVue() {
		terrain.setCarteListe(voir.getTerrain());
		board.setBoard(voir.getPlateau());
	}
	
	public void setNom(String s) {
		nomJoueur.setText(s);
		trade.setVisible(false);

		
	}
	
	public void setNomTerrain(String s) {
		nomJoueurTerrain.setText(s);
	}
	
	public void afficherMessageCombat(String s) {
		Alert alert = new Alert(AlertType.INFORMATION, s , ButtonType.OK);
		alert.show();
	}
	
	public void setInfo(String s) {
		info.setText(s);
		PauseTransition delay = new PauseTransition(Duration.seconds(2));
		delay.setOnFinished( event -> info.setText("") );
		delay.play();
	}
	
}
