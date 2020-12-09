package car_mechanic_diagnostic;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Login extends JFrame implements ActionListener {
    JPanel logowanie;
    JLabel login,haslo;
    JTextField log;
    JPasswordField has;          
    JButton zaloguj;
    
    public Login(String title) {

        super(title);
        
        logowanie = new JPanel();
        
        add(logowanie);
        
        logowanie.setLayout(new GridLayout(3,2));
        
        login = new JLabel("Podaj login");
        
        haslo = new JLabel("Podaj haslo");
        
        log = new JTextField();
        
        has = new JPasswordField();
        
        zaloguj = new JButton("ZALOGUJ");
        
        logowanie.add(login);
        logowanie.add(log);
        logowanie.add(haslo);
        logowanie.add(has);
        logowanie.add(zaloguj);
        
        zaloguj.addActionListener(this);
        
       
        
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(log.getText().equals("a") && has.getText().equals("a"))
        {
            JOptionPane.showMessageDialog(null,"LOGOWANIE POMYSLNE");
            
             setVisible(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
            SwingUtilities.invokeLater(new Runnable() {
            
            
            public void run() {
                
                try {
                    JFrame frame = new MainFrame("Plan wymian");
                    frame.setSize(600, 500);
                    frame.setTitle("Dziennik wymian");
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (SQLException ex) {
                    
                }
            }
        });
            
            
           
        }
        else
            
            JOptionPane.showMessageDialog(null,"LOGIN LUB HASLO JEST NIE POPRAWNE");
        {
            
        }
}
    
    
    
}


