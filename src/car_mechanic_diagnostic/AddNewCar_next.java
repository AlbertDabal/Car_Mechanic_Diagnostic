package car_mechanic_diagnostic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNewCar_next extends JPanel {

    JLabel przebieg, wymiana_olej, wymiana_paliwo, wymiana_powietrze, wymiana_tarcza, wymiana_dwumas;
    JTextField przebieg_text, wymiana_olej_text, wymiana_paliwo_text, wymiana_powietrze_text, wymiana_tarcza_text, wymiana_dwumas_text;
    JPanel form;
    JButton wykonaj,zmien;

    AddNewCar_next(MainFrame parent) throws SQLException {

        String rodzaj = parent.getRodzaj();
        
        int local = parent.getLocal();

        przebieg = new JLabel("podaj przebieg:");
        przebieg_text = new JTextField(10);
        wymiana_olej = new JLabel("podaj wymiana_olej:");
        wymiana_olej_text = new JTextField(10);
        wymiana_paliwo = new JLabel("podaj wymiana_paliwo:");
        wymiana_paliwo_text = new JTextField(10);
        wymiana_powietrze = new JLabel("podaj wymiana_powietrze:");
        wymiana_powietrze_text = new JTextField(10);
        wymiana_tarcza = new JLabel("podaj wymiana_tarcza:");
        wymiana_tarcza_text = new JTextField(10);

        if ("diesel".equals(rodzaj)) {
            wymiana_dwumas = new JLabel("podaj wymiana_dwumas:");
            wymiana_dwumas_text = new JTextField(10);
        }
        wykonaj = new JButton("WYKONAJ");
        zmien = new JButton("ZMIEN");

        
        wykonaj.addActionListener(parent);
        zmien.addActionListener(parent);

        form = new JPanel();

        add(form);

        form.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        /////////////// 1 row ////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;

        form.add(przebieg, gc);

        gc.gridy = 0;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        form.add(przebieg_text, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridy = 1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;

        /////////////// 2 row ////////////////////////////////
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridy = 2;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        form.add(wymiana_olej, gc);
        gc.gridy = 2;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;

        form.add(wymiana_olej_text, gc);

        /////////////// 3 row ////////////////////////////////
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridy = 3;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        form.add(wymiana_paliwo, gc);
        gc.gridy = 3;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;

        form.add(wymiana_paliwo_text, gc);

        /////////////// 4 row ////////////////////////////////
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridy = 4;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        form.add(wymiana_powietrze, gc);
        gc.gridy = 4;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;

        form.add(wymiana_powietrze_text, gc);

        /////////////// 5 row ////////////////////////////////
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridy = 5;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        form.add(wymiana_tarcza, gc);
        gc.gridy = 5;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;

        form.add(wymiana_tarcza_text, gc);

         
        
        /////////////// 6 row ////////////////////////////////
        if ("diesel".equals(rodzaj)) {

            gc.weighty = 0.1;
            gc.anchor = GridBagConstraints.LINE_START;

            gc.gridy = 6;
            gc.gridx = 0;
            gc.anchor = GridBagConstraints.LINE_END;
            form.add(wymiana_dwumas, gc);
            gc.gridy = 6;
            gc.gridx = 1;
            gc.anchor = GridBagConstraints.LINE_START;

            form.add(wymiana_dwumas_text, gc);

             /////////////// 7 row ////////////////////////////////
            

            if(local==1)
            {
                
                
                gc.weighty = 1.0;
                gc.gridy = 7;
                gc.gridx = 0;
                gc.anchor = GridBagConstraints.LINE_START;

                form.add(wykonaj, gc);
            }
            else if(local==2){
                
                
                gc.weighty = 1.0;
                gc.gridy = 7;
                gc.gridx = 0;
                gc.anchor = GridBagConstraints.LINE_START;

                form.add(zmien, gc);
            }
            
            
           
            
           
            
            
        } else if ("bezyna".equals(rodzaj)) {
            
            if(local==1)
            {
               
           
            gc.weighty = 1.0;
            gc.gridy = 6;
            gc.gridx = 0;
            gc.anchor = GridBagConstraints.LINE_START;

            form.add(wykonaj, gc);
            }
            else if(local==2){
              
                
               gc.weighty = 1.0;
                gc.gridy = 6;
                gc.gridx = 0;
                gc.anchor = GridBagConstraints.LINE_START;

                form.add(zmien, gc);     
            }
            
            }
            
            
        

    }
}
