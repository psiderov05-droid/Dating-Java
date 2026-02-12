package mainPackage;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import performance.PerformanceHandaler;

public class InputControler {
	
	private Scene scene;
	
	public InputControler(Scene scene, PerformanceHandaler performanceHandaler, TextBox textBox) {
		this.scene = scene;
		this.scene.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.SPACE) {
				performanceHandaler.getNextPerformance();
			}
			if(event.getCode() == KeyCode.F) {
				performanceHandaler.displayMoreDialog();
			}
		});
	}
}
