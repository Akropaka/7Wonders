package view;

import java.util.HashMap;


import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Images {
	
	private static HashMap<String, ImagePattern> map = new HashMap<String, ImagePattern>();

	public static ImagePattern get(String key) {
		if(map.containsKey(key)) {
			return map.get(key);
		}else {
			return map.get("no");
		}
	}
	
	public static void buildImageList() {		
		add("TABLETTE","/image/carte/energie.png");
		add("ENGRENAGE","/image/carte/informatique.png");
		add("COMPAS","/image/carte/mecanique.png");
		
		add("BOIS","/image/carte/langue.png");
		add("FER","/image/carte/maths.png");
		add("PIERRE","/image/carte/physique.png");
		add("ARGILE","/image/carte/cg.png");
		
		add("OR","/image/carte/or.png");
		
		add("TISSU","/image/carte/alcool.png");
		add("VERRE","/image/carte/chimie.png");
		add("PARCHEMIN","/image/carte/electronic.png");

		add("POINTVICTOIRE","/image/carte/victoire.png");
		
		add("JETONCOMBAT","/image/carte/combat.png");
		
		add("carte_base", "/image/carte/carte_base.png");
		add("logo","/image/carte/logo.png");
		add("slash","/image/carte/slash.png");
		
		add("MOI","/image/carte/fleche_bas.png");
		add("DROITE","/image/carte/fleche_droite.png");
		add("GAUCHE","/image/carte/fleche_gauche.png");

		add("no","/image/no.jpg");
		add("next","/image/fleche_droit.png");

		System.out.println(map.size() + " images chargées !");
	}
	
	private static void add(String name, String path) {
		Image s = new Image(path);
		map.put(name, new ImagePattern(s));	
	}
	
}
