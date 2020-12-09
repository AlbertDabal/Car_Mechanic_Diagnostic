/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_mechanic_diagnostic;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/*
 * @author Albert
 */
public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new Login("Login");
                frame.setSize(300, 200);
                frame.setTitle("Login");
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        
        
        
        
        
        
        
    }
    
    

}
