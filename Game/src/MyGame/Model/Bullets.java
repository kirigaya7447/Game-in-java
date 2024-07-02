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
        //instância de imageicon
        ImageIcon reference = new ImageIcon("/home/userComum/Área de trabalho/GitHub/Game-in-java/Game/src/Images/bullet.png");
        //recebe a imagem
        bullet = reference.getImage();

        //seta a altura e largura com base na imagem
        height = bullet.getHeight(null);
        width = bullet.getWidth(null);
    }

    public void update(){
        //altera a posição com base na velocidade
        this.x += velo;
        //se x for maior que a largura da tela, some a imagem
        if(x >= large){
            visible = false;
        }
    }

    //retorna um retângulo com posição e tamanho
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
