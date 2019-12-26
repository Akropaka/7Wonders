package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardView extends Rectangle{

	public static final int WIDTH = 750;
	public static final int HEIGHT = 330;

	BoardView() {
		super(WIDTH, HEIGHT);
		setTranslateX(0);
		setTranslateY(Window.HEIGHT/2-HEIGHT/2);
    }
	
	void setBoard() {
		//TODO Objet plateau
		setFill(Color.web("#eb4d4b")); //Images.get();
	}
	
}
