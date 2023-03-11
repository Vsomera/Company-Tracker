package ui;

import model.Company;
import model.CompanyList;
import model.PublicVars;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  GUI of main application using Application.form
 ***/
public class Application extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton addButton;
    private JPanel listPanel;
    private CompanyList companyList;

    public Application(CompanyList companyList) {
        super(PublicVars.name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(mainPanel);
        listPanel.setLayout(new GridLayout(10,1));

        this.companyList = companyList;

        addButton.setActionCommand("addButton");
        addButton.addActionListener(this);

        setupList(companyList);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }

    // MODIFIES: this
    // EFFECTS: adds panels for every company in the tracklist
    private void setupList(CompanyList companyList) {
        for (Company c : companyList.getCompanyList()) {
            listPanel.add(new JPanel().add(new CompanyPanel(c, companyList, this).getMainPanel()));
            System.out.println("Added " + c.getCompanyName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addButton")) {
            setVisible(false);

            new AddCompany(companyList);
        }

        if (e.getActionCommand().equals("delete")) {
            setVisible(false);

            new Application(companyList);
        }
    }
}
