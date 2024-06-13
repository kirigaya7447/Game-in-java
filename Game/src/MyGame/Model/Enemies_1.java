package MyGame.Model;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enemies_1 {
    private static int velo = 1;
    private Image alien;
    private int height, width;
    private int x,y;
    private boolean visible;
    private int life = 10;

    public Enemies_1(int x, int y){
        this.x = x;
        this.y = y;
        visible = true;
    }

    public void load(){
        ImageIcon reference = new ImageIcon("/home/userComum/Área de trabalho/GitHub/Game-in-java/Game/src/Images/alien.png");
        alien = reference.getImage();

        height = alien.getHeight(null);
        width = alien.getWidth(null);
    }

    public void update(){
        this.x -= velo;
    }

    public Rectangle getBound(){
        return new Rectangle(x, y, width, height);
    }

    public void getAudio(){
        try{
            File enemyDieSong = new File("/home/userComum/Área de trabalho/GitHub/Game-in-java/Game/src/Sounds/oof.wav");
            AudioInputStream stream = AudioSystem.getAudioInputStream(enemyDieSong);
            Clip toque = AudioSystem.getClip();
            toque.open(stream);
            toque.start();
        }
        catch(Exception err){
            System.err.println("Erro no som da morte do inimigo: " + err);
        }
    }

    public void getAudioBoost(){
        try{
            File enemyDieBoost = new File("/home/userComum/Área de trabalho/GitHub/Game-in-java/Game/src/Sounds/nossa.wav");
            AudioInputStream stream = AudioSystem.getAudioInputStream(enemyDieBoost);
            Clip toque = AudioSystem.getClip();
            toque.open(stream);
            toque.start();
        }
        catch(Exception err){
            System.err.println("Erro no som da morte em boost do inimigo: " + err);
        }
    }

    public Image getImage(){
        return alien;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getVelo(){
        return velo;
    }

    public boolean getVisible(){
        return visible;
    }

    public int getLife(){
        return life;
    }

    public static void setVelo(int veloc){
        velo = veloc;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

    public void setLife(int retireLife){
        life -= retireLife;
    }
}
