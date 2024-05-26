package Main;

import javax.swing.*;
import java.awt.Color;

public class Main extends JFrame{
    public static void main(String[] args){
    JFrame janela = new JFrame();
    JPanel painel = new JPanel();
    JLabel texto = new JLabel();

    janela.setDefaultCloseOperation(EXIT_ON_CLOSE);

    janela.setSize(600, 450);
    janela.setLocationRelativeTo(null);

    painel.setBackground(Color.YELLOW);
    painel.setFocusable(true);

    texto.setText("Olá Marilene!");

    painel.add(texto);
    janela.add(painel);

    janela.setVisible(true);
    }
}
