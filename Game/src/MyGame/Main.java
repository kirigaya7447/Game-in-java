package MyGame;

import javax.swing.JFrame;
import MyGame.Model.Level.Level1;

public class Main extends JFrame{
    public Main(){
        add(new Level1());
        setTitle("Game Nave");
        setSize(1024, 768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);
    }
    public static void main(String[] args){
    new Main();
    }
}