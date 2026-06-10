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
    Scene tutorial;
    Scene boss;
    Scene ultimateMenu;

    Scene currentBattle;

    int dummyHP = 100000000;
    int playerHP = 1200;
    int playerShield = 0;
    int bossStagePlayerShield = 0;
    int bossHP = 5000;
    int stageBuffs = 4;
    int startingSkillPoints = 3;
    int minSkillPoints = 0;
    int maxSkillPoints = 5;
    int startingEnergy = 0;
    int maxEnergy = 100;
    int basicAttackDmg = 20;
    int specialAttackDmg = 30;
    int ultimateAttackDmg = 100;

    Label tutorialPlayerHpLabel;
    Label bossPlayerHpLabel;
    Label bossHpLabel;
    Label dummyHpLabel;
    Label tutorialPlayerShieldLabel;
    Label bossPlayerShieldLabel;
    Label tutorialSkillPointLabel;
    Label tutorialEnergyLabel;
    Label bossSkillPointLabel;
    Label bossEnergyLabel;

    @Override
    public void start(Stage stage){

        Label titlePage = new Label("Untitled");
        titlePage.setStyle("-fx-font-size: 50;");

        Button startButton = new Button("Start");
        startButton.setStyle("-fx-font-size: 30;");

        Button settingButton = new Button("Settings");
        settingButton.setStyle("-fx-font-size: 30;");

        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-font-size: 30;");
        exitButton.setOnAction(e -> System.exit(0));

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

        tutorialPlayerHpLabel = new Label("Player HP: " + playerHP);
        tutorialPlayerShieldLabel = new Label("Shield: " + playerShield);
        dummyHpLabel = new Label("Dummy HP: Inf");
        tutorialSkillPointLabel = new Label("Skill Points: " + startingSkillPoints);
        tutorialEnergyLabel = new Label("Energy: " + startingEnergy);

        VBox tutorialLayout = new VBox(25);
        tutorialLayout.getChildren().addAll(gameStage, basicAttack, specialAttack, ultimateAttack, tutorialPlayerHpLabel, tutorialPlayerShieldLabel, dummyHpLabel, tutorialSkillPointLabel, tutorialEnergyLabel);

        tutorial = new Scene(tutorialLayout, 900, 600);


        Label bossPage = new Label("Boss Stage");
        bossPage.setStyle("-fx-font-size: 50");

        Button bAttack = new Button("Basic Attack");
        bAttack.setStyle("-fx-font-size: 30;");

        Button spAttack = new Button("Special Attack");
        spAttack.setStyle("-fx-font-size: 30;");

        Button ultAttack = new Button("Ultimate Attack");
        ultAttack.setStyle("-fx-font-size: 30;");

        bossPlayerHpLabel = new Label("Player HP: " + playerHP);
        bossHpLabel = new Label("Boss HP: " + bossHP);
        bossPlayerShieldLabel = new Label("Shield: " + bossStagePlayerShield);
        bossSkillPointLabel = new Label("Skill Points: " + startingSkillPoints);
        bossEnergyLabel = new Label("Energy: " + startingEnergy);

        VBox bossLayout = new VBox(25);
        bossLayout.getChildren().addAll(bossPage, bAttack, spAttack, ultAttack, bossPlayerHpLabel, bossPlayerShieldLabel, bossHpLabel, bossSkillPointLabel, bossEnergyLabel);

        boss = new Scene(bossLayout, 900, 600);


        Label ultLabel = new Label("Choose an ultimate type");

        Button damageUlt = new Button("Damage Ult");
        Button healingUlt = new Button("Healing Ult");

        VBox ultimateLayout = new VBox(25);
        ultimateLayout.getChildren().addAll(ultLabel, damageUlt, healingUlt);

        ultimateMenu = new Scene(ultimateLayout, 900, 600);


        startButton.setOnAction(e -> stage.setScene(stages));
        settingButton.setOnAction(e -> stage.setScene(setting));
        returnButton.setOnAction(e -> stage.setScene(menu));

        tutorialStage.setOnAction(e -> {
            currentBattle = tutorial;
            stage.setScene(tutorial);
        });

        bossStage.setOnAction(e -> {
            currentBattle = boss;
            stage.setScene(boss);
        });

        rtButton.setOnAction(e -> stage.setScene(menu));


        ultimateAttack.setOnAction(e -> {

            if (startingEnergy >= 100) {
                stage.setScene(ultimateMenu);
            }
            else {
                stage.setScene(currentBattle);
            }

        });


        basicAttack.setOnAction(e -> {basicAttack(); refreshUi();});
        specialAttack.setOnAction(e -> {specialAttack(); refreshUi();});
        bAttack.setOnAction(e -> {basicAttack(); refreshUi();});
        spAttack.setOnAction(e -> {specialAttack(); refreshUi();});


        damageUlt.setOnAction(e -> {

            if (startingEnergy < 100) return;

            dummyHP -= ultimateAttackDmg * 3;
            bossHP -= ultimateAttackDmg * 3 * stageBuffs;

            startingEnergy = 0;

            bossHP = Math.max(0, bossHP);

            refreshUi();
            stage.setScene(currentBattle);
        });


        healingUlt.setOnAction(e -> {

            if (startingEnergy < 100) return;

            playerHP += 100;
            playerShield += 100;

            startingEnergy = 0;

            refreshUi();
            stage.setScene(currentBattle);
        });


        stage.setScene(menu);
        stage.setTitle("Untitled");
        stage.show();
    }

    public void refreshUi() {

        tutorialPlayerHpLabel.setText("Player HP: " + playerHP);
        tutorialPlayerShieldLabel.setText("Shield: " + playerShield);

        bossPlayerHpLabel.setText("Player HP: " + playerHP);
        bossPlayerShieldLabel.setText("Shield: " + bossStagePlayerShield);

        bossHpLabel.setText("Boss HP: " + bossHP);

        tutorialSkillPointLabel.setText("Skill Points: " + startingSkillPoints);
        tutorialEnergyLabel.setText("Energy: " + startingEnergy);

        bossSkillPointLabel.setText("Skill Points: " + startingSkillPoints);
        bossEnergyLabel.setText("Energy: " + startingEnergy);
    }

    public static void main(String[] args) {
        launch(args);
    }
}