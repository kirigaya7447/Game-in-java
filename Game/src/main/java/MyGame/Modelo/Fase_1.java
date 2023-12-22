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
import java.util.ArrayList;

public class Fase_1 extends JPanel implements ActionListener {

    private Image fundo;
    private Player player;
    private Timer timer;
    private List<Enemyes_1> enemyes1;

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

        initEnemyes1();

    }

    public void initEnemyes1() {
        int coord[] = new int[40];
        enemyes1 = new ArrayList<Enemyes_1>();
        for (int cont = 0; cont < coord.length; cont++) {
            int randomX = (int) (Math.random() * 6000 + 1024);
            int randomY = (int) (Math.random() * 650 + 30);
            enemyes1.add(new Enemyes_1(randomX, randomY));
        }
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

        for (int cont = 0; cont < enemyes1.size(); cont++) {
            Enemyes_1 enem = enemyes1.get(cont);
            enem.load();
            graphics.drawImage(enem.getImage(), enem.getX(), enem.getY(), this);
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

        for (int cont = 0; cont < enemyes1.size(); cont++) {
            Enemyes_1 enem = enemyes1.get(cont);
            if (enem.getVisible()) {
                enem.update();
            } else {
                enemyes1.remove(cont);
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
