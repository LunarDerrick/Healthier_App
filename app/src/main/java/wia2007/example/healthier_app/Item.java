package wia2007.example.healthier_app;

public class Item {
    String theActivity;
    int checklistLogo;
    int cancelLogo;

    public Item(String theActivity, int checklistLogo, int cancelLogo) {
        this.theActivity = theActivity;
        this.checklistLogo = checklistLogo;
        this.cancelLogo = cancelLogo;
    }

    public String getTheActivity() {
        return theActivity;
    }

    public int getChecklistLogo() {
        return checklistLogo;
    }

    public int getCancelLogo() {
        return cancelLogo;
    }

}
