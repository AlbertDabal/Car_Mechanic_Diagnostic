package car_mechanic_diagnostic;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener {

    public int wybor;
    public Menu Menu;
    public ListCarInServices ListCarInServices;
    public AddNewCar AddNewCar;
    public AddExchange AddExchange;
    public ShowExchange ShowExchange;
    public CardLayout cardlayout;
    public AddNewCar_next AddNewCar_next;
    public Obsluga_przyciskow Obsluga_przyciskow;
    public Grafika_3D Grafika_3D;
    Container contentPane;

    private int local = 1;

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public void setRodzaj(String rodzaj) {

        this.rodzaj = rodzaj;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    private String rodzaj = "tekst";

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    private String nazwa = "nazwa";

    public MainFrame() {
    }

    int show = 0;

    public MainFrame(String title) throws SQLException {
        super(title);
        Menu = new Menu(this);

        AddNewCar = new AddNewCar(this);
        Obsluga_przyciskow = new Obsluga_przyciskow(this);
        ListCarInServices = new ListCarInServices(this);
        Grafika_3D = new Grafika_3D(this);
        cardlayout = new CardLayout();
        contentPane = this.getContentPane();
        
        contentPane.setLayout(cardlayout);
        contentPane.add(Menu, "1");
        contentPane.add(ListCarInServices, "2");
        contentPane.add(AddNewCar, "3");
        contentPane.add(Obsluga_przyciskow,"7");
        contentPane.add(Grafika_3D,"8");
        cardlayout.show(contentPane, "1");
        
        ShowExchange = new ShowExchange(this);
                    contentPane.add(ShowExchange, "5");

            AddNewCar_next = new AddNewCar_next(this);
                    contentPane.add(AddNewCar_next, "6");        
                    
                   AddExchange = new AddExchange(this);

                    contentPane.add(AddExchange, "4");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SQL_comends sql = new SQL_comends();

        Object source = e.getSource();
        try {
            if (source != null) {

                if (Menu.wybor1.equals(source)) {
                    ListCarInServices = new ListCarInServices(this);
                     contentPane.add(ListCarInServices, "2");
                    cardlayout.show(contentPane, "2");

                } else if (Menu.wybor2.equals(source)) {
                    cardlayout.show(contentPane, "3");
                    show = 1;

                } else if (Menu.wybor3.equals(source)) {

                    setLocal(1);
                    AddExchange = new AddExchange(this);

                    contentPane.add(AddExchange, "4");

                    cardlayout.show(contentPane, "4");
                } else if (Menu.wybor4.equals(source)) {

                    setLocal(3);
                    AddExchange = new AddExchange(this);

                    contentPane.add(AddExchange, "4");

                    cardlayout.show(contentPane, "4");

                } else if (ListCarInServices.powrot.equals(source)) {
                    cardlayout.show(contentPane, "1");

                } else if (AddNewCar.powrot.equals(source)) {
                    sql.AddSQL(
                            AddNewCar.VIN_text.getText(),
                            AddNewCar.marka_text.getText(),
                            AddNewCar.model_text.getText(),
                            (String) AddNewCar.rodzaj_select.getSelectedItem());

                    setRodzaj((String) AddNewCar.rodzaj_select.getSelectedItem());

                    setLocal(1);
                    AddNewCar_next = new AddNewCar_next(this);

                    contentPane.add(AddNewCar_next, "6");
                    cardlayout.show(contentPane, "6");

                
                
                
                
                
                
                
                
                
                
                } else if (source == AddExchange.powrot) {

                    setLocal(2);
                    setRodzaj(sql.GetType((String) AddExchange.select_wybor.getSelectedItem()));
                    AddNewCar_next = new AddNewCar_next(this);
                    contentPane.add(AddNewCar_next, "6");

                    cardlayout.show(contentPane, "6");

                } else if (ShowExchange.powrot.equals(source)) {
                    cardlayout.show(contentPane, "1");
                } else if (AddNewCar_next.wykonaj.equals(source)) {

                    if ("bezyna".equals((String) AddNewCar.rodzaj_select.getSelectedItem())) {
                        sql.SQL_next(
                                AddNewCar.VIN_text.getText(),
                                AddNewCar_next.przebieg_text.getText(),
                                AddNewCar_next.wymiana_olej_text.getText(),
                                AddNewCar_next.wymiana_paliwo_text.getText(),
                                AddNewCar_next.wymiana_powietrze_text.getText(),
                                AddNewCar_next.wymiana_tarcza_text.getText());
                    } else {

                        if ("diesel".equals((String) AddNewCar.rodzaj_select.getSelectedItem())) {

                            sql.SQL_next(
                                    AddNewCar.VIN_text.getText(),
                                    AddNewCar_next.przebieg_text.getText(),
                                    AddNewCar_next.wymiana_olej_text.getText(),
                                    AddNewCar_next.wymiana_paliwo_text.getText(),
                                    AddNewCar_next.wymiana_powietrze_text.getText(),
                                    AddNewCar_next.wymiana_tarcza_text.getText(),
                                    AddNewCar_next.wymiana_dwumas_text.getText());
                        }
                    }

                    cardlayout.show(contentPane, "1");

                } else if (AddNewCar_next.zmien.equals(source)) {

                    if ("bezyna".equals(getRodzaj())) {
                        sql.SQL_edit(
                                (String) AddExchange.select_wybor.getSelectedItem(),
                                AddNewCar_next.przebieg_text.getText(),
                                AddNewCar_next.wymiana_olej_text.getText(),
                                AddNewCar_next.wymiana_paliwo_text.getText(),
                                AddNewCar_next.wymiana_powietrze_text.getText(),
                                AddNewCar_next.wymiana_tarcza_text.getText());
                    } else if ("diesel".equals(getRodzaj())) {

                        sql.SQL_edit(
                                (String) AddExchange.select_wybor.getSelectedItem(),
                                AddNewCar_next.przebieg_text.getText(),
                                AddNewCar_next.wymiana_olej_text.getText(),
                                AddNewCar_next.wymiana_paliwo_text.getText(),
                                AddNewCar_next.wymiana_powietrze_text.getText(),
                                AddNewCar_next.wymiana_tarcza_text.getText(),
                                AddNewCar_next.wymiana_dwumas_text.getText());
                    }

                    cardlayout.show(contentPane, "1");

                } else if (AddExchange.sprawdz.equals(source)) {

                    setRodzaj(sql.GetType((String) AddExchange.select_wybor.getSelectedItem()));

                    setNazwa((String) AddExchange.select_wybor.getSelectedItem());

                    ShowExchange = new ShowExchange(this);
                    contentPane.add(ShowExchange, "5");
                    cardlayout.show(contentPane, "5");

                }
                
                 else if (Menu.obsluga_przyciskow.equals(source)) {

                     cardlayout.show(contentPane, "7");

                }
                 
                 
                 else if (Menu.grafika_3D.equals(source)) {
                     Grafika_3D = new Grafika_3D(this);
                     contentPane.add(Grafika_3D,"8");
                     cardlayout.show(contentPane, "8");

                }
                
                else if (Obsluga_przyciskow.powrot.equals(source)) {

                     cardlayout.show(contentPane, "1");

                }
                
                else if (Grafika_3D.powrot.equals(source)) {

                     cardlayout.show(contentPane, "1");

                }

            }

        } catch (SQLException ex) {
        }
    }
}
