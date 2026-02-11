package mainPackage;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import performance.PerformanceHandaler;

public class InputControler {
	
	private Scene scene;
	
	public InputControler(Scene scene, PerformanceHandaler performanceHandaler) {
		this.scene = scene;
		this.scene.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.F) {
				System.out.println("It is wokring");
			}
			if(event.getCode() == KeyCode.SPACE) {
				performanceHandaler.getNextPerformance(this.scene);
			}
		});
	}
}
