package MyGame.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemies_1 {
    private Image image;
    private int width, height;
    private int x, y;
    private static int velo = 1;
    //private static int large = 1; 
    private boolean visible;
    private int life = 10;
    
    public Enemies_1(int x, int y){
        this.x = x;
        this.y = y;
        visible = true;
    }
    
    public void load(){
        ImageIcon reference = new ImageIcon("/home/joao4774/Documentos/Linguagens de programação/Java/Game-in-java/Game/src/main/java/Images/alien.png");
        image = reference.getImage();
        
        this.height = image.getHeight(null);
        this.width = image.getWidth(null);
    }
    
    public void update(){
        this.x -= velo;
        /*if(x <= large){
            visible = false;
        }*/
    }
    
    public Rectangle getBound(){
        return new Rectangle(x,y,width, height);
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
    
    public int getLife(){
        return life;
    }
    
    public void setLife(int retireLife){
        life -= retireLife;
    }
}
