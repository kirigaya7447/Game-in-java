package MyGame.Modelo;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Fase_1 extends JPanel implements ActionListener {

    private Image fundo;
    private Player player;      
    private Timer timer;
    private List<Enemies_1> enemies1;
    private List<Stars> stars;
    private boolean gameStarted = true;

    public Fase_1() {
        if (gameStarted) {
            setFocusable(true);
            setDoubleBuffered(true);
            ImageIcon reference = new ImageIcon("/home/admin/Área de trabalho/GitHub/Game-in-java/GameOriginal/src/main/java/Images/fundo-preto.jpg");
            fundo = reference.getImage();
            gameStarted = true;

            player = new Player();
            player.load();

            addKeyListener(new tecladoAdapter());

            timer = new Timer(5, this);
            timer.start();

            initStars();
            initEnemyes1();
        }
    }

    public void initEnemyes1() {
        int coord[] = new int[1000];
        enemies1 = new ArrayList<Enemies_1>();
        for (int cont = 0; cont < coord.length; cont++) {
            int randomX = (int) (Math.random() * 6000 + 1024);
            int randomY = (int) (Math.random() * 650 + 30);
            enemies1.add(new Enemies_1(randomX, randomY));
        }
    }

    public void initStars() {
        int coord[] = new int[1500];
        stars = new ArrayList<Stars>();
        for (int cont = 0; cont < coord.length; cont++) {
            int randomX = (int) (Math.random() * 1200 + 0);
            int randomY = (int) (Math.random() * 1024 + 0);
            stars.add(new Stars(randomX, randomY));
        }
    }

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(fundo, 0, 0, null);

        for (int cont = 0; cont < stars.size(); cont++) {
            Stars star = stars.get(cont);
            star.load();
            graphics.drawImage(star.getImage(), star.getX(), star.getY(), this);
        }

        graphics.drawImage(player.getImage(), player.getX(), player.getY(), this);

        if (gameStarted) {
            List<Bullets> bullet = player.getBullet();

            for (int cont = 0; cont < bullet.size(); cont++) {
                Bullets b = bullet.get(cont);
                b.load();
                graphics.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }

            for (int cont = 0; cont < enemies1.size(); cont++) {
                Enemies_1 enem = enemies1.get(cont);
                enem.load();
                graphics.drawImage(enem.getImage(), enem.getX(), enem.getY(), this);
            }
        } else {
            ImageIcon reference = new ImageIcon("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Images/game-over.jpg");
            fundo = reference.getImage();
            graphics.drawImage(fundo, 0, 0, null);
        }

        g.dispose();
    }

    public void checkCollisions() {
        Rectangle naveRet = player.getBound();
        Rectangle bulletsRet;
        Rectangle enemyRet;

        for (int cont = 0; cont < enemies1.size(); cont++) {
            Enemies_1 enemy1 = enemies1.get(cont);
            enemyRet = enemy1.getBound();
            if (naveRet.intersects(enemyRet)) {
                if (player.getBoost()) {
                    enemy1.setVisible(false);
                    enemy1.getAudioBoost();
                } else {
                    player.setVisible(false);
                    enemy1.setVisible(false);
                    gameStarted = false;
                }
            }
        }

        List<Bullets> bulletList = player.getBullet();
        for (int cont = 0; cont < bulletList.size(); cont++) {
            Bullets bullet = bulletList.get(cont);
            bulletsRet = bullet.getBound();

            for (int cont1 = 0; cont1 < enemies1.size(); cont1++) {
                Enemies_1 enemy1 = enemies1.get(cont1);
                enemyRet = enemy1.getBound();
                if (bulletsRet.intersects(enemyRet)) {
                    enemy1.setLife(bullet.getDamage());
                    if (enemy1.getLife() <= 0) {
                        enemy1.setVisible(false);
                        enemy1.getAudio();
                    }
                    bullet.setVisible(false);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e
    ) {
        player.updateMove();
        if (player.getBoost()) {
            timer.setDelay(2);
        } else {
            timer.setDelay(5);
        }

        for (int cont = 0; cont < stars.size(); cont++) {
            Stars s = stars.get(cont);
            if (s.getVisible()) {
                s.update();
            } else {
                stars.remove(s);
            }
        }

        List<Bullets> bullet = player.getBullet();

        for (int cont = 0; cont < bullet.size(); cont++) {
            Bullets b = bullet.get(cont);
            if (b.getVisible()) {
                b.update();
                if (player.getBoost()) {
                    bullet.get(cont).setVelo(-1);
                } else {
                    bullet.get(cont).setVelo(2);
                }
            } else {
                bullet.remove(b);
            }
        }

        for (int cont = 0; cont < enemies1.size(); cont++) {
            Enemies_1 enem = enemies1.get(cont);
            if (enem.getVisible()) {
                enem.update();
            } else {
                enemies1.remove(cont);
            }
        }

        checkCollisions();
        repaint();
        if (gameStarted == false) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Game Over :(", JOptionPane.OK_CANCEL_OPTION);
            if (confirm == 0) {
                gameStarted = true;
                ImageIcon reference = new ImageIcon("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Images/fundo-preto.jpg");
                fundo = reference.getImage();
                player = new Player();
                player.load();
            } else {
                System.exit(0);
            }
        }
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
