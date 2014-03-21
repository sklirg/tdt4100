package inheritance;

public class SavingsAccount2 extends AbstractAccount {
    private int withdrawalLimit, currentWithdrawals;
    private double fee;

    public SavingsAccount2(int limit, double fee) {
        super();
        this.withdrawalLimit = limit;
        this.fee = fee;
        this.currentWithdrawals = 0;
    }

    public void internalWithdraw(double amount) {
        if (currentWithdrawals >= withdrawalLimit)
            throw new IllegalStateException("Not enough withdrawals");
        else if (amount > super.getBalance())
            throw new IllegalStateException("Not enough funds");
    }
}
