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
        if (amount > super.getBalance())
            throw new IllegalStateException("Not enough funds");
        else if (currentWithdrawals >= withdrawalLimit) {
            if (super.getBalance() - amount - this.fee < 0) {
                throw new IllegalStateException("Not enough funds to cover fee");
            }
            else
                throw new IllegalArgumentException("Not enough withdrawals");
        }
        else {
            currentWithdrawals++;
        }
    }
}
