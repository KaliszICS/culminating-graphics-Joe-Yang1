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
    int maxSkillPoints = 6;
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

    Label playerHpLabel;
    Label bossHpLabel;
    Label dummyHpLabel;
    Label skillPointLabel;
    Label energyLabel;

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

        playerHpLabel = new Label("Player HP: " +playerHP);
        dummyHpLabel = new Label("Dummy Hp: Inf");
        skillPointLabel = new Label("Skill points: " + startingSkillPoints);
        energyLabel = new Label("Energy: " + startingEnergy);

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

        playerHpLabel = new Label("Player HP: " +playerHP);
        dummyHpLabel = new Label("Dummy Hp: " + dummyHP);
        skillPointLabel = new Label("Skill points: " + startingSkillPoints);
        energyLabel = new Label("Energy: " + startingEnergy);

        VBox tutorialLayout = new VBox(25);
        tutorialLayout.getChildren().addAll(gameStage, basicAttack, specialAttack, ultimateAttack, playerHpLabel, dummyHpLabel, skillPointLabel, energyLabel);

        tutorial = new Scene(tutorialLayout, 900, 600);


        Label bossPage = new Label("Boss Stage");
        bossPage.setStyle("-fx-font-size: 50");

        Button bAttack = new Button("Basic Attack");
        bAttack.setStyle("-fx-font-size: 30;");

        Button spAttack = new Button("Special Attack");
        spAttack.setStyle("-fx-font-size: 30;");

        Button ultAttack = new Button("Ultimate Attack");
        ultAttack.setStyle("-fx-font-size: 30;");

        playerHpLabel = new Label("Player HP: " +playerHP);
        bossHpLabel = new Label("Boss HP: " + bossHP);
        skillPointLabel = new Label("Skill points: " + startingSkillPoints);
        energyLabel = new Label("Energy: " + startingEnergy);

        VBox bossLayout = new VBox(25);
        bossLayout.getChildren().addAll(bossPage, bAttack, spAttack, ultAttack, playerHpLabel, bossHpLabel, skillPointLabel, energyLabel );
        
        boss = new Scene(bossLayout, 900, 600);


        startButton.setOnAction(e -> stage.setScene(stages));

        settingButton.setOnAction(e -> stage.setScene(setting));

        returnButton.setOnAction(e -> stage.setScene(menu));

        tutorialStage.setOnAction(e -> stage.setScene(tutorial));

        bossStage.setOnAction(e -> stage.setScene(boss));

        rtButton.setOnAction(e -> stage.setScene(menu));



        basicAttack.setOnAction(e -> {basicAttack(); refreshUi(); });

        specialAttack.setOnAction(e -> {specialAttack(); refreshUi(); });

        ultimateAttack.setOnAction(e -> {ultimateAttack(); refreshUi(); });

        bAttack.setOnAction(e -> {basicAttack(); refreshUi(); });

        spAttack.setOnAction(e -> {specialAttack(); refreshUi(); });

        ultAttack.setOnAction(e -> {ultimateAttack(); refreshUi(); });

        stage.setTitle("Untitled");
        stage.setScene(menu);
        stage.show();
    }

    public void refreshUi() {

    if (playerHpLabel != null) {
        playerHpLabel.setText("Player HP: " + playerHP);
    }

    if (dummyHpLabel != null) {
        dummyHpLabel.setText("Dummy HP: " + dummyHP);
    }

    if (bossHpLabel != null) {
        bossHpLabel.setText("Boss HP: " + bossHP);
    }

    if (skillPointLabel != null) {
        skillPointLabel.setText("Skill Points: " + startingSkillPoints);
    }

    if (energyLabel != null) {
        energyLabel.setText("Energy: " + startingEnergy);
    }
}

   public void basicAttack() {

    dummyHP -= basicAttackDmg;
    bossHP -= basicAttackDmg * stageBuffs;

    startingSkillPoints = Math.min(startingSkillPoints + 1, maxSkillPoints);

    startingEnergy = Math.min(startingEnergy + 25, maxEnergy);

    bossHP = Math.max(0, bossHP);

    playerAction = false;

    if (bossHP == 0) {
        System.out.println("Boss Defeated!");
    }
}

   public void specialAttack() {

    if (startingSkillPoints > minSkillPoints) {

        dummyHP -= specialAttackDmg;
        bossHP -= specialAttackDmg * stageBuffs;

        startingSkillPoints--;

        startingEnergy = Math.min(startingEnergy + 30, maxEnergy);

        bossHP = Math.max(0, bossHP);

        playerAction = false;

        if (bossHP == 0) {
            System.out.println("Boss Defeated!");
        }
    }
}

   public void ultimateAttack() {

    if (startingEnergy >= maxEnergy) {

        dummyHP -= ultimateAttackDmg;
        bossHP -= ultimateAttackDmg * stageBuffs;

        startingEnergy = minEnergy;

        playerHP += ultimateAttackHeal;

        bossHP = Math.max(0, bossHP);

        playerAction = false;

        if (bossHP == 0) {
            System.out.println("Boss Defeated!");
        }
    }
}

    public static void main(String[] args) {
        launch(args);
    }
}





