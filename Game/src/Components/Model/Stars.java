package Components.Model;

import java.awt.Image;
import javax.swing.ImageIcon;

import java.util.Random;

public class Stars {

    private static int velo = 5;
    private Image image;
    private int width, height;
    private int x, y;
    //private static int large = 1; 
    private boolean visible;

    public Stars(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;
    }

    public void load() {
        ImageIcon reference = new ImageIcon("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Images/star.png");
        image = reference.getImage();

        this.height = image.getHeight(null);
        this.width = image.getWidth(null);
    }

    public void update() {
        if (x < 0) {
            this.x = width;
            Random numX = new Random();
            int som = numX.nextInt(500);
            this.x = som + 2048;

            Random numY = new Random();
            this.y = numY.nextInt(1456);
        } else {
            this.x -= velo;
        }
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

    public static void setVelo(int veloc) {
        velo = veloc;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
