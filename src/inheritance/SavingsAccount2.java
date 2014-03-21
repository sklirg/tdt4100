package inheritance;

public class SavingsAccount2 extends AbstractAccount {
    private int withdrawalLimit, currentWithdrawals;
    private double fee;

    public SavingsAccount2(int limit, double fee) {
        super();
        this.withdrawalLimit = limit;
        this.fee = fee;
    }

    public void internalWithdraw(double amount) {

    }
}
