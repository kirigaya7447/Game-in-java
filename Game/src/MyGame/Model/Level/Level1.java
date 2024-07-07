package MyGame.Model.Level;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import MyGame.Model.Bullets;
import MyGame.Model.Enemies_1;
import MyGame.Model.Player;
import MyGame.Model.Stars;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Level1 extends JPanel implements ActionListener{
    private Image fundo;
    private Player player;
    private Timer timer;
    private List<Enemies_1> enemies_1;
    private List<Stars> stars;
    private boolean gameStarted = true;

    public Level1(){
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon reference = new ImageIcon("src/Images/fundo-preto.jpg");
        fundo = reference.getImage();
        gameStarted = true;

        player = new Player();
        player.load();

        addKeyListener(new TableAdapter());

        timer = new Timer(500, this);
        timer.start();

        initStars();
        initEnemies1();
    }

    public void initEnemies1(){
        int coord[] = new int[60];
        enemies_1 = new ArrayList<Enemies_1>();
        for(int cont = 0; cont < coord.length; cont++){
            int randomX = (int) (Math.random() * 9000 + 1024);
            int randomY = (int) (Math.random() * 850 + 30);
            enemies_1.add(new Enemies_1(randomX, randomY));
        }
    }

    public void initStars(){
        int coord[] = new int[1500];
        stars = new ArrayList<Stars>();
        for(int cont = 0; cont < coord.length; cont++){
            int randomX = (int) (Math.random() * 1200 + 0);
            int randomY = (int) (Math.random() * 1024 + 0);
            stars.add(new Stars(randomX, randomY));
        }
    }

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(fundo, 0, 0, null);

        for(int cont = 0; cont < stars.size(); cont++){
            Stars star = stars.get(cont);
            star.load();
            graphics.drawImage(star.getImage(), star.getX(), star.getY(), this);
        }

        graphics.drawImage(player.getImage(), player.getX(), player.getY(), this);

        if (gameStarted) {
            List<Bullets> bullets = player.getBullets();
            for(int cont = 0; cont < bullets.size(); cont++){
                Bullets bullet = bullets.get(cont);
                bullet.load();
                graphics.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), this);
            }

            for(int cont = 0; cont < enemies_1.size(); cont++) {
                Enemies_1 enemy = enemies_1.get(cont);
                enemy.load();
                graphics.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);

            }
        }
        else{
            ImageIcon reference = new ImageIcon("src/Images/game-over.jpg");
            fundo = reference.getImage();
            graphics.drawImage(fundo, 0, 0, null);
        }

        g.dispose();
    }

    public void checkColisions(){
        Rectangle retPlayer = player.getBound();
        Rectangle retEnemy;
        Rectangle retBullet;

        for(int cont = 0; cont < enemies_1.size(); cont++){
            Enemies_1 enemy = enemies_1.get(cont);
            retEnemy = enemy.getBound();
            if(retPlayer.intersects(retEnemy)){
                if(player.getBoost()){
                    enemy.setLife(0);
                    enemy.setVisible(false);
                    enemy.getAudioBoost();
                }
                else{
                    player.setVisible(false);
                    enemy.setVisible(false);
                    gameStarted = false;
                }
            }
        }

        List<Bullets> bulletList = player.getBullets();
        for(int cont = 0; cont < bulletList.size(); cont++){
            Bullets bullet = bulletList.get(cont);
            retBullet = bullet.getBound();


            for(int cont1 = 0; cont1 < enemies_1.size(); cont1++) {
                Enemies_1 enemy = enemies_1.get(cont1);
                retEnemy = enemy.getBound();
                if (retBullet.intersects(retEnemy)) {
                    enemy.setLife(bullet.getDamage());
                    if(enemy.getLife() <= 0){
                        enemy.getAudio();
                        enemy.death();
                        enemy.setVisible(false);
                    }
                    bullet.setVisible(false);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.updateMove();
        if(player.getBoost()){
            timer.setDelay(3);
        }
        else{
            timer.setDelay(5);
        }

        for(int cont = 0; cont < stars.size(); cont++){
            Stars star = stars.get(cont);
            if(star.getVisible()){
                star.update();
            }
            else{
                stars.remove(cont);
            }
        }

        List<Bullets> bulletList = player.getBullets();

        for(int cont = 0; cont < bulletList.size(); cont++){
            Bullets bullet = bulletList.get(cont);
            if(bullet.getVisible()){
                bullet.update();
                if(player.getBoost()){
                    bulletList.get(cont).setVelo(1);
                }
                else{
                    bulletList.get(cont).setVelo(2);
                }
            }
            else{
                bulletList.remove(cont);
            }
        }

        for(int cont = 0; cont < enemies_1.size(); cont++){
            Enemies_1 enemy = enemies_1.get(cont);
            if(enemy.getVisible()){
                enemy.update();
            }
            else{
                enemies_1.remove(cont);
            }
        }

        checkColisions();
        repaint();

        if(gameStarted == false){
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Game Over", JOptionPane.OK_CANCEL_OPTION);
            if(confirm == 0){
                gameStarted = true;
                ImageIcon reference = new ImageIcon("src/Images/fundo-preto.jpg");
                fundo = reference.getImage();
                player = new Player();
                initEnemies1();
                player.load();
            }
            else{
                System.exit(0);
            }
        }
    }

    private class TableAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
        }

        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
        }
    }
}