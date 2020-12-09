package car_mechanic_diagnostic;

import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JPanel {

    JLabel text;
    JButton wybor1,wybor2,wybor3,wybor4;
    JMenu menu;  
    JMenuItem obsluga_przyciskow,grafika_3D;
    JMenuBar mb;
    Container list_menu;
    Menu(MainFrame parent) {

        
        
        
        JLabel background=new JLabel(new ImageIcon("mechanic.jpg"));
        add(background);
        background.setLayout(new FlowLayout());
        
        mb=new JMenuBar();  
          menu=new JMenu("Menu");  
          
          obsluga_przyciskow=new JMenuItem("Obsługa przycisków");  
          grafika_3D=new JMenuItem("Grafika 3D animacje");  
          
          
          menu.add(obsluga_przyciskow); menu.add(grafika_3D);
          
          obsluga_przyciskow.addActionListener(parent);
          
          grafika_3D.addActionListener(parent);
          
          mb.add(menu);  
        
         parent.setJMenuBar(mb);  
        
        
        
        list_menu = new Container();
        
        background.add(list_menu);
        
        list_menu.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        
        
        
       

        gc.gridx = 0;
        gc.gridy = 0;

        
        
        text = new JLabel("Menu");
        list_menu.add(text,gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        
        
        
       
        
        wybor1 = new JButton("LISTA SAMOCHODOW W WARSZTACIE");
        wybor1.addActionListener(parent);
        
        wybor1.setBorderPainted(false);
        wybor1.setFocusPainted(false);
        
        wybor1.setBackground(Color.BLACK);
        wybor1.setForeground(Color.WHITE);
        wybor1.setPreferredSize(new Dimension(450, 30));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        list_menu.add(wybor1,gc);
        
        
         gc.gridx = 0;
        gc.gridy = 3;
        
        wybor2 = new JButton("DODAJ NOWY SAMOCHOD");
        wybor2.addActionListener(parent);
        
        
        
        list_menu.add(wybor2,gc);
        
         gc.gridx = 0;
        gc.gridy = 4;
        
        wybor3 = new JButton("DODAJ WYMIANE");
        wybor3.addActionListener(parent);
        
        
        
        
        list_menu.add(wybor3,gc);
        
         gc.gridx = 0;
        gc.gridy = 5;
        
        
        
        wybor4 = new JButton("LISTA WYMIAN DLA DANEGO AUTA");
        wybor4.addActionListener(parent);
        
        list_menu.add(wybor4,gc);

         wybor2.setBorderPainted(false);
        wybor2.setFocusPainted(false);
        
        wybor2.setBackground(Color.BLACK);
        wybor2.setForeground(Color.WHITE);
        wybor2.setPreferredSize(new Dimension(450, 30));
        
         wybor3.setBorderPainted(false);
        wybor3.setFocusPainted(false);
        
        wybor3.setBackground(Color.BLACK);
        wybor3.setForeground(Color.WHITE);
        wybor3.setPreferredSize(new Dimension(450, 30));
        
         wybor4.setBorderPainted(false);
        wybor4.setFocusPainted(false);
        
        wybor4.setBackground(Color.BLACK);
        wybor4.setForeground(Color.WHITE);
        wybor4.setPreferredSize(new Dimension(450, 30));
    }

}
