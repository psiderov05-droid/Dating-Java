package mainPackage;


import java.io.FileInputStream;

import org.json.JSONObject;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import performance.PerformanceHandaler;

public class Game {

	Stage stage;
	Scene scene;
	Group group;
	InputControler inputControler;
	PerformanceHandaler performanceHandaler;
	
	Image mc;
	Text text;
	
	public Game(Stage stage) {
	    this.stage = stage;
	    this.group = new Group();
	    this.scene = new Scene(group);
	    this.text = new Text();

	    this.stage.setScene(scene);
	    this.stage.setTitle("Dating Sim");
	    this.stage.setFullScreenExitHint("");
	    this.stage.setFullScreen(true);
	    this.stage.show();
	    
	   //------------
	    this.performanceHandaler = new PerformanceHandaler();
	    this.inputControler = new InputControler(this.scene, this.performanceHandaler);
	}
}
