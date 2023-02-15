import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee extends Person{

    private User user;
    private String position;
    private Date dateOfEmployment;
    private int monthlySalary;
    private int monthlyBonuses;



    public Employee(String firstName, String lastName, Date birthDate, String telephone, String email, User user,
                    String position, Date dateOfEmployment, int monthlySalary, int monthlyBonuses)
    {
        super(firstName, lastName, birthDate, telephone, email);
        this.user = user;
        this.position = position;
        this.dateOfEmployment = dateOfEmployment;
        this.monthlySalary = monthlySalary;
        this.monthlyBonuses = monthlyBonuses;
    }

    public String getPosition() {
        return position;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public String getDateOfEmploymentString()
    {
        SimpleDateFormat simpleDF = new SimpleDateFormat("yyyy-MM-dd");
        String dateOfEmploymentString = simpleDF.format(dateOfEmployment);
        return dateOfEmploymentString;
    }


    public int getMonthlySalary() {
        return monthlySalary;
    }

    public User getUser() {
        return user;
    }

    public int getMonthlyBonuses() {
        return monthlyBonuses;
    }
}
