package wia2007.example.healthier_app;

public class User {
    private String username;
    private String email;
    private int age;
    private double height;
    private double weight;
    private String phoneNumber;
    private String name;
    private String gender;
    private String cardnumber;
    private String expirydate;
    private int cvv;
    private String ewallet;

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(String username, String email, int age, double height, double weight, String phoneNumber, String name,
                String gender, String cardnumber, String expirydate, int cvv, String ewallet) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.gender = gender;
        this.cardnumber = cardnumber;
        this.expirydate = expirydate;
        this.cvv = cvv;
        this.ewallet = ewallet;
    }

    /*
    public User(String cardnumber, String expirydate, int cvv, String ewallet) {
        this.cardnumber = cardnumber;
        this.expirydate = expirydate;
        this.cvv = cvv;
        this.ewallet = ewallet;
    }
     */

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getEwallet() {
        return ewallet;
    }

    public void setEwallet(String ewallet) {
        this.ewallet = ewallet;
    }
}
