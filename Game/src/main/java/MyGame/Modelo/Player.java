package MyGame.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import java.util.List;
import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Player implements ActionListener {

    private int x, y;
    private int dx, dy;
    private int height, width;
    private Image image;
    private boolean visible;
    private boolean boost = false;
    private Timer timer;

    private List<Bullets> bullet;

    public Player() {
        this.x = 100;
        this.y = 100;

        bullet = new ArrayList<Bullets>();

        timer = new Timer(2000, this);
        timer.start();
    }

    public void load() {
        ImageIcon reference = new ImageIcon("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Images/nave.png");
        image = reference.getImage();
        height = image.getHeight(null);
        width = image.getWidth(null);
        visible = true;
    }

    public void updateMove() {
        x += dx;
        y += dy;
    }

    public void simpleBullet() {
        this.bullet.add(new Bullets(x + width, y + (height / 2)));
        if (bullet.size() == 20) {
            for (int cont = 18; cont <= bullet.size(); cont++) {
                bullet.remove(cont);
            }
        }
    }

    public void boost() {
        boost = true;
        ImageIcon reference = new ImageIcon("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Images/naveBoost.png");
        image = reference.getImage();

    }

    public Rectangle getBound() {
        return new Rectangle(x, y, width, height);
    }

    public void keyPressed(KeyEvent pressioned) {
        int numTecla = pressioned.getKeyCode();
        switch (numTecla) {
            case KeyEvent.VK_UP:
                dy = -3;
                break;

            case KeyEvent.VK_W:
                dy = -3;
                break;

            case KeyEvent.VK_DOWN:
                dy = 3;
                break;

            case KeyEvent.VK_S:
                dy = 3;
                break;

            case KeyEvent.VK_LEFT:
                dx = -3;
                break;

            case KeyEvent.VK_A:
                dx = -3;
                break;

            case KeyEvent.VK_RIGHT:
                dx = 3;
                break;

            case KeyEvent.VK_D:
                dx = 3;
                break;

            case KeyEvent.VK_SPACE:
                if (boost == false) {
                    simpleBullet();
                }
                break;

            case KeyEvent.VK_E:
                boost();
                break;
        }
    }

    public void keyReleased(KeyEvent released) {
        int numTecla = released.getKeyCode();
        switch (numTecla) {
            case KeyEvent.VK_UP:
                dy = 0;
                break;

            case KeyEvent.VK_W:
                dy = 0;
                break;

            case KeyEvent.VK_DOWN:
                dy = 0;
                break;

            case KeyEvent.VK_S:
                dy = 0;
                break;

            case KeyEvent.VK_LEFT:
                dx = 0;
                break;

            case KeyEvent.VK_A:
                dx = 0;
                break;

            case KeyEvent.VK_RIGHT:
                dx = 0;
                break;

            case KeyEvent.VK_D:
                dx = 0;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public List<Bullets> getBullet() {
        return bullet;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getBoost() {
        return boost;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (boost) {
            boost = false;
        } else {
            load();
        }
    }
}
