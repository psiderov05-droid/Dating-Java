package mainPackage;
import org.json.JSONArray;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

public class TextBox {
	private JSONArray dialogOfCurrentScene;
	private int index;
	private Rectangle box;
	
	public TextBox(final Scene scene) {
		this.box = new Rectangle();
		box.widthProperty().bind(scene.widthProperty().multiply(0.6));
		box.heightProperty().bind(scene.heightProperty().multiply(0.3));
		
		box.xProperty().bind(
		    scene.widthProperty()
		         .subtract(box.widthProperty())
		         .divide(2)
		);

		
		box.yProperty().bind(
		    scene.heightProperty()
		         .subtract(scene.heightProperty().multiply(0.010))
		         .subtract(box.heightProperty())
		);
		
		box.setArcWidth(40);
		box.setArcHeight(40);
		
		box.setOpacity(0.8);
		
		this.index = 0;
	}
	
	public void dialogOfCurrentScene(JSONArray dialogOfCurrentScene) {
		this.dialogOfCurrentScene = dialogOfCurrentScene;
	}
	
	public String getNextDialogSegment() {
		String dialogSegment = this.dialogOfCurrentScene.getString(index);
		index++;
		return dialogSegment;
	}
	
	public void resetIndexForDialog() {
		this.index = 0;
	}

	public Rectangle getBox() {
		return box;
	}

	public void setBox(Rectangle box) {
		this.box = box;
	}
	
}
