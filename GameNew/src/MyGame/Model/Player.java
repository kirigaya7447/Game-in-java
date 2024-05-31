package MyGame.Model;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class Player implements ActionListener {
    private int x, y;
    private int dx, dy;
    private int height, width;

    private boolean visible;
    private boolean boost = false;

    private Timer timer;
    private Image player;

    private List<Bullets> bullets;

    public Player(){
        this.x = 100;
        this.y = 100;

        bullets = new ArrayList<Bullets>();

        timer = new Timer(2000, this);
        timer.start();
    }

    public void load(){
        ImageIcon reference = new ImageIcon("/home/admin/Área de trabalho/GitHub/Game-in-java/GameNew/src/Images/nave.png");
        player = reference.getImage();
        height = player.getHeight(null);
        width = player.getWidth(null);
        visible = true;
    }

    public void updateMove(){
        x += dx;
        y += dy;
    }

    public void boost(){
        boost = true;
        ImageIcon reference = new ImageIcon("/home/admin/Área de trabalho/GitHub/Game-in-java/GameNew/src/Images/naveBoost.png");
        player = reference.getImage();
    }

    public Rectangle getBound(){
        return new Rectangle(x, y, height, width);
    }

    public void simpleBullet(){
        this.bullets.add(new Bullets(x + width, y + (height/2)));
        if(bullets.size() >= 20){
            for(int cont = 18; cont <= bullets.size(); cont++){
                bullets.remove(cont);
            }
        }
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
                    simpleBullet();
                }
                break;
            case KeyEvent.VK_E:
                boost();
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
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Image getImage(){
        return player;
    }

    public boolean getBoost(){
        return boost;
    }

    public boolean getVisible(){
        return visible;
    }

    public List<Bullets> getBullets(){
        return bullets;
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
