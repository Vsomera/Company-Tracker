package ui;

import model.PublicVars;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *  GUI create a new account connected to SQL database using CreateNew.form
 ***/
public class CreateNew extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JTextField passwordInput;
    private JLabel pwLabel;
    private JTextField userInput;
    private JLabel userLabel;
    private JButton cancelButton;
    private JButton confirm;

    public CreateNew() {
        super(PublicVars.name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(mainPanel);

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
            if ((userInput.getText().length() > 0) && (passwordInput.getText().length() > 0)) {
                try {
                    // TODO: Link account to SQL
                    setVisible(false);String url = "jdbc:mysql://localhost:3306/trackmate";

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection(
                            url,"root","mfl@mySQL03");

                    Statement stmt = con.createStatement();

                    String username = userInput.getText();
                    String password = passwordInput.getText();

                    String sql = "INSERT INTO users (userName, userPassword) " +
                                "VALUES ('"+username+"', '"+password+"')";

                    stmt.executeUpdate(sql);

                    con.close();

                    new Login();
                } catch (Exception ex) {
                    // TODO: Exception case
                    System.out.println(ex);
                }
            }
        }

        if (e.getActionCommand().equals("cancel")) {
            setVisible(false);
            new Login();
        }
    }
}
