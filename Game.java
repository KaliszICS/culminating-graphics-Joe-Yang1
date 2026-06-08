import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game extends Application {

    Scene menu;
    Scene stages;
    Scene setting;
    Scene combat;
    Scene tutorial;
    Scene boss;

    @Override
    public void start(Stage stage){

        
        Label titlePage = new Label("Untitled");
        titlePage.setStyle("-fx-font-size: 50;");

        Button startButton = new Button("Start");
        startButton.setStyle("-fx-font-size: 30;");

        Button settingButton = new Button("Settings");
        settingButton.setStyle("-fx-font-size: 30;");

        VBox menuSpacing = new VBox(25);
        menuSpacing.getChildren().addAll(titlePage, startButton, settingButton);

        menu = new Scene(menuSpacing, 900, 600);

        
        Label settingPage = new Label("Options");
        settingPage.setStyle("-fx-font-size: 50;");

        CheckBox tipsToggled = new CheckBox("Display Tips");

        Button returButton = new Button("Return");
        returButton.setStyle("-fx-font-size: 30;");

        VBox settingOptions = new VBox(25);
        settingOptions.getChildren().addAll(settingPage, tipsToggled, returButton);

        setting = new Scene(settingOptions, 900, 600);


        Label stageSelectionPage = new Label("Stage Selection");
        stageSelectionPage.setStyle("-fx-font-size: 50;");

        Button tutorialStage = new Button("Tutorial Stage");
        tutorialStage.setStyle("-fx-font-size: 30;");

        Button bossStage = new Button("Boss Stage");
        bossStage.setStyle("-fx-font-size: 30;");

        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-font-size: 30;");

        VBox stageLayout = new VBox(25);
        stageLayout.getChildren().addAll(stageSelectionPage, tutorialStage, bossStage, returnButton);

        stages = new Scene(stageLayout, 900, 600);


        Label gameStage = new Label("Tutorial Stage");
        gameStage.setStyle("-fx-font-size: 50;");

        Button basicAttack = new Button("Basic Attack");
        Button specialAttack = new Button("Special Attack");
        Button ultimateAttack = new Button("Ultimate Attack");

        Button tutorialBack = new Button("Back");
        tutorialBack.setStyle("-fx-font-size: 20;");

        VBox tutorialLayout = new VBox(25);
        tutorialLayout.getChildren().addAll(gameStage, basicAttack, specialAttack, ultimateAttack, tutorialBack);

        tutorial = new Scene(tutorialLayout, 900, 600);




        startButton.setOnAction(e -> stage.setScene(stages));

        settingButton.setOnAction(e -> stage.setScene(setting));

        returButton.setOnAction(e -> stage.setScene(menu));

        returnButton.setOnAction(e -> stage.setScene(menu));

        tutorialStage.setOnAction(e -> stage.setScene(tutorial));

        tutorialBack.setOnAction(e -> stage.setScene(stages));


        stage.setTitle("Untitled");
        stage.setScene(menu);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}