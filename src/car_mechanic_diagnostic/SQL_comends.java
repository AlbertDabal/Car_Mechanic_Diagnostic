package car_mechanic_diagnostic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL_comends {

    private Connection myConnection;
    private String comend="";
    private Statement myStatement;
    private int location;
    private String vin;
    private String id;
    
    public SQL_comends() {

    }

    public void SQL_connect() throws SQLException {

        String url = "jdbc:mysql://localhost/";
        String dbName = "komis";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";

        try {
            Class.forName(driver);
            myConnection = (Connection) DriverManager.getConnection(url + dbName, userName, password);

            System.out.println("connect!!!");

            myStatement = (Statement) myConnection.createStatement();

            
            if(location==2)
            {
              ResultSet myRS = (ResultSet) myStatement.executeQuery("select rodzaj from samochody where VIN='"+vin+"';");
            
                while(myRS.next()){
                id = myRS.getString(1);
                
           
            }
            }
            else
            {
            myStatement.executeUpdate(comend);
            }
            
                    
        } catch (ClassNotFoundException | SQLException sqle) {
            System.out.println("connect fail!!!");
        }

        myConnection.close();

    }

    public void SQL_next(String VIN, String przebieg, String wymiana_olej, String wymiana_paliwo, String wymiana_powietrze, String wymiana_tarcza) throws SQLException {

        comend = "INSERT INTO przebiegi VALUES('" + VIN + "','" + przebieg + "','" + wymiana_olej + "','" + wymiana_paliwo + "','" + wymiana_powietrze + "','" + wymiana_tarcza + "',NULL);";

        
        SQL_connect();
    }

    public void SQL_next(String VIN, String przebieg, String wymiana_olej, String wymiana_paliwo, String wymiana_powietrze, String wymiana_tarcza, String dwumas) throws SQLException {

        comend = "INSERT INTO przebiegi VALUES('" + VIN + "','" + przebieg + "','" + wymiana_olej + "','" + wymiana_paliwo + "','" + wymiana_powietrze + "','" + wymiana_tarcza + "','" + dwumas + "');";
        SQL_connect();
    }

    public void AddSQL(String VIN, String marka, String model, String rodzaj) throws SQLException {

        comend = "INSERT INTO samochody VALUES('" + VIN + "','" + marka + "','" + model + "','" + rodzaj + "');";
        SQL_connect();
    }
    
    
     public void SQL_edit(String VIN, String przebieg, String wymiana_olej, String wymiana_paliwo, String wymiana_powietrze, String wymiana_tarcza) throws SQLException {

        comend = "UPDATE `przebiegi` SET `przebieg` = '" + przebieg + "', `wymiana olej` = '" + wymiana_olej + "', `wymiana paliwo` = '" + wymiana_paliwo + "', `wymiana powietrze` = '" + wymiana_powietrze + "', `wymiana tarcza` = '" + wymiana_tarcza + "' WHERE `przebiegi`.`VIN` = '" + VIN + "';";

        
        SQL_connect();
    }

    public void SQL_edit(String VIN, String przebieg, String wymiana_olej, String wymiana_paliwo, String wymiana_powietrze, String wymiana_tarcza, String dwumas) throws SQLException {

        comend = "UPDATE `przebiegi` SET `przebieg` = '" + przebieg + "', `wymiana olej` = '" + wymiana_olej + "', `wymiana paliwo` = '" + wymiana_paliwo + "', `wymiana powietrze` = '" + wymiana_powietrze + "', `wymiana tarcza` = '" + wymiana_tarcza + "', `wymiana dwumas` = '" + dwumas + "' WHERE `przebiegi`.`VIN` = '" + VIN + "';";
        SQL_connect();
    }
    
    

    
    public String GetType(String VIN) throws SQLException{
        vin = VIN;
        location=2;
        SQL_connect();
        
        return id;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    public String SQL_type_car(String VIN) throws SQLException {

        ResultSet myRS = (ResultSet) myStatement.executeQuery("select rodzaj from samochody where VIN='" + VIN + "';");

        while (myRS.next()) {
            String id = myRS.getString(1);
            System.out.println(id);

            return id;
        }

        return null;

    }
    */
}
