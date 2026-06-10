/**

        * File: culminating

        * Author: Joe Yang

 		* Date Created: May 15, 2026

        * Date Last Modified: May 18, 2026

        */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.scene.layout.BorderPane;


public class Game extends Application {

    Scene menu;
    Scene stages;
    Scene setting;
    Scene tutorial;
    Scene boss;
    Scene ultimateMenu;
    Scene currentBattle;
    Scene battleSetting;

    int dummyHP = 100000000;
    int playerHP = 1200;
    int playerShield = 0;
    int bossHP = 5000;
    int stageBuffs = 4;
    int startingSkillPoints = 3;
    int minSkillPoints = 0;
    int maxSkillPoints = 5;
    int startingEnergy = 0;
    int maxEnergy = 100;
    int basicAttackDmg = 40;
    int specialAttackDmg = 60;
    int ultimateAttackDmg = 200;
    int bossBasicAttack = 50;
    int bossHeavyAttack = 75;
    int bossSpecialAttack = 200;
    boolean passive = false;
    boolean playerAction = true;
    boolean settingsFromBattle = false;

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
    Label passiveLabel;
    Label turnBar;


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
        passiveLabel = new Label("Passive: " + passive);

        VBox tutorialLayout = new VBox(25);
        tutorialLayout.getChildren().addAll(gameStage, basicAttack, specialAttack, ultimateAttack, tutorialPlayerHpLabel, tutorialPlayerShieldLabel, dummyHpLabel, tutorialSkillPointLabel, tutorialEnergyLabel, passiveLabel);

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
        bossPlayerShieldLabel = new Label("Shield: " + playerShield);
        bossSkillPointLabel = new Label("Skill Points: " + startingSkillPoints);
        bossEnergyLabel = new Label("Energy: " + startingEnergy);
        passiveLabel = new Label("Passive: " + passive);

        BorderPane bossLayout = new BorderPane();
        VBox ability = new VBox(25);
        ability.getChildren().addAll(bossPage, bAttack, spAttack, ultAttack, bossPlayerHpLabel, bossPlayerShieldLabel, bossHpLabel, bossSkillPointLabel, bossEnergyLabel, passiveLabel);

        VBox actionBox = new VBox(10);

        turnBar = new Label("Turn: Player");
        turnBar.setStyle("-fx-font-size: 20");

        actionBox.getChildren().addAll(turnBar);

        bossLayout.setLeft(ability);
        bossLayout.setRight(actionBox);

        boss = new Scene(bossLayout, 900, 600);

        Label ultLabel = new Label("Choose an ultimate type");

        Button damageUlt = new Button("Damage Ult");
        Button healingUlt = new Button("Healing Ult");

        VBox ultimateLayout = new VBox(25);
        ultimateLayout.getChildren().addAll(ultLabel, damageUlt, healingUlt);

        ultimateMenu = new Scene(ultimateLayout, 900, 600);

        Label pauseMenu = new Label("Game Paused");
        pauseMenu.setStyle("-fx-font-size: 50");

        Button battleSettings = new Button("Settings");
        battleSettings.setStyle("-fx-font-size: 30");

        Button leave = new Button("Flee the battle");
        leave.setStyle("-fx-font-size: 30");

        VBox pause = new VBox(25);
        pause.getChildren().addAll(pauseMenu, battleSettings, leave);


        battleSetting = new Scene(pause, 900, 600);

        tutorialStage.setOnAction(e -> { currentBattle = tutorial; stage.setScene(tutorial); tutorial.getRoot().requestFocus(); });
        bossStage.setOnAction(e -> { currentBattle = boss; stage.setScene(boss); boss.getRoot().requestFocus(); });

        startButton.setOnAction(e -> stage.setScene(stages));
        settingButton.setOnAction(e -> { settingsFromBattle = false; stage.setScene(setting); });

        battleSettings.setOnAction(e -> { settingsFromBattle = true; stage.setScene(setting); });

        returnButton.setOnAction(e -> {
        if (settingsFromBattle && currentBattle != null) {
            stage.setScene(currentBattle);
            if (currentBattle == tutorial) tutorial.getRoot().requestFocus();
            if (currentBattle == boss) boss.getRoot().requestFocus();
        } else {
        stage.setScene(menu);
    }
});

        tutorial.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ESCAPE:
                    currentBattle = tutorial;
                    stage.setScene(battleSetting);
                    battleSetting.getRoot().requestFocus();
                    break;
            }
    });

        boss.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ESCAPE:
                    currentBattle = boss;
                    stage.setScene(battleSetting);
                    battleSetting.getRoot().requestFocus();
                    break;
            }
    });


        leave.setOnAction(e -> stage.setScene(stages));

        tutorialStage.setOnAction(e -> { currentBattle = tutorial; refreshUi(); stage.setScene(tutorial); tutorial.getRoot().requestFocus(); });

        bossStage.setOnAction(e -> { currentBattle = boss; refreshUi(); stage.setScene(boss); boss.getRoot().requestFocus(); });

        rtButton.setOnAction(e -> stage.setScene(menu));

        ultimateAttack.setOnAction(e -> stage.setScene(startingEnergy >= maxEnergy ? ultimateMenu : currentBattle));
        ultAttack.setOnAction(e -> stage.setScene(startingEnergy >= maxEnergy ? ultimateMenu : currentBattle));

        basicAttack.setOnAction(e -> {basicAttack(); refreshUi();});
        specialAttack.setOnAction(e -> {specialAttack(); refreshUi();});
        bAttack.setOnAction(e -> {basicAttack(); refreshUi();});
        spAttack.setOnAction(e -> {specialAttack(); refreshUi();});


    damageUlt.setOnAction(e -> {

        if (startingEnergy < maxEnergy) return;

        if (currentBattle == boss) {

            bossHP -= ultimateAttackDmg * stageBuffs;
            bossHP = Math.max(0, bossHP);
        }

            startingEnergy = 0;
            refreshUi();

            stage.setScene(currentBattle);
    });

        healingUlt.setOnAction(e -> {
            if (startingEnergy < maxEnergy) return;

            if(currentBattle == tutorial){
                playerHP += 25;
                playerShield += 25;
                startingEnergy = 0;
                refreshUi();
                return;
            }

            playerHP += 25 * stageBuffs;
            playerShield += 25 * stageBuffs;
            startingEnergy = 0;
            refreshUi();

            if (currentBattle != null) stage.setScene(currentBattle);
            
        });

        stage.setScene(menu);
        stage.setTitle("Untitled");
        stage.show();
    }

    public void refreshUi() {

        tutorialPlayerHpLabel.setText("Player HP: " + playerHP);
        tutorialPlayerShieldLabel.setText("Shield: " + playerShield);

        bossPlayerHpLabel.setText("Player HP: " + playerHP);
        bossPlayerShieldLabel.setText("Shield: " + playerShield);

        dummyHpLabel.setText("Dummy HP: " + dummyHP);
        bossHpLabel.setText("Boss HP: " + bossHP);

        tutorialSkillPointLabel.setText("Skill Points: " + startingSkillPoints);
        tutorialEnergyLabel.setText("Energy: " + startingEnergy);

        bossSkillPointLabel.setText("Skill Points: " + startingSkillPoints);
        bossEnergyLabel.setText("Energy: " + startingEnergy);
    }

    public void basicAttack() {

        if (!playerAction) return;
        int dmg = basicAttackDmg;

        if(currentBattle == tutorial){
            startingSkillPoints = Math.min(startingSkillPoints + 1, maxSkillPoints);
            startingEnergy = Math.min(startingEnergy + 25, maxEnergy);
            refreshUi();
            return;
        }

        bossHP -= dmg * stageBuffs;

        startingSkillPoints = Math.min(startingSkillPoints + 1, maxSkillPoints);
        startingEnergy = Math.min(startingEnergy + 25, maxEnergy);

        passive = true;
        playerAction = false;
        chaningTurns();
        refreshUi();
        bossActions();
    }

    public void chaningTurns(){

        if (playerAction == true && passive == true){
            turnBar.setText("Turn: Player");
        }
        else{
            turnBar.setText("Turn: Boss");
        }
    }

    public void specialAttack() {

        if (!playerAction) return;
        if (startingSkillPoints > minSkillPoints) {

            int dmg = specialAttackDmg;

            if(currentBattle == tutorial){
                startingSkillPoints--;
                startingEnergy = Math.min(startingEnergy + 30, maxEnergy);
                refreshUi();
                return;
            }

            bossHP -= dmg * stageBuffs;

            startingSkillPoints--;
            startingEnergy = Math.min(startingEnergy + 30, maxEnergy);

            bossHP = Math.max(0, bossHP);

        }

            if (passive){
                passive = false;
                playerAction = true;
                refreshUi();
                return;
            }

            passive = false;
            chaningTurns();
            refreshUi();
            bossActions();
        }

    public void bossBAttack(){

            int dmg = bossBasicAttack;

            if (playerShield > 0){
                int absorb = Math.min(playerShield, dmg);
                playerShield -= absorb;
                dmg -= absorb;
            }

            playerHP -= dmg;

            playerHP = Math.max(0, playerHP);
        }

    public void bossHAttack(){

        int dmg = bossHeavyAttack;

        if (playerShield > 0){
            int absorb = Math.min(playerShield, dmg);
            playerShield -= absorb;
            dmg -= absorb;
        }
        
        playerHP -= dmg;

        playerHP = Math.max(0, playerHP);
    }

    public void bossSpAttack(){

        int dmg = bossSpecialAttack;

        if (playerShield > 0){
            int absorb = Math.min(playerShield, dmg);
            playerShield -= absorb;
            dmg -= absorb;
        }
        
        playerHP -= dmg;

        playerHP = Math.max(0, playerHP);
    }


    public void bossActions() {

    if (currentBattle != boss) return;

    javafx.animation.PauseTransition delay =
            new javafx.animation.PauseTransition(javafx.util.Duration.seconds(2));

    delay.setOnFinished(e -> {

        int bossAttackAction = (int)(Math.random() * 3);

        if (bossAttackAction == 0) {
            bossBAttack();
        } 
        else if (bossAttackAction == 1) {
            bossHAttack();
        } 
        else {
            bossSpAttack();
        }

        playerAction = true;
        chaningTurns();
        refreshUi();
    });

    delay.play();
}


    public static void main(String[] args) {
        launch(args);
    }
}
