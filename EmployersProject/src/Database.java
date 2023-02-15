import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private final String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESSQ:1433;encrypt=false;trustServerCertificate=true;integratedSecurity=true;databaseName=employeesDatabase";

    public List<Object[]> getTabularInfo() {
        List<Object[]> employees = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(connectionUrl);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select first_name, last_name, email, date_of_employment, monthly_salary, monthly_bonuses from [user] as u\n" +
                     "inner join person as p on (u.user_id = p.user_id) \n" +
                     "inner join employee_info as e on(u.user_id = e.user_id)")) {
            while (rs.next()) {
                Object[] ob = {rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),
                        rs.getDate("date_of_employment"), rs.getInt("monthly_salary"), rs.getInt("monthly_bonuses")};
                employees.add(ob);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public void addEmployee(Employee employee)
    {

        String addEmployeeProcedure = "exec addEmployee ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
        try (Connection con = DriverManager.getConnection(connectionUrl);
             PreparedStatement stmt = con.prepareStatement(addEmployeeProcedure))
        {
            stmt.setString(1, employee.getUser().getUsername());
            stmt.setString(2, employee.getUser().getPassword());
            stmt.setString(3, employee.getFirstName());
            stmt.setString(4, employee.getLastName());
            stmt.setString(5, employee.getBirthDateString());
            stmt.setString(6, employee.getTelephone());
            stmt.setString(7, employee.getEmail());
            stmt.setString(8, employee.getPosition());
            stmt.setString(9, employee.getDateOfEmploymentString());
            stmt.setInt(10, employee.getMonthlySalary());
            stmt.setInt(11, employee.getMonthlyBonuses());

            stmt.executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public boolean verifyLogin(String username, String password) {
        try (Connection con = DriverManager.getConnection(connectionUrl);
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM [user] WHERE username = ? AND password = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

public boolean isAdmin(String username, String password)
{
    try (Connection con = DriverManager.getConnection(connectionUrl);
         PreparedStatement stmt = con.prepareStatement("SELECT * FROM [user] WHERE username = ? AND password = ? AND user_role_id IS NOT NULL")) {
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}

