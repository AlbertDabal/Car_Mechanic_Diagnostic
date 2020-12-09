package car_mechanic_diagnostic;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.awt.GridLayout;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddExchange extends JPanel {

    JButton powrot, sprawdz;
    JTable tabela;
    JComboBox select_wybor;
    JLabel text;
    int local;

    private Connection myConnection;

    AddExchange(MainFrame parent) throws SQLException {

        String[] columnNames = {"VIN", "marka", "model"};
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
            select_wybor = new JComboBox();
            while (myRS.next()) {
                String VIN = myRS.getString("VIN");
                String marka = myRS.getString("marka");
                String model = myRS.getString("model");
                select_wybor.addItem(VIN);
                // create a single array of one row's worth of data
                String[] data = {VIN, marka, model};
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
        powrot = new JButton("WYBIERZ");

        sprawdz = new JButton("SPRAWDZ");

        setLayout(new GridLayout(3, 2));
        text = new JLabel("Podaj VIN");
        add(sp);
        add(text);
        add(select_wybor);

        local = parent.getLocal();

        powrot.addActionListener(parent);
        sprawdz.addActionListener(parent);
        if (local == 2 || local == 1) {
           
            add(powrot);
        } else if (local == 3) {
            
            add(sprawdz);
        }
        

    }
}
