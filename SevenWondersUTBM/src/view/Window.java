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
	
	public static void main(String[] args) {
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) {
		Images.buildImageList();
		bv = new BoardView();
		hv = new HandView();
		cjv = new CarteJouerView();
		
		StackPane root = new StackPane();

		primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
		primaryStage.show();
		primaryStage.setTitle("7 Wonders - UTBM");
		
        root.getChildren().add(cjv);
        root.getChildren().add(hv);
        root.getChildren().add(bv);

		mdt = new ManageurDeTour(this);
		mdt.remplirPile(2);
		
		/*Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});*/



	}
	
}
