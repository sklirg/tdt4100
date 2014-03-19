package inheritance;

public class ForeldreSpar extends SavingsAccount{
    private int limit, withdrawalsThisYear;

    public ForeldreSpar(double rentefot, int allowedNumOfWithdrawal) {
        super(rentefot);
        this.limit = allowedNumOfWithdrawal;
    }
}
