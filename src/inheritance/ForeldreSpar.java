package inheritance;

public class ForeldreSpar extends SavingsAccount{
    private int limit, remainingWithdrawals;

    public ForeldreSpar(double rentefot, int allowedNumOfWithdrawal) {
        super(rentefot);
        this.limit = allowedNumOfWithdrawal;
        this.remainingWithdrawals = this.limit;
    }

    public void withdraw(double amount) {
        if (remainingWithdrawals>0) {
            super.withdraw(amount);
            remainingWithdrawals--;
        }
        else {
            throw new IllegalStateException("Not enough withdrawals left");
        }
    }

    public int getRemainingWithdrawals() {
        return this.remainingWithdrawals;
    }
}
