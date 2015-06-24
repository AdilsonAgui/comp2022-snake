import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.File;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Score score;
    private boolean paraDireita;
    private boolean paraEsquerda;
    private boolean paraCima;
    private boolean paraBaixo;
    private boolean pause;
    
    private boolean isPlaying = false;

    private Font font;
       
    public Board() {

        addKeyListener(new TAdapter());
        
        setFocusable(true);        
        setDoubleBuffered(true);
        setBackground(Color.WHITE);

        score = new Score();
        add(score);       
        
        timer = new Timer(5, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);
        
        score.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;        

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
    }


    public void paintIntro(Graphics g) {
        if(isPlaying){
            isPlaying = false;
            Graphics2D g2d = (Graphics2D) g;
            try{
                File file = new File("fonts/VT323-Regular.ttf");
                font = Font.createFont(Font.TRUETYPE_FONT, file);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);
                font = font.deriveFont(Font.PLAIN,40);
                g2d.setFont(font);
            }catch (Exception e){
                System.out.println(e.toString());
            }   
            g2d.drawString("S N A K E: " + this.score, 300, 300);
        }
    }
    
    public void actionPerformed(ActionEvent e) {        
        repaint();  
    }
    
    
    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            
            // Obtém o código da tecla
            int key =  e.getKeyCode();

            switch (key){
                case KeyEvent.VK_ENTER:
                pause = true;
            
                    break;
                    
                case KeyEvent.VK_LEFT:
                if ((key == KeyEvent.VK_LEFT) && (!paraDireita)) {
                  paraEsquerda = true;
                  paraCima = false;
                  paraBaixo = false;
                    break;
                }
                    
                case KeyEvent.VK_RIGHT:
                if ((key == KeyEvent.VK_RIGHT) && (!paraEsquerda)) {
                 paraDireita = true;
                 paraCima = false;
                 paraBaixo = false;
                    break;
                }
                    
                case KeyEvent.VK_UP:
                if ((key == KeyEvent.VK_UP) && (!paraBaixo)) {
                    paraCima = true;
                    paraDireita = false;
                    paraEsquerda = false;
            
                    break;
                }
                    
                case KeyEvent.VK_DOWN:
                if ((key == KeyEvent.VK_DOWN) && (!paraCima)) {
                
                    paraEsquerda = false;
                    paraDireita = false;
                    paraBaixo = true;
                    break;
                }
            
        }
    }
    
  }
}