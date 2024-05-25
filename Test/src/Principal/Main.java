package Principal;

import java.awt.Color;
import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        JFrame app = new JFrame();
        JPanel painel = new JPanel();
        JLabel label = new JLabel();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        app.setSize(550, 400);
        app.setLocationRelativeTo(null);

        painel.setFocusable(true);
        painel.setBackground(Color.black);

        label.setText("Hello Everyone, it's cool!");
        label.setBackground(Color.white);

        painel.add(label);

        app.add(painel);

        app.setVisible(true);
    }
}
