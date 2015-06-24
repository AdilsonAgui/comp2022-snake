import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends JPanel
{
    private String snake = "head.png";
    private Snake anterior;
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    
    public Snake() {
        ImageIcon ii = new ImageIcon("images/"+this.getClass().getResource(snake));
        image = ii.getImage();
        x = 40;
        y = 60;
    }
    public Snake getAnterior(){
        return anterior;
    }
    public void setAnterior(Snake anterior){
        this.anterior = anterior;
    }
    
    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }
    public void setX(int x){
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y){
        this.y = y;
    }

    public Image getImage() {
        return image;
    }
    public void setImage(String ponta){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(ponta));
        image = ii.getImage();
    }

}
