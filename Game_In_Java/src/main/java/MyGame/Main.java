package MyGame;

import javax.swing.JFrame;
import MyGame.Modelo.Fase_1;

public class Main extends JFrame {

    public Main() {
        add(new Fase_1());
        setTitle("Game pica 2D!!!");
        setSize(1024, 728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
