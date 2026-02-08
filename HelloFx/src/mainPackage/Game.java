package mainPackage;

import org.json.JSONObject;

import javafx.stage.Stage;

public class Game {

	Stage stage;
	
	public Game(Stage stage) {
		this.stage = stage;
		
		JSONObject obj = new JSONObject();
        obj.put("name", "ChatGPT");
        System.out.println(obj.toString());
        stage.setTitle("JavaFX is alive");
        stage.show();
	}
}
