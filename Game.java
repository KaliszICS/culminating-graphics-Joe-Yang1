import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game extends Application {

    Scene menu;
    Scene game;
    Scene setting;

    @Override
    public void start(Stage stage){

        Label titlePage = new Label("Untitled");
        titlePage.setStyle("-fx-font-size: 50;");

        Button startButton = new Button("Start");
        startButton.setStyle("-fx-font-size: 30;");

        Button settingButton = new Button("Setting");
        settingButton.setStyle("-fx-font-size: 30;");

        VBox menuSpacing = new VBox(25);
        menuSpacing.getChildren().addAll(titlePage, startButton, settingButton);

        menu = new Scene(menuSpacing, 900, 600);

        Label settingPage = new Label("Options");

        
    }
    
    
}