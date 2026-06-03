import javafx.application.Application;
import javafx.stage.Stage;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Game extends Application {
    JFrame menu;
    Container con;
    JPanel titlePanel;
    JLabel titleNamePanel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);

    public static void main (String[]args){

        launch(args);
    }

    public Game(){

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

        titlePanel.add(titleNamePanel);
        con.add(titleNamePanel);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }


}

