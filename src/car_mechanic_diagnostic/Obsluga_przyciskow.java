/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_mechanic_diagnostic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Albert
 */
public class Obsluga_przyciskow extends JPanel implements MouseListener,ActionListener {
    
    
    JButton change_color,powrot;
    
    Obsluga_przyciskow(MainFrame parent){
        
        change_color = new JButton("Zmien kolor");
        add(change_color);
        change_color.addMouseListener(this);
        
        powrot = new JButton("Powrot");
        add(powrot);
        powrot.addActionListener(parent);
        
        Font  f1  = new Font(Font.SERIF, Font.PLAIN,  10);
        powrot.setFont(f1);
    }
    
    
    @Override
     public void mousePressed(MouseEvent e) {
       if (e.getButton() == MouseEvent.BUTTON1){
                    System.out.println("Left button clicked");
                   setBackground(Color.GREEN);
                } else if (e.getButton() == MouseEvent.BUTTON2){
                    System.out.println("Middle button clicked");
                     setBackground(Color.RED);
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Right button clicked");
                     setBackground(Color.BLUE);
                } 
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

    @Override
    public void mouseClicked(MouseEvent e) {
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
    
	
}
    

