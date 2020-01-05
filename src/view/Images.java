package view;

import java.util.HashMap;


import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Images {
	
	private static HashMap<String, ImagePattern> map = new HashMap<String, ImagePattern>();

	public static ImagePattern get(String key) {
		return map.get(key);
	}
	
	public static void buildImageList() {
		add("carte_base", "/image/carte/carte_base.png");
		
		add("TABLETTE","/image/carte/energie.png");
		add("ENGRENAGE","/image/carte/informatique.png");
		add("COMPAS","/image/carte/mecanique.png");
		
		add("BOIS","/image/carte/langue.png");
		add("FER","/image/carte/maths.png");
		add("PIERRE","/image/carte/physique.png");
		add("ARGILE","/image/carte/cg.png");
		
		add("OR","/image/carte/or.png");
		
		add("TISSU","/image/carte/cg.png");
		add("VERRE","/image/carte/cg.png");
		add("PARCHEMIN","/image/carte/cg.png");

		add("POINTVICTOIRE","/image/carte/victoire.png");
		
		add("JETONCOMBAT","/image/carte/combat.png");

		add("prof0","/image/carte/prof0.png");

		System.out.println(map.size() + " images charg�es !");
	}
	
	private static void add(String name, String path) {
		Image s = new Image(path);
		map.put(name, new ImagePattern(s));	
	}
	
}
