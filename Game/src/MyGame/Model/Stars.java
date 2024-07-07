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

    //carrega a imagem das estrelas
    public void load(){
        //cria uma instância de imageicon
        ImageIcon reference = new ImageIcon("src/Images/star.png");
        //star recebe a imagem
        star = reference.getImage();

        //seta altura e largura
        this.height = star.getHeight(null);
        this.width = star.getWidth(null);
    }

    //toda vez que é chamada, faz o objeto se mover
    public void update(){
        if(x < 0){
            //instância de random
            Random numX = new Random();
            //gera um número aleatório
            int som = numX.nextInt(501);
            //soma o número aleatório para posicionamento à frente do jogador
            this.x = som + 2048;

            //gera outro número aleatório
            Random numY = new Random();
            //seta o número aleatório
            this.y = numY.nextInt(1456);
        }
        else{
            //subtrai a posição com a velocidade
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

    public boolean getVisible(){
        return visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

}
