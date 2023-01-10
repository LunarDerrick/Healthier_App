package wia2007.example.healthier_app;

public class Payment {
    private String cardnumber;
    private String expirydate;
    private int cvv;
    private String ewallet;

    public Payment() {
    }

    public Payment(String cardnumber, String expirydate, int cvv, String ewallet) {
        this.cardnumber = cardnumber;
        this.expirydate = expirydate;
        this.cvv = cvv;
        this.ewallet = ewallet;
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
