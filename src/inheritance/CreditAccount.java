package inheritance;

public class CreditAccount extends AbstractAccount {
    private double creditLine;

    public CreditAccount(double limit) {

    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }
}
