package MyGame.Modelo;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.List;

public class Fase_1 extends JPanel implements ActionListener {

    private Image fundo;
    private Player player;
    private Timer timer;

    public Fase_1() {
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon reference = new ImageIcon("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Images/fundo-preto.jpg");
        fundo = reference.getImage();

        player = new Player();
        player.load();

        addKeyListener(new tecladoAdapter());

        timer = new Timer(5, this);
        timer.start();

    }

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(fundo, 0, 0, null);
        graphics.drawImage(player.getImage(), player.getX(), player.getY(), this);

        List<Bullets> bullet = player.getBullet();

        for (int cont = 0; cont < bullet.size(); cont++) {
            Bullets b = bullet.get(cont);
            b.load();
            graphics.drawImage(b.getImage(), b.getX(), b.getY(), this);
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.updateMove();
        List<Bullets> bullet = player.getBullet();

        for (int cont = 0; cont < bullet.size(); cont++) {
            Bullets b = bullet.get(cont);
            if (b.getVisible()) {
                b.update();
            } else {
                bullet.remove(b);
            }
        }

        repaint();
    }

    private class tecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }

}
