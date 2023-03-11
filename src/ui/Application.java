package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton addButton;

    public Application() {
        super(PublicVars.name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(mainPanel);

        addButton.setActionCommand("addButton");
        addButton.addActionListener(this);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            // TODO: Add Company to List
        }
    }
}
