package MyGame.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Bullets {

    private static final int large = 2048;
    private static int velo = 2;
    private static int damage = 5;
    private Image image;
    private int x, y;
    private int width, height;
    private boolean visible;

    public Bullets(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;
    }

    public void load() {
        ImageIcon reference = new ImageIcon("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Images/bullet.png");
        image = reference.getImage();

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public void update() {
        this.x += velo;
        if (x >= large) {
            visible = false;
        }
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, width, height);
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVelo() {
        return velo;
    }

    public void setVelo(int veloc) {
        velo = veloc;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getDamage() {
        return damage;
    }
}
