
import javafx.application.Application;
import javafx.stage.Stage;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Game extends Application {
    JFrame menu;
    Container con;
    JPanel titlePanel;
    JPanel startButton;
    JLabel titleNamePanel;
    JButton start;
    Font textFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);

    public static void main (String[]args){

        launch(args);
    }

    public void Menu(){

        menu = new JFrame();
        menu.setSize(800, 600);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.getContentPane().setBackground(Color.white);
        menu.setVisible(true);
        con = menu.getContentPane();

        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100 , 600, 150);
        titleNamePanel = new JLabel("Untitled");
        titleNamePanel.setForeground(Color.BLACK);
        titleNamePanel.setFont(titleFont);

        startButton = new JPanel();
        startButton.setBounds(400, 300, 200, 100);
        startButton.setBackground(Color.BLACK);

        start = new JButton("Start");
        start.setForeground(Color.BLACK);
        start.setForeground(Color.WHITE);
        start.setFont(textFont);


        titlePanel.add(titleNamePanel);
        startButton.add(start);

        con.add(titleNamePanel);
        con.add(start);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }



}