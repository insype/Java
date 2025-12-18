public class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean CheckPassword(String p) {
        return password.equals(p);
    }

    public void Display() {
        System.out.println("username :" + username);
    }
}