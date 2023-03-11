package ui;

import model.PublicVars;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNew extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JTextField passwordInput;
    private JLabel pwLabel;
    private JTextField userInput;
    private JLabel userLabel;
    private JLabel appLabel;
    private JButton cancelButton;
    private JButton confirm;

    public CreateNew() {
        super(PublicVars.name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(mainPanel);
        appLabel.setText(PublicVars.name);

        confirm.setActionCommand("confirm");
        confirm.addActionListener(this);
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(this);


        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirm")) {
            try {
                // TODO: Link account to SQL
                setVisible(false);

                new Login();
            } catch (Exception ex) {
                // TODO: Exception case
                System.out.println("Caught Exception...");
            }

        }

        if (e.getActionCommand().equals("cancel")) {
            setVisible(false);
            new Login();
        }
    }
}
