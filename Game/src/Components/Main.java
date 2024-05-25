package Components;

import javax.swing.JFrame;

import Components.Model.Fase_1;

public class Main extends JFrame {

    public Main() {
        setTitle("Game pica 2D!!!");
        setSize(1024, 728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);

        add(new Fase_1());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
