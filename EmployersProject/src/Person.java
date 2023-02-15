import java.text.SimpleDateFormat;
import java.util.Date;
public class Person {

    protected String firstName;
    protected String lastName;
    protected Date birthDate;
    protected String telephone;
    protected String email;

    public String getFirstName() { return this.firstName;}
    public String getLastName() { return this.lastName;}
    public Date getBirthDate() { return this.birthDate;}
    public String getTelephone() { return this.telephone;}
    public String getEmail() { return this.email;}
    public String getBirthDateString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthDateString = sdf.format(birthDate);
        return birthDateString;
    }

   public Person(String firstName, String lastName, Date birthDate, String telephone, String email)
   {
       this.firstName = firstName;
       this.lastName = lastName;
       this.birthDate = birthDate;
       this.telephone = telephone;
       this.email = email;
   }

}
