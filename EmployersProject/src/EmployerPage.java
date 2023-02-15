import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployerPage extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel addEmployeePanel;
    private JPanel viewEmployeePanel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel birthDateLabel;
    private JLabel telephoneLabel;
    private JLabel emailLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JDateChooser birthDateField;
    private JTextField telephoneField;
    private JTextField emailField;
    private JLabel positionLabel;
    private JTextField positionField;
    private JLabel dateOfEmploymentLabel;
    private JDateChooser dateOfEmploymentField;
    private JLabel monthlySalaryLabel;
    private JTextField monthlySalaryField;
    private JLabel monthlyBonusesLabel;
    private JTextField monthlyBonusesField;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton addButton;
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JLabel timeLabel;
    private Database database;


    public EmployerPage() {
        super("Employer Home Page");

        database = new Database();
        tabbedPane = new JTabbedPane();
        addEmployeePanel = new JPanel();
        viewEmployeePanel = new JPanel();
        firstNameLabel = new JLabel("First Name: ");
        lastNameLabel = new JLabel("Last Name: ");
        birthDateLabel = new JLabel("Birth Date: ");
        telephoneLabel = new JLabel("Telephone: ");
        emailLabel = new JLabel("E-mail: ");
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        birthDateField = new JDateChooser();
        telephoneField = new JTextField(20);
        emailField = new JTextField(20);
        positionLabel = new JLabel("Position: ");
        positionField = new JTextField(20);
        dateOfEmploymentLabel = new JLabel("Date of employment: ");
        dateOfEmploymentField = new JDateChooser();
        monthlySalaryLabel = new JLabel("Monthly salary: ");
        monthlySalaryField = new JTextField(20);
        monthlyBonusesLabel = new JLabel("Monthly bonuses: ");
        monthlyBonusesField = new JTextField(20);
        usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField(20);
        passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField(20);
        addButton = new JButton("OK");
        employeeTable = new JTable();
        tableModel = new DefaultTableModel();
        scrollPane = new JScrollPane(employeeTable);

        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("E-mail");
        tableModel.addColumn("Employment Date");
        tableModel.addColumn("Monthly Salary");
        tableModel.addColumn("Monthly Bonus");
        employeeTable.setModel(tableModel);

       List<Object[]> employeeList = database.getTabularInfo();
        for(Object[] employee : employeeList)
            tableModel.addRow(employee);

        addEmployeePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel personalInfoTitle = new JLabel("Personal info");
        personalInfoTitle.setForeground(Color.BLUE);
        Font personalInfoTitleFont = new Font(personalInfoTitle.getFont().getName(), Font.BOLD, 15);
        personalInfoTitle.setFont(personalInfoTitleFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        addEmployeePanel.add(personalInfoTitle, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        addEmployeePanel.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        addEmployeePanel.add(firstNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        addEmployeePanel.add(lastNameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        addEmployeePanel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        addEmployeePanel.add(birthDateLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        addEmployeePanel.add(birthDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        addEmployeePanel.add(telephoneLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        addEmployeePanel.add(telephoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        addEmployeePanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        addEmployeePanel.add(emailField, gbc);

        JLabel employeeInfoTitle = new JLabel("Employee info");
        employeeInfoTitle.setForeground(Color.BLUE);
        Font employeeInfoTitleFont = new Font(employeeInfoTitle.getFont().getName(), Font.BOLD, 15);
        employeeInfoTitle.setFont(employeeInfoTitleFont);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        addEmployeePanel.add(employeeInfoTitle, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        addEmployeePanel.add(positionLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        addEmployeePanel.add(positionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        addEmployeePanel.add(dateOfEmploymentLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        addEmployeePanel.add(dateOfEmploymentField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        addEmployeePanel.add(monthlySalaryLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        addEmployeePanel.add(monthlySalaryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.EAST;
        addEmployeePanel.add(monthlyBonusesLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        addEmployeePanel.add(monthlyBonusesField, gbc);
        JLabel authenticationDataTitle = new JLabel("Authentication data");
        authenticationDataTitle.setForeground(Color.BLUE);
        Font authenticationDataTitleFont = new Font(authenticationDataTitle.getFont().getName(), Font.BOLD, 15);
        authenticationDataTitle.setFont(authenticationDataTitleFont);
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        addEmployeePanel.add(authenticationDataTitle, gbc);
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        addEmployeePanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.WEST;
        addEmployeePanel.add(usernameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.EAST;
        addEmployeePanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.WEST;
        addEmployeePanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        addEmployeePanel.add(addButton, gbc);

       timeLabel = new JLabel();
        timeLabel.setForeground(Color.BLACK);
        Font timeLabelFont = new Font(timeLabel.getFont().getName(), Font.PLAIN, 12);
        timeLabel.setFont(timeLabelFont);
        updateTime();
        add(timeLabel, BorderLayout.PAGE_END);

        // Create a timer to update the time every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if(usernameField.getText().isEmpty() || new String(passwordField.getPassword()).isEmpty() || telephoneField.getText().isEmpty() ||
                emailField.getText().isEmpty() || firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || positionField.getText().isEmpty()
            || monthlySalaryField.getText().isEmpty() || monthlyBonusesField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please fill al the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                User user = new User(usernameField.getText(), new String(passwordField.getPassword()));
                Employee employee = new Employee(firstNameField.getText(), lastNameField.getText(), birthDateField.getDate(), telephoneField.getText(),
                        emailField.getText(), user,positionField.getText(), dateOfEmploymentField.getDate(), Integer.parseInt(monthlySalaryField.getText()),
                        Integer.parseInt(monthlyBonusesField.getText()));
                database.addEmployee(employee);
                JOptionPane.showMessageDialog(null, "Employee added successfully!");

                List<Object[]> employeeList = database.getTabularInfo();
                tableModel.setRowCount(0);
                for(Object[] emp : employeeList)
                    tableModel.addRow(emp);

                firstNameField.setText("");
                lastNameField.setText("");
                birthDateField.setDate(null);
                telephoneField.setText("");
                emailField.setText("");
                positionField.setText("");
                dateOfEmploymentField.setDate(null);
                monthlySalaryField.setText("");
                monthlyBonusesField.setText("");
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        scrollPane.setPreferredSize(new Dimension(500, 200));
        viewEmployeePanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Add Employee", addEmployeePanel);
        tabbedPane.addTab("View Employees", viewEmployeePanel);

        add(tabbedPane);

        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addEmployeePanel.setBackground(new Color(200,200,200));
        viewEmployeePanel.setBackground(new Color(200,200,200));

        firstNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lastNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        birthDateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        telephoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        positionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        dateOfEmploymentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        monthlySalaryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        monthlyBonusesLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        addButton.setBackground(Color.GREEN);

        addButton.setForeground(Color.WHITE);

        addButton.setFont(new Font("Arial", Font.BOLD, 20));

        employeeTable.setBackground(new Color(240,240,240));

        employeeTable.setFillsViewportHeight(true);
        employeeTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                    public Component getTableCellRendererComponent(JTable table,
                                                                   Object value, boolean isSelected, boolean hasFocus,
                                                                   int row, int column) {
                        final Component c = super.getTableCellRendererComponent(table,
                                value, isSelected, hasFocus, row, column);
                        c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
                        return c;
                    }
                });

        setVisible(true);
    }

    private void updateTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeLabel.setText(timeFormat.format(new Date()));
    }
}
