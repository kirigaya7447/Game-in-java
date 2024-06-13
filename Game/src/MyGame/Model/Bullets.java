package MyGame.Model;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Bullets {
    private static final int large = 2048;
    private static int velo = 2;
    private static int damage = 5;
    private Image bullet;
    private int height, width;
    private int x,y;
    private boolean visible;

    public Bullets(int x, int y){
        this.x = x;
        this.y = y;

        visible = true;
    }

    public void load(){
        ImageIcon reference = new ImageIcon("/home/userComum/Área de trabalho/GitHub/Game-in-java/Game/src/Images/bullet.png");
        bullet = reference.getImage();

        height = bullet.getHeight(null);
        width = bullet.getWidth(null);
    }

    public void update(){
        this.x += velo;
        if(x >= large){
            visible = false;
        }
    }

    public Rectangle getBound(){
        return new Rectangle(x, y, width, height);
    }

    public Image getImage(){
        return bullet;
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

    public int getDamage(){
        return damage;
    }

    public void setVelo(int veloc){
        velo = veloc;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }
}
