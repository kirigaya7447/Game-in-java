package MyGame.Modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import java.util.List;
import java.util.ArrayList;

public class Player {

    private int x, y;
    private int dx, dy;
    private int height, width;
    private Image image;

    private List<Bullets> bullet;

    public Player() {
        this.x = 100;
        this.y = 100;

        bullet = new ArrayList<Bullets>();
    }

    public void load() {
        ImageIcon reference = new ImageIcon("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Images/nave.png");
        image = reference.getImage();
        height = image.getHeight(null);
        width = image.getWidth(null);
    }

    public void updateMove() {
        x += dx;
        y += dy;
    }

    public void simpleBullet() {
        this.bullet.add(new Bullets(x + width, y + (height / 2)));
        System.out.println("Balas: " + bullet.size());
        if (bullet.size() == 6) {
            for (int cont = 4; cont <= 6; cont++) {
                bullet.remove(cont);
            }
        }
    }

    public void keyPressed(KeyEvent pressioned) {
        int numTecla = pressioned.getKeyCode();
        switch (numTecla) {
            case KeyEvent.VK_UP:
                dy = -3;
                break;

            case KeyEvent.VK_DOWN:
                dy = 3;
                break;

            case KeyEvent.VK_LEFT:
                dx = -3;
                break;

            case KeyEvent.VK_RIGHT:
                dx = 3;
                break;
            case KeyEvent.VK_SPACE:
                simpleBullet();
                break;
        }
    }

    public void keyReleased(KeyEvent released) {
        int numTecla = released.getKeyCode();
        switch (numTecla) {
            case KeyEvent.VK_UP:
                dy = 0;
                break;

            case KeyEvent.VK_DOWN:
                dy = 0;
                break;

            case KeyEvent.VK_LEFT:
                dx = 0;
                break;

            case KeyEvent.VK_RIGHT:
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
}