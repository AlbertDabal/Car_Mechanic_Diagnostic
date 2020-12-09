/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_mechanic_diagnostic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Albert
 */
class Grafika_3D extends JPanel implements ActionListener{
    
    JButton powrot;
    
     Timer tm = new Timer(5, this);
     int x=0,valX= 2; 
    
    
    
       Grafika_3D(MainFrame parent) {
        
         powrot = new JButton("Powrot");
        add(powrot);
        powrot.addActionListener(parent);
	
         
       
        
        
        
        
    }
       
     
      
    
    	public void paintComponent(Graphics g)
	    {
                
                
                  super.paintComponent(g);
		  g.setColor(Color.orange);
		  g.fillRect(x,0,400,250);
                  
                  g.setColor(Color.blue);
		  g.fillOval(0,x,200,250);
                  
                   g.setColor(Color.red);
                   g.fillOval(x,x,200,250);
                   
                   Polygon triangle = new Polygon();
                triangle.addPoint(0-x, 150);
                triangle.addPoint(300-x, 150);
                triangle.addPoint(150-x, 0);

     
      g.fillPolygon(triangle);//paints a polygon
                  
                  
		 
                  tm.start();
                 
                  
	    }

        @Override
        public void actionPerformed(ActionEvent e) {
            x = x + valX;
            repaint();
        }
        
  }
       
       

   
    

