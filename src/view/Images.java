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
		add("ENERGIE","/image/carte/energie.png");
		add("INFO","/image/carte/informatique.png");
		add("MECA","/image/carte/mecanique.png");
		
		add("LANGUE","/image/carte/langue.png");
		add("MATHS","/image/carte/maths.png");
		add("PHYSIQUE","/image/carte/physique.png");
		add("CG","/image/carte/cg.png");
		
		add("IZLY","/image/carte/or.png");
		
		add("ALCOOL","/image/carte/alcool.png");
		add("CHIMIE","/image/carte/chimie.png");
		add("ELEC","/image/carte/electronic.png");

		add("POINTVICTOIRE","/image/carte/victoire.png");
		
		add("JETONCOMBAT","/image/carte/combat.png");
		
		add("carte_base", "/image/carte/carte_base.png");
		add("logo","/image/carte/logo.png");
		add("slash","/image/carte/slash.png");
		
		add("MOI","/image/carte/fleche_bas.png");
		add("DROITE","/image/carte/fleche_droite.png");
		add("GAUCHE","/image/carte/fleche_gauche.png");

		add("CarteJaune","/image/carte/jaune.png");
		add("CarteRouge","/image/carte/rouge.png");
		add("CarteViolette","/image/carte/violet.png");
		add("CarteGrise","/image/carte/gris.png");
		add("CarteMarron","/image/carte/marron.png");
		add("CarteVerte","/image/carte/vert.png");
		add("CarteBleue","/image/carte/bleue.png");

		add("no","/image/no.jpg");
		add("next","/image/fleche_droit.png");

		System.out.println(map.size() + " images chargées !");
	}
	
	private static void add(String name, String path) {
		Image s = new Image(path);
		map.put(name, new ImagePattern(s));	
	}
	
}
