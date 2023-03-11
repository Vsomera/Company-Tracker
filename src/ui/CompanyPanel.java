package ui;

import model.Company;
import model.CompanyList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  GUI panel that displays the company using CompanyPanel.form
 ***/
public class CompanyPanel extends JPanel implements ActionListener {
    private JLabel companyName;
    private JLabel locationLabel;
    private JButton markButton;
    private JButton deleteButton;
    private JPanel mainPanel;
    private Company company;
    private CompanyList companyList;
    private Application application;

    public CompanyPanel(Company c, CompanyList companyList, Application application) {
        this.company = c;
        this.companyList = companyList;
        this.application = application;

        this.companyName.setText(c.getCompanyName());
        this.locationLabel.setText(c.getLocation());
        this.setBackground(new Color(46, 213, 124));

        markButton.setActionCommand("mark");
        markButton.addActionListener(this);
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(application);
        deleteButton.addActionListener(this);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("mark")) {
            company.setStatus(!company.getStatus());
        }

        if (e.getActionCommand().equals("delete")) {
            companyList.removeCompany(company);
        }
    }
}
