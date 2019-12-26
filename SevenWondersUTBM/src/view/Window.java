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

	public static final int WIDTH = 1600;
	public static final int HEIGHT = 890;
	
	public ManageurDeTour mdt;
	public BoardView bv;
	public HandView hv;
	
	public static void main(String[] args) {
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) {
		Images.buildImageList();
		bv = new BoardView();
		hv = new HandView();
		
		mdt = new ManageurDeTour(this);
		mdt.remplirPile(2);
		
		hv.setCarteListe(mdt.getJoueurs().get(0).getMain());
		primaryStage.setTitle("7 Wonders - UTBM");
		/*Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});*/

		StackPane root = new StackPane();
		//root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
		primaryStage.show();
        root.getChildren().add(hv);
        root.getChildren().add(bv);

	}
	
}
