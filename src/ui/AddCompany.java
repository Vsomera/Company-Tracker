package ui;

import model.Company;
import model.CompanyList;
import model.PublicVars;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  GUI to add a company to tracklist using AddCompany.form
 ***/
public class AddCompany extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JTextField locationInput;
    private JLabel locationLabel;
    private JTextField companyInput;
    private JLabel companyLabel;
    private JButton addButton;
    private JButton cancelButton;

    private CompanyList companyList;

    public AddCompany(CompanyList companyList) {
        super(PublicVars.name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setContentPane(mainPanel);
        this.companyList = companyList;

        addButton.setActionCommand("addButton");
        addButton.addActionListener(this);
        cancelButton.setActionCommand("cancelButton");
        cancelButton.addActionListener(this);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addButton")) {
            if (companyInput.getText().length() > 0) {
                companyList.addCompany(new Company(companyInput.getText(), locationInput.getText(), false));
                setVisible(false);

                new Application(companyList);
            }
        }

        if (e.getActionCommand().equals("cancelButton")) {
            setVisible(false);

            new Application(companyList);
        }
    }
}
