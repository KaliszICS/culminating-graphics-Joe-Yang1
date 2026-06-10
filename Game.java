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
        dummyHpLabel = new Label("Dummy HP: Inf");
        tutorialSkillPointLabel = new Label("Skill Points: " + startingSkillPoints);
        tutorialEnergyLabel = new Label("Energy: " + startingEnergy);

        VBox tutorialLayout = new VBox(25);
        tutorialLayout.getChildren().addAll(
            gameStage, basicAttack, specialAttack, ultimateAttack, tutorialPlayerHpLabel, dummyHpLabel, tutorialSkillPointLabel, tutorialEnergyLabel
        );

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
        bossSkillPointLabel = new Label("Skill Points: " + startingSkillPoints);
        bossEnergyLabel = new Label("Energy: " + startingEnergy);

        VBox bossLayout = new VBox(25);
        bossLayout.getChildren().addAll(
            bossPage, bAttack, spAttack, ultAttack, bossPlayerHpLabel, bossHpLabel, bossSkillPointLabel, bossEnergyLabel
        );

        boss = new Scene(bossLayout, 900, 600);

        
        Label ultLabel = new Label("Choose an ultimate type");

        Button damageUlt = new Button("Damage Ult");
        Button healingUlt = new Button("Healing Ult");

        VBox ultimateLayout = new VBox(25);
        ultimateLayout.getChildren().addAll(ultLabel, damageUlt, healingUlt);

        ultimateMenu = new Scene(ultimateLayout, 900, 600);

        
        startButton.setOnAction(e -> stage.setScene(stages));

        settingButton.setOnAction(e -> stage.setScene(menu));

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

            if (startingEnergy < maxEnergy) {
                System.out.println("Not enough energy for Ultimate");
                return;
            }

            stage.setScene(ultimateMenu);
        });

        basicAttack.setOnAction(e -> {basicAttack(); refreshUi();});
        specialAttack.setOnAction(e -> {specialAttack(); refreshUi();});
        bAttack.setOnAction(e -> {basicAttack(); refreshUi();});
        spAttack.setOnAction(e -> {specialAttack(); refreshUi();});

        damageUlt.setOnAction(e -> {

            if (startingEnergy < maxEnergy) return;

            dummyHP -= ultimateAttackDmg;
            bossHP -= ultimateAttackDmg * stageBuffs;

            startingEnergy = 0;

            refreshUi();
            stage.setScene(currentBattle);
        });

        healingUlt.setOnAction(e -> {

            if (startingEnergy < maxEnergy) return;

            playerHP += 100;

            startingEnergy = 0;

            refreshUi();
            stage.setScene(currentBattle);
        });

        stage.setScene(menu);
        stage.setTitle("Untitled");
        stage.show();
    }

    public void refreshUi() {

        if (tutorialPlayerHpLabel != null)
            tutorialPlayerHpLabel.setText("Player HP: " + playerHP);

        if (dummyHpLabel != null)
            dummyHpLabel.setText("Dummy HP: " + dummyHP);

        if (bossPlayerHpLabel != null)
            bossPlayerHpLabel.setText("Player HP: " + playerHP);

        if (bossHpLabel != null)
            bossHpLabel.setText("Boss HP: " + bossHP);

        if (tutorialSkillPointLabel != null)
            tutorialSkillPointLabel.setText("Skill Points: " + startingSkillPoints);

        if (tutorialEnergyLabel != null)
            tutorialEnergyLabel.setText("Energy: " + startingEnergy);

        if (bossSkillPointLabel != null)
            bossSkillPointLabel.setText("Skill Points: " + startingSkillPoints);

        if (bossEnergyLabel != null)
            bossEnergyLabel.setText("Energy: " + startingEnergy);
    }

    public void basicAttack() {

        dummyHP -= basicAttackDmg;
        bossHP -= basicAttackDmg * stageBuffs;

        startingSkillPoints = Math.min(startingSkillPoints + 1, maxSkillPoints);
        startingEnergy = Math.min(startingEnergy + 25, maxEnergy);

        bossHP = Math.max(0, bossHP);

        refreshUi();
    }

    public void specialAttack() {

        if (startingSkillPoints > minSkillPoints) {

            dummyHP -= specialAttackDmg;
            bossHP -= specialAttackDmg * stageBuffs;

            startingSkillPoints--;

            startingEnergy = Math.min(startingEnergy + 30, maxEnergy);

            bossHP = Math.max(0, bossHP);

            refreshUi();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}