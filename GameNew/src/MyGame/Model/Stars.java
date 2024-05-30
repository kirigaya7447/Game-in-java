package MyGame.Model;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Stars {
    private Image star;
    private static int velo = 5;
    private int width, height;
    private int x, y;
    private boolean visible;

    public Stars(int x, int y){
        this.x = x;
        this.y = y;
        visible = true;
    }

    public void load(){
        ImageIcon reference = new ImageIcon("/home/admin/Área de trabalho/GitHub/Game-in-java/GameNew/src/Images/star.png");
        star = reference.getImage();

        this.height = star.getHeight(null);
        this.width = star.getWidth(null);
    }

    public void update(){
        if(x < 0){
            this.x = width;

            Random numX = new Random();
            int som = numX.nextInt(500);
            this.x = som + 2048;

            Random numY = new Random();
            this.y = numY.nextInt(1456);
        }
        else{
            this.x -= velo;
        }
    }

    public Image getImage(){
        return star;
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

    public static void setVelo(int veloc){
        velo = veloc;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

}
