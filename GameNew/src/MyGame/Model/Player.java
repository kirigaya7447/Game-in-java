package MyGame.Model;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import java.util.List;

import javax.swing.Timer;

public class Player {
    private int x, y;
    private int dx, dy;
    private int height, width;

    private boolean visible;
    private boolean boost = false;

    private Timer timer;
    private Image image;

    public Player(){
        this.x = 100;
        this.y = 100;

        timer = new Timer(2000, null);
        timer.start();
    }

    public void load(){
        ImageIcon reference = new ImageIcon("/home/admin/Área de trabalho/GitHub/Game-in-java/GameNew/src/Images/nave.png");
        image = reference.getImage();
        height = image.getHeight(null);
        width = image.getWidth(null);
        visible = true;
    }

    public void updateMove(){
        x += dx;
        y += dy;
    }

    public void boost(){
        boost = true;
        ImageIcon reference = new ImageIcon("/home/admin/Área de trabalho/GitHub/Game-in-java/GameNew/src/Images/naveBoost.png");
        image = reference.getImage();
    }

    public Rectangle getBound(){
        return new Rectangle(x, y, height, width);
    }

    public void keyPressed(KeyEvent keyPressioned){
        int numTecla = keyPressioned.getKeyCode();
        switch(numTecla){
            case KeyEvent.VK_UP:
                dy += 3;
                break;
            case KeyEvent.VK_DOWN:
                dy -= 3;
                break;
            case KeyEvent.VK_LEFT:
                dx -= 3;
                break;
            case KeyEvent.VK_RIGHT:
                dx += 3;
                break;
            case KeyEvent.VK_W:
                dy += 3;
                break;
            case KeyEvent.VK_S:
                dy -= 3;
                break;
            case KeyEvent.VK_A:
                dx -= 3;
                break;
            case KeyEvent.VK_D:
                dx += 3;
                break;
            case KeyEvent.VK_SPACE:
                if(boost == false){

                }
                break;
            case KeyEvent.VK_E:
                //boost();
                break;
        }
    }

    public void keyReleased(KeyEvent keyPressioned){
        int numTecla = keyPressioned.getKeyCode();
        switch(numTecla){
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
            case KeyEvent.VK_W:
                dy = 0;
                break;
            case KeyEvent.VK_S:
                dy = 0;
                break;
            case KeyEvent.VK_A:
                dx = 0;
                break;
            case KeyEvent.VK_D:
                dx = 0;
                break;
            case KeyEvent.VK_SPACE:
                if(boost == false){

                }
                break;
            case KeyEvent.VK_E:
                //boost();
                break;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return x;
    }

    public int getImage(){
        return x;
    }

    /*public int getBUllets(){
        return x;
    }*/

    public boolean getBoost(){
        return boost;
    }

    public boolean getVisible(){
        return visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(boost){
            boost = false;
        }
        else{
            load();
        }
    }

}
