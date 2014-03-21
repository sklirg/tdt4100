package inheritance;

public class CreditAccount extends AbstractAccount {
    private double creditLine;

    public CreditAccount(double limit) {
        if (limit < 0)
            throw new IllegalArgumentException("Creditline cannot be less than 0");
        else
            this.creditLine = limit;
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }

    protected void internalWithdraw(double amount) {

    }
}
