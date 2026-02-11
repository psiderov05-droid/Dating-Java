package mainPackage;


import javafx.application.Application;
import javafx.stage.Stage;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
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