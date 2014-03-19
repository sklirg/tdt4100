package inheritance;

public class ForeldreSpar extends SavingsAccount{
    private int limit, remainingWithdrawals;

    public ForeldreSpar(double rentefot, int allowedNumOfWithdrawal) {
        super(rentefot);
        this.limit = allowedNumOfWithdrawal;
    }

    public void withdraw() {
        // @Todo: validate according to limit
    }

    public int getRemainingWithdrawals() {
        return this.remainingWithdrawals;
    }
}
