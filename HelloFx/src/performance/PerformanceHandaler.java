package performance;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.scene.Group;
import javafx.scene.Scene;

public class PerformanceHandaler {
	public static final String path = "resources/dialog/";
	
	private String[] files = {"Scene1_GetsHitByATruck.json", "Scene2_Test.json"};
	private String jsonString;
	private JSONObject jsonObject;
	private int index = 0;
	
	public void getNextPerformance(Scene scene) {
		
		if(this.index == files.length){
			System.out.println("No more scenes to give");
			return;
		}
		
		Group rootNode = new Group();
		
		String currentPath = path+files[index];
		
		try {
			this.jsonString = new String(Files.readString(Paths.get(currentPath)));	
		}catch (Exception e) {
			System.out.println("Could not read json");
		}
		
		this.jsonObject = new JSONObject(this.jsonString);
		JSONArray dialog = this.jsonObject.getJSONArray("lines");
		
		JSONArray charaters = this.jsonObject.getJSONArray("charaters");
		
		for(int i = 0; i<charaters.length(); i++) {
			JSONObject currentCharater = charaters.getJSONObject(i);
			double x = currentCharater.getDouble("x");
			double y = currentCharater.getDouble("y");
			String image = currentCharater.getString("image");
			
			Charater character = new Charater(x,y,image);
			rootNode.getChildren().add(character.getImageView());
		}
		
		
		scene.setRoot(rootNode);
		index++;
	}
	
}
