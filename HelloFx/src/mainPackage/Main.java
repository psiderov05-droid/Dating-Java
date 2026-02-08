package mainPackage;


import javafx.application.Application;
import javafx.stage.Stage;
import org.json.JSONObject;
 

public class Main extends Application {

    @Override
    public void start(Stage stage) {
    	Game game = new Game(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}