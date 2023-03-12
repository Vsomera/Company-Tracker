package ui;

import model.CompanyList;
import model.PublicVars;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener {
    JPanel mainPanel;
    private JButton signIn;
    private JTextField passwordInput;
    private JTextField userInput;
    private JLabel userLabel;
    private JLabel pwLabel;
    private JButton createNewButton;
    private JLabel message;

    private CompanyList companyList;

    /**
     *  GUI to log in connected to SQL database using Login.form
     ***/
    public Login() {
        super(PublicVars.name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(mainPanel);

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
            if ((userInput.getText().length() > 0) && (passwordInput.getText().length() > 0)) {
                try {
                    String url = "jdbc:mysql://localhost:3306/trackmate";

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection(
                            url,"root","mfl@mySQL03");

                    Statement stmt = con.createStatement();

                    String username = userInput.getText();
                    String password = passwordInput.getText();

                    ResultSet rs = stmt.executeQuery("select * from users");

                    while(rs.next()) {
                        String result = rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3);

                        if (result.contains(username + "  " + password)) {
                            setVisible(false);

                            CompanyList companies = getTracklist(rs);

                            companyList = companies;

                            new Application(companyList);
                        } else {
                            message.setText("ERROR: Account doesn't exist.");
                        }
                    }

                    con.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else {
                message.setText("ERROR: Cannot have blank fields.");
            }
        }

        if (e.getActionCommand().equals("createNew")) {
            setVisible(false);
            new CreateNew();
        }
    }

    private CompanyList getTracklist(ResultSet rs) {
        return null;
    }
}
