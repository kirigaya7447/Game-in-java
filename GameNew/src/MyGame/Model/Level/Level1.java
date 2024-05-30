package MyGame.Model.Level;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import MyGame.Model.Player;

public class Level1 extends JPanel implements ActionListener{
    private Image fundo;
    private Player player;

    public Level1(){
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon reference = new ImageIcon("/home/admin/Área de trabalho/GitHub/Game-in-java/GameNew/src/Images/fundo-preto.jpg");
        fundo = reference.getImage();
    }

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(fundo, 0, 0, null);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}