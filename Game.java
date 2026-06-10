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
    Scene defeatMenuScene;

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
    Label tips;

    private Stage defStage;

    @Override
    public void start(Stage stage){
        defStage = stage;

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

        CheckBox tipsCheckBox = new CheckBox("Display Tips");   

        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-font-size: 30;");

        VBox settingOptions = new VBox(25);
        settingOptions.getChildren().addAll(settingPage, tipsCheckBox, returnButton);

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
        dummyHpLabel = new Label("Dummy HP: " + dummyHP);
        tutorialSkillPointLabel = new Label("Skill Points: " + startingSkillPoints);
        tutorialEnergyLabel = new Label("Energy: " + startingEnergy);
        passiveLabel = new Label("Passive: false");

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
        passiveLabel = new Label("Passive: false");

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

        Button leave = new Button("Leave the battle");
        leave.setStyle("-fx-font-size: 30");

        VBox pause = new VBox(25);
        pause.getChildren().addAll(pauseMenu, battleSettings, leave);


        battleSetting = new Scene(pause, 900, 600);

        Label defeatLabel = new Label("You have been defeated");
        defeatLabel.setStyle("-fx-font-size: 35");

        Button retry = new Button("Retry");
        retry.setStyle("-fx-font-size: 20");

        Button defLeave = new Button("Leave");
        defLeave.setStyle("-fx-font-size: 20");

        VBox defeatLayout = new VBox(25);
        defeatLayout.getChildren().addAll(defeatLabel, defLeave, retry);

        defeatMenuScene = new Scene(defeatLayout, 600, 300);


        startButton.setOnAction(e -> stage.setScene(stages));
        retry.setOnAction(e -> {playerHP = 1200; playerShield = 0; bossHP = 5000; startingSkillPoints = 3; startingEnergy = 0; playerAction = true; passive = false; refreshUi(); stage.setScene(currentBattle);});
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
        defLeave.setOnAction(e -> stage.setScene(stages));
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

        if (currentBattle == tutorial) {
            dummyHP -= ultimateAttackDmg;
            dummyHP = Math.max(0, dummyHP);
            startingEnergy = 0;
        }

            bossHP -= ultimateAttackDmg * stageBuffs;
            bossHP = Math.max(0, bossHP);

            startingEnergy = 0;
            refreshUi();

            stage.setScene(currentBattle);
    });

        healingUlt.setOnAction(e -> {
            if (startingEnergy < maxEnergy) return;

            if(currentBattle == tutorial){
                playerHP += 25;
                playerShield += 50;
                startingEnergy = 0;
            }

            playerHP += 25 * stageBuffs;
            playerShield += 50 * stageBuffs;
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

    // creates a basic attack for the player to use as an attack.
    public void basicAttack() {

        if (!playerAction) return; // if conditions aren't met, rest of the code does not run
        int dmg = basicAttackDmg;

        if(currentBattle == tutorial){ // checks if the scene is the tutorial scene.
            dummyHP -= dmg;
            dummyHP = Math.max(0, dummyHP);
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
        changingTurns();
        refreshUi();
        bossActions();
    }

    // method to change turn labels to show the actions.
    public void changingTurns(){

        if (playerAction){
            turnBar.setText("Turn: Player");
        }
        else{
            turnBar.setText("Turn: Boss");
        }
    }

    // method to change the passive label to the conditions of passiveAnnouncer.
    public void passiveAnnouncer(){

        if(passive == true){
            passiveLabel.setText("Passive: true");
        }
        else{
            passiveLabel.setText("Passive: false");
        }
    }

    // creates a special attack which checks if the player has enough skill points to use a skill ,etc.
    public void specialAttack() {

        if (!playerAction) return; // if it is not the player's action, then the rest of the code does not run.
        if (startingSkillPoints <= minSkillPoints){ 
            return;
        }
        if (startingSkillPoints > minSkillPoints) { // if skill points is greater than min skillpoints(0), the condition of the code runs the rest
            
            int dmg = specialAttackDmg;

            if(currentBattle == tutorial){
                dummyHP -= dmg;
                dummyHP = Math.max(0, dummyHP);
                startingSkillPoints--;
                startingEnergy = Math.min(startingEnergy + 30, maxEnergy); // increases energy for ultimate charge
                refreshUi(); //refreshes the labels
                return; //ignores the code if the condition doesn't match
            }

            bossHP -= dmg * stageBuffs;

            startingSkillPoints--;
            startingEnergy = Math.min(startingEnergy + 30, maxEnergy);

            bossHP = Math.max(0, bossHP);

        }

            if (passive){
                passive = false;
                playerAction = true;
                passiveAnnouncer();
                refreshUi();
                return;
            }

            passive = false;
            changingTurns();
            refreshUi();
            bossActions();
        }

        // method for boss's basic attack
    public void bossBAttack(){

            int dmg = bossBasicAttack;

            if (playerShield > 0){
                int absorb = Math.min(playerShield, dmg);
                playerShield -= absorb;
                dmg -= absorb;
            }

            playerHP -= dmg;

            playerHP = Math.max(0, playerHP);

            if (playerHP <= 0){
                defeat();
                return;
            }
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

        if (playerHP <= 0){
            defeat();
        }
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

        if (playerHP <= 0){
            defeat();
            return;
        }
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

        if (playerHP <= 0){
            defeat();
            return;
        }

        playerAction = true;
        changingTurns();
        refreshUi();
    });

    delay.play();
    }

    public void defeat(){
       defStage.setScene(defeatMenuScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
    }

    