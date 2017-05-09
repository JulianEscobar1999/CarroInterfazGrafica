
package test;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPaintComponent extends JFrame{
    
    
    public TestPaintComponent(){
        add(new NewPanel());
    }

    public static void main(String[] args) {
       TestPaintComponent frame = new TestPaintComponent();
       frame.setTitle("TestPaintComponent");
       frame.setSize(600,600);
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);            
    }
    
}


     class NewPanel extends JPanel implements ActionListener, MouseListener{
        
         private Timer timer;
         private int x,y,dx,dy;
         public Rectangle rectangle;
         
    public NewPanel() {
        this.addMouseListener(this);
        timer = new Timer(110, this);
        timer.start();
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        
        this.x =5;
        this.y = 6;
        this.dx = 0;
        this.dy = 0;
    }
         
         
         
         @Override
         protected void paintComponent(Graphics g){
             super.paintComponent(g);
             
             Image fondo = cargarImagen("fondo.png");
             g.drawImage(fondo,0,0,null);
             
             Image gato = cargarImagen("cats.gif");
             g.drawImage(gato,1,1,1,1,1,1,1,1,this);
                       //Buscar las coordenadas correctas para colocar el gato
                     //gato,30,300,132,80,264,0,(264+132),80,this);
           //  g.drawLine(0, 0, 50, 50);
             
         /*    g.drawString("Puntos : 100",500, 40);
             g.drawRect(80, 200, 60, 100);
             g.drawRect(450, 200, 60, 100);
             g.drawRect(265, 100, 60, 100);
             g.drawRect(310, 100, 60, 100);
             g.drawOval(280, 320, 70, 70);             
             g.drawRect(275, 390, 80, 80);
             */
             
             
             g.setColor(Color.black);
             
             g.drawRect(29+x , 439+y, 52, 32);
             g.drawRect(400, 439, 50, 50);
             g.fillOval(60+x, 460+y, 10, 10);
             g.fillOval(40+x, 460+y, 10, 10);             
             g.setColor(Color.blue);
             g.fillRect(30+x, 450+y, 50, 10);             
             g.setColor(Color.red);
             int l[]={40+x,50+x,60+x,70+x};
             int y1[]={450+y, 440+y, 440+y, 450+y};
             g.fillPolygon(l, y1, l.length);                          
             
         //    System.out.println("Click");
             
         }

    @Override
    public void actionPerformed(ActionEvent e) {
        x=dx;
        y=dy;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
        if(r().contains(mp)){
           
            try {           
                Thread.sleep(300);
                // timer.stop();
            } catch (InterruptedException ex) {
                Logger.getLogger(NewPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
           
          
        }        
        
        System.out.println("CLICK");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    
    
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
    public Rectangle r(){
        
        return new Rectangle(29+x , 439, 52, 32);
    }
    
    public Rectangle c(){
        return new Rectangle(400, 439, 50, 50);
    }
    
    /*
    public void colision(){
        Rectangle rCarro = rectangle.r();
        Rectangle rColision = rectangle.c();
        
    }
    */
    
    public Image cargarImagen(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    private class TAdapter extends KeyAdapter{
        
        @Override
        public void keyReleased(KeyEvent e){
           // System.out.println("Released");
        }
        
        @Override
        public void keyPressed(KeyEvent e){
            
            int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_LEFT){
                dx += -8;
            }
            if (key == KeyEvent.VK_RIGHT){
                dx += 8;
            }
            if (key == KeyEvent.VK_DOWN){
                dy += 8;
            }
            if (key == KeyEvent.VK_UP){
              dy += -8;              
            }
            
        }
        
    }
    }
