package car_mechanic_diagnostic;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.awt.GridLayout;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListCarInServices extends JPanel {

    JButton powrot;
    JTable tabela;
    private Connection myConnection;

    ListCarInServices(MainFrame parent) throws SQLException {

        setLayout(new GridLayout(2, 2));

        String[] columnNames = {"VIN", "marka", "model", "rodzaj"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

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
            ResultSet myRS = (ResultSet) myStatement.executeQuery("select * from samochody");

            while (myRS.next()) {
                
                String VIN = myRS.getString("VIN");
                String marka = myRS.getString("marka");
                String model = myRS.getString("model");
                String rodzaj = myRS.getString("rodzaj");

                // create a single array of one row's worth of data
                String[] data = {VIN, marka, model, rodzaj};
                // and add this row of data into the table model
                tableModel.addRow(data);
            }
        } catch (ClassNotFoundException | SQLException sqle) {
            System.out.println("connect fail!!!");
        }

        tabela = new JTable(tableModel);
        JScrollPane sp = new JScrollPane(tabela);
        tabela.setBounds(30, 40, 200, 300);
        myConnection.close();
        add(sp);
        powrot = new JButton("POWROT");
        powrot.addActionListener(parent);
        add(powrot);
    }
}
