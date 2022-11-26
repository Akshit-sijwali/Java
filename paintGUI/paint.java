import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

class setup extends JFrame{
    setup(){
        // creating side panel
        JPanel sp = new JPanel();
        sp.setBounds(0, 0, 100, 500);
        sp.setBackground(Color.GRAY);
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
                Graphics g = getGraphics();
                g.drawOval(290,300,50,60);
                // System.out.println(getX()+" "+getY());
            }
        });

        Rectangle.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Graphics g = getGraphics();
                g.drawRect(200, 130, 30, 20);
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