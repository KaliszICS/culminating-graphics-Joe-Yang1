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

    int dummyHP = 100000000;
    int playerHP = 1200;
    int bossHP = 5000;
    int stageBuffs = 4;
    int startingSkillPoints = 3;
    int minSkillPoints = 0;
    int maxSKillPoints = 5;
    int startingEnergy = 0;
    int minEnergy = 0;
    int maxEnergy = 100;
    int basicAttackDmg = 20;
    int specialAttackDmg = 30;
    int ultimateAttackDmg = 100;
    int ultimateAttackShield = 20;
    int ultimateAttackHeal = 100;
    int passiveBar = 0;
    double bossPhase2Buffs = 1.25;
    boolean playerAction = true;

    @Override
    public void start(Stage stage){
        
        Label titlePage = new Label("Untitled");
        titlePage.setStyle("-fx-font-size: 50;");

        Button startButton = new Button("Start");
        startButton.setStyle("-fx-font-size: 30;");

        Button settingButton = new Button("Settings");
        settingButton.setStyle("-fx-font-size: 30;");

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> {System.exit(0);
        });

        VBox menuSpacing = new VBox(25);
        menuSpacing.getChildren().addAll(titlePage, startButton, settingButton, exitButton);

        menu = new Scene(menuSpacing, 900, 600);

        
        Label settingPage = new Label("Options");
        settingPage.setStyle("-fx-font-size: 50;");

        CheckBox tipsToggled = new CheckBox("Display Tips");

        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-font-size: 30;");

        VBox settingOptions = new VBox(25);
        settingOptions.getChildren().addAll(settingPage, tipsToggled, returnButton);

        setting = new Scene(settingOptions, 900, 600);


        Label stageSelectionPage = new Label("Stage Selection");
        stageSelectionPage.setStyle("-fx-font-size: 50;");

        Button tutorialStage = new Button("Tutorial Stage");
        tutorialStage.setStyle("-fx-font-size: 30;");

        Button bossStage = new Button("Boss Stage");
        bossStage.setStyle("-fx-font-size: 30;");

        Button rtButton = new Button("Return");
        rtButton.setStyle("-fx-font-size: 30;");

        VBox stageLayout = new VBox(25);
        stageLayout.getChildren().addAll(stageSelectionPage, tutorialStage, bossStage, rtButton);

        stages = new Scene(stageLayout, 900, 600);


        Label gameStage = new Label("Tutorial Stage");

        gameStage.setStyle("-fx-font-size: 50;");

        Button basicAttack = new Button("Basic Attack");
        basicAttack.setStyle("-fx-font-size: 30;");

        Button specialAttack = new Button("Special Attack");
        specialAttack.setStyle("-fx-font-size: 30;");

        Button ultimateAttack = new Button("Ultimate Attack");
        ultimateAttack.setStyle("-fx-font-size: 30;");


        VBox tutorialLayout = new VBox(25);
        tutorialLayout.getChildren().addAll(gameStage, basicAttack, specialAttack, ultimateAttack);

        tutorial = new Scene(tutorialLayout, 900, 600);


        Label bossPage = new Label("Boss Stage");
        bossPage.setStyle("-fx-font-size: 50");

        Button bAttack = new Button("Basic Attack");
        bAttack.setStyle("-fx-font-size: 30;");

        Button spAttack = new Button("Special Attack");
        spAttack.setStyle("-fx-font-size: 30;");

        Button ultAttack = new Button("Ultimate Attack");
        ultAttack.setStyle("-fx-font-size: 30;");


        VBox bossLayout = new VBox(25);
        bossLayout.getChildren().addAll(bossPage, bAttack, spAttack, ultAttack);
        
        boss = new Scene(bossLayout, 900, 600);

        
        startButton.setOnAction(e -> stage.setScene(stages));

        settingButton.setOnAction(e -> stage.setScene(setting));

        returnButton.setOnAction(e -> stage.setScene(menu));

        tutorialStage.setOnAction(e -> stage.setScene(tutorial));


        stage.setTitle("Untitled");
        stage.setScene(menu);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}





