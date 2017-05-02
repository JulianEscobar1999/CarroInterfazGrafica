
package test;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


     class NewPanel extends JPanel implements ActionListener{
        
         private Timer timer;
         private int x;

    public NewPanel() {
        timer = new Timer(110, this);
        timer.start();
        this.x =20;
    }
         
         
         
         @Override
         protected void paintComponent(Graphics g){
             super.paintComponent(g);
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
             
             g.drawRect(29+x , 439, 52, 32);
             
             g.fillOval(60+x, 460, 10, 10);
             g.fillOval(40+x, 460, 10, 10);             
             g.setColor(Color.blue);
             g.fillRect(30+x, 450, 50, 10);             
             g.setColor(Color.red);
             int l[]={40+x,50+x,60+x,70+x};
             int y[]={450, 440, 440, 450};
             g.fillPolygon(l, y, l.length);                          
             
             System.out.println("Click");
         }

    @Override
    public void actionPerformed(ActionEvent e) {
          x+=20;
       // y+=1;
        repaint();
    }
             
         
     }