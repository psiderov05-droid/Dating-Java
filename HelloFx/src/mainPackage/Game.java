package mainPackage;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import performance.PerformanceHandaler;

public class Game {

	private Stage stage;
	private Scene scene;
	private Group group;
	private InputControler inputControler;
	private PerformanceHandaler performanceHandaler;
	private TextBox textBox;
	
	public Game(Stage stage) {
	    this.stage = stage;
	    this.group = new Group();
	    this.scene = new Scene(group);
	    
	    this.stage.setScene(scene);
	    this.stage.setTitle("Dating Sim");
	    this.stage.setFullScreenExitHint("");
	    this.stage.setFullScreen(true);
	    this.stage.show();
	    
	    this.performanceHandaler = new PerformanceHandaler(scene);
	    this.inputControler = new InputControler(this.scene, this.performanceHandaler,this.textBox);
	}
}
