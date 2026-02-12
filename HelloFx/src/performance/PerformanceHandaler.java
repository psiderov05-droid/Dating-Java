package performance;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

import mainPackage.TextBox;

public class PerformanceHandaler {
    public static final String path = "resources/dialog/";

    private String[] files = {"Scene1_GetsHitByATruck.json", "Scene2_Test.json"};
    private String jsonString;
    private String currentPath;
    private JSONObject jsonObject;
    private Group rootNode;
    private TextBox textBox;
    private TextFlow dialogueFlow;
    private JSONArray charactersArray;
    private JSONArray dialog;
    private Scene scene;
    private int index;

    public PerformanceHandaler(Scene scene) {
        this.scene = scene;
        this.currentPath = "";
        this.index = 0;
        this.rootNode = new Group();
        this.textBox = new TextBox(scene);

        this.dialogueFlow = new TextFlow();
        rootNode.getChildren().add(dialogueFlow);

        scene.setRoot(rootNode);
    }

    public void getNextPerformance() {
        if (this.index >= this.files.length) {
            System.out.println("No more scenes to give");
            return;
        }

        this.rootNode.getChildren().clear();
        this.textBox.resetIndexForDialog();

        this.currentPath = path + this.files[index];

        try {
            this.jsonString = new String(Files.readAllBytes(Paths.get(currentPath)));
        } catch (Exception e) {
            System.out.println("Could not read json: " + this.currentPath);
            e.printStackTrace();
            return;
        }

        this.jsonObject = new JSONObject(this.jsonString);

        this.charactersArray = this.jsonObject.getJSONArray("charaters");
        for (int i = 0; i < charactersArray.length(); i++) {
            JSONObject currentCharacter = charactersArray.getJSONObject(i);
            double x = currentCharacter.getDouble("x");
            double y = currentCharacter.getDouble("y");
            String image = currentCharacter.getString("image");

            Charater character = new Charater(x, y, image);
            rootNode.getChildren().add(character.getImageView());
        }

        rootNode.getChildren().add(textBox.getBox());

        dialogueFlow.layoutXProperty().bind(textBox.getBox().xProperty().add(20));
        dialogueFlow.layoutYProperty().bind(textBox.getBox().yProperty().add(40));
        dialogueFlow.prefWidthProperty().bind(textBox.getBox().widthProperty().subtract(40));

        rootNode.getChildren().add(dialogueFlow);

        this.dialog = this.jsonObject.getJSONArray("lines");
        this.textBox.dialogOfCurrentScene(dialog);

        scene.setRoot(rootNode);
        index++;
    }

    public void displayMoreDialog() {
        String nextSegment = textBox.getNextDialogSegment();
        if (nextSegment == null) return;

        dialogueFlow.getChildren().clear();

        fadeInText(dialogueFlow, nextSegment, 0.05, 0.3);
    }

    public void fadeInText(TextFlow container, String fullText, double secondsPerChar, double fadeDuration) {
        container.getChildren().clear();

        for (int i = 0; i < fullText.length(); i++) {
            char c = fullText.charAt(i);
            Text t = new Text(String.valueOf(c));
            t.setFill(Color.WHITE);
            t.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            t.setOpacity(0);
            container.getChildren().add(t);

            // Fade transition for each character
            FadeTransition ft = new FadeTransition(Duration.seconds(fadeDuration), t);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.setInterpolator(Interpolator.EASE_BOTH);
            ft.setDelay(Duration.seconds(i * secondsPerChar)); // stagger per character
            ft.play();
        }
    
    }
    
}