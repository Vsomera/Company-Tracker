package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JPanel mainPanel;
    private JButton signIn;
    private JTextField passwordInput;
    private JTextField userInput;
    private JLabel userLabel;
    private JLabel pwLabel;
    private JLabel appLabel;
    private JButton createNewButton;

    public Login() {
        super(PublicVars.name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(mainPanel);
        appLabel.setText(PublicVars.name);

        signIn.setActionCommand("signIn");
        signIn.addActionListener(this);

        createNewButton.setActionCommand("createNew");
        createNewButton.addActionListener(this);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("signIn")) {
            // TODO: Attempt Login with SQL

            try {
                setVisible(false);
                new Application();

            } catch (Exception ex) {
                // TODO: Exception case
                System.out.println("Caught Exception...");
            }
        }

        if (e.getActionCommand().equals("createNew")) {
            setVisible(false);
            new CreateNew();
        }
    }
}
