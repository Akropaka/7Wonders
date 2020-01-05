package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.ManageurDeTour;

public class Window extends Application {

	public static final int WIDTH = 1800;
	public static final int HEIGHT = 890;
	
	public ManageurDeTour mdt;
	public BoardView bv;
	public HandView hv;
	public CarteJouerView cjv;
	public ChoiceView cv;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Images.buildImageList();
		
		mdt = new ManageurDeTour(this);

		bv = new BoardView();
		hv = new HandView();
		cjv = new CarteJouerView();
		cv = new ChoiceView(this);
		StackPane root = new StackPane();

		primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
		primaryStage.show();
		primaryStage.setTitle("7 Wonders - UTBM");
		primaryStage.setResizable(false);
		
        root.getChildren().add(cjv);
        root.getChildren().add(hv);
        root.getChildren().add(bv);
        root.getChildren().add(cv);	
        
        mdt.lancerJeu();
	}
	
}
