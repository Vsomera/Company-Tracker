package ui;

import model.Company;

import javax.swing.*;
import java.awt.*;

public class CompanyPanel extends JPanel {
    private JLabel companyName;
    private JLabel locationLabel;
    private JButton markButton;
    private JButton deleteButton;

    public CompanyPanel(Company c) {
        this.companyName.setText(c.getCompanyName());
        this.locationLabel.setText(c.getLocation());
        this.setForeground(new Color(46, 213, 124));
    }
}
