package view;

import java.util.ArrayList;
import java.util.HashMap;


import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Images {
	
	private static HashMap<String, ImagePattern> map = new HashMap<String, ImagePattern>();
	private static ArrayList<String> stringList;
	
	private static int total;
	private static boolean loaded = false;
		
	public static ImagePattern get(String key) {
		return map.get(key);
	}
	
	public static void buildImageList() {
		add("carte_base", "/image/carte/carte_base.png");
		add("energie","/image/carte/energie.png");
		add("informatique","/image/carte/informatique.png");
		add("langue","/image/carte/langue.png");
		add("maths","/image/carte/maths.png");
		add("physique","/image/carte/physique.png");
		add("mecanique","/image/carte/mecanique.png");
		add("cg","/image/carte/cg.png");
		add("prof0","/image/carte/prof0.png");

		System.out.println(map.size() + " images chargées !");
	}
	
	private static void add(String name, String path) {
		Image s = new Image(path);
		map.put(name, new ImagePattern(s));	
	}
	
}
