import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;
import java.awt.*;

public class Login extends JFrame implements ActionListener {

    private JLabel labelUsername, labelPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton buttonLogin;
    private Connection connection;
    private Database database;

    public Login() {

            setTitle("Employer Login");
            setSize(400, 250);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(null);

            database = new Database();
            JPanel loginPanel = new JPanel();
            loginPanel.setLayout(null);
            loginPanel.setBackground(Color.decode("#37474F"));


            Font font = new Font("Sans-Serif", Font.PLAIN, 14);


            labelUsername = new JLabel("Username:");
            labelUsername.setBounds(50, 50, 80, 25);
            labelUsername.setForeground(Color.WHITE);
            labelUsername.setFont(font);
            loginPanel.add(labelUsername);


            txtUsername = new JTextField(20);
            txtUsername.setBounds(150, 50, 200, 25);
            txtUsername.setFont(font);
            loginPanel.add(txtUsername);


            labelPassword = new JLabel("Password:");
            labelPassword.setBounds(50, 80, 80, 25);
            labelPassword.setForeground(Color.WHITE);
            labelPassword.setFont(font);
            loginPanel.add(labelPassword);

            // Create the password text field
            txtPassword = new JPasswordField(20);
            txtPassword.setBounds(150, 80, 200, 25);
            txtPassword.setFont(font);
            loginPanel.add(txtPassword);


            buttonLogin = new JButton("Login");
            buttonLogin.setBounds(150, 130, 80, 25);
            buttonLogin.setBackground(Color.decode("#00796B"));
            buttonLogin.setForeground(Color.WHITE);
            buttonLogin.setFont(font);
            buttonLogin.setFocusPainted(false);
            buttonLogin.addActionListener(this);
            loginPanel.add(buttonLogin);

            add(loginPanel);



            setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        if(database.verifyLogin(username, password))
        {
            if(database.isAdmin(username, password))
            {
                new EmployerPage();
            this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Invalid Login", "Error", JOptionPane.ERROR_MESSAGE);
        }

        }
    }


