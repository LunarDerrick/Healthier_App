package wia2007.example.healthier_app;

public class User {

    private String username;
    private String email;
    private String password;
    private String confirmPass;

    public User(){}

    public User(String username, String email, String password, String confirmPass) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }
}
