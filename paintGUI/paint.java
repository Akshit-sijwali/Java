import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

class setup extends JFrame{
     int width,length,preX,preY;
     String Drawing;
    setup(){
        // creating side panel
        JPanel drawpanel = new JPanel();
        JPanel sp = new JPanel();

        drawpanel.setBounds(100, 0, 1000, 500);
        drawpanel.setBackground(Color.WHITE);

        sp.setBounds(0, 0, 100, 500);
        sp.setBackground(Color.GRAY);
        add(drawpanel);
        add(sp);

        // creating buttons 
        JButton Circle = new JButton("Circle");
        JButton Rectangle = new JButton("Rectangle");
        
        Circle.setBounds(10, 20, 70, 30);
        Rectangle.setBounds(10, 70, 70, 30);
        Circle.setToolTipText("Draw circle");
        Rectangle.setToolTipText("Draw rectangle");

        sp.add(Circle);
        sp.add(Rectangle);

        // Windowclosing listener
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
        
                System.exit(-1);
            }
        });

        Circle.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Drawing = "Circle";
            }
        });

        Rectangle.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Drawing = "Rectangle";
            }
        });

        drawpanel.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                System.out.println(e.getX()+" "+e.getY());
                preX = e.getX();
                preY = e.getY();
            }

            public void mouseReleased(MouseEvent e){
                width = e.getX() - preX;
                length = e.getY() - preY;
                System.out.println(e.getX()+" "+e.getY());
                Graphics g = getGraphics();
                if(Drawing == "Circle"){
                    g.drawOval(preX,preY,width,length);
                }
                else if(Drawing == "Rectangle"){
                    g.drawRect(preX, preY, width, length);
                }
            }
        });

        


        setLayout(null);
        setVisible(true);
        setSize(700,500);
    }
    
    // public void paint(Graphics g) { 
        // g.fillRect(130,30,100,80);
        // g.drawOval(130,230,50,60);
        // setForeground(Color.RED);
        // g.fillOvasl(130,130,50,60);
        // g.drawArc(30,20s0,40,50,90,60);
        // g.fillArc(30,130,40,50,180,40);
    // }

}

class paintgui{
    public static void main(String[] args) {
       new setup();
    }
}