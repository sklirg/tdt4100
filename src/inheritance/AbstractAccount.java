package inheritance;

public abstract class AbstractAccount {
    private double balance;

    public AbstractAccount() {
        this.balance = 0;
    }

    public void deposit(double amount) {

    }

    protected void withdraw(double amount) {

    }

    abstract void internalWithdraw(double amount);

    public double getBalance() {
        return this.balance;
    }
}
