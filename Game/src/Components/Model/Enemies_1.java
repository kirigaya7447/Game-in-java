package Components.Model;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enemies_1 {

    private static int velo = 1;
    private Image image;
    private int width, height;
    private int x, y;
    private boolean visible;
    private int life = 10;

    public Enemies_1(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;
    }

    public void load() {
        ImageIcon reference = new ImageIcon("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Images/alien.png");
        image = reference.getImage();

        this.height = image.getHeight(null);
        this.width = image.getWidth(null);
    }

    public void update() {
        this.x -= velo;
        /*if(x <= large){
            visible = false;
        }*/
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, width, height);
    }

    public void getAudio() {
        try {
            File deathEnemySond = new File("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Sounds/oof.wav");
            AudioInputStream stream = AudioSystem.getAudioInputStream(deathEnemySond);
            Clip toque = AudioSystem.getClip();
            toque.open(stream);
            toque.start();
        } catch (Exception err) {
            System.err.println(err);
        }
    }

    public void getAudioBoost() {
        try {
            File deathSpecial = new File("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Sounds/nossa.wav");
            AudioInputStream stream = AudioSystem.getAudioInputStream(deathSpecial);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        } catch (Exception err) {
            System.err.println(err);
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

    public int getLife() {
        return life;
    }

    public void setLife(int retireLife) {
        life -= retireLife;
    }
}
