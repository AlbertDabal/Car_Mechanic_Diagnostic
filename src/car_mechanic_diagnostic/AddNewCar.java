package car_mechanic_diagnostic;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddNewCar extends JPanel {

    JButton powrot;
    JLabel VIN, marka, model, dodaj_text,rodzaj;
    JTextField VIN_text, marka_text, model_text;
    JPanel form;
    JComboBox rodzaj_select;

    AddNewCar(MainFrame parent) {

        VIN = new JLabel("podaj VIN:");
        VIN_text = new JTextField(10);
        marka = new JLabel("podaj marke:");
        marka_text = new JTextField(10);
        model = new JLabel("podaj model:");
        model_text = new JTextField(10);
        rodzaj = new JLabel("podaj rodzaj:");
        String[] wybory = {
            "bezyna", "diesel"
        };

        rodzaj_select = new JComboBox(wybory);

        setLayout(new BorderLayout());

        dodaj_text = new JLabel("DODAWANIE SAMOCHODU", SwingConstants.CENTER);

        add(dodaj_text, BorderLayout.PAGE_START);

        form = new JPanel();

        add(form, BorderLayout.CENTER);

        powrot = new JButton("DALEJ");

        powrot.addActionListener(parent);

        form.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        /////////////// 1 row ////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;

        form.add(VIN, gc);

        gc.gridy = 0;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        form.add(VIN_text, gc);

        /////////////// 2 row ////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridy = 1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        form.add(marka, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        form.add(marka_text, gc);

        /////////////// 3 row ////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridy = 2;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        form.add(model, gc);

        gc.gridy = 2;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        form.add(model_text, gc);
        /////////////// 4 row ////////////////////////////////

        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridy = 3;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        form.add(rodzaj, gc);
        gc.gridy = 3;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;

        form.add(rodzaj_select, gc);

        /////////////// 5 row ////////////////////////////////
        /////////////// 11 row ////////////////////////////////
        gc.weighty = 1.0;
        gc.gridy = 4;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;

        form.add(powrot, gc);
    }

}
