package inheritance;

public class CreditAccount extends AbstractAccount {
    private double creditLine;

    public CreditAccount(double limit) {
        super();
        if (limit < 0)
            throw new IllegalArgumentException("Creditline cannot be less than 0");
        else
            this.creditLine = limit;
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        if (creditLine < 0)
            throw new IllegalArgumentException("Creditline cannot be less than 0");
        else if (creditLine < super.getBalance()*-1)
            throw new IllegalStateException("Cannot set limit lower than current credit");
        else
            this.creditLine = creditLine;
    }

    protected void internalWithdraw(double amount) {
        if (amount > (this.creditLine + super.getBalance()))
            throw new IllegalStateException("Not enough funds");
    }
}
