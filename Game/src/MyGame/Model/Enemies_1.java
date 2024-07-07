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

    //carrega a imagem
    public void load(){
        //cria instância de ImageIcon e coleta o local da imagem
        ImageIcon reference = new ImageIcon("src/Images/alien.png");
        //seta a imagem, passando a instância
        alien = reference.getImage();

        //seta a altura com base na imagem
        height = alien.getHeight(null);
        //seta a largura com base na imagem
        width = alien.getWidth(null);
    }

    public void update(){
        //vindo da direita para a esquerda atacando o player
        this.x -= velo;
    }

    //retorna o retângulo para verificar se há colisão
    public Rectangle getBound(){
        return new Rectangle(x, y, width, height);
    }

    //som de morte comum do inimigo
    public void getAudio(){
        try{
            //coleta o local do som
            File enemyDieSong = new File("src/Sounds/oof.wav");
            //através do arquivo, coleta o som
            AudioInputStream stream = AudioSystem.getAudioInputStream(enemyDieSong);
            //cria um clip para reproduzir o som
            Clip toque = AudioSystem.getClip();
            //abre o clip para permitir a passagem de som
            toque.open(stream);
            //toca finalmente o som
            toque.start();
        }
        catch(Exception err){
            System.err.println("Erro no som da morte do inimigo: " + err);
        }
    }

    //som de morte por boost do inimigo
    public void getAudioBoost(){
        try{
            //pega o local do arquivo
            File enemyDieBoost = new File("src/Sounds/nossa.wav");
            //coleta o som presente no arquivo
            AudioInputStream stream = AudioSystem.getAudioInputStream(enemyDieBoost);
            //cria o clip
            Clip toque = AudioSystem.getClip();
            //abre o clip para passagem de som
            toque.open(stream);
            //toca o som
            toque.start();
        }
        catch(Exception err){
            System.err.println("Erro no som da morte em boost do inimigo: " + err);
        }
    }

    //ainda não funciona, mas terá um sprite de explosão
    public void death(){
        ImageIcon reference = new ImageIcon("src/OriginalImages/liar-Original.png");
        alien = reference.getImage();
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

    //conforme o inimigo toma dano, aqui seta a vida
    public void setLife(int retireLife){
        life -= retireLife;
    }
}
