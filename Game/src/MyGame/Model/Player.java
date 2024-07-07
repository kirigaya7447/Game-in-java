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

        timer = new Timer(500, this);
        timer.start();
    }

    //carrega a imagem doo player
    public void load(){
        //cria instância de ImageIcon
        ImageIcon reference = new ImageIcon("src/Images/nave.png");
        //seta a image contida na instância
        player = reference.getImage();

        //seta a altura com base na imagem
        height = player.getHeight(null);
        //seta a largura com base na imagem
        width = player.getWidth(null);

        //seta o personagem como visível
        visible = true;
    }

    public void updateMove(){
        //pegando o valor de d* e somando para que o valor seja ou subtraído ou somado
        x += dx;
        y += dy;
    }

    public void boost(){
        //seta o boost como true
        boost = true;
        //cria instância da imagem do boost
        ImageIcon reference = new ImageIcon("src/Images/naveBoost.png");
        //seta a imagem do player como boost
        player = reference.getImage();
    }

    //retorna retângulo para verificar colisões
    public Rectangle getBound(){
        return new Rectangle(x, y, height, width);
    }

    //tiro simples
    public void simpleBullet(){
        //adiciona tiro passando a posição atual e metade da altura para que saia da metade do tamanho do personagem
        this.bullets.add(new Bullets(x + width, y + (height/2)));

        //verifica se os tiros passaram do limite
        if(bullets.size() >= 20){
            //se passou retira os dois últimos
            for(int cont = 18; cont <= bullets.size(); cont++){
                bullets.remove(cont);
            }
        }
    }

    //verifica o pressionamento de teclas
    public void keyPressed(KeyEvent keyPressioned){
        //pega o código da tecla pressionada
        int numTecla = keyPressioned.getKeyCode();
        switch(numTecla){
            case KeyEvent.VK_UP:
                dy -= 3;
                break;
            case KeyEvent.VK_DOWN:
                dy += 3;
                break;
            case KeyEvent.VK_LEFT:
                dx -= 3;
                break;
            case KeyEvent.VK_RIGHT:
                dx += 3;
                break;
            case KeyEvent.VK_W:
                dy -= 3;
                break;
            case KeyEvent.VK_S:
                dy += 3;
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
                //cria tarefa para ser executada em paralelo
                Thread ligaBoost = new Thread(new Boost());
                //dá início a execução
                ligaBoost.start();
                break;
        }
    }

    class Boost implements Runnable{
        @Override
        //fazer o boost acontecer
        public void run(){
            //seta o tempo de duração da repetição (3s)
            long duration = 3000;
            //começa a contar o tempo
            long start = System.nanoTime();

            //enquanto o tempo decorrido menos o inicial(convertido em milissegundos)
            // for menor do que a duração, ele chama o boost
            while((System.nanoTime() - start) / 1_000_000 < duration){
                boost();
            }

        }

    }

    //verifica quando a tecla é solta após pressionada
    public void keyReleased(KeyEvent keyPressioned){
        //pega o código da tecla
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
    //verfica para fazer a troca dos ícones do player
    public void actionPerformed(ActionEvent e){
        if(boost){
            boost = false;
        }
        else{
            load();
        }
    }

}
