package car_mechanic_diagnostic;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.awt.GridLayout;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowExchange extends JPanel{
    JButton powrot;
    JLabel VIN_text;
    String nazwa;
    JTable tabela;
    private Connection myConnection;

    ShowExchange(MainFrame parent) throws SQLException {

        setLayout(new GridLayout(2, 2));

        int[] dane = new int[6];
            
         
        String url = "jdbc:mysql://localhost/";
        String dbName = "komis";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";

        try {
            Class.forName(driver);
            myConnection = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("connect!!!");
            Statement myStatement = (Statement) myConnection.createStatement();
            ResultSet myRS = (ResultSet) myStatement.executeQuery("select * from przebiegi WHERE VIN='"+ parent.getNazwa() +"'");

            
            
            while (myRS.next()) {
                
                
                dane[0] = myRS.getInt("przebieg");
                dane[1] = myRS.getInt("wymiana olej");
                dane[2] = myRS.getInt("wymiana paliwo");
                dane[3] = myRS.getInt("wymiana powietrze");
                dane[4] = myRS.getInt("wymiana tarcza");
                dane[5] = myRS.getInt("wymiana dwumas");

                // create a single array of one row's worth of data
               
                // and add this row of data into the table model
               
            }
        } catch (ClassNotFoundException | SQLException sqle) {
            System.out.println("connect fail!!!");
        }
         myConnection.close();
        
       
        
        
       
        
        
        
        
        String text=("<html>DZIENIK WYMIAN DLA SAMOCHODU O VIN: " + parent.getNazwa());
        
        
        String[] pojazd_nazwa = {
            "olej",
            "filtr_paliwa",
            "filtr_powietrza",
            "tarcze",
            "dwumasa"
        };
        
        if("diesel".equals(parent.getRodzaj())){
            
            
          
        Diesel diesel = new Diesel();

            int[] pojazd = {
                diesel.olej,
                diesel.filtr_paliwa,
                diesel.filtr_powietrza,
                diesel.tarcze,
                diesel.dwumasa
        };
        
         text+="<br>";
            
        for (int i = 1; i < 6; i++) {
                text+="<br>";
            
                if (pojazd[i - 1] == (dane[0] - dane[i])) {

                    text+=(pojazd_nazwa[i - 1] + " nalezy wymienic za 0km");
                } else if (pojazd[i - 1] < (dane[0] - dane[i])) {
                    text+=(pojazd_nazwa[i - 1] + " nalezy wymienic opuznienie to " + (pojazd[i - 1] - (dane[0] - dane[i])) + "km");
                } else {
                    text+=("do wymiany " + pojazd_nazwa[i - 1] + " zostalo " + (pojazd[i - 1] - (dane[0] - dane[i])) + "km");
                }
                
                text+="<br>";
                
            }
        
            text+="</html>";
            
            
            
        }
        else if("bezyna".equals(parent.getRodzaj())){
             Gasoline gasoline = new Gasoline();

            int[] pojazd = {
                gasoline.olej,
                gasoline.filtr_paliwa,
                gasoline.filtr_powietrza,
                gasoline.tarcze

            };
        
         text+="<br>";
            
        for (int i = 1; i < 5; i++) {
                text+="<br>";
            
                if (pojazd[i - 1] == (dane[0] - dane[i])) {

                    text+=(pojazd_nazwa[i - 1] + " nalezy wymienic za 0km");
                } else if (pojazd[i - 1] < (dane[0] - dane[i])) {
                    text+=(pojazd_nazwa[i - 1] + " nalezy wymienic opuznienie to " + (pojazd[i - 1] - (dane[0] - dane[i])) + "km");
                } else {
                    text+=("do wymiany " + pojazd_nazwa[i - 1] + " zostalo " + (pojazd[i - 1] - (dane[0] - dane[i])) + "km");
                }
                
                text+="<br>";
        }
                
                
        }      
                
        
         VIN_text = new JLabel(text);
        
        
        add(VIN_text);
        
        powrot = new JButton("POWROT");
        powrot.addActionListener(parent);
        add(powrot);
    }
    
    
    
}
