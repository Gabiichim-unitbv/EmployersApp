public class User  {

    protected String username;
    protected String password;
    protected Integer userRoleId = null;

    public User(String username, String password, Integer userRoleId) {
        this.username = username;
        this.password = password;
        this.userRoleId = userRoleId;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public String getUsername() {
        return username;
    }
}
